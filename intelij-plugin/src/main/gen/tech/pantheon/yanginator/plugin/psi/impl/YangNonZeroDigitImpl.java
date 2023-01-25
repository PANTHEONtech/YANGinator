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

public class YangNonZeroDigitImpl extends YangNamedElementImpl implements YangNonZeroDigit {

  public YangNonZeroDigitImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitNonZeroDigit(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getEight() {
    return findChildByType(YANG_EIGHT);
  }

  @Override
  @Nullable
  public PsiElement getFive() {
    return findChildByType(YANG_FIVE);
  }

  @Override
  @Nullable
  public PsiElement getFour() {
    return findChildByType(YANG_FOUR);
  }

  @Override
  @Nullable
  public PsiElement getNine() {
    return findChildByType(YANG_NINE);
  }

  @Override
  @Nullable
  public PsiElement getOne() {
    return findChildByType(YANG_ONE);
  }

  @Override
  @Nullable
  public PsiElement getSeven() {
    return findChildByType(YANG_SEVEN);
  }

  @Override
  @Nullable
  public PsiElement getSix() {
    return findChildByType(YANG_SIX);
  }

  @Override
  @Nullable
  public PsiElement getThree() {
    return findChildByType(YANG_THREE);
  }

  @Override
  @Nullable
  public PsiElement getTwo() {
    return findChildByType(YANG_TWO);
  }

}
