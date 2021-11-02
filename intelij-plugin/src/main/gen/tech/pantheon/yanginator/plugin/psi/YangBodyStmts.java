// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.NotNull;

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
