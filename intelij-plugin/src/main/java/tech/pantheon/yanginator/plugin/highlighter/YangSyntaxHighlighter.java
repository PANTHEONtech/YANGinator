/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.lexer.YangHighlighterLexer;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_KEYWORD_MATCHER;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_MODULE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SUBMODULE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_STRING;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SEMICOLON;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_EXTENSION_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_OPERATORS;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_INVALID_ESCAPE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_VALID_ESCAPE;

public class YangSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey ILLEGAL = createTextAttributesKey("YANG_ILLEGAL", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);
    public static final TextAttributesKey LEGAL = createTextAttributesKey("YANG_LEGAL", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
    public static final TextAttributesKey STRING = createTextAttributesKey("YANG_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("YANG_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BRACES = createTextAttributesKey("YANG_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey OP_SIGN = createTextAttributesKey("YANG_OP_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("YANG_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey UNKNOWN = createTextAttributesKey("YANG_UNKNOWN", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("YANG_UNKNOWN", DefaultLanguageHighlighterColors.IDENTIFIER);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new YangHighlighterLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {

        if (type == YANG_H_KEYWORD_MATCHER) {
            return pack(KEYWORD);
        }
        if (type == YANG_H_MODULE_KEYWORD || type == YANG_H_SUBMODULE_KEYWORD) {
            return pack(KEYWORD);
        }
        if (type == TokenType.BAD_CHARACTER) {
            return pack(ILLEGAL);
        }
        if (type == YANG_H_STRING) {
            return pack(STRING);
        }
        if (type == YANG_H_SEMICOLON) {
            return pack(SEMICOLON);
        }
        if (type == YANG_H_EXTENSION_IDENTIFIER) {
            return pack(UNKNOWN);
        }
        if (type == YANG_H_LEFT_BRACE || type == YANG_H_RIGHT_BRACE) {
            return pack(BRACES);
        }
        if (type == YANG_H_OPERATORS) {
            return pack(OP_SIGN);
        }
        if (type == YANG_H_INVALID_ESCAPE) {
            return pack(ILLEGAL);
        }
        if (type == YANG_H_VALID_ESCAPE) {
            return pack(LEGAL);
        }

        return pack(IDENTIFIER);

    }
}