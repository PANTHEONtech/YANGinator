/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.YangFileType;
import tech.pantheon.yanginator.plugin.YangLanguage;

public class YangFile extends PsiFileBase {
    public YangFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, YangLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return YangFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Yang File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}