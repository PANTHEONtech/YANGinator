// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangFragment;
import tech.pantheon.yanginator.plugin.psi.YangHierPart;
import tech.pantheon.yanginator.plugin.psi.YangQuery;
import tech.pantheon.yanginator.plugin.psi.YangScheme;
import tech.pantheon.yanginator.plugin.psi.YangUri;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUriImpl extends YangNamedElementImpl implements YangUri {

  public YangUriImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUri(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangFragment getFragment() {
    return findChildByClass(YangFragment.class);
  }

  @Override
  @NotNull
  public YangHierPart getHierPart() {
    return findNotNullChildByClass(YangHierPart.class);
  }

  @Override
  @Nullable
  public YangQuery getQuery() {
    return findChildByClass(YangQuery.class);
  }

  @Override
  @NotNull
  public YangScheme getScheme() {
    return findNotNullChildByClass(YangScheme.class);
  }

  @Override
  @NotNull
  public PsiElement getColon() {
    return findNotNullChildByType(YANG_COLON);
  }

}
