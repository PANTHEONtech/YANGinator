/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter.settings;

import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.YangLanguage;

public class YangLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {

    private static final String INDENT_SIZE_OPTION_NAME = "INDENT_SIZE";
    private static final String TAB_SIZE_OPTION_NAME = "TAB_SIZE";
    private static final String SPACE_AROUND_ADDITIVE_OPERATORS_OPTION_NAME = "SPACE_AROUND_ADDITIVE_OPERATORS";
    private static final String SPACES_BEFORE_LEFT_BRACE_OPTION_NAME = "spacesBeforeLeftBrace";
    private static final String SPACES_BEFORE_LEFT_BRACE_TITLE = "Space before left brace";
    private static final String SPACES_BEFORE_LEFT_BRACE_GROUP_NAME = "Custom spacing";

    private static @NotNull String readCodeSample() {
        return CodeStyleAbstractPanel.readFromFile(YangLanguageCodeStyleSettingsProvider.class, "preview.yang");
    }
    @Override
    public void customizeSettings(@NotNull final CodeStyleSettingsCustomizable consumer,
                                  @NotNull final SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions(SPACE_AROUND_ADDITIVE_OPERATORS_OPTION_NAME);
            consumer.showCustomOption(YangCodeStyleSettings.class, SPACES_BEFORE_LEFT_BRACE_OPTION_NAME, SPACES_BEFORE_LEFT_BRACE_TITLE, SPACES_BEFORE_LEFT_BRACE_GROUP_NAME);
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions(INDENT_SIZE_OPTION_NAME);
            consumer.showStandardOptions(TAB_SIZE_OPTION_NAME);
        }
    }

    @Override
    public @Nullable String getCodeSample(@NotNull final SettingsType settingsType) {
        return readCodeSample();
    }

    @Override
    public @NotNull Language getLanguage() {
        return YangLanguage.INSTANCE;
    }

    @Override
    public IndentOptionsEditor getIndentOptionsEditor() {
        return new SmartIndentOptionsEditor();
    }

    @Override
    protected void customizeDefaults(@NotNull final CommonCodeStyleSettings commonSettings,
                                     @NotNull final CommonCodeStyleSettings.IndentOptions indentOptions) {
        indentOptions.INDENT_SIZE = commonSettings.initIndentOptions().INDENT_SIZE;
        indentOptions.CONTINUATION_INDENT_SIZE = commonSettings.initIndentOptions().CONTINUATION_INDENT_SIZE;
        indentOptions.TAB_SIZE = commonSettings.initIndentOptions().TAB_SIZE;
    }
}