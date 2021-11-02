// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangLeafListStmtBody;
import tech.pantheon.yanginator.plugin.psi.YangStatement;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLeafListStmtBodyImpl extends YangNamedElementImpl implements YangLeafListStmtBody {

  public YangLeafListStmtBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLeafListStmtBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangStatement getStatement() {
    return findChildByClass(YangStatement.class);
  }

  @Override
  @NotNull
  public YangStmtsep getStmtsep() {
    return findNotNullChildByClass(YangStmtsep.class);
  }

  @Override
  @Nullable
  public YangTypeStmt getTypeStmt() {
    return findChildByClass(YangTypeStmt.class);
  }

}