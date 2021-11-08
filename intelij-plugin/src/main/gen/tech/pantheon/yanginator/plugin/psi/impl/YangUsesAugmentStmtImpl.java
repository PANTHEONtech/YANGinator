// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
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
  public YangOptsep getOptsep() {
    return findNotNullChildByClass(YangOptsep.class);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public YangStmtsep getStmtsep() {
    return findNotNullChildByClass(YangStmtsep.class);
  }

  @Override
  @NotNull
  public YangUsesAugmentArgStr getUsesAugmentArgStr() {
    return findNotNullChildByClass(YangUsesAugmentArgStr.class);
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
  @NotNull
  public PsiElement getLeftBrace() {
    return findNotNullChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @NotNull
  public PsiElement getRightBrace() {
    return findNotNullChildByType(YANG_RIGHT_BRACE);
  }

}
