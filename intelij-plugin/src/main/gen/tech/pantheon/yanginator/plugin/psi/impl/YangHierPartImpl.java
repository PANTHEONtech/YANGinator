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

public class YangHierPartImpl extends YangNamedElementImpl implements YangHierPart {

  public YangHierPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitHierPart(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangAuthority getAuthority() {
    return findChildByClass(YangAuthority.class);
  }

  @Override
  @Nullable
  public YangPathAbempty getPathAbempty() {
    return findChildByClass(YangPathAbempty.class);
  }

  @Override
  @Nullable
  public YangPathAbsolute getPathAbsolute() {
    return findChildByClass(YangPathAbsolute.class);
  }

  @Override
  @Nullable
  public YangPathEmpty getPathEmpty() {
    return findChildByClass(YangPathEmpty.class);
  }

  @Override
  @Nullable
  public YangPathRootless getPathRootless() {
    return findChildByClass(YangPathRootless.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleForwardSlash() {
    return findChildByType(YANG_DOUBLE_FORWARD_SLASH);
  }

}
