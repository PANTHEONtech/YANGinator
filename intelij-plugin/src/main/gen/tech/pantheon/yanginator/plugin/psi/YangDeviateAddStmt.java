// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangDeviateAddStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @Nullable
  YangAddKeywordStr getAddKeywordStr();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangDeviateKeyword getDeviateKeyword();

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
