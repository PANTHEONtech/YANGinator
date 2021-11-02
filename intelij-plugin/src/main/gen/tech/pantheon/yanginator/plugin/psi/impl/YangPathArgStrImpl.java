// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPathArg;
import tech.pantheon.yanginator.plugin.psi.YangPathArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPathArgStrImpl extends YangNamedElementImpl implements YangPathArgStr {

  public YangPathArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPathArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangPathArg getPathArg() {
    return findNotNullChildByClass(YangPathArg.class);
  }

}
