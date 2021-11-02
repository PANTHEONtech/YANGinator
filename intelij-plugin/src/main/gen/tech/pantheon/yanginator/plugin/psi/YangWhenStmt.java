// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangWhenStmt extends YangStatement {

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @NotNull
  YangString getString();

  @NotNull
  List<YangWhenStmtBody> getWhenStmtBodyList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

  @NotNull
  PsiElement getWhenKeyword();

}
