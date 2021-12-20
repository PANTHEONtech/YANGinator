// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangRevisionStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangStatement> getStatementList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangRevisionDate getRevisionDate();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRevisionKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
