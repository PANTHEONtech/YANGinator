// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangRefineContainerStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineContainerStmtsBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRefineContainerStmtsImpl extends YangNamedElementImpl implements YangRefineContainerStmts {

  public YangRefineContainerStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRefineContainerStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangRefineContainerStmtsBody> getRefineContainerStmtsBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRefineContainerStmtsBody.class);
  }

}
