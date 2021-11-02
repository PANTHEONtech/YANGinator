// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmt;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmts;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangRevisionStmtsImpl extends YangNamedElementImpl implements YangRevisionStmts {

  public YangRevisionStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRevisionStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangRevisionStmt> getRevisionStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangRevisionStmt.class);
  }

  @Override
  @NotNull
  public List<YangStmtsep> getStmtsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
  }

}
