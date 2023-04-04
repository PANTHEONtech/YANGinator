/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.MAP_OF_IDENTIFIER_KEYWORDS;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.MAP_OF_SUBSTATEMENTS;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.SKIP_TOKENS;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.getFirstParentAfterSkip;
import static tech.pantheon.yanginator.plugin.reference.YangUtil.findAllChildrenOfTypeAsList;
import static tech.pantheon.yanginator.plugin.reference.YangUtil.getClassType;

public class YangCompletionContributor extends CompletionContributor {

    // the most relevant parent (in cases where caret is after keyword it is a sibling), which is then used in fillCompletionVariants()
    private PsiElement contextParent = null;
    // used when completion is used for groups of statements
    private PsiElement contextParentNextSibling = null;
    // isAfterKeyword tracks if the caret is after keyword and an identifier suggestion should be triggered
    private boolean isAfterKeyword = false;
    private boolean isKeywordCheck = false;
    private boolean isFirstStmtInGroup = false;
    private boolean isLastStmtInGroup = false;
    private int caretOffset;
    private String version = "";
    private boolean withErrors = false;
    private int countBraces;
    private int countDQuotes;
    private int countSQuotes;

    private static final List<String> anymoduleStmtsContinuation = List.of(
            "YANG_LINKAGE_STMTS",
            "YANG_META_STMTS",
            "YANG_REVISION_STMTS",
            "YANG_BODY_STMTS"
    );

    private static final List<String> moduleStmtsContinuation = new ArrayList<>() {
        {
            add("YANG_MODULE_HEADER_STMTS");
            addAll(anymoduleStmtsContinuation);
        }
    };
    private static final List<String> submoduleStmtsContinuation = new ArrayList<>() {
        {
            add("YANG_SUBMODULE_HEADER_STMTS");
            addAll(anymoduleStmtsContinuation);
        }
    };


    @Override
    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        contextParent = null;
        contextParentNextSibling = null;
        isAfterKeyword = false;
        isKeywordCheck = false;
        isFirstStmtInGroup = false;
        isLastStmtInGroup = false;
        withErrors = false;
        countBraces = 0;
        countDQuotes = 0;
        countSQuotes = 0;
        caretOffset = context.getCaret().getOffset();
        PsiFile file = context.getFile();
        PsiElement caretElement = file.findElementAt(caretOffset);
        if (caretElement == null) return;
        PsiElement searchStartElement = caretElement;
        PsiElement prevSibling = caretElement.getPrevSibling();

