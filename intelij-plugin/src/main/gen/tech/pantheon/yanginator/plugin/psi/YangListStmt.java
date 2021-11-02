// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangListStmt extends YangStatement {

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  List<YangListStmtBody> getListStmtBodyList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getListKeyword();

  @NotNull
  PsiElement getRightBrace();

}
