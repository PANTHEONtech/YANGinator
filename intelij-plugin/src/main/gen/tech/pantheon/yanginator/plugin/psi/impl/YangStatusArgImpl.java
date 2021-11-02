// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CURRENT_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DEPRECATED_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OBSOLETE_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangStatusArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangStatusArgImpl extends YangNamedElementImpl implements YangStatusArg {

  public YangStatusArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitStatusArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCurrentKeyword() {
    return findChildByType(YANG_CURRENT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getDeprecatedKeyword() {
    return findChildByType(YANG_DEPRECATED_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getObsoleteKeyword() {
    return findChildByType(YANG_OBSOLETE_KEYWORD);
  }

}
