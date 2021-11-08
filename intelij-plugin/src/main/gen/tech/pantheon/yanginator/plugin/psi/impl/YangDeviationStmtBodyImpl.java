// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDeviationStmtBody;
import tech.pantheon.yanginator.plugin.psi.YangStatement;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangDeviationStmtBodyImpl extends YangNamedElementImpl implements YangDeviationStmtBody {

  public YangDeviationStmtBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDeviationStmtBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStatement.class);
  }

  @Override
  @Nullable
  public YangStmtsep getStmtsep() {
    return findChildByClass(YangStmtsep.class);
  }

}
