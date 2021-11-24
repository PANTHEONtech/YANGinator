// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangIdentityStmtBody extends YangNamedElement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @Nullable
  YangStatement getStatement();

  @Nullable
  YangBaseStmt getBaseStmt();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

}
