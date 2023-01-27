// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangConfigStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangConfigArgStr getConfigArgStr();

  @NotNull
  YangConfigKeyword getConfigKeyword();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangStmtend getStmtend();

}
