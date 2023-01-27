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

public class YangGenDelimsImpl extends YangNamedElementImpl implements YangGenDelims {

  public YangGenDelimsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitGenDelims(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getAtSign() {
    return findChildByType(YANG_AT_SIGN);
  }

  @Override
  @Nullable
  public PsiElement getClosedBracket() {
    return findChildByType(YANG_CLOSED_BRACKET);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

  @Override
  @Nullable
  public PsiElement getForwardSlash() {
    return findChildByType(YANG_FORWARD_SLASH);
  }

  @Override
  @Nullable
  public PsiElement getHash() {
    return findChildByType(YANG_HASH);
  }

  @Override
  @Nullable
  public PsiElement getOpenBracket() {
    return findChildByType(YANG_OPEN_BRACKET);
  }

  @Override
  @Nullable
  public PsiElement getQuestionMark() {
    return findChildByType(YANG_QUESTION_MARK);
  }

}
