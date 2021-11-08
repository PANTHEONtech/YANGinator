// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangHexdig;
import tech.pantheon.yanginator.plugin.psi.YangPctEncoded;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangPctEncodedImpl extends YangNamedElementImpl implements YangPctEncoded {

  public YangPctEncodedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPctEncoded(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangHexdig> getHexdigList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangHexdig.class);
  }

}
