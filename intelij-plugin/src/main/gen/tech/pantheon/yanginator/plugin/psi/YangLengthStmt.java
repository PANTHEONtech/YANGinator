// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangLengthStmt extends YangStatement {

  @NotNull
  YangLengthArgStr getLengthArgStr();

  @NotNull
  List<YangLengthStmtBody> getLengthStmtBodyList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getLengthKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
