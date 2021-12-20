// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangModuleStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @Nullable
  YangBodyStmts getBodyStmts();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @Nullable
  YangLinkageStmts getLinkageStmts();

  @Nullable
  YangMetaStmts getMetaStmts();

  @Nullable
  YangModuleHeaderStmts getModuleHeaderStmts();

  @Nullable
  YangRevisionStmts getRevisionStmts();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getModuleKeyword();

  @Nullable
  PsiElement getRightBrace();

}
