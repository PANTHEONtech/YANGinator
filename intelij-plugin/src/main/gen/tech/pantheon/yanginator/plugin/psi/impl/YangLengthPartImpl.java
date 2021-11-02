// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_DOT;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangLengthBoundary;
import tech.pantheon.yanginator.plugin.psi.YangLengthPart;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLengthPartImpl extends YangNamedElementImpl implements YangLengthPart {

  public YangLengthPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLengthPart(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangLengthBoundary> getLengthBoundaryList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLengthBoundary.class);
  }

  @Override
  @NotNull
  public List<YangOptsep> getOptsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleDot() {
    return findChildByType(YANG_DOUBLE_DOT);
  }

}
