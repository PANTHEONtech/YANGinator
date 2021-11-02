// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_LINE_COMMENT_START;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangLineComment;
import tech.pantheon.yanginator.plugin.psi.YangNewLineCharacters;
import tech.pantheon.yanginator.plugin.psi.YangSingleLineCharacters;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangLineCommentImpl extends YangNamedElementImpl implements YangLineComment {

  public YangLineCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitLineComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangNewLineCharacters getNewLineCharacters() {
    return findChildByClass(YangNewLineCharacters.class);
  }

  @Override
  @NotNull
  public List<YangSingleLineCharacters> getSingleLineCharactersList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSingleLineCharacters.class);
  }

  @Override
  @NotNull
  public PsiElement getSingleLineCommentStart() {
    return findNotNullChildByType(YANG_SINGLE_LINE_COMMENT_START);
  }

}
