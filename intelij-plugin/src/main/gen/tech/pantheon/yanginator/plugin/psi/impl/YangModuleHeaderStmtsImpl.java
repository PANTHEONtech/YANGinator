// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmtsBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangModuleHeaderStmtsImpl extends YangNamedElementImpl implements YangModuleHeaderStmts {

  public YangModuleHeaderStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitModuleHeaderStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangModuleHeaderStmtsBody> getModuleHeaderStmtsBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangModuleHeaderStmtsBody.class);
  }

}
