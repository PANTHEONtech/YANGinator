// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangMetaStmts;
import tech.pantheon.yanginator.plugin.psi.YangMetaStmtsBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangMetaStmtsImpl extends YangNamedElementImpl implements YangMetaStmts {

  public YangMetaStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMetaStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangMetaStmtsBody> getMetaStmtsBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangMetaStmtsBody.class);
  }

}
