// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangValueStmt extends YangStatement {

  @Nullable
  YangIntegerValue getIntegerValue();

  @Nullable
  YangIntegerValueStr getIntegerValueStr();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtend getStmtend();

  @NotNull
  PsiElement getValueKeyword();

}
