// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangOutputStmt extends YangStatement {

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  List<YangOutputStmtBody> getOutputStmtBodyList();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getOutputKeyword();

  @NotNull
  PsiElement getRightBrace();

}
