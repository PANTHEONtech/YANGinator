// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangStmtsep extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

}
