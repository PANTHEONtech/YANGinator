// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangPathEqualityExpr;
import tech.pantheon.yanginator.plugin.psi.YangPathKeyExpr;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUAL;

public class YangPathEqualityExprImpl extends YangNamedElementImpl implements YangPathEqualityExpr {

  public YangPathEqualityExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPathEqualityExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangStringSplitter> getStringSplitterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
  }

  @Override
  @NotNull
  public List<YangWsp> getWspList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
  }

  @Override
  @NotNull
  public YangNodeIdentifier getNodeIdentifier() {
    return findNotNullChildByClass(YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public YangPathKeyExpr getPathKeyExpr() {
    return findNotNullChildByClass(YangPathKeyExpr.class);
  }

  @Override
  @NotNull
  public PsiElement getEqual() {
    return findNotNullChildByType(YANG_EQUAL);
  }

}
