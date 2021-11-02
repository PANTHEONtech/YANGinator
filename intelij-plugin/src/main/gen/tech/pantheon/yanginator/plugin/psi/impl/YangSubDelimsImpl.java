// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUAL;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_QUOTE;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangSubDelims;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangSubDelimsImpl extends YangNamedElementImpl implements YangSubDelims {

  public YangSubDelimsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSubDelims(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getEqual() {
    return findChildByType(YANG_EQUAL);
  }

  @Override
  @Nullable
  public PsiElement getLeftParenthesis() {
    return findChildByType(YANG_LEFT_PARENTHESIS);
  }

  @Override
  @Nullable
  public PsiElement getRightParenthesis() {
    return findChildByType(YANG_RIGHT_PARENTHESIS);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(YANG_SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getSingleQuote() {
    return findChildByType(YANG_SINGLE_QUOTE);
  }

}
