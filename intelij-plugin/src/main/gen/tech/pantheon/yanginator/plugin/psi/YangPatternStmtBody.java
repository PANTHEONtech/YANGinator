// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangPatternStmtBody extends YangNamedElement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  YangStatement getStatement();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

}
