/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter;

import com.intellij.formatting.Indent;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import static com.intellij.lang.parser.GeneratedParserUtilBase.DUMMY_BLOCK;
import static tech.pantheon.yanginator.plugin.YangParserDefinition.FILE;

public final class YangFormatterUtils {
    public static final TokenSet KEYWORD_SET = TokenSet.create(
            YangTypes.YANG_ANYXML_KEYWORD,
            YangTypes.YANG_ARGUMENT_KEYWORD,
            YangTypes.YANG_AUGMENT_KEYWORD,
            YangTypes.YANG_BASE_KEYWORD,
            YangTypes.YANG_BELONGS_TO_KEYWORD,
            YangTypes.YANG_BIT_KEYWORD,
            YangTypes.YANG_CASE_KEYWORD,
            YangTypes.YANG_CHOICE_KEYWORD,
            YangTypes.YANG_CONFIG_KEYWORD,
            YangTypes.YANG_CONTACT_KEYWORD,
            YangTypes.YANG_CONTAINER_KEYWORD,
            YangTypes.YANG_DEFAULT_KEYWORD,
            YangTypes.YANG_DESCRIPTION_KEYWORD,
            YangTypes.YANG_ENUM_KEYWORD,
            YangTypes.YANG_ERROR_APP_TAG_KEYWORD,
            YangTypes.YANG_ERROR_MESSAGE_KEYWORD,
            YangTypes.YANG_EXTENSION_KEYWORD,
            YangTypes.YANG_DEVIATION_KEYWORD,
            YangTypes.YANG_DEVIATE_KEYWORD,
            YangTypes.YANG_FEATURE_KEYWORD,
            YangTypes.YANG_FRACTION_DIGITS_KEYWORD,
            YangTypes.YANG_GROUPING_KEYWORD,
            YangTypes.YANG_IDENTITY_KEYWORD,
            YangTypes.YANG_IF_FEATURE_KEYWORD,
            YangTypes.YANG_IMPORT_KEYWORD,
            YangTypes.YANG_INCLUDE_KEYWORD,
            YangTypes.YANG_INPUT_KEYWORD,
            YangTypes.YANG_KEY_KEYWORD,
            YangTypes.YANG_LEAF_KEYWORD,
            YangTypes.YANG_LEAF_LIST_KEYWORD,
            YangTypes.YANG_LENGTH_KEYWORD,
            YangTypes.YANG_LIST_KEYWORD,
            YangTypes.YANG_MANDATORY_KEYWORD,
            YangTypes.YANG_MAX_ELEMENTS_KEYWORD,
            YangTypes.YANG_MIN_ELEMENTS_KEYWORD,
            YangTypes.YANG_MODULE_KEYWORD,
            YangTypes.YANG_MUST_KEYWORD,
            YangTypes.YANG_NAMESPACE_KEYWORD,
            YangTypes.YANG_NOTIFICATION_KEYWORD,
            YangTypes.YANG_ORDERED_BY_KEYWORD,
            YangTypes.YANG_ORGANIZATION_KEYWORD,
            YangTypes.YANG_OUTPUT_KEYWORD,
            YangTypes.YANG_PATH_KEYWORD,
            YangTypes.YANG_PATTERN_KEYWORD,
            YangTypes.YANG_POSITION_KEYWORD,
            YangTypes.YANG_PREFIX_KEYWORD,
            YangTypes.YANG_PRESENCE_KEYWORD,
            YangTypes.YANG_RANGE_KEYWORD,
            YangTypes.YANG_REFERENCE_KEYWORD,
            YangTypes.YANG_REFINE_KEYWORD,
            YangTypes.YANG_REQUIRE_INSTANCE_KEYWORD,
            YangTypes.YANG_REVISION_KEYWORD,
            YangTypes.YANG_REVISION_DATE_KEYWORD,
            YangTypes.YANG_RPC_KEYWORD,
            YangTypes.YANG_STATUS_KEYWORD,
            YangTypes.YANG_SUBMODULE_KEYWORD,
            YangTypes.YANG_TYPE_KEYWORD,
            YangTypes.YANG_TYPEDEF_KEYWORD,
            YangTypes.YANG_UNIQUE_KEYWORD,
            YangTypes.YANG_UNITS_KEYWORD,
            YangTypes.YANG_USES_KEYWORD,
            YangTypes.YANG_VALUE_KEYWORD,
            YangTypes.YANG_WHEN_KEYWORD,
            YangTypes.YANG_YANG_VERSION_KEYWORD,
            YangTypes.YANG_YIN_ELEMENT_KEYWORD,
            YangTypes.YANG_CURRENT_KEYWORD,
            YangTypes.YANG_DELETE_KEYWORD,
            YangTypes.YANG_DEPRECATED_KEYWORD,
            YangTypes.YANG_FALSE_KEYWORD,
            YangTypes.YANG_ADD_KEYWORD,
            YangTypes.YANG_MAX_KEYWORD,
            YangTypes.YANG_MIN_KEYWORD,
            YangTypes.YANG_NOT_SUPPORTED_KEYWORD,
            YangTypes.YANG_OBSOLETE_KEYWORD,
            YangTypes.YANG_REPLACE_KEYWORD,
            YangTypes.YANG_SYSTEM_KEYWORD,
            YangTypes.YANG_TRUE_KEYWORD,
            YangTypes.YANG_UNBOUNDED_KEYWORD,
            YangTypes.YANG_USER_KEYWORD,
            YangTypes.YANG_ACTION_KEYWORD,
            YangTypes.YANG_ANYDATA_KEYWORD,
            YangTypes.YANG_MODIFIER_KEYWORD,
            YangTypes.YANG_INVERT_MATCH_KEYWORD,
            YangTypes.YANG_ADD_KEYWORD,
            YangTypes.YANG_OR_KEYWORD,
            YangTypes.YANG_NOT_KEYWORD
    );

