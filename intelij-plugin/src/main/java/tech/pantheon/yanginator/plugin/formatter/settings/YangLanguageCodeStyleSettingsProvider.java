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
    @Override
    public void customizeSettings(@NotNull final CodeStyleSettingsCustomizable consumer,
                                  @NotNull final SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS");
            consumer.showCustomOption(YangCodeStyleSettings.class, "SPACE_AFTER_KEYWORD", "Keyword : 'type' ...", "Custom spacing");
        } else if (settingsType == SettingsType.INDENT_SETTINGS) {
            consumer.showStandardOptions("INDENT_SIZE");
            consumer.showStandardOptions("CONTINUATION_INDENT_SIZE");
            consumer.showStandardOptions("TAB_SIZE");
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
        indentOptions.INDENT_SIZE = 2;
        indentOptions.CONTINUATION_INDENT_SIZE = 2;
        indentOptions.TAB_SIZE = 2;
    }

    private static @NotNull String readCodeSample() {
        return CodeStyleAbstractPanel.readFromFile(YangLanguageCodeStyleSettingsProvider.class, "preview.yang");
    }
}
