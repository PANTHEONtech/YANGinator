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

import java.util.List;

public interface YangBodyStmts extends YangNamedElement {

  @NotNull
  List<YangAugmentStmt> getAugmentStmtList();

  @NotNull
  List<YangDataDefStmt> getDataDefStmtList();

  @NotNull
  List<YangDeviationStmt> getDeviationStmtList();

  @NotNull
  List<YangExtensionStmt> getExtensionStmtList();

  @NotNull
  List<YangFeatureStmt> getFeatureStmtList();

  @NotNull
  List<YangGroupingStmt> getGroupingStmtList();

  @NotNull
  List<YangIdentityStmt> getIdentityStmtList();

  @NotNull
  List<YangNotificationStmt> getNotificationStmtList();

  @NotNull
  List<YangRpcStmt> getRpcStmtList();

  @NotNull
  List<YangTypedefStmt> getTypedefStmtList();

}
