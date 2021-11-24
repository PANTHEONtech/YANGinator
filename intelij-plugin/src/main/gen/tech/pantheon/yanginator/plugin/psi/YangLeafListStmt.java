// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangLeafListStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  List<YangLeafListStmtBody> getLeafListStmtBodyList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @NotNull
  PsiElement getLeafListKeyword();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
