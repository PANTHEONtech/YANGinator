/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangPrefixStmt extends YangYangStmt {

    @NotNull
    List<YangWsp> getWspList();

    @NotNull
    List<YangComment> getCommentList();

    @NotNull
    List<YangLineBreak> getLineBreakList();

    @Nullable
    YangPrefixArgStr getPrefixArgStr();

    @NotNull
    YangPrefixKeyword getPrefixKeyword();

    @Nullable
    YangStmtend getStmtend();

}
