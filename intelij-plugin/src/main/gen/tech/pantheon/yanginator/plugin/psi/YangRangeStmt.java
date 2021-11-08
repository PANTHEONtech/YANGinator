// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangRangeStmt extends YangStatement {

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangRangeArgStr getRangeArgStr();

  @NotNull
  List<YangRangeStmtBody> getRangeStmtBodyList();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRangeKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
