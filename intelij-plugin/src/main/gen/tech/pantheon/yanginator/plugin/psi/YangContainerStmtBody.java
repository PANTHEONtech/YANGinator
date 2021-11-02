// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangContainerStmtBody extends YangNamedElement {

  @Nullable
  YangStatement getStatement();

  @Nullable
  YangGroupingStmt getGroupingStmt();

  @NotNull
  YangStmtsep getStmtsep();

  @Nullable
  YangTypedefStmt getTypedefStmt();

}
