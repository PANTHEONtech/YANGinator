// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierLiteral;
import tech.pantheon.yanginator.plugin.psi.YangUnquotedStringBodyCharacters;
import tech.pantheon.yanginator.plugin.psi.YangUnquotedVchar;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_LINE_COMMENT_START;

public class YangUnquotedStringBodyCharactersImpl extends YangNamedElementImpl implements YangUnquotedStringBodyCharacters {

  public YangUnquotedStringBodyCharactersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUnquotedStringBodyCharacters(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIdentifierLiteral getIdentifierLiteral() {
    return findChildByClass(YangIdentifierLiteral.class);
  }

  @Override
  @Nullable
  public YangUnquotedVchar getUnquotedVchar() {
    return findChildByClass(YangUnquotedVchar.class);
  }

  @Override
  @Nullable
  public PsiElement getSingleLineCommentStart() {
    return findChildByType(YANG_SINGLE_LINE_COMMENT_START);
  }

}
