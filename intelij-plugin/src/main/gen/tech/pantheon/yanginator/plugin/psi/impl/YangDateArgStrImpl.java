// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDateArg;
import tech.pantheon.yanginator.plugin.psi.YangDateArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangDateArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangDateArgStrImpl extends YangNamedElementImpl implements YangDateArgStr {

  public YangDateArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDateArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDateArg getDateArg() {
    return findChildByClass(YangDateArg.class);
  }

  @Override
  @Nullable
  public YangDateArgQuoted getDateArgQuoted() {
    return findChildByClass(YangDateArgQuoted.class);
  }

}
