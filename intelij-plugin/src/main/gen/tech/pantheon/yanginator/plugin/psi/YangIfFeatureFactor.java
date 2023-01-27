// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangIfFeatureFactor extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierRefArg getIdentifierRefArg();

  @Nullable
  YangIfFeatureExpr getIfFeatureExpr();

  @Nullable
  YangIfFeatureFactor getIfFeatureFactor();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangNotKeyword getNotKeyword();

  @Nullable
  PsiElement getLeftParenthesis();

  @Nullable
  PsiElement getRightParenthesis();

}
