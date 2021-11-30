package tech.pantheon.yanginator.plugin.formatter;

import com.intellij.formatting.Indent;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

final class YangFormatterUtils {
    private static final TokenSet WHITESPACE_SET = TokenSet.create(
            YangTypes.YANG_SPACE,
            YangTypes.YANG_TAB,
            YangTypes.YANG_NEW_LINE_CHARACTERS,
            YangTypes.YANG_LINEFEED,
            YangTypes.YANG_CARRIAGE_RETURN
    );

    private static final TokenSet STATEMENT_SET = TokenSet.create(
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
            YangTypes.YANG_UNKNOWN_STATEMENT_2,
            YangTypes.YANG_STRING,
            YangTypes.YANG_LINE_COMMENT
    );

    private static final TokenSet DO_NOT_ALIGN_SET = TokenSet.create(
            YangTypes.YANG_STRING_SPLITTER
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
}
