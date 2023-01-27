// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangIfFeatureFactorImpl extends YangNamedElementImpl implements YangIfFeatureFactor {

  public YangIfFeatureFactorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIfFeatureFactor(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangWsp> getWspList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
  }

  @Override
  @NotNull
  public List<YangComment> getCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangComment.class);
  }

  @Override
  @Nullable
  public YangIdentifierRefArg getIdentifierRefArg() {
    return findChildByClass(YangIdentifierRefArg.class);
  }

  @Override
  @Nullable
  public YangIfFeatureExpr getIfFeatureExpr() {
    return findChildByClass(YangIfFeatureExpr.class);
  }

  @Override
  @Nullable
  public YangIfFeatureFactor getIfFeatureFactor() {
    return findChildByClass(YangIfFeatureFactor.class);
  }

  @Override
  @NotNull
  public List<YangLineBreak> getLineBreakList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLineBreak.class);
  }

  @Override
  @Nullable
  public YangNotKeyword getNotKeyword() {
    return findChildByClass(YangNotKeyword.class);
  }

  @Override
  @Nullable
  public PsiElement getLeftParenthesis() {
    return findChildByType(YANG_LEFT_PARENTHESIS);
  }

  @Override
  @Nullable
  public PsiElement getRightParenthesis() {
    return findChildByType(YANG_RIGHT_PARENTHESIS);
  }

}
