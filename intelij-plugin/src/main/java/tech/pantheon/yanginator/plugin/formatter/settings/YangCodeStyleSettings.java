package tech.pantheon.yanginator.plugin.formatter.settings;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class YangCodeStyleSettings extends CustomCodeStyleSettings {

    public boolean spacesAfterKeyword = true;

    public YangCodeStyleSettings(final CodeStyleSettings settings) {
        super("YangCodeStyleSettings", settings);
    }
}
