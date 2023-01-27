// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangDescendantPathImpl extends YangNamedElementImpl implements YangDescendantPath {

  public YangDescendantPathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDescendantPath(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangAbsolutePath getAbsolutePath() {
    return findChildByClass(YangAbsolutePath.class);
  }

  @Override
  @NotNull
  public YangNodeIdentifier getNodeIdentifier() {
    return findNotNullChildByClass(YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public List<YangPathPredicate> getPathPredicateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPathPredicate.class);
  }

}
