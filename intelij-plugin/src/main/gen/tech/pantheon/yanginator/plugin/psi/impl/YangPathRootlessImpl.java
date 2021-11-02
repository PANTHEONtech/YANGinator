// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPathRootless;
import tech.pantheon.yanginator.plugin.psi.YangSegment;
import tech.pantheon.yanginator.plugin.psi.YangSegmentNz;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPathRootlessImpl extends YangNamedElementImpl implements YangPathRootless {

  public YangPathRootlessImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPathRootless(this);
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
  @NotNull
  public YangSegmentNz getSegmentNz() {
    return findNotNullChildByClass(YangSegmentNz.class);
  }

}
