/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.YangLanguage;


public class YangTokenType extends IElementType {

    public YangTokenType(@NotNull @NonNls String debugName) {
        super(debugName, YangLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "YangTokenType." + super.toString();
    }


}
