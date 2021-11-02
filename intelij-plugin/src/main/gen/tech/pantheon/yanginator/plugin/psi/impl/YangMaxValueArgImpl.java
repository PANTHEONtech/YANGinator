// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_UNBOUNDED_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangMaxValueArg;
import tech.pantheon.yanginator.plugin.psi.YangPositiveIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangMaxValueArgImpl extends YangNamedElementImpl implements YangMaxValueArg {

  public YangMaxValueArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMaxValueArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangPositiveIntegerValue getPositiveIntegerValue() {
    return findChildByClass(YangPositiveIntegerValue.class);
  }

  @Override
  @Nullable
  public PsiElement getUnboundedKeyword() {
    return findChildByType(YANG_UNBOUNDED_KEYWORD);
  }

}
