// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangErrorAppTagStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangErrorAppTagKeyword getErrorAppTagKeyword();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangQuotedString getQuotedString();

  @Nullable
  YangStmtend getStmtend();

  @Nullable
  YangString getString();

}
