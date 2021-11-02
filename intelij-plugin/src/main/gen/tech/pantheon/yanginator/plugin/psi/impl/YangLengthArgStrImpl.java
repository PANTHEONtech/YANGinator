// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangLengthArg;
import tech.pantheon.yanginator.plugin.psi.YangLengthArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLengthArgStrImpl extends YangNamedElementImpl implements YangLengthArgStr {

  public YangLengthArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLengthArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangLengthArg getLengthArg() {
    return findNotNullChildByClass(YangLengthArg.class);
  }

}
