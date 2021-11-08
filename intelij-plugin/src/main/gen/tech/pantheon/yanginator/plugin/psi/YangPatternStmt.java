// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangPatternStmt extends YangStatement {

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  List<YangPatternStmtBody> getPatternStmtBodyList();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @NotNull
  YangString getString();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getPatternKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
