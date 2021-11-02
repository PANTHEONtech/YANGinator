// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangSubmoduleStmt extends YangStatement {

  @NotNull
  YangBodyStmts getBodyStmts();

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @Nullable
  YangLinkageStmts getLinkageStmts();

  @Nullable
  YangMetaStmts getMetaStmts();

  @NotNull
  List<YangOptsep> getOptsepList();

  @NotNull
  YangRevisionStmts getRevisionStmts();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  YangSubmoduleHeaderStmts getSubmoduleHeaderStmts();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

  @NotNull
  PsiElement getSubmoduleKeyword();

}
