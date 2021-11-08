// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangDeviationStmt extends YangStatement {

  @NotNull
  YangDeviationArgStr getDeviationArgStr();

  @NotNull
  List<YangDeviationStmtBody> getDeviationStmtBodyList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getDeviationKeyword();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
