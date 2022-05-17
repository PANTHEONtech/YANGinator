/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.icons.YangIcons;

import javax.swing.*;

public class YangFileType extends LanguageFileType {
    public static final YangFileType INSTANCE = new YangFileType();

    private YangFileType() {
        super(YangLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Yang file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return " YANGinator";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "yang";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return YangIcons.FILE;
    }
}
