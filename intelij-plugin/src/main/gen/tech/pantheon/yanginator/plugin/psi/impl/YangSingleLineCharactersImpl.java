// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierLiteral;
import tech.pantheon.yanginator.plugin.psi.YangSingleLineCharacters;
import tech.pantheon.yanginator.plugin.psi.YangVchar;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_QUOTE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_LINE_COMMENT_START;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_QUOTE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SPACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TAB;

public class YangSingleLineCharactersImpl extends YangNamedElementImpl implements YangSingleLineCharacters {

  public YangSingleLineCharactersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSingleLineCharacters(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangVchar getVchar() {
    return findChildByClass(YangVchar.class);
  }

  @Override
  @Nullable
  public YangIdentifierLiteral getIdentifierLiteral() {
    return findChildByClass(YangIdentifierLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleQuote() {
    return findChildByType(YANG_DOUBLE_QUOTE);
  }

  @Override
  @Nullable
  public PsiElement getSingleLineCommentStart() {
    return findChildByType(YANG_SINGLE_LINE_COMMENT_START);
  }

  @Override
  @Nullable
  public PsiElement getSingleQuote() {
    return findChildByType(YANG_SINGLE_QUOTE);
  }

  @Override
  @Nullable
  public PsiElement getSpace() {
    return findChildByType(YANG_SPACE);
  }

  @Override
  @Nullable
  public PsiElement getTab() {
    return findChildByType(YANG_TAB);
  }

}
