// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

import java.util.List;

public interface YangTypedefStmt extends YangGeneratedReferenceType {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  List<YangTypedefStmtBody> getTypedefStmtBodyList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

  @NotNull
  PsiElement getTypedefKeyword();

}
