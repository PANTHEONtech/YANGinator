// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface YangErrorAppTagStmt extends YangStatement {

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtend getStmtend();

  @NotNull
  YangString getString();

  @NotNull
  PsiElement getErrorAppTagKeyword();

}
