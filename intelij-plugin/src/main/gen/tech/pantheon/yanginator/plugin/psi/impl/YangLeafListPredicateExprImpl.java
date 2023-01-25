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

public class YangLeafListPredicateExprImpl extends YangNamedElementImpl implements YangLeafListPredicateExpr {

  public YangLeafListPredicateExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLeafListPredicateExpr(this);
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
  public YangQuotedString getQuotedString() {
    return findNotNullChildByClass(YangQuotedString.class);
  }

  @Override
  @NotNull
  public PsiElement getDot() {
    return findNotNullChildByType(YANG_DOT);
  }

  @Override
  @NotNull
  public PsiElement getEquals() {
    return findNotNullChildByType(YANG_EQUALS);
  }

}
