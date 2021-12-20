// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangLineComment;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement;
import tech.pantheon.yanginator.plugin.psi.YangUsesAugmentArgStr;
import tech.pantheon.yanginator.plugin.psi.YangUsesAugmentStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesAugmentStmtBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_AUGMENT_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;

public class YangUsesAugmentStmtImpl extends YangStatementImpl implements YangUsesAugmentStmt {

  public YangUsesAugmentStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUsesAugmentStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangLineComment> getLineCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLineComment.class);
  }

  @Override
  @NotNull
  public List<YangComment> getCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangComment.class);
  }

  @Override
  @NotNull
  public List<YangUnknownStatement> getUnknownStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnknownStatement.class);
  }

  @Override
  @Nullable
  public YangUsesAugmentArgStr getUsesAugmentArgStr() {
    return findChildByClass(YangUsesAugmentArgStr.class);
  }

  @Override
  @NotNull
  public List<YangUsesAugmentStmtBody> getUsesAugmentStmtBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUsesAugmentStmtBody.class);
  }

  @Override
  @NotNull
  public PsiElement getAugmentKeyword() {
    return findNotNullChildByType(YANG_AUGMENT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getLeftBrace() {
    return findChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getRightBrace() {
    return findChildByType(YANG_RIGHT_BRACE);
  }

}
