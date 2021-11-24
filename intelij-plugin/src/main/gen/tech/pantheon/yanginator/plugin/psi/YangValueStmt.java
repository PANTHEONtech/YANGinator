// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangValueStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIntegerValue getIntegerValue();

  @Nullable
  YangIntegerValueStr getIntegerValueStr();

  @NotNull
  YangStmtend getStmtend();

  @NotNull
  PsiElement getValueKeyword();

}
