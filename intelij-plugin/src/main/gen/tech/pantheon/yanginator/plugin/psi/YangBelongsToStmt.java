// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangBelongsToStmt extends YangStatement {

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangPrefixStmt getPrefixStmt();

  @NotNull
  YangSep getSep();

  @NotNull
  List<YangStmtsep> getStmtsepList();

  @NotNull
  PsiElement getBelongsToKeyword();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
