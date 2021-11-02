// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangEnumStmtBody;
import tech.pantheon.yanginator.plugin.psi.YangStatement;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangEnumStmtBodyImpl extends YangNamedElementImpl implements YangEnumStmtBody {

  public YangEnumStmtBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitEnumStmtBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangStatement getStatement() {
    return findNotNullChildByClass(YangStatement.class);
  }

  @Override
  @NotNull
  public YangStmtsep getStmtsep() {
    return findNotNullChildByClass(YangStmtsep.class);
  }

}
