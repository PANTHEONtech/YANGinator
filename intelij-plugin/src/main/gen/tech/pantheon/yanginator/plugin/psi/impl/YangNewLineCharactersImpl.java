// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CARRIAGE_RETURN;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LINEFEED;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangNewLineCharacters;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangNewLineCharactersImpl extends YangNamedElementImpl implements YangNewLineCharacters {

  public YangNewLineCharactersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitNewLineCharacters(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCarriageReturn() {
    return findChildByType(YANG_CARRIAGE_RETURN);
  }

  @Override
  @Nullable
  public PsiElement getLinefeed() {
    return findChildByType(YANG_LINEFEED);
  }

}
