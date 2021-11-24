// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangLeafListStmtBody extends YangNamedElement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @Nullable
  YangStatement getStatement();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangTypeStmt getTypeStmt();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

}
