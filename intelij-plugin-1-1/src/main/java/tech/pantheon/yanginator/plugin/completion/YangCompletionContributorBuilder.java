/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.completion;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.TokenType;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.YangFileType;
import tech.pantheon.yanginator.plugin.psi.YangFile;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.BASE_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.COLON_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.DOT_YANG_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.EMPTY_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.LEFT_BRACE_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.QUOTES_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.SEMICOLON_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.TO_WORDS_RGX;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.TYPE_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.USES_STR;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.WSP_STR;

public class YangCompletionContributorBuilder implements FoldingBuilder {

    private PsiElement psiNode;

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode node, @NotNull Document document) {
        psiNode = node.getPsi();

        var childrenOfCurrentFile = new ArrayList<>(PsiTreeUtil.findChildrenOfType(this.psiNode, PsiElement.class));

        setPrefixValues(childrenOfCurrentFile, YangCompletionContributorPopUp.POP_UP.getPrefixToYangModule());

        setCompletionValues(childrenOfCurrentFile, YangCompletionContributorPopUp.POP_UP.getCurrentGroupingNames(), YangTypes.YANG_GROUPING_KEYWORD);
        setCompletionValues(childrenOfCurrentFile, YangCompletionContributorPopUp.POP_UP.getCurrentTypedefNames(), YangTypes.YANG_TYPEDEF_KEYWORD);
        setCompletionValues(childrenOfCurrentFile, YangCompletionContributorPopUp.POP_UP.getCurrentIdentityNames(), YangTypes.YANG_IDENTITY_KEYWORD);

        var importedIdentifiers = findAllImportedIdentifiers();
        setImportedIdentifiers(importedIdentifiers, YangCompletionContributorPopUp.POP_UP.getImportedIdentifiers());
        updateImportedIdentifiers(importedIdentifiers);

        YangCompletionContributorPopUp.POP_UP.setPrefixMatcher("");

        return new FoldingDescriptor[0];
    }

    private void setImportedIdentifiers(List<String> currentIdentifiers, List<String> values) {
        if (!currentIdentifiers.isEmpty()) {
            updateValues(values);
            findChildrenInAnotherFile(createFileName(currentIdentifiers)).stream()
                    .filter(e -> isElementYangType(e, getYangKeyword(currentIdentifiers)))
                    .forEach(e -> values.add(getIdentifier(e)));
            values.removeIf(e -> e.length() < 1);
        }
    }


    @NotNull
    private IElementType getYangKeyword(List<String> currentIdentifiers) {
        IElementType yangKeyword;
        if (currentIdentifiers.get(0).startsWith(BASE_STR)) {
            yangKeyword = YangTypes.YANG_IDENTITY_KEYWORD;
        } else if (currentIdentifiers.get(0).startsWith(USES_STR)) {
            yangKeyword = YangTypes.YANG_GROUPING_KEYWORD;
        } else {
            yangKeyword = YangTypes.YANG_TYPEDEF_KEYWORD;
        }
        return yangKeyword;
    }

    @Nullable
    private PsiElement getPsiNode(Project project, String fileName) {
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(YangFileType.INSTANCE, GlobalSearchScope.allScope(project));
        return virtualFiles.stream()
                .filter(virtualFile -> equalsFileName(fileName, virtualFile))
                .map(virtualFile -> getYangFile(project, virtualFile))
                .findFirst().orElse(null);
    }

    private void setPrefixValues(@NotNull List<PsiElement> psiElements, Map<String, String> values) {
        updateValues(values);
        psiElements.stream()
                .filter(e -> isElementYangType(e, YangTypes.YANG_PREFIX_KEYWORD))
                .forEach(psiElement -> values.put(getPrefixKeyword(psiElement), getImportKeyword(psiElement)));
        values.keySet().removeIf(e -> e.length() < 2);
    }

    private String getPrefixKeyword(PsiElement e) {
        StringBuilder prefixIdentifier = new StringBuilder();
        var nextSibling = e.getNextSibling() == null ? null : e.getNextSibling();
        if (isPrefixStatement(e)) {
            while (nextSibling != null) {
                if (isErrorElement(nextSibling)) return "";
                if (isNotSpaceOrQuote(nextSibling)) {
                    if (isElementYangType(nextSibling, YangTypes.YANG_SEMICOLON)) {
                        return prefixIdentifier.toString();
                    }
                    prefixIdentifier.append(nextSibling.getText());
                }
                nextSibling = nextSibling.getNextSibling();
            }
        }
        return "";
    }

    private boolean isPrefixStatement(PsiElement e) {
        var prevSibling = e.getPrevSibling() == null ? null : e.getPrevSibling();
        while (prevSibling != null) {
            if (isNotCharExceptSemicolon(prevSibling)) {
                prevSibling = prevSibling.getPrevSibling();
            } else if (isImportOrSemicolon(prevSibling)) {
                return true;
            } else if (isDescriptionOrModule(prevSibling)) {
                return false;
            } else {
                prevSibling = prevSibling.getPrevSibling();
            }
        }
        return false;
    }

    private String getImportKeyword(PsiElement e) {
        StringBuilder importIdentifier = new StringBuilder();
        var prevSibling = e.getPrevSibling() == null ? null : e.getPrevSibling();
        while (prevSibling != null) {
            if (isNotSpaceOrBrace(prevSibling)) {
                if (isElementYangType(prevSibling, YangTypes.YANG_IMPORT_KEYWORD)) {
                    return importIdentifier.reverse().toString();
                }
                createImportIdentifier(importIdentifier, prevSibling);
            }
            prevSibling = prevSibling.getPrevSibling();
        }
        return "";
    }

    private void createImportIdentifier(StringBuilder prefixIdentifier, PsiElement prevSibling) {
        if (isNotForbiddenCharacter(prevSibling)) {
            prefixIdentifier.append(new StringBuilder(prevSibling.getText()).reverse());
        } else {
            prefixIdentifier.append(prevSibling.getText());
        }
    }

    private boolean isNotSpaceOrBrace(PsiElement prevSibling) {
        return !(isElementYangType(prevSibling, YangTypes.YANG_SPACE)
                || isElementYangType(prevSibling, YangTypes.YANG_LEFT_BRACE)
                || isElementYangType(prevSibling, YangTypes.YANG_LINEFEED));
    }

    private boolean isNotForbiddenCharacter(PsiElement prevSibling) {
        return !(isElementYangType(prevSibling, YangTypes.YANG_ALPHA)
                || isElementYangType(prevSibling, YangTypes.YANG_DASH)
                || isElementYangType(prevSibling, YangTypes.YANG_DIGIT)
                || isElementYangType(prevSibling, YangTypes.YANG_UNDERSCORE)
                || isElementYangType(prevSibling, YangTypes.YANG_DOT));
    }

    private String getIdentifier(PsiElement e) {
        StringBuilder prefixIdentifier = new StringBuilder();
        var nextSibling = e.getNextSibling() == null ? null : e.getNextSibling();

        while (nextSibling != null) {
            if (!isElementYangType(nextSibling, YangTypes.YANG_SPACE)) {
                if (isElementYangType(nextSibling, YangTypes.YANG_LEFT_BRACE)) {
                    return prefixIdentifier.toString().replace(WSP_STR, EMPTY_STR).replace(QUOTES_STR, EMPTY_STR);
                }
                prefixIdentifier.append(nextSibling.getText());
            }
            nextSibling = getNotNullSibling(nextSibling);
        }
        return "";
    }

    @Nullable
    private PsiElement getNotNullSibling(PsiElement nextSibling) {
        if (nextSibling.getNextSibling() == null) {
            nextSibling = nonNullElementAt(nextSibling.getTextOffset() + nextSibling.getTextLength());
        } else if (isComment(nextSibling)) {
            nextSibling = null;
        } else {
            nextSibling = nextSibling.getNextSibling();
        }
        return nextSibling;
    }

    @NotNull
    private List<String> findAllImportedIdentifiers() {
        var currentIdentifiers = new ArrayList<String>();

        YangCompletionContributorPopUp.POP_UP.getPrefixToYangModule().keySet().forEach(prefix -> createListOfWords().stream()
                .filter(isYangStatement(prefix))
                .filter(endsWithColons())
                .forEach(currentIdentifiers::add));
        return currentIdentifiers;
    }

    @NotNull
    private Predicate<String> endsWithColons() {
        return s -> s.charAt(s.length() - 1) == COLON_STR.charAt(0)
                || s.charAt(s.length() - 1) == SEMICOLON_STR.charAt(0) && s.charAt(s.length() - 2) == COLON_STR.charAt(0)
                || s.charAt(s.length() - 1) == LEFT_BRACE_STR.charAt(0) && s.charAt(s.length() - 2) == COLON_STR.charAt(0);
    }

    @NotNull
    private Predicate<String> isYangStatement(String prefix) {
        return s -> s.contains(BASE_STR + prefix + COLON_STR)
                || s.contains(TYPE_STR + prefix + COLON_STR)
                || s.contains(USES_STR + prefix + COLON_STR);
    }

    @NotNull
    private String createFileName(List<String> currentIdentifiers) {
        return currentIdentifiers.get(0)
                .substring(BASE_STR.length())
                .replace(COLON_STR, EMPTY_STR)
                .replace(SEMICOLON_STR, EMPTY_STR)
                .replace(LEFT_BRACE_STR, EMPTY_STR);
    }

    @NotNull
    private List<PsiElement> findChildrenInAnotherFile(String fileName) {
        return new ArrayList<>(PsiTreeUtil.findChildrenOfType(
                getPsiNode(this.psiNode.getProject(),
                        YangCompletionContributorPopUp.POP_UP.getPrefixToYangModule().get(fileName)),
                PsiElement.class));
    }

    private void setCompletionValues(@NotNull List<PsiElement> psiElements, List<String> values, IElementType yangType) {
        updateValues(values);
        psiElements.stream()
                .filter(e -> isElementYangType(e, yangType))
                .forEach(e -> values.add(getIdentifier(e)));
        values.removeIf(e -> e.length() < 1);
    }

    private void updateValues(Map<String, String> values) {
        if (!values.isEmpty()) {
            values.clear();
        }
    }

    private void updateValues(List<String> values) {
        if (!values.isEmpty()) {
            values.clear();
        }
    }

    private void updateImportedIdentifiers(List<String> importedIdentifiers) {
        if (importedIdentifiers.isEmpty()) {
            YangCompletionContributorPopUp.POP_UP.getImportedIdentifiers().clear();
        }
    }

    private boolean isNotSpaceOrQuote(PsiElement nextSibling) {
        return !(isElementYangType(nextSibling, YangTypes.YANG_SPACE)
                || isElementYangType(nextSibling, YangTypes.YANG_DOUBLE_QUOTE));
    }

    private boolean isComment(PsiElement nextSibling) {
        return isElementYangType(nextSibling.getNextSibling(), YangTypes.YANG_DOUBLE_QUOTE)
                || isElementYangType(nextSibling.getNextSibling(), YangTypes.YANG_LINEFEED);
    }

    private boolean isImportOrSemicolon(PsiElement prevSibling) {
        return isElementYangType(prevSibling, YangTypes.YANG_IMPORT_KEYWORD)
                || isElementYangType(prevSibling, YangTypes.YANG_SEMICOLON);
    }

    private boolean isDescriptionOrModule(PsiElement prevSibling) {
        return isElementYangType(prevSibling, YangTypes.YANG_DESCRIPTION_KEYWORD)
                || isElementYangType(prevSibling, YangTypes.YANG_MODULE_KEYWORD)
                || isElementYangType(prevSibling, YangTypes.YANG_LEAF_KEYWORD)
                || isElementYangType(prevSibling, YangTypes.YANG_TYPEDEF_KEYWORD)
                || isElementYangType(prevSibling, YangTypes.YANG_KEY_KEYWORD)
                || isElementYangType(prevSibling, YangTypes.YANG_MUST_KEYWORD);
    }

    private boolean isNotCharExceptSemicolon(PsiElement prevSibling) {
        return prevSibling.getTextLength() == 1 && !isElementYangType(prevSibling, YangTypes.YANG_SEMICOLON);
    }

    private boolean isErrorElement(PsiElement sibling) {
        return isElementYangType(sibling, TokenType.ERROR_ELEMENT);
    }

    @NotNull
    private YangFile getYangFile(Project project, VirtualFile virtualFile) {
        return (YangFile) Objects.requireNonNull(PsiManager.getInstance(project).findFile(virtualFile));
    }

    private List<String> createListOfWords() {
        return new ArrayList<>(List.of(this.psiNode.getText().replace(WSP_STR, EMPTY_STR).split(TO_WORDS_RGX)));
    }

    private boolean equalsFileName(String fileName, VirtualFile virtualFile) {
        if (virtualFile != null) {
            String presentableName = virtualFile.getPresentableName();
            String presentableNameSubStr = presentableName.substring(0, presentableName.length() - DOT_YANG_STR.length());
            return presentableNameSubStr.equals(fileName);
        }
        return false;
    }

    private PsiElement nonNullElementAt(int offset) {
        return this.psiNode.findElementAt(offset) == null ? null : this.psiNode.findElementAt(offset);
    }

    private boolean isElementYangType(final PsiElement element, IElementType yangType) {
        return element.getNode().getElementType().equals(yangType);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        return null;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
