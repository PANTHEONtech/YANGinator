/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.lexer.YangGrammarLexer;
import tech.pantheon.yanginator.plugin.parser.YangParser;
import tech.pantheon.yanginator.plugin.psi.YangFile;
import tech.pantheon.yanginator.plugin.psi.YangTokenType;
import tech.pantheon.yanginator.plugin.psi.YangTypes;


public class YangParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(new YangTokenType("SPACE"));
    //TODO: highlighter stuff commented, will be implemented later
    public static final TokenSet COMMENTS = TokenSet.create(YangTypes.YANG_BLOCK_COMMENT/*, YangTypes.YANG_LINE_COMMENT,
       //     YangTypes.YANG_H_BLOCK_COMMENT, YangTypes.YANG_H_SINGLE_LINE_COMMENT*/);
    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(YangLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new YangGrammarLexer();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new YangParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new YangFile(viewProvider);
    }

    @NotNull
    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return YangTypes.Factory.createElement(node);
    }
}
