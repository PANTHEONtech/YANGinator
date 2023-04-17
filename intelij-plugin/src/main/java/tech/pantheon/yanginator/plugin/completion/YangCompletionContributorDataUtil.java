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

import com.google.common.collect.ImmutableList;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import tech.pantheon.yanginator.plugin.formatter.YangFormatterUtils;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleStmt;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleStmt;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionArg;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionArgStr;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionStmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class YangCompletionContributorDataUtil {
    public static final String IDENTITYREF_STR = "identityref";

    // orSet() method returns a token set containing the union of the specified token sets.
    public static final TokenSet SKIP_TOKENS = TokenSet.orSet(
            YangFormatterUtils.WHITESPACE_SET,
            TokenSet.create(
                    TokenType.ERROR_ELEMENT
            )
    );

    private static final List<String> MODULE_HEADER_STMTS = List.of(
            "yang-version",
            "namespace",
            "prefix"
    );

    private static final List<String> SUBMODULE_HEADER_STMTS = List.of(
            "yang-version",
            "belongs-to"
    );

    private static final List<String> META_STMTS = List.of(
            "organization",
            "contact",
            "description",
            "reference"
    );

    private static final List<String> LINKAGE_STMTS = List.of(
            "import",
            "include"
    );

    private static final List<String> REVISION_STMTS = List.of(
            "revision"
    );

    private static final List<String> BODY_STMTS = List.of(
            "extension",
            "feature",
            "identity",
            "typedef",
            "grouping",
            "augment",
            "rpc",
            "notification",
            "deviation",
            "container",
            "leaf",
            "leaf-list",
            "list",
            "choice",
            "anyxml",
            "uses"
    );

    private static final List<String> BODY_STMTS_1_1 = new ArrayList<>() {
        {
            addAll(BODY_STMTS);
            add("anydata");
        }
    };

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

    private static final List<String> IMPORT_SUBSTATEMENTS = List.of(
            "prefix",
            "revision-date"
    );

    private static final List<String> IMPORT_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(IMPORT_SUBSTATEMENTS);
            add("description");
            add("reference");
        }
    };

    private static final List<String> INCLUDE_SUBSTATEMENTS = List.of(
            "revision-date"
    );

    private static final List<String> INCLUDE_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(INCLUDE_SUBSTATEMENTS);
            add("description");
            add("reference");
        }
    };
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
            "bit",
            "enum",
            "length",
            "path",
            "pattern",
            "range",
            "require-instance",
            "type"
    );

    private static final List<String> TYPE_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(TYPE_SUBSTATEMENTS);
            add("fraction-digits");
            add("base");
        }
    };
    private static final List<String> CONTAINER_SUBSTATEMENTS = List.of(
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
            "presence",
            "reference",
            "status",
            "typedef",
            "uses",
            "when"
    );

    private static final List<String> CONTAINER_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(CONTAINER_SUBSTATEMENTS);
            add("action");
            add("anydata");
            add("notification");
        }
    };
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
            remove("default");
            add("max-elements");
            add("min-elements");
            add("ordered-by");
        }
    };

    private static final List<String> LEAF_LIST_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(LEAF_LIST_SUBSTATEMENTS);
            add("default");
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

    private static final List<String> LIST_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(LIST_SUBSTATEMENTS);
            add("action");
            add("anydata");
            add("notification");
        }
    };
    private static final List<String> CHOICE_SUBSTATEMENTS = List.of(
            "anyxml",
            "case",
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

    private static final List<String> CHOICE_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(CHOICE_SUBSTATEMENTS);
            add("anydata");
            add("choice");
        }
    };
    private static final List<String> CASE_SUBSTATEMENTS = List.of(
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
    private static final List<String> CASE_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(CASE_SUBSTATEMENTS);
            add("anydata");
        }
    };
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

    private static final List<String> GROUPING_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(GROUPING_SUBSTATEMENTS);
            add("action");
            add("anydata");
            add("notification");
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
            "anyxml",
            "choice",
            "container",
            "grouping",
            "leaf",
            "leaf-list",
            "list",
            "typedef",
            "uses"
    );

    private static final List<String> INPUT_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(INPUT_SUBSTATEMENTS);
            add("anydata");
            add("must");
        }
    };
    private static final List<String> OUTPUT_SUBSTATEMENTS = INPUT_SUBSTATEMENTS;

    private static final List<String> OUTPUT_SUBSTATEMENTS_1_1 = INPUT_SUBSTATEMENTS_1_1;

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
            "anyxml",
            "choice",
            "container",
            "description",
            "grouping",
            "if-feature",
            "leaf",
            "leaf-list",
            "list",
            "reference",
            "status",
            "typedef",
            "uses"
    );

    private static final List<String> NOTIFICATION_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(NOTIFICATION_SUBSTATEMENTS);
            add("anydata");
            add("must");
        }
    };
    private static final List<String> AUGMENT_SUBSTATEMENTS = List.of(
            "anyxml",
            "case",
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

    private static final List<String> AUGMENT_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(AUGMENT_SUBSTATEMENTS);
            add("action");
            add("anydata");
            add("notification");
        }
    };
    private static final List<String> IDENTITY_SUBSTATEMENTS = List.of(
            "base",
            "description",
            "reference",
            "status"
    );

    private static final List<String> IDENTITY_SUBSTATEMENTS_1_1 = new ArrayList<>() {
        {
            addAll(IDENTITY_SUBSTATEMENTS);
            add("if-feature");
        }
    };
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
            put("YANG_MODULE_STMT", MODULE_HEADER_STMTS);
            put("YANG_MODULE_HEADER_STMTS", MODULE_HEADER_STMTS);
            put("YANG_SUBMODULE_STMT", SUBMODULE_HEADER_STMTS);
            put("YANG_SUBMODULE_HEADER_STMTS", SUBMODULE_HEADER_STMTS);
            put("YANG_META_STMTS", META_STMTS);
            put("YANG_LINKAGE_STMTS", LINKAGE_STMTS);
            put("YANG_REVISION_STMTS", REVISION_STMTS);
            put("YANG_BODY_STMTS", BODY_STMTS);
            put("YANG_BODY_STMTS_1_1", BODY_STMTS_1_1);
            put("YANG_IMPORT_STMT", IMPORT_SUBSTATEMENTS);
            put("YANG_IMPORT_STMT_1_1", IMPORT_SUBSTATEMENTS_1_1);
            put("YANG_INCLUDE_STMT", INCLUDE_SUBSTATEMENTS);
            put("YANG_INCLUDE_STMT_1_1", INCLUDE_SUBSTATEMENTS_1_1);
            put("YANG_REVISION_STMT", REVISION_SUBSTATEMENTS);
            put("YANG_AUGMENT_STMT", AUGMENT_SUBSTATEMENTS);
            put("YANG_AUGMENT_STMT_1_1", AUGMENT_SUBSTATEMENTS_1_1);
            put("YANG_USES_AUGMENT_STMT", AUGMENT_SUBSTATEMENTS);
            put("YANG_EXTENSION_STMT", EXTENSION_SUBSTATEMENTS);
            put("YANG_FEATURE_STMT", FEATURE_SUBSTATEMENTS);
            put("YANG_IDENTITY_STMT", IDENTITY_SUBSTATEMENTS);
            put("YANG_IDENTITY_STMT_1_1", IDENTITY_SUBSTATEMENTS_1_1);
            put("YANG_TYPEDEF_STMT", TYPEDEF_SUBSTATEMENTS);
            put("YANG_TYPE_STMT", TYPE_SUBSTATEMENTS);
            put("YANG_TYPE_STMT_1_1", TYPE_SUBSTATEMENTS_1_1);
            put("YANG_MUST_STMT", MUST_SUBSTATEMENTS);
            put("YANG_GROUPING_STMT", GROUPING_SUBSTATEMENTS);
            put("YANG_GROUPING_STMT_1_1", GROUPING_SUBSTATEMENTS_1_1);
            put("YANG_RPC_STMT", RPC_SUBSTATEMENTS);
            put("YANG_NOTIFICATION_STMT", NOTIFICATION_SUBSTATEMENTS);
            put("YANG_NOTIFICATION_STMT_1_1", NOTIFICATION_SUBSTATEMENTS_1_1);
            put("YANG_DEVIATION_STMT", DEVIATION_SUBSTATEMENTS);
            put("YANG_CONTAINER_STMT", CONTAINER_SUBSTATEMENTS);
            put("YANG_CONTAINER_STMT_1_1", CONTAINER_SUBSTATEMENTS_1_1);
            put("YANG_LEAF_LIST_STMT", LEAF_LIST_SUBSTATEMENTS);
            put("YANG_LEAF_LIST_STMT_1_1", LEAF_LIST_SUBSTATEMENTS_1_1);
            put("YANG_LEAF_STMT", LEAF_SUBSTATEMENTS);
            put("YANG_LIST_STMT", LIST_SUBSTATEMENTS);
            put("YANG_LIST_STMT_1_1", LIST_SUBSTATEMENTS_1_1);
            put("YANG_CHOICE_STMT", CHOICE_SUBSTATEMENTS);
            put("YANG_CHOICE_STMT_1_1", CHOICE_SUBSTATEMENTS_1_1);
            put("YANG_ANYDATA_STMT", ANYDATA_SUBSTATEMENTS);
            put("YANG_ANYXML_STMT", ANYXML_SUBSTATEMENTS);
            put("YANG_CASE_STMT", CASE_SUBSTATEMENTS);
            put("YANG_CASE_STMT_1_1", CASE_SUBSTATEMENTS_1_1);
            put("YANG_USES_STMT", USES_SUBSTATEMENTS);
            put("YANG_INPUT_STMT", INPUT_SUBSTATEMENTS);
            put("YANG_INPUT_STMT_1_1", INPUT_SUBSTATEMENTS_1_1);
            put("YANG_OUTPUT_STMT", OUTPUT_SUBSTATEMENTS);
            put("YANG_OUTPUT_STMT_1_1", OUTPUT_SUBSTATEMENTS_1_1);
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

    public static String getVersion(PsiElement position) {
        String version = "";
        PsiElement moduleParent = PsiTreeUtil.getParentOfType(position, YangModuleStmt.class);
        if (moduleParent == null) {
            moduleParent = PsiTreeUtil.getParentOfType(position, YangSubmoduleStmt.class);
        }
        if (moduleParent == null) {
            return version;
        }
        for (PsiElement child : moduleParent.getChildren()) {
            if (child instanceof YangModuleHeaderStmts || child instanceof YangSubmoduleHeaderStmts) {
                for (PsiElement ch : child.getChildren()) {
                    if (ch instanceof YangYangVersionStmt) {
                        YangYangVersionArgStr argStr = ((YangYangVersionStmt) ch).getYangVersionArgStr();
                        YangYangVersionArg arg = argStr == null ? null : argStr.getYangVersionArg();
                        version = arg == null ? "" :
                                arg.getText() == null ? "" : arg.getText();
                        break;
                    }
                }
            }
        }
        return version;
    }

    public static List<String> getResults(String version, String parent) {
        if (version.equals("1.1")) {
            if (MAP_OF_SUBSTATEMENTS.containsKey(parent.concat("_1_1"))) {
                parent = parent.concat("_1_1");
            }
        }
        return MAP_OF_SUBSTATEMENTS.containsKey(parent) ?
                MAP_OF_SUBSTATEMENTS.get(parent).stream().sorted().distinct().collect(Collectors.toList()) :
                null;
    }
}