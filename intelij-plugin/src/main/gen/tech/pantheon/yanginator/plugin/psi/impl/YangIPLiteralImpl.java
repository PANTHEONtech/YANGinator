// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIPLiteral;
import tech.pantheon.yanginator.plugin.psi.YangIPv6Address;
import tech.pantheon.yanginator.plugin.psi.YangIPvFuture;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CLOSED_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OPEN_BRACKET;

public class YangIPLiteralImpl extends YangNamedElementImpl implements YangIPLiteral {

  public YangIPLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIPLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIPv6Address getIPv6Address() {
    return findChildByClass(YangIPv6Address.class);
  }

  @Override
  @Nullable
  public YangIPvFuture getIPvFuture() {
    return findChildByClass(YangIPvFuture.class);
  }

  @Override
  @NotNull
  public PsiElement getClosedBracket() {
    return findNotNullChildByType(YANG_CLOSED_BRACKET);
  }

  @Override
  @NotNull
  public PsiElement getOpenBracket() {
    return findNotNullChildByType(YANG_OPEN_BRACKET);
  }

}
