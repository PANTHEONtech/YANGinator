// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangRangeBoundary;
import tech.pantheon.yanginator.plugin.psi.YangRangePart;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_DOT;

public class YangRangePartImpl extends YangNamedElementImpl implements YangRangePart {

  public YangRangePartImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRangePart(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangOptsep> getOptsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
  }

  @Override
  @NotNull
  public List<YangRangeBoundary> getRangeBoundaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRangeBoundary.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleDot() {
    return findChildByType(YANG_DOUBLE_DOT);
  }

}
