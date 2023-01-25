// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangUsesAugmentStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  YangAugmentKeyword getAugmentKeyword();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  YangUsesAugmentArgStr getUsesAugmentArgStr();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

}
