// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangBodyStmts extends YangNamedElement {

  @NotNull
  List<YangStatement> getStatementList();

  @NotNull
  List<YangGroupingStmt> getGroupingStmtList();

  @NotNull
  List<YangIdentityStmt> getIdentityStmtList();

  @NotNull
  List<YangStmtsep> getStmtsepList();

  @NotNull
  List<YangTypedefStmt> getTypedefStmtList();

}
