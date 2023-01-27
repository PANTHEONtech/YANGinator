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

public class YangInstanceIdentifierImpl extends YangNamedElementImpl implements YangInstanceIdentifier {

  public YangInstanceIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitInstanceIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangKeyPredicate> getKeyPredicateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangKeyPredicate.class);
  }

  @Override
  @NotNull
  public List<YangLeafListPredicate> getLeafListPredicateList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLeafListPredicate.class);
  }

  @Override
  @NotNull
  public List<YangNodeIdentifier> getNodeIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNodeIdentifier.class);
  }

  @Override
  @NotNull
  public List<YangPos> getPosList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPos.class);
  }

}
