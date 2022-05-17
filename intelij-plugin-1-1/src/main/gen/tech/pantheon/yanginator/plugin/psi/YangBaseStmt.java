/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

public interface YangBaseStmt extends YangGeneratedReferenceType {

  @NotNull
  YangBaseKeyword getBaseKeyword();

  @NotNull
  YangIdentifierRefArgStr getIdentifierRefArgStr();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtend getStmtend();

}
