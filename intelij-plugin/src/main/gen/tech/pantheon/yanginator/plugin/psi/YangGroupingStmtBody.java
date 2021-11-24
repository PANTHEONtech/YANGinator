// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangGroupingStmtBody extends YangNamedElement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @Nullable
  YangStatement getStatement();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangGroupingStmt getGroupingStmt();

  @Nullable
  YangTypedefStmt getTypedefStmt();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

}
