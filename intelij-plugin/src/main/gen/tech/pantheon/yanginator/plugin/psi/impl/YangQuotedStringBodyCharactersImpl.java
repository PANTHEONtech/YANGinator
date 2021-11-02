// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_LINE_COMMENT_START;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_STRINGS_DOUBLE_QUOTE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_STRINGS_SINGLE_QUOTE;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangHtab;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierLiteral;
import tech.pantheon.yanginator.plugin.psi.YangNewLineCharacters;
import tech.pantheon.yanginator.plugin.psi.YangQuotedStringBodyCharacters;
import tech.pantheon.yanginator.plugin.psi.YangSp;
import tech.pantheon.yanginator.plugin.psi.YangVchar;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangQuotedStringBodyCharactersImpl extends YangNamedElementImpl implements YangQuotedStringBodyCharacters {

  public YangQuotedStringBodyCharactersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitQuotedStringBodyCharacters(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangHtab getHtab() {
    return findChildByClass(YangHtab.class);
  }

  @Override
  @Nullable
  public YangSp getSp() {
    return findChildByClass(YangSp.class);
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
  public YangNewLineCharacters getNewLineCharacters() {
    return findChildByClass(YangNewLineCharacters.class);
  }

  @Override
  @Nullable
  public PsiElement getSingleLineCommentStart() {
    return findChildByType(YANG_SINGLE_LINE_COMMENT_START);
  }

  @Override
  @Nullable
  public PsiElement getStringsDoubleQuote() {
    return findChildByType(YANG_STRINGS_DOUBLE_QUOTE);
  }

  @Override
  @Nullable
  public PsiElement getStringsSingleQuote() {
    return findChildByType(YANG_STRINGS_SINGLE_QUOTE);
  }

}
