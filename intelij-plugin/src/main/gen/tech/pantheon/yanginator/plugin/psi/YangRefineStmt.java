// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangRefineStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangRefineAnyxmlStmts getRefineAnyxmlStmts();

  @NotNull
  YangRefineArgStr getRefineArgStr();

  @Nullable
  YangRefineCaseStmts getRefineCaseStmts();

  @Nullable
  YangRefineChoiceStmts getRefineChoiceStmts();

  @Nullable
  YangRefineContainerStmts getRefineContainerStmts();

  @Nullable
  YangRefineLeafListStmts getRefineLeafListStmts();

  @Nullable
  YangRefineLeafStmts getRefineLeafStmts();

  @Nullable
  YangRefineListStmts getRefineListStmts();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRefineKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
