// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangBitStmt;
import tech.pantheon.yanginator.plugin.psi.YangBitsSpecification;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangBitsSpecificationImpl extends YangNamedElementImpl implements YangBitsSpecification {

  public YangBitsSpecificationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitBitsSpecification(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangBitStmt> getBitStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangBitStmt.class);
  }

  @Override
  @NotNull
  public List<YangStmtsep> getStmtsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStmtsep.class);
  }

}
