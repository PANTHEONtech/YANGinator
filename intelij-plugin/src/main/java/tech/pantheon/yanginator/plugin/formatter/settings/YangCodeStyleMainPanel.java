/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter.settings;

import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import tech.pantheon.yanginator.plugin.YangLanguage;

public class YangCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

    public YangCodeStyleMainPanel(final CodeStyleSettings currentSettings,
                                  final CodeStyleSettings settings) {
        super(YangLanguage.INSTANCE, currentSettings, settings);
    }

    // Method is override as empty so the blank lines tab does not appear in the setting.
    @Override
    protected void addBlankLinesTab(final CodeStyleSettings settings) {
    }

    // Method is override as empty so the wrapping and braces tab does not appear in the setting.
    @Override
    protected void addWrappingAndBracesTab(final CodeStyleSettings settings) {
    }
}
