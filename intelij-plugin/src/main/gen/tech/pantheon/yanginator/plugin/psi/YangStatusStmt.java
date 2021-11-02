// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface YangStatusStmt extends YangStatement {

  @NotNull
  YangSep getSep();

  @NotNull
  YangStatusArgStr getStatusArgStr();

  @NotNull
  YangStmtend getStmtend();

  @NotNull
  PsiElement getStatusKeyword();

}
