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

public class YangUriImpl extends YangNamedElementImpl implements YangUri {

  public YangUriImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUri(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangFragment getFragment() {
    return findChildByClass(YangFragment.class);
  }

  @Override
  @NotNull
  public YangHierPart getHierPart() {
    return findNotNullChildByClass(YangHierPart.class);
  }

  @Override
  @Nullable
  public YangQuery getQuery() {
    return findChildByClass(YangQuery.class);
  }

  @Override
  @NotNull
  public YangScheme getScheme() {
    return findNotNullChildByClass(YangScheme.class);
  }

  @Override
  @NotNull
  public PsiElement getColon() {
    return findNotNullChildByType(YANG_COLON);
  }

  @Override
  @Nullable
  public PsiElement getHash() {
    return findChildByType(YANG_HASH);
  }

  @Override
  @Nullable
  public PsiElement getQuestionMark() {
    return findChildByType(YANG_QUESTION_MARK);
  }

}
