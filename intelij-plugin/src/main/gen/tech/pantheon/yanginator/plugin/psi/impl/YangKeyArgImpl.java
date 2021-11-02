// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangKeyArg;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangKeyArgImpl extends YangNamedElementImpl implements YangKeyArg {

  public YangKeyArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitKeyArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangNodeIdentifier> getNodeIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public List<YangSep> getSepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSep.class);
  }

}