    public static final TokenSet SEMICOLON_SET = TokenSet.create(
            YangTypes.YANG_SEMICOLON,
            YangTypes.YANG_STMTEND
    );

    public static final TokenSet WHITESPACE_SET = TokenSet.create(
            YangTypes.YANG_WSP,
            YangTypes.YANG_SP,
            YangTypes.YANG_SPACE,
            YangTypes.YANG_TAB,
            YangTypes.YANG_LINE_BREAK,
            YangTypes.YANG_CRLF,
            YangTypes.YANG_CR,
            YangTypes.YANG_LF,
            YangTypes.YANG_LINEFEED,
            YangTypes.YANG_CARRIAGE_RETURN
    );

    static final TokenSet STATEMENT_SET = TokenSet.create(
            YangTypes.YANG_YANG_VERSION_STMT,
            YangTypes.YANG_NAMESPACE_STMT,
            YangTypes.YANG_IMPORT_STMT,
            YangTypes.YANG_INCLUDE_STMT,
            YangTypes.YANG_ORGANIZATION_STMT,
            YangTypes.YANG_CONTACT_STMT,
            YangTypes.YANG_REVISION_STMT,
            YangTypes.YANG_EXTENSION_STMT,
            YangTypes.YANG_FEATURE_STMT,
            YangTypes.YANG_IDENTITY_STMT,
            YangTypes.YANG_TYPEDEF_STMT,
            YangTypes.YANG_GROUPING_STMT,
            YangTypes.YANG_CONTAINER_STMT,
            YangTypes.YANG_LEAF_STMT,
            YangTypes.YANG_LIST_STMT,
            YangTypes.YANG_LEAF_LIST_STMT,
            YangTypes.YANG_CHOICE_STMT,
            YangTypes.YANG_ANYXML_STMT,
            YangTypes.YANG_USES_STMT,
            YangTypes.YANG_ARGUMENT_STMT,
            YangTypes.YANG_RPC_STMT,
            YangTypes.YANG_NOTIFICATION_STMT,
            YangTypes.YANG_DEVIATION_STMT,
            YangTypes.YANG_BELONGS_TO_STMT,
            YangTypes.YANG_PREFIX_STMT,
            YangTypes.YANG_REVISION_DATE_STMT,
            YangTypes.YANG_YIN_ELEMENT_STMT,
            YangTypes.YANG_AUGMENT_STMT,
            YangTypes.YANG_BASE_STMT,
            YangTypes.YANG_IF_FEATURE_STMT,
            YangTypes.YANG_TYPE_STMT,
            YangTypes.YANG_UNITS_STMT,
            YangTypes.YANG_DEFAULT_STMT,
            YangTypes.YANG_RANGE_STMT,
            YangTypes.YANG_FRACTION_DIGITS_STMT,
            YangTypes.YANG_ENUM_STMT,
            YangTypes.YANG_PATH_STMT,
            YangTypes.YANG_REQUIRE_INSTANCE_STMT,
            YangTypes.YANG_BIT_STMT,
            YangTypes.YANG_LENGTH_STMT,
            YangTypes.YANG_PATTERN_STMT,
            YangTypes.YANG_ERROR_APP_TAG_STMT,
            YangTypes.YANG_ERROR_MESSAGE_STMT,
            YangTypes.YANG_VALUE_STMT,
            YangTypes.YANG_POSITION_STMT,
            YangTypes.YANG_WHEN_STMT,
            YangTypes.YANG_MUST_STMT,
            YangTypes.YANG_PRESENCE_STMT,
            YangTypes.YANG_MANDATORY_STMT,
            YangTypes.YANG_MIN_ELEMENTS_STMT,
            YangTypes.YANG_MAX_ELEMENTS_STMT,
            YangTypes.YANG_ORDERED_BY_STMT,
            YangTypes.YANG_KEY_STMT,
            YangTypes.YANG_UNIQUE_STMT,
            YangTypes.YANG_CASE_STMT,
            YangTypes.YANG_USES_AUGMENT_STMT,
            YangTypes.YANG_REFINE_STMT,
            YangTypes.YANG_INPUT_STMT,
            YangTypes.YANG_OUTPUT_STMT,
            YangTypes.YANG_DEVIATE_ADD_STMT,
            YangTypes.YANG_DEVIATE_NOT_SUPPORTED_STMT,
            YangTypes.YANG_DEVIATE_REPLACE_STMT,
            YangTypes.YANG_DEVIATE_DELETE_STMT,
            YangTypes.YANG_CONFIG_STMT,
            YangTypes.YANG_REFERENCE_STMT,
            YangTypes.YANG_STATUS_STMT,
            YangTypes.YANG_DESCRIPTION_STMT,
            YangTypes.YANG_UNKNOWN_STATEMENT,
            YangTypes.YANG_STRING,
            YangTypes.YANG_BLOCK_COMMENT,
            YangTypes.YANG_ACTION_STMT,
            YangTypes.YANG_ANYDATA_STMT,
            YangTypes.YANG_MODIFIER_STMT
    );

