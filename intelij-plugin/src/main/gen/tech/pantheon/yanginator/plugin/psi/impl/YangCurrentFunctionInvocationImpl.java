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

public class YangCurrentFunctionInvocationImpl extends YangNamedElementImpl implements YangCurrentFunctionInvocation {

  public YangCurrentFunctionInvocationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitCurrentFunctionInvocation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangWsp> getWspList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
  }

  @Override
  @NotNull
  public YangCurrentKeyword getCurrentKeyword() {
    return findNotNullChildByClass(YangCurrentKeyword.class);
  }

  @Override
  @NotNull
  public PsiElement getLeftParenthesis() {
    return findNotNullChildByType(YANG_LEFT_PARENTHESIS);
  }

  @Override
  @NotNull
  public PsiElement getRightParenthesis() {
    return findNotNullChildByType(YANG_RIGHT_PARENTHESIS);
  }

}
