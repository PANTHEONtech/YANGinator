package tech.pantheon.yanginator.plugin.formatter.settings;

import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import tech.pantheon.yanginator.plugin.YangLanguage;

public class YangCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
    public YangCodeStyleMainPanel(final CodeStyleSettings currentSettings,
                                  final CodeStyleSettings settings) {
        super(YangLanguage.INSTANCE, currentSettings, settings);
    }

    @Override
    protected void addBlankLinesTab(final CodeStyleSettings settings) {
    }

    @Override
    protected void addWrappingAndBracesTab(final CodeStyleSettings settings) {
    }
}
