/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.completion;

import com.google.common.collect.ImmutableList;
import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import java.util.List;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.or;

public final class YangCompletionContributorDataUtil {
    public static final String IDENTITYREF_STR = "identityref";
    public static final String BASE_STR = "base";
    public static final String USES_STR = "uses";
    public static final String TYPE_STR = "type";
    public static final String COLON_STR = ":";
    public static final String SEMICOLON_STR = ";";
    public static final String LEFT_BRACE_STR = "{";
    public static final String WSP_STR = " ";
    public static final String EMPTY_STR = "";
    public static final String QUOTES_STR = "\"";
    public static final String TO_WORDS_RGX = "\\s+";
    public static final String DOT_YANG_STR = ".yang";

    public static final ElementPattern<PsiElement> AFTER_BASE_KEYWORD = getCaptureAfterWSP(YangTypes.YANG_BASE_KEYWORD);
    public static final ElementPattern<PsiElement> AFTER_GROUPING_KEYWORD = getCaptureAfterWSP(YangTypes.YANG_GROUPING_KEYWORD);
    public static final ElementPattern<PsiElement> AFTER_TYPE_KEYWORD = getCaptureAfterWSP(YangTypes.YANG_TYPE_KEYWORD);
    public static final ElementPattern<PsiElement> AFTER_USES_KEYWORD = getCaptureAfterWSP(YangTypes.YANG_USES_KEYWORD);
    public static final ElementPattern<PsiElement> AFTER_IDENTIFIER
            = psiElement().afterLeaf(psiElement(YangTypes.YANG_COLON).afterSibling(psiElement(YangTypes.YANG_ALPHA)));
    public static final ElementPattern<PsiElement> AFTER_PSI_ERROR_ELEMENT
            = psiElement().afterLeaf(psiElement(YangTypes.YANG_COLON));

    public static final List<String> YANG_STATEMENTS = ImmutableList.of(
            "anyxml",
            "argument",
            "augment",
            "base",
            "belongs-to",
            "bit",
            "case",
            "choice",
            "config",
            "contact",
            "container",
            "default",
            "description",
            "enum",
            "error-app_tag",
            "error-message",
            "extension",
            "deviation",
            "deviate",
            "feature",
            "fraction-digits",
            "grouping",
            "identity",
            "if-feature",
            "import",
            "include",
            "input",
            "key",
            "leaf",
            "leaf-list",
            "length",
            "list",
            "mandatory",
            "max-elements",
            "min-elements",
            "module",
            "must",
            "namespace",
            "notification",
            "ordered-by",
            "organization",
            "output",
            "path",
            "pattern",
            "position",
            "prefix",
            "presence",
            "range",
            "reference",
            "refine",
            "require-instance",
            "revision",
            "revision-date",
            "rpc",
            "status",
            "submodule",
            "type",
            "typedef",
            "unique",
            "units",
            "uses",
            "value",
            "when",
            "yang-version",
            "yin-element",
            "add",
            "delete",
            "replace"
    );

    public static final List<String> BUILT_IN_TYPES = ImmutableList.of(
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

    private static PsiElementPattern.Capture<PsiElement> getCaptureAfterWSP(IElementType keyword) {
        return psiElement().afterLeafSkipping(or(psiElement(YangTypes.YANG_SPACE),
                psiElement(YangTypes.YANG_ALPHA)), psiElement(keyword));
    }
}
