// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangRevisionDateStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangRevisionDate getRevisionDate();

  @NotNull
  YangRevisionDateKeyword getRevisionDateKeyword();

  @Nullable
  YangStmtend getStmtend();

}
