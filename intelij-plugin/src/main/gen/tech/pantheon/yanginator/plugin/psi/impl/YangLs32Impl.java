// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangH16;
import tech.pantheon.yanginator.plugin.psi.YangIPv4Address;
import tech.pantheon.yanginator.plugin.psi.YangLs32;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangLs32Impl extends YangNamedElementImpl implements YangLs32 {

  public YangLs32Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLs32(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIPv4Address getIPv4Address() {
    return findChildByClass(YangIPv4Address.class);
  }

  @Override
  @NotNull
  public List<YangH16> getH16List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangH16.class);
  }

}
