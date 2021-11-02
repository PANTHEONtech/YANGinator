// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryArg;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangMandatoryArgStrImpl extends YangNamedElementImpl implements YangMandatoryArgStr {

  public YangMandatoryArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMandatoryArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangMandatoryArg getMandatoryArg() {
    return findNotNullChildByClass(YangMandatoryArg.class);
  }

}
