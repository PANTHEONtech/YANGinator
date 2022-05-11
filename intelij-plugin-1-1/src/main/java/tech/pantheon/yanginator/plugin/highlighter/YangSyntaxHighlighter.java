/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
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
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ANYXML_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ARGUMENT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_AUGMENT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_BASE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_BELONGS_TO_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_BIT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_CASE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_CHOICE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_CONFIG_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_CONTACT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_CONTAINER_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_DEFAULT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_DESCRIPTION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_DEVIATE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_DEVIATION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ENUM_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ERROR_APP_TAG_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ERROR_MESSAGE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_EXTENSION_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_EXTENSION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_FEATURE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_FRACTION_DIGITS_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_GROUPING_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_IDENTITY_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_IF_FEATURE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_IMPORT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_INCLUDE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_INPUT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_INVALID_ESCAPE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_KEY_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_LEAF_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_LEAF_LIST_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_LENGTH_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_LIST_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_MANDATORY_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_MAX_ELEMENTS_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_MIN_ELEMENTS_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_MODULE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_MUST_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_NAMESPACE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_NOTIFICATION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_OPERATORS;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ORDERED_BY_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_ORGANIZATION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_OUTPUT_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_PATH_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_PATTERN_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_POSITION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_PREFIX_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_PRESENCE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_RANGE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_REFERENCE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_REFINE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_REQUIRE_INSTANCE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_REVISION_DATE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_REVISION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_RPC_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SEMICOLON;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_STATUS_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_STRING;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_SUBMODULE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_TYPEDEF_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_TYPE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_UNIQUE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_UNITS_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_USES_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_VALID_ESCAPE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_VALUE_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_WHEN_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_YANG_VERSION_KEYWORD;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.YANG_H_YIN_ELEMENT_KEYWORD;

public class YangSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey ILLEGAL = createTextAttributesKey("YANG_ILLEGAL", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);
    public static final TextAttributesKey LEGAL = createTextAttributesKey("YANG_LEGAL", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
    public static final TextAttributesKey STRING = createTextAttributesKey("YANG_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("YANG_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BRACES = createTextAttributesKey("YANG_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey OP_SIGN = createTextAttributesKey("YANG_OP_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("YANG_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey UNKNOWN = createTextAttributesKey("YANG_UNKNOWN", DefaultLanguageHighlighterColors.CONSTANT);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new YangHighlighterLexer();
    }


    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
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
        if (
                YANG_H_ANYXML_KEYWORD == type ||
                        YANG_H_ARGUMENT_KEYWORD == type ||
                        YANG_H_AUGMENT_KEYWORD == type ||
                        YANG_H_BASE_KEYWORD == type ||
                        YANG_H_BELONGS_TO_KEYWORD == type ||
                        YANG_H_BIT_KEYWORD == type ||
                        YANG_H_CASE_KEYWORD == type ||
                        YANG_H_CHOICE_KEYWORD == type ||
                        YANG_H_CONFIG_KEYWORD == type ||
                        YANG_H_CONTACT_KEYWORD == type ||
                        YANG_H_CONTAINER_KEYWORD == type ||
                        YANG_H_DEFAULT_KEYWORD == type ||
                        YANG_H_DESCRIPTION_KEYWORD == type ||
                        YANG_H_ENUM_KEYWORD == type ||
                        YANG_H_ERROR_APP_TAG_KEYWORD == type ||
                        YANG_H_ERROR_MESSAGE_KEYWORD == type ||
                        YANG_H_EXTENSION_KEYWORD == type ||
                        YANG_H_DEVIATION_KEYWORD == type ||
                        YANG_H_DEVIATE_KEYWORD == type ||
                        YANG_H_FEATURE_KEYWORD == type ||
                        YANG_H_FRACTION_DIGITS_KEYWORD == type ||
                        YANG_H_GROUPING_KEYWORD == type ||
                        YANG_H_IDENTITY_KEYWORD == type ||
                        YANG_H_IF_FEATURE_KEYWORD == type ||
                        YANG_H_IMPORT_KEYWORD == type ||
                        YANG_H_INCLUDE_KEYWORD == type ||
                        YANG_H_INPUT_KEYWORD == type ||
                        YANG_H_KEY_KEYWORD == type ||
                        YANG_H_LEAF_KEYWORD == type ||
                        YANG_H_LEAF_LIST_KEYWORD == type ||
                        YANG_H_LENGTH_KEYWORD == type ||
                        YANG_H_LIST_KEYWORD == type ||
                        YANG_H_MANDATORY_KEYWORD == type ||
                        YANG_H_MAX_ELEMENTS_KEYWORD == type ||
                        YANG_H_MIN_ELEMENTS_KEYWORD == type ||
                        YANG_H_MODULE_KEYWORD == type ||
                        YANG_H_MUST_KEYWORD == type ||
                        YANG_H_NAMESPACE_KEYWORD == type ||
                        YANG_H_NOTIFICATION_KEYWORD == type ||
                        YANG_H_ORDERED_BY_KEYWORD == type ||
                        YANG_H_ORGANIZATION_KEYWORD == type ||
                        YANG_H_OUTPUT_KEYWORD == type ||
                        YANG_H_PATH_KEYWORD == type ||
                        YANG_H_PATTERN_KEYWORD == type ||
                        YANG_H_POSITION_KEYWORD == type ||
                        YANG_H_PREFIX_KEYWORD == type ||
                        YANG_H_PRESENCE_KEYWORD == type ||
                        YANG_H_RANGE_KEYWORD == type ||
                        YANG_H_REFERENCE_KEYWORD == type ||
                        YANG_H_REFINE_KEYWORD == type ||
                        YANG_H_REQUIRE_INSTANCE_KEYWORD == type ||
                        YANG_H_REVISION_KEYWORD == type ||
                        YANG_H_REVISION_DATE_KEYWORD == type ||
                        YANG_H_RPC_KEYWORD == type ||
                        YANG_H_STATUS_KEYWORD == type ||
                        YANG_H_SUBMODULE_KEYWORD == type ||
                        YANG_H_TYPE_KEYWORD == type ||
                        YANG_H_TYPEDEF_KEYWORD == type ||
                        YANG_H_UNIQUE_KEYWORD == type ||
                        YANG_H_UNITS_KEYWORD == type ||
                        YANG_H_USES_KEYWORD == type ||
                        YANG_H_VALUE_KEYWORD == type ||
                        YANG_H_WHEN_KEYWORD == type ||
                        YANG_H_YANG_VERSION_KEYWORD == type ||
                        YANG_H_YIN_ELEMENT_KEYWORD == type
        ) {
            return pack(KEYWORD);
        }
        return new TextAttributesKey[0];
    }
}