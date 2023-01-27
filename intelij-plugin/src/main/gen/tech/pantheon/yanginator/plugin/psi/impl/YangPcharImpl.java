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

public class YangPcharImpl extends YangNamedElementImpl implements YangPchar {

  public YangPcharImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPchar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangPctEncoded getPctEncoded() {
    return findChildByClass(YangPctEncoded.class);
  }

  @Override
  @Nullable
  public YangSubDelims getSubDelims() {
    return findChildByClass(YangSubDelims.class);
  }

  @Override
  @Nullable
  public YangUnreserved getUnreserved() {
    return findChildByClass(YangUnreserved.class);
  }

  @Override
  @Nullable
  public PsiElement getAtSign() {
    return findChildByType(YANG_AT_SIGN);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

}
