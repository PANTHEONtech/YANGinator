// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangAugmentStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @Nullable
  YangAugmentArgStr getAugmentArgStr();

  @NotNull
  List<YangAugmentStmtBody> getAugmentStmtBodyList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @NotNull
  PsiElement getAugmentKeyword();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

}
