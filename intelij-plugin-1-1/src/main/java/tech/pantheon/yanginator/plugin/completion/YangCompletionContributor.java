/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.StandardPatterns.not;
import static com.intellij.patterns.StandardPatterns.or;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.AFTER_BASE_KEYWORD;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.AFTER_GROUPING_KEYWORD;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.AFTER_IDENTIFIER;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.AFTER_PSI_ERROR_ELEMENT;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.AFTER_TYPE_KEYWORD;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.AFTER_USES_KEYWORD;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.BUILT_IN_TYPES;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorDataUtil.YANG_STATEMENTS;
import static tech.pantheon.yanginator.plugin.completion.YangCompletionContributorPopUp.POP_UP;

public class YangCompletionContributor extends CompletionContributor {

    public YangCompletionContributor() {
        // YANG KEYWORDS
        extend(CompletionType.BASIC, not(or(AFTER_TYPE_KEYWORD, AFTER_USES_KEYWORD, AFTER_BASE_KEYWORD,
                        AFTER_GROUPING_KEYWORD, AFTER_IDENTIFIER, AFTER_PSI_ERROR_ELEMENT)),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        YANG_STATEMENTS.forEach(s -> resultSet.withPrefixMatcher(POP_UP.prefixMatcher)
                                .addElement(LookupElementBuilder.create(s).withTypeText("yang-keyword")));

                    }
                });
        // BUILT-IN TYPES
        extend(CompletionType.BASIC, AFTER_TYPE_KEYWORD, new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                BUILT_IN_TYPES.forEach(s -> resultSet.withPrefixMatcher(POP_UP.prefixMatcher)
                        .addElement(LookupElementBuilder.create(s).withTypeText("built-in-type").bold()));
            }
        });
        // PREFIX VALUES
        extend(CompletionType.BASIC, or(AFTER_BASE_KEYWORD, AFTER_USES_KEYWORD, AFTER_TYPE_KEYWORD), new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                POP_UP.getPrefixToYangModule().keySet().forEach(s -> resultSet.withPrefixMatcher(POP_UP.prefixMatcher)
                        .addElement(LookupElementBuilder.create(s).withTypeText("prefix").bold()));
            }
        });
        // GROUPING TYPES
        extend(CompletionType.BASIC, AFTER_USES_KEYWORD, new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                POP_UP.getCurrentGroupingNames().forEach(s -> resultSet.withPrefixMatcher(POP_UP.prefixMatcher)
                        .addElement(LookupElementBuilder.create(s).withTypeText("grouping").bold()));
            }
        });
        // TYPEDEF VALUES
        extend(CompletionType.BASIC, AFTER_TYPE_KEYWORD, new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                POP_UP.getCurrentTypedefNames().forEach(s -> resultSet.withPrefixMatcher(POP_UP.prefixMatcher)
                        .addElement(LookupElementBuilder.create(s).withTypeText("typedef").bold()));

            }
        });
        // IDENTITY VALUES
        extend(CompletionType.BASIC, AFTER_BASE_KEYWORD, new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                POP_UP.getCurrentIdentityNames().forEach(s -> resultSet.withPrefixMatcher(POP_UP.prefixMatcher)
                        .addElement(LookupElementBuilder.create(s).withTypeText("identity").bold()));
            }
        });

        // IMPORTED IDENTIFIER VALUES
        extend(CompletionType.BASIC, or(AFTER_IDENTIFIER, AFTER_PSI_ERROR_ELEMENT), new CompletionProvider<>() {
            public void addCompletions(@NotNull CompletionParameters parameters,
                                       @NotNull ProcessingContext context,
                                       @NotNull CompletionResultSet resultSet) {
                POP_UP.getImportedIdentifiers().forEach(s -> resultSet
                        .addElement(LookupElementBuilder.create(s).bold()));

            }
        });
    }
}