// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangDeviateDeleteStmt extends YangStatement {

  @NotNull
  List<YangStatement> getStatementList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  List<YangStmtsep> getStmtsepList();

  @NotNull
  PsiElement getDeleteKeyword();

  @NotNull
  PsiElement getDeviateKeyword();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
