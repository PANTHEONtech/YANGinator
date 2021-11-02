// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangInputStmt extends YangStatement {

  @NotNull
  List<YangInputStmtBody> getInputStmtBodyList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getInputKeyword();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
