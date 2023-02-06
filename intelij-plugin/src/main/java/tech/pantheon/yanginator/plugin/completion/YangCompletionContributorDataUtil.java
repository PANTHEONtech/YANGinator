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

import com.google.common.collect.ImmutableList;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import tech.pantheon.yanginator.plugin.formatter.YangFormatterUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class YangCompletionContributorDataUtil {
    public static final String IDENTITYREF_STR = "identityref";

    // orSet() method returns a token set containing the union of the specified token sets.
    public static final TokenSet SKIP_TOKENS = TokenSet.orSet(
            YangFormatterUtils.WHITESPACE_SET,
            TokenSet.create(
                    TokenType.ERROR_ELEMENT
            )
    );

    private static final List<String> BUILT_IN_TYPES = ImmutableList.of(
            "binary",
            "bits",
            "boolean",
            "decimal64",
            "empty",
            "enumeration",
            "identityref",
            "instance-identifier",
            "int8",
            "int16",
            "int32",
            "int64",
            "leafref",
            "string",
            "uint8",
            "uint16",
            "uint32",
            "uint64",
            "union"
    );

    private static final List<String> BASE_MODULE_SUBSTATEMENTS = List.of(
            "anydata",
            "anyxml",
            "augment",
            "choice",
            "contact",
            "container",
            "description",
            "deviation",
            "extension",
            "feature",
            "grouping",
            "identity",
            "import",
            "include",
            "leaf",
            "leaf-list",
            "list",
            "notification",
            "organization",
            "reference",
            "revision",
            "rpc",
            "typedef",
            "uses",
            "yang-version"
    );
    private static final List<String> MODULE_SUBSTATEMENTS = new ArrayList<>() {
        {
            add("namespace");
            add("prefix");
            addAll(BASE_MODULE_SUBSTATEMENTS);
        }
    };
    private static final List<String> SUBMODULE_SUBSTATEMENTS = new ArrayList<>() {
        {
            add("belongs-to");
            addAll(BASE_MODULE_SUBSTATEMENTS);
        }
    };
    private static final List<String> IMPORT_SUBSTATEMENTS = List.of(
            "description",
            "prefix",
            "reference",
            "revision-date"
    );
    private static final List<String> INCLUDE_SUBSTATEMENTS = List.of(
            "description",
            "reference",
            "revision-date"
    );
    private static final List<String> REVISION_SUBSTATEMENTS = List.of(
            "description",
            "reference"
    );
    private static final List<String> TYPEDEF_SUBSTATEMENTS = List.of(
            "default",
            "description",
            "reference",
            "status",
            "type",
            "units"
    );
    private static final List<String> TYPE_SUBSTATEMENTS = List.of(
            "base",
            "bit",
            "enum",
            "fraction-digits",
            "length",
            "path",
            "pattern",
            "range",
            "require-instance",
            "type"
    );
    private static final List<String> CONTAINER_SUBSTATEMENTS = List.of(
            "action",
            "anydata",
            "anyxml",
            "choice",
            "config",
            "container",
            "description",
            "grouping",
            "if-feature",
            "leaf",
            "leaf-list",
            "list",
            "must",
            "notification",
            "presence",
            "reference",
            "status",
            "typedef",
            "uses",
            "when"
    );
    private static final List<String> MUST_SUBSTATEMENTS = List.of(
            "description",
            "error-app-tag",
            "error-message",
            "reference"
    );
    private static final List<String> LEAF_SUBSTATEMENTS = List.of(
            "config",
            "default",
            "description",
            "if-feature",
            "mandatory",
            "must",
            "reference",
            "status",
            "type",
            "units",
            "when"
    );
    private static final List<String> LEAF_LIST_SUBSTATEMENTS = new ArrayList<>() {
        {
            addAll(LEAF_SUBSTATEMENTS);
            remove("mandatory");
            add("max-elements");
            add("min-elements");
            add("ordered-by");
        }
    };
    private static final List<String> LIST_SUBSTATEMENTS = new ArrayList<>() {
        {
            addAll(CONTAINER_SUBSTATEMENTS);
            remove("presence");
            add("key");
            add("max-elements");
            add("min-elements");
            add("ordered-by");
            add("unique");
        }
    };
    private static final List<String> CHOICE_SUBSTATEMENTS = List.of(
            "anydata",
            "anyxml",
            "case",
            "choice",
            "config",
            "container",
            "default",
            "description",
            "if-feature",
            "leaf",
            "leaf-list",
            "list",
            "mandatory",
            "reference",
            "status",
            "when"
    );
    private static final List<String> CASE_SUBSTATEMENTS = List.of(
            "anydata",
            "anyxml",
            "choice",
            "container",
            "description",
            "if-feature",
            "leaf",
            "leaf-list",
            "list",
            "reference",
            "status",
            "uses",
            "when"
    );
    private static final List<String> ANYDATA_SUBSTATEMENTS = List.of(
            "config",
            "description",
            "if-feature",
            "mandatory",
            "must",
            "reference",
            "status",
            "when"
    );
    private static final List<String> ANYXML_SUBSTATEMENTS = ANYDATA_SUBSTATEMENTS;
    private static final List<String> GROUPING_SUBSTATEMENTS = new ArrayList<>() {
        {
            addAll(CONTAINER_SUBSTATEMENTS);
            remove("config");
            remove("if-feature");
            remove("must");
            remove("presence");
            remove("when");
        }
    };
    private static final List<String> USES_SUBSTATEMENTS = List.of(
            "augment",
            "description",
            "if-feature",
            "reference",
            "refine",
            "status",
            "when"
    );
    private static final List<String> RPC_SUBSTATEMENTS = List.of(
            "description",
            "grouping",
            "if-feature",
            "input",
            "output",
            "reference",
            "status",
            "typedef"
    );
    private static final List<String> INPUT_SUBSTATEMENTS = List.of(
            "anydata",
            "anyxml",
            "choice",
            "container",
            "grouping",
            "leaf",
            "leaf-list",
            "list",
            "must",
            "typedef",
            "uses"
    );
    private static final List<String> OUTPUT_SUBSTATEMENTS = INPUT_SUBSTATEMENTS;
    private static final List<String> ACTION_SUBSTATEMENTS = List.of(
            "description",
            "grouping",
            "if-feature",
            "input",
            "output",
            "reference",
            "status",
            "typedef"
    );
    private static final List<String> NOTIFICATION_SUBSTATEMENTS = List.of(
            "anydata",
            "anyxml",
            "choice",
            "container",
            "description",
            "grouping",
            "if-feature",
            "leaf",
            "leaf-list",
            "list",
            "must",
            "reference",
            "status",
            "typedef",
            "uses"
    );
    private static final List<String> AUGMENT_SUBSTATEMENTS = List.of(
            "action",
            "anydata",
            "anyxml",
            "case",
            "choice",
            "container",
            "description",
            "if-feature",
            "leaf",
            "leaf-list",
            "list",
            "notification",
            "reference",
            "status",
            "uses",
            "when"
    );
    private static final List<String> IDENTITY_SUBSTATEMENTS = List.of(
            "base",
            "description",
            "if-feature",
            "reference",
            "status"
    );
    private static final List<String> EXTENSION_SUBSTATEMENTS = List.of(
            "argument",
            "description",
            "reference",
            "status"
    );
    private static final List<String> FEATURE_SUBSTATEMENTS = new ArrayList<>() {
        {
            addAll(IDENTITY_SUBSTATEMENTS);
            remove("base");
        }
    };
    private static final List<String> DEVIATION_SUBSTATEMENTS = List.of(
            "description",
            "deviate",
            "reference"
    );
    private static final List<String> DEVIATE_SUBSTATEMENTS = List.of(
            "config",
            "default",
            "mandatory",
            "max-elements",
            "min-elements",
            "must",
            "type",
            "unique",
            "units"
    );
    private static final List<String> RANGE_SUBSTATEMENTS = MUST_SUBSTATEMENTS;
    private static final List<String> LENGTH_SUBSTATEMENTS = MUST_SUBSTATEMENTS;
    private static final List<String> PATTERN_SUBSTATEMENTS = new ArrayList<>() {
        {
            addAll(MUST_SUBSTATEMENTS);
            add("modifier");
        }
    };
    private static final List<String> ENUM_SUBSTATEMENTS = List.of(
            "description",
            "if-feature",
            "reference",
            "status",
            "value"
    );
    private static final List<String> BIT_SUBSTATEMENTS = List.of(
            "description",
            "if-feature",
            "position",
            "reference",
            "status"
    );

    public static final Map<String, List<String>> MAP_OF_SUBSTATEMENTS = new HashMap<>() {
        {
            put("FILE", List.of("module", "submodule"));
            put("YANG_MODULE_STMT", MODULE_SUBSTATEMENTS);
            put("YANG_MODULE_HEADER_STMTS", MODULE_SUBSTATEMENTS);
            put("YANG_SUBMODULE_STMT", SUBMODULE_SUBSTATEMENTS);
            put("YANG_SUBMODULE_HEADER_STMTS", SUBMODULE_SUBSTATEMENTS);
            put("YANG_META_STMTS", BASE_MODULE_SUBSTATEMENTS);
            put("YANG_LINKAGE_STMTS", BASE_MODULE_SUBSTATEMENTS);
            put("YANG_BODY_STMTS", BASE_MODULE_SUBSTATEMENTS);
            put("YANG_IMPORT_STMT", IMPORT_SUBSTATEMENTS);
            put("YANG_INCLUDE_STMT", INCLUDE_SUBSTATEMENTS);
            put("YANG_REVISION_STMT", REVISION_SUBSTATEMENTS);
            put("YANG_AUGMENT_STMT", AUGMENT_SUBSTATEMENTS);
            put("YANG_USES_AUGMENT_STMT", AUGMENT_SUBSTATEMENTS);
            put("YANG_EXTENSION_STMT", EXTENSION_SUBSTATEMENTS);
            put("YANG_FEATURE_STMT", FEATURE_SUBSTATEMENTS);
            put("YANG_IDENTITY_STMT", IDENTITY_SUBSTATEMENTS);
            put("YANG_TYPEDEF_STMT", TYPEDEF_SUBSTATEMENTS);
            put("YANG_TYPE_STMT", TYPE_SUBSTATEMENTS);
            put("YANG_MUST_STMT", MUST_SUBSTATEMENTS);
            put("YANG_GROUPING_STMT", GROUPING_SUBSTATEMENTS);
            put("YANG_RPC_STMT", RPC_SUBSTATEMENTS);
            put("YANG_NOTIFICATION_STMT", NOTIFICATION_SUBSTATEMENTS);
            put("YANG_DEVIATION_STMT", DEVIATION_SUBSTATEMENTS);
            put("YANG_CONTAINER_STMT", CONTAINER_SUBSTATEMENTS);
            put("YANG_LEAF_LIST_STMT", LEAF_LIST_SUBSTATEMENTS);
            put("YANG_LEAF_STMT", LEAF_SUBSTATEMENTS);
            put("YANG_LIST_STMT", LIST_SUBSTATEMENTS);
            put("YANG_CHOICE_STMT", CHOICE_SUBSTATEMENTS);
            put("YANG_ANYDATA_STMT", ANYDATA_SUBSTATEMENTS);
            put("YANG_ANYXML_STMT", ANYXML_SUBSTATEMENTS);
            put("YANG_CASE_STMT", CASE_SUBSTATEMENTS);
            put("YANG_USES_STMT", USES_SUBSTATEMENTS);
            put("YANG_INPUT_STMT", INPUT_SUBSTATEMENTS);
            put("YANG_OUTPUT_STMT", OUTPUT_SUBSTATEMENTS);
            put("YANG_ACTION_STMT", ACTION_SUBSTATEMENTS);
            put("YANG_DEVIATE_STMT", DEVIATE_SUBSTATEMENTS);
            put("YANG_RANGE_STMT", RANGE_SUBSTATEMENTS);
            put("YANG_LENGTH_STMT", LENGTH_SUBSTATEMENTS);
            put("YANG_PATTERN_STMT", PATTERN_SUBSTATEMENTS);
            put("YANG_ENUM_STMT", ENUM_SUBSTATEMENTS);
            put("YANG_BIT_STMT", BIT_SUBSTATEMENTS);
        }
    };

    private static final List<String> TRUE_FALSE = ImmutableList.of("true", "false");

    private static final List<String> YIN_ELEMENT_ARG = TRUE_FALSE;
    private static final List<String> REQUIRE_INSTANCE_ARG = TRUE_FALSE;
    private static final List<String> CONFIG_ARG = TRUE_FALSE;
    private static final List<String> MANDATORY_ARG = TRUE_FALSE;

    private static final List<String> MAX_VALUE_ARG = List.of("unbounded");
    public static final Map<String, List<String>> MAP_OF_IDENTIFIER_KEYWORDS = new HashMap<>() {
        {
            put("YANG_TYPE_KEYWORD", BUILT_IN_TYPES);
            put("YANG_YIN_ELEMENT_KEYWORD", YIN_ELEMENT_ARG);
            put("YANG_REQUIRE_INSTANCE_KEYWORD", REQUIRE_INSTANCE_ARG);
            put("YANG_CONFIG_KEYWORD", CONFIG_ARG);
            put("YANG_MANDATORY_KEYWORD", MANDATORY_ARG);
            put("YANG_MAX_ELEMENTS_KEYWORD", MAX_VALUE_ARG);
        }
    };

    public static PsiElement getFirstParentAfterSkip(PsiElement currentPosition) {
        PsiElement parent = currentPosition.getParent();
        while (SKIP_TOKENS.contains(parent.getNode().getElementType())) {
            parent = parent.getParent();
        }
        return parent;
    }
}