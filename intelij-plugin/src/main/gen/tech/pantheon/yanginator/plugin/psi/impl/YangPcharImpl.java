// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierLiteral;
import tech.pantheon.yanginator.plugin.psi.YangPchar;
import tech.pantheon.yanginator.plugin.psi.YangPctEncoded;
import tech.pantheon.yanginator.plugin.psi.YangSubDelims;
import tech.pantheon.yanginator.plugin.psi.YangUnreserved;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

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
  public YangIdentifierLiteral getIdentifierLiteral() {
    return findChildByClass(YangIdentifierLiteral.class);
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
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

}
