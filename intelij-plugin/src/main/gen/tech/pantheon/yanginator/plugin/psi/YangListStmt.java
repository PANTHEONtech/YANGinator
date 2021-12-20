// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangListStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  List<YangListStmtBody> getListStmtBodyList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getListKeyword();

  @Nullable
  PsiElement getRightBrace();

}
