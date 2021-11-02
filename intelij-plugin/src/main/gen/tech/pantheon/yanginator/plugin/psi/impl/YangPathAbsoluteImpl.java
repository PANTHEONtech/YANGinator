// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangPathAbsolute;
import tech.pantheon.yanginator.plugin.psi.YangSegment;
import tech.pantheon.yanginator.plugin.psi.YangSegmentNz;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPathAbsoluteImpl extends YangNamedElementImpl implements YangPathAbsolute {

  public YangPathAbsoluteImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPathAbsolute(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangSegment> getSegmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSegment.class);
  }

  @Override
  @Nullable
  public YangSegmentNz getSegmentNz() {
    return findChildByClass(YangSegmentNz.class);
  }

}
