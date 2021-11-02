// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SYSTEM_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_USER_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangOrderedByArgImpl extends YangNamedElementImpl implements YangOrderedByArg {

  public YangOrderedByArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitOrderedByArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getSystemKeyword() {
    return findChildByType(YANG_SYSTEM_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getUserKeyword() {
    return findChildByType(YANG_USER_KEYWORD);
  }

}