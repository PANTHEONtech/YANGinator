// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangNonQuotedString;
import tech.pantheon.yanginator.plugin.psi.YangPredicateExpr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUAL;

public class YangPredicateExprImpl extends YangNamedElementImpl implements YangPredicateExpr {

  public YangPredicateExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPredicateExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangNodeIdentifier getNodeIdentifier() {
    return findChildByClass(YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public YangNonQuotedString getNonQuotedString() {
    return findNotNullChildByClass(YangNonQuotedString.class);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(YANG_DOT);
  }

  @Override
  @NotNull
  public PsiElement getEqual() {
    return findNotNullChildByType(YANG_EQUAL);
  }

}
