// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangRefineListStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineListStmtsBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRefineListStmtsImpl extends YangNamedElementImpl implements YangRefineListStmts {

  public YangRefineListStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRefineListStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangRefineListStmtsBody> getRefineListStmtsBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRefineListStmtsBody.class);
  }

}
