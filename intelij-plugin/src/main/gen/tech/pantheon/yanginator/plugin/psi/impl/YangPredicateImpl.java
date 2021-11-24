// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPos;
import tech.pantheon.yanginator.plugin.psi.YangPredicate;
import tech.pantheon.yanginator.plugin.psi.YangPredicateExpr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OPEN_BRACKET;

public class YangPredicateImpl extends YangNamedElementImpl implements YangPredicate {

  public YangPredicateImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPredicate(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangPos> getPosList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPos.class);
  }

  @Override
  @NotNull
  public List<YangPredicateExpr> getPredicateExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPredicateExpr.class);
  }

  @Override
  @NotNull
  public PsiElement getOpenBracket() {
    return findNotNullChildByType(YANG_OPEN_BRACKET);
  }

}
