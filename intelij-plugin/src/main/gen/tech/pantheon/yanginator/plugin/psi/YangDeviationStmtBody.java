// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangDeviationStmtBody extends YangNamedElement {

  @NotNull
  List<YangStatement> getStatementList();

  @Nullable
  YangStmtsep getStmtsep();

}