        List<PsiErrorElement> listOfErrorElements = findAllChildrenOfTypeAsList(caretElement.getContainingFile(),
                PsiErrorElement.class, -100);
        if (listOfErrorElements.size() > 0) {
            withErrors = true;
        }
        if (prevSibling != null && prevSibling.getNode().getElementType() == YangTypes.YANG_ALPHA) {
            searchStartElement = file.findElementAt(caretOffset - prevSibling.getTextLength() - 1);
        }
        if (searchStartElement == null) return;
        ASTNode realParent = findContextParentOfCurrentNode(searchStartElement.getNode());
        contextParent = realParent != null ? realParent.getPsi() : null;
        contextParentNextSibling = findNextSibling();
    }

    /**
     * Finds the next sibling for the contextParent.
     * If the next sibling does not exit or is empty, it returns null.
     *
     * @return Element that is the next sibling for contextParent or null.
     */
    private PsiElement findNextSibling() {
        PsiElement sibling = null;
        if (contextParent != null) {
            sibling = contextParent.getNextSibling();
            while (sibling != null) {
                if (sibling.getChildren().length > 0) {
                    break;
                }
                if (sibling.getNextSibling() != null) {
                    sibling = sibling.getNextSibling();
                } else {
                    return null;
                }
            }
        }
        return sibling;
    }

    /**
     * This method searches for a relevant parent of the current context.
     * If there is an error element in the tree, the search is customized to go through
     * each element instead of parents and siblings.
     * It essentially searches for the first '{' (i.e. LEFT_BRACE) and returns the node, that is a parent to that L_BRACE
     * It skips the enclosed statements ('{ ... }') and only looks for the relevant parent, so that the caret position
     * is in the scope of that found parent
     * <p>
     * In case of built-in-types (or identifier/argument being a keyword) it searches for the relevant sibling
     *
     * @param current the node, at which the caret is situated
     * @return the relevant parent (or sibling - in case of built-in keyword suggestion) node, of the current context
     */
    private ASTNode findContextParentOfCurrentNode(ASTNode current) {
        isAfterKeyword = false;
        if (current == null)
            return null;
        if (!isKeywordCheck) {
            ASTNode sibling = getFirstSiblingAfterSkip(current);
            if (sibling.getElementType().toString().contains("_KEYWORD")) {
                isAfterKeyword = true;
                return sibling;
            }
            isKeywordCheck = true;
        }
        ASTNode prevSibling = current.getTreePrev();
        ASTNode parent = current.getTreeParent();
        if (!withErrors) {
            if (parent != null && (moduleStmtsContinuation.contains(parent.getElementType().toString())
                    || submoduleStmtsContinuation.contains(parent.getElementType().toString()))) {
                getStmtSituation(current);
                return parent;
            }
            if (prevSibling == null) {
                // some logic to prevent crashes
                return findContextParentOfCurrentNode(parent);
            }
            // if there is a semicolon, a whole statement needs to be skipped
            if (prevSibling.getElementType() == YangTypes.YANG_SEMICOLON) {
                /* sometimes the ';' is within YANG_STMTEND, if so, skip that too
                 *  it is still the same statement, just the semicolon (';') has extra parent => YANG_STMTEND
                 */
                if (prevSibling.getTreeParent().getElementType() == YangTypes.YANG_STMTEND) {
                    return findContextParentOfCurrentNode(prevSibling.getTreeParent().getTreeParent());
                }
                return findContextParentOfCurrentNode(prevSibling.getTreeParent());
            }
            // if the caret is situated after a keyword, the user wants us to suggest an identifier (built-in-types or other keywords)
            if (prevSibling.getElementType().toString().contains("_KEYWORD")) {
                isAfterKeyword = true;
                return prevSibling;
            }
            // if the prevSibling is '}' -> means that we need to skip the whole statement enclosed in '{..}'
            if (prevSibling.getElementType() == YangTypes.YANG_RIGHT_BRACE) {
                return findContextParentOfCurrentNode(prevSibling.getTreeParent());
            }
            // the left brace (relevant to our scope) was found -> return its parent
            if (prevSibling.getElementType() == YangTypes.YANG_LEFT_BRACE) {
                return prevSibling.getTreeParent();
            }
            // in other cases, keep searching for sibling left_brace
            return findContextParentOfCurrentNode(prevSibling);
        } else {

            // if there are PsiErrorElements, the psi tree is broken and the context parent needs to be found
            // by going through all elements.
            if (current.getElementType() == YangTypes.YANG_DQUOTE) {
                countDQuotes++;
            }

            if (current.getElementType() == YangTypes.YANG_SQUOTE) {
                countSQuotes++;
            }

            if (countSQuotes % 2 == 0 && countDQuotes % 2 == 0) {
                if (current.getElementType() == YangTypes.YANG_RIGHT_BRACE) {
                    countBraces++;
                }

                if (current.getElementType() == YangTypes.YANG_LEFT_BRACE) {
                    if (countBraces < 1) {
                        return current.getTreeParent();
                    }
                    countBraces--;
                }
            }
            return findContextParentOfCurrentNode(findPreviousElement(current));
        }
    }

    /**
     * Finds the closest previous node either previous sibling, parent
     * or last child of previous sibling or parent. Does not consider
     * whitespace elements and alphas as important.
     *
     * @param current Node for which should search start
     * @return Returns the closest previous "important" node or null.
     */
    private ASTNode getFirstSiblingAfterSkip(ASTNode current) {
        ASTNode sibling = findPreviousElement(current);
        while (sibling != null && (SKIP_TOKENS.contains(sibling.getElementType()) || sibling.getElementType().toString().contains("ALPHA"))) {
            sibling = findPreviousElement(sibling);
        }
        return sibling;
    }

    /**
     * Finds the closest previous node either previous sibling, parent
     * or last child of previous sibling or parent
     *
     * @param current Node for which should search start
     * @return Returns the closest previous node or null.
     */
    private ASTNode findPreviousElement(ASTNode current) {
        ASTNode prevSibling = current.getTreePrev();
        ASTNode parent = current.getTreeParent();
        if (prevSibling != null) {
            while (prevSibling.getLastChildNode() != null) {
                prevSibling = prevSibling.getLastChildNode();
            }
            return prevSibling;
        } else return parent;
    }

    /**
     * Checks if the current node is the first and, or last inside it's parent statement.
     *
     * @param current Node to be checked if it's first and, or last inside statement
     */
    private void getStmtSituation(ASTNode current) {
        ASTNode prevSiblingPsi = current.getTreePrev();
        ASTNode nextSiblingPsi = current.getTreeNext();
        if (prevSiblingPsi == null && nextSiblingPsi == null) {
            if (getOffsetForEnd(current)) {
                this.isLastStmtInGroup = true;
            }
            if (current.getStartOffset() == caretOffset) {
                this.isFirstStmtInGroup = true;
            }
        } else if (prevSiblingPsi == null) {
            if (nextSiblingPsi.getElementType().toString().contains("_STMT")) {
                if (current.getStartOffset() == caretOffset) {
                    this.isFirstStmtInGroup = true;
                }
            }
        } else if (nextSiblingPsi == null) {
            if (prevSiblingPsi.getElementType().toString().contains("_STMT")) {
                if (getOffsetForEnd(current)) {
                    this.isLastStmtInGroup = true;
                }
            }
        }
    }

    /**
     * Loop through elements previous siblings and parents till it finds the actual end of statement,
     * and returns if the caretOffset is outside the statement.
     *
     * @param node node for which the caretOffset should be checked
     * @return true if the caretOffset is outside the node's body
     */
    private boolean getOffsetForEnd(ASTNode node) {
        ASTNode lastNode = node.getLastChildNode();
        int lastEndElemOffset = lastNode.getStartOffset() + lastNode.getTextLength();
        while (!lastNode.getElementType().toString().matches(".*RIGHT_BRACE|.*SEMICOLON|.*END")) {
            lastNode = lastNode.getTreePrev() != null ? lastNode.getTreePrev() : lastNode.getTreeParent();
            if (lastNode == null)
                break;
        }
        if (lastNode == null) {
            return false;
        }
        int firstEndElemOffset = lastNode.getStartOffset();
        return caretOffset >= firstEndElemOffset && caretOffset <= lastEndElemOffset;
    }

    /**
     * After completion is initiated and beforeCompletion is done, this method gets called.
     * It fills up the results for the completion.
     * It checks for certain scenarios:
     * * if it is called inside empty yang
     * * if it is called after a keyword (returns types e.g.)
     * * if it is called inside groups of statements (returns statements)
     * * or if it is called inside statements (returns substatements)
     * These returned variants are then added to the results with a basic description.
     *
     * @param parameters
     * @param result
     */
    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
        PsiElement position = parameters.getPosition();
        version = YangCompletionContributorDataUtil.getVersion(position);

        // base case -> when the file is empty (or only having whitespaces and comments)
        if (getFirstParentAfterSkip(position).getNode().getElementType().toString().equals("FILE")) {
            MAP_OF_SUBSTATEMENTS.get("FILE")
                    .forEach(s -> result.addElement(LookupElementBuilder.create(s).withTypeText("yang-keyword")));
            return;
        }
        if (contextParent == null) return;
        List<String> possibleResults = null;
        String typeText;
        String parentType = contextParent.getNode().getElementType().toString();
        if (isAfterKeyword) {
            possibleResults = afterKeywordCompletion();
            typeText = "built-in-type";
        } else {
            if (moduleStmtsContinuation.contains(parentType)) {
                findPossibleResultsForGroup(result, true);
                return;
            } else if (submoduleStmtsContinuation.contains(parentType)) {
                findPossibleResultsForGroup(result, false);
                return;
            } else {
                List<String> results = YangCompletionContributorDataUtil.getResults(version, parentType);
                if (results != null) {
                    possibleResults = new ArrayList<>(results);
                }
                typeText = getCompletionDescription(contextParent.getNode().getElementType().toString());
            }
        }

        if (possibleResults == null) return;
        possibleResults.forEach(s ->
                result.addElement(LookupElementBuilder.create(s).withTypeText(typeText.isEmpty() ? s : typeText))
        );
    }

    private List<String> afterKeywordCompletion() {
        Class<PsiElement> element = getClassType(contextParent);
        if (element.equals(YangTypedefStmt.class)) {
            return MAP_OF_IDENTIFIER_KEYWORDS.getOrDefault(contextParent.getNode().getElementType().toString(), null);
        } else
            return findAllChildrenOfTypeAsList(contextParent.getContainingFile(), element, 0)
                    .stream().map(psiElement -> psiElement.getChildren()[2].getText()).collect(Collectors.toList());
    }

    /**
     * Takes a string format of element type, removes YANG and replaces stmt and stmts for sub-statement
     * in order to have nicer visualization.
     *
     * @param type Element type in string format
     * @return String ready to be used for completion description
     */
    @NotNull
    private String getCompletionDescription(String type) {
        type = type.replaceFirst("YANG_", "");
        type = type.replaceAll("STMT(S?)", "sub-statement");
        type = type.replace("_", "-");
        type = type.toLowerCase();
        return type;
    }

    /**
     * Loops through all possible group statements in module or submodule, checks in which group it should start adding
     * results and also checks in which group it should end based on isFirstStmtInGroup and isLastStmtInGroup.
     *
     * @param result   CompletionResult in which the possible completion results should be added
     * @param isModule true if the yang is a module or false if the yang is a submodule
     */
    private void findPossibleResultsForGroup(@NotNull CompletionResultSet result, boolean isModule) {
        boolean start = false;
        //loops in possible stmts groups and finds in which group results should start and end
        // i = module group iteration
        List<String> continuation = isModule ? moduleStmtsContinuation : submoduleStmtsContinuation;
        String moduleStmt = "";
        for (int i = 0; i < continuation.size(); i++) {
            moduleStmt = continuation.get(i);
            if (!start) {
                start = contextParent.getNode().getElementType().toString().equals(moduleStmt);
                if (start && isFirstStmtInGroup) {
                    if (i > 0) {
                        --i;
                        moduleStmt = continuation.get(i);
                    }
                }
            }
            if (start) {
                List<String> possibleResults = YangCompletionContributorDataUtil.getResults(version, moduleStmt);
                String finalType = getCompletionDescription(moduleStmt);
                if (possibleResults != null) {
                    possibleResults.forEach(s ->
                            result.addElement(LookupElementBuilder.create(s).withTypeText(finalType))
                    );
                    possibleResults.clear();
                }
                if (isLastStmtInGroup && contextParentNextSibling != null && moduleStmt.equals(contextParentNextSibling.getNode().getElementType().toString())) {
                    return;
                }
                if (!isLastStmtInGroup && moduleStmt.equals(contextParent.getNode().getElementType().toString())) {
                    return;
                }
            }
        }
    }
}