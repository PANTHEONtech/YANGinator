// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangMustStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangMustStmtBody> getMustStmtBodyList();

  @Nullable
  YangString getString();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getMustKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
