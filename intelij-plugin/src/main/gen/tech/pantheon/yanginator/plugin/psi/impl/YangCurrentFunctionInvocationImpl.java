// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CURRENT_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_PARENTHESIS;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangCurrentFunctionInvocation;
import tech.pantheon.yanginator.plugin.psi.YangSplittedCurrentKeyword;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWsp;

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
  public List<YangStringSplitter> getStringSplitterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
  }

  @Override
  @NotNull
  public List<YangWsp> getWspList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
  }

  @Override
  @Nullable
  public YangSplittedCurrentKeyword getSplittedCurrentKeyword() {
    return findChildByClass(YangSplittedCurrentKeyword.class);
  }

  @Override
  @Nullable
  public PsiElement getCurrentKeyword() {
    return findChildByType(YANG_CURRENT_KEYWORD);
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
