// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHA;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_UNDERSCORE;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangUnreserved;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUnreservedImpl extends YangNamedElementImpl implements YangUnreserved {

  public YangUnreservedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUnreserved(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDigit getDigit() {
    return findChildByClass(YangDigit.class);
  }

  @Override
  @Nullable
  public PsiElement getAlpha() {
    return findChildByType(YANG_ALPHA);
  }

  @Override
  @Nullable
  public PsiElement getDash() {
    return findChildByType(YANG_DASH);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(YANG_DOT);
  }

  @Override
  @Nullable
  public PsiElement getUnderscore() {
    return findChildByType(YANG_UNDERSCORE);
  }

}
