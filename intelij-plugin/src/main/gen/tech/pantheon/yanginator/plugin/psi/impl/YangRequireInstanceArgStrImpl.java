// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangRequireInstanceArg;
import tech.pantheon.yanginator.plugin.psi.YangRequireInstanceArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRequireInstanceArgStrImpl extends YangNamedElementImpl implements YangRequireInstanceArgStr {

  public YangRequireInstanceArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRequireInstanceArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangRequireInstanceArg getRequireInstanceArg() {
    return findNotNullChildByClass(YangRequireInstanceArg.class);
  }

}
