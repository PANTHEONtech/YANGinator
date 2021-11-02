// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangAugmentArg;
import tech.pantheon.yanginator.plugin.psi.YangAugmentArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangAugmentArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangAugmentArgStrImpl extends YangNamedElementImpl implements YangAugmentArgStr {

  public YangAugmentArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitAugmentArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangAugmentArg getAugmentArg() {
    return findChildByClass(YangAugmentArg.class);
  }

  @Override
  @Nullable
  public YangAugmentArgQuoted getAugmentArgQuoted() {
    return findChildByClass(YangAugmentArgQuoted.class);
  }

}
