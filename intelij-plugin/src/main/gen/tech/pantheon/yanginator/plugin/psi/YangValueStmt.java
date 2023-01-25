// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangValueStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIntegerValueStr getIntegerValueStr();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangStmtend getStmtend();

  @NotNull
  YangValueKeyword getValueKeyword();

}
