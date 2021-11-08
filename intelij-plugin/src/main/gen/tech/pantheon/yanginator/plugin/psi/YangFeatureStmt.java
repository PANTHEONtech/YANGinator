// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangFeatureStmt extends YangStatement {

  @NotNull
  List<YangFeatureStmtBody> getFeatureStmtBodyList();

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getFeatureKeyword();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
