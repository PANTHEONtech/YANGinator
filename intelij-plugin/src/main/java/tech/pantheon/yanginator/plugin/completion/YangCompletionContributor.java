/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.completion;

import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.MAP_OF_IDENTIFIER_KEYWORDS;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.MAP_OF_SUBSTATEMENTS;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.getFirstParentAfterSkip;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

public class YangCompletionContributor extends CompletionContributor {

    // the most relevant parent (in cases where caret is after keyword it is a sibling), which is then used in fillCompletionVariants()
    private PsiElement contextParent = null;
    // isAfterKeyword tracks if the caret is after keyword and an identifier suggestion should be triggered
    private boolean isAfterKeyword = false;
    @Override
    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        int caretOffset = context.getCaret().getOffset();
        PsiFile file = context.getFile();
        PsiElement caretElement = file.findElementAt(caretOffset);
        if (caretElement == null) return;
        PsiElement searchStartElement = caretElement;
        PsiElement prevSibling = caretElement.getPrevSibling();

        if (prevSibling != null && prevSibling.getNode().getElementType() == YangTypes.YANG_ALPHA) {
            searchStartElement = file.findElementAt(caretOffset - prevSibling.getTextLength() - 1);
        }
        if (searchStartElement == null) return;

        ASTNode realParent = findContextParentOfCurrentNode(searchStartElement.getNode());
        contextParent = realParent != null ? realParent.getPsi() : null;
    }

    /**
     * This method searches for a relevant parent of the current context.
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
        ASTNode prevSibling = current.getTreePrev();
        ASTNode parent = current.getTreeParent();
        if(prevSibling == null) {
            // some logic to prevent crashes
            if (parent == null || parent.getElementType().toString().equals("FILE")){
                return null;
            }
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
        if (prevSibling.getElementType().toString().contains("_KEYWORD")){
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
    }


    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
        PsiElement position = parameters.getPosition();

        // base case -> when the file is empty (or only having whitespaces and comments)
        if(getFirstParentAfterSkip(position).getNode().getElementType().toString().equals("FILE")){
            MAP_OF_SUBSTATEMENTS.get("FILE")
                                .forEach(s -> result.addElement(LookupElementBuilder.create(s).withTypeText("yang-keyword")));
            return;
        }
        if (contextParent == null) return;
        List<String> possibleResults;
        String typeText;
        if (isAfterKeyword){
            possibleResults = MAP_OF_IDENTIFIER_KEYWORDS.get(contextParent.getNode().getElementType().toString());
            typeText = "built-in-type";
        }
        else {
            possibleResults = MAP_OF_SUBSTATEMENTS.get(contextParent.getNode().getElementType().toString());
            String type = contextParent.getNode().getElementType().toString();
            type = type.replaceFirst("YANG_","");
            type = type.replaceAll("STMT(S?)", "sub-statement");
            type = type.replace("_", "-");
            type = type.toLowerCase();
            typeText = type;
        }

        if (possibleResults == null) return;
        possibleResults.forEach(s -> result.addElement(LookupElementBuilder.create(s).withTypeText(typeText)));
    }
}