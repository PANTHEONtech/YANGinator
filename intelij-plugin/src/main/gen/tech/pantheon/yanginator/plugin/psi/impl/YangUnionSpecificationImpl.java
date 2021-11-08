// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnionSpecification;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangUnionSpecificationImpl extends YangNamedElementImpl implements YangUnionSpecification {

  public YangUnionSpecificationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUnionSpecification(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangStmtsep> getStmtsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
  }

  @Override
  @NotNull
  public List<YangTypeStmt> getTypeStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangTypeStmt.class);
  }

}
