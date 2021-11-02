// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangLengthArg;
import tech.pantheon.yanginator.plugin.psi.YangLengthPart;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLengthArgImpl extends YangNamedElementImpl implements YangLengthArg {

  public YangLengthArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLengthArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangLengthPart> getLengthPartList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLengthPart.class);
  }

  @Override
  @NotNull
  public List<YangOptsep> getOptsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
  }

}
