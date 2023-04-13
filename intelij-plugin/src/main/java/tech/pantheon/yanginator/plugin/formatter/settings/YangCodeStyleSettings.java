/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter.settings;


import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;


public class YangCodeStyleSettings extends CustomCodeStyleSettings {
    // This initializes custom code style option
    public static boolean spacesBeforeLeftBrace = true;
    public static boolean limitRecursionKeyLeafSearch = false;

    public YangCodeStyleSettings(final CodeStyleSettings settings) {
        super("YangCodeStyleSettings", settings);
    }
}