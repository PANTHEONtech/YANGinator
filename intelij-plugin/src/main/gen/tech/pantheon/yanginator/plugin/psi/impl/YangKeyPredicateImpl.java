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

public class YangKeyPredicateImpl extends YangNamedElementImpl implements YangKeyPredicate {

  public YangKeyPredicateImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitKeyPredicate(this);
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
  public YangKeyPredicateExpr getKeyPredicateExpr() {
    return findNotNullChildByClass(YangKeyPredicateExpr.class);
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
