// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangCaseStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  YangCaseKeyword getCaseKeyword();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierArgStr getIdentifierArgStr();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
