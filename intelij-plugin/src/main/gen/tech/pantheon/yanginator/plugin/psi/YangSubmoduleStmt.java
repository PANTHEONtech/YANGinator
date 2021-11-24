// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangSubmoduleStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  YangBodyStmts getBodyStmts();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @Nullable
  YangLinkageStmts getLinkageStmts();

  @Nullable
  YangMetaStmts getMetaStmts();

  @NotNull
  YangRevisionStmts getRevisionStmts();

  @NotNull
  YangSubmoduleHeaderStmts getSubmoduleHeaderStmts();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

  @NotNull
  PsiElement getSubmoduleKeyword();

}
