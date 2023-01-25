// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangMinElementsStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  YangMinElementsKeyword getMinElementsKeyword();

  @Nullable
  YangMinValueArgStr getMinValueArgStr();

  @Nullable
  YangStmtend getStmtend();

}