    private static final TokenSet TO_INDENT_STATEMENTS_SET = TokenSet.create(
            YangTypes.YANG_MODULE_STMT,
            YangTypes.YANG_SUBMODULE_STMT,
            YangTypes.YANG_IMPORT_STMT,
            YangTypes.YANG_INCLUDE_STMT,
            YangTypes.YANG_BELONGS_TO_STMT,
            YangTypes.YANG_REVISION_STMT,
            YangTypes.YANG_EXTENSION_STMT,
            YangTypes.YANG_ARGUMENT_STMT,
            YangTypes.YANG_IDENTITY_STMT,
            YangTypes.YANG_FEATURE_STMT,
            YangTypes.YANG_TYPEDEF_STMT,
            YangTypes.YANG_TYPE_STMT,
            YangTypes.YANG_RANGE_STMT,
            YangTypes.YANG_LENGTH_STMT,
            YangTypes.YANG_PATTERN_STMT,
            YangTypes.YANG_ENUM_STMT,
            YangTypes.YANG_BIT_STMT,
            YangTypes.YANG_MUST_STMT,
            YangTypes.YANG_GROUPING_STMT,
            YangTypes.YANG_CONTAINER_STMT,
            YangTypes.YANG_LEAF_STMT,
            YangTypes.YANG_LEAF_LIST_STMT,
            YangTypes.YANG_LIST_STMT,
            YangTypes.YANG_CHOICE_STMT,
            YangTypes.YANG_CASE_STMT,
            YangTypes.YANG_ANYXML_STMT,
            YangTypes.YANG_USES_STMT,
            YangTypes.YANG_REFINE_STMT,
            YangTypes.YANG_USES_AUGMENT_STMT,
            YangTypes.YANG_AUGMENT_STMT,
            YangTypes.YANG_UNKNOWN_STATEMENT,
            YangTypes.YANG_WHEN_STMT,
            YangTypes.YANG_RPC_STMT,
            YangTypes.YANG_INPUT_STMT,
            YangTypes.YANG_OUTPUT_STMT,
            YangTypes.YANG_NOTIFICATION_STMT,
            YangTypes.YANG_DEVIATION_STMT,
            YangTypes.YANG_DEVIATE_NOT_SUPPORTED_STMT,
            YangTypes.YANG_DEVIATE_ADD_STMT,
            YangTypes.YANG_DEVIATE_DELETE_STMT,
            YangTypes.YANG_DEVIATE_REPLACE_STMT
    );

    private static final TokenSet DO_NOT_ALIGN_SET = TokenSet.create(
            YangTypes.YANG_NODE_IDENTIFIER,
            YangTypes.YANG_IDENTIFIER,
            YangTypes.YANG_IDENTIFIER_ARG_STR,
            YangTypes.YANG_PREFIX
    );

    private static final TokenSet INVALID_YANG_SET = TokenSet.create(
            FILE,
            DUMMY_BLOCK
    );

    private static final TokenSet BEFORE_MODULE_SET = TokenSet.create(
            YangTypes.YANG_MODULE_STMT,
            YangTypes.YANG_SUBMODULE_STMT,
            FILE
    );

    private YangFormatterUtils() {
    }

    static Indent getIndentForType(final IElementType type) {
        if (STATEMENT_SET.contains(type)) {
            return Indent.getNormalIndent();
        }
        return Indent.getNoneIndent();
    }

    static boolean shouldBuildBlock(final IElementType type) {
        return !WHITESPACE_SET.contains(type);
    }

    static boolean shouldAlign(final IElementType type) {
        return !DO_NOT_ALIGN_SET.contains(type);
    }

    static boolean indentSubStmt(final IElementType type) {
        return TO_INDENT_STATEMENTS_SET.contains(type);
    }

    static boolean invalidYang(final IElementType type) {
        return INVALID_YANG_SET.contains(type);
    }

    static boolean shouldBuildBeforeModule(final IElementType type) {
        return BEFORE_MODULE_SET.contains(type);
    }
}