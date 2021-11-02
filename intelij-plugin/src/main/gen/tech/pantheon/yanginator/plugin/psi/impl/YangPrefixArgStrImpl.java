// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangPrefixArg;
import tech.pantheon.yanginator.plugin.psi.YangPrefixArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangPrefixArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPrefixArgStrImpl extends YangNamedElementImpl implements YangPrefixArgStr {

  public YangPrefixArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPrefixArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangPrefixArg getPrefixArg() {
    return findChildByClass(YangPrefixArg.class);
  }

  @Override
  @Nullable
  public YangPrefixArgQuoted getPrefixArgQuoted() {
    return findChildByClass(YangPrefixArgQuoted.class);
  }

}
