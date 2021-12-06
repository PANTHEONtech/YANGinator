/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.FormattingContext;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.WrapType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.YangLanguage;
import tech.pantheon.yanginator.plugin.formatter.settings.YangCodeStyleSettings;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import static tech.pantheon.yanginator.plugin.formatter.YangFormatterUtils.KEYWORD_SET;
import static tech.pantheon.yanginator.plugin.formatter.YangFormatterUtils.SEMICOLON_SET;

public class YangFormattingModelBuilder implements FormattingModelBuilder {
    @Override
    public @NotNull FormattingModel createModel(@NotNull final FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new YangBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(codeStyleSettings)),
                        codeStyleSettings);
    }

    private static SpacingBuilder createSpaceBuilder(final CodeStyleSettings settings) {
        final YangCodeStyleSettings yangSetting = settings.getCustomSettings(YangCodeStyleSettings.class);
        return new SpacingBuilder(settings, YangLanguage.INSTANCE)
                .after(KEYWORD_SET)
                .spaces(1)
                .before(YangTypes.YANG_LEFT_BRACE)
                .spaceIf(yangSetting.spacesBeforeLeftBrace)
                .before(SEMICOLON_SET)
                .none()
                .beforeInside(YangTypes.YANG_STRING, YangTypes.YANG_UNKNOWN_STATEMENT)
                .spaces(1)
                .aroundInside(YangTypes.YANG_OTHER_CHARACTER, YangTypes.YANG_STRING_SPLITTER)
                .spaceIf(settings.getCommonSettings(YangLanguage.INSTANCE.getID()).SPACE_AROUND_ADDITIVE_OPERATORS);
    }

}
