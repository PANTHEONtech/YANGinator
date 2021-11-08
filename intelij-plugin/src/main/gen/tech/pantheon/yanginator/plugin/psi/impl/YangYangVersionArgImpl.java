// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionArg;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;

public class YangYangVersionArgImpl extends YangNamedElementImpl implements YangYangVersionArg {

  public YangYangVersionArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYangVersionArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(YANG_DOT);
  }

}
