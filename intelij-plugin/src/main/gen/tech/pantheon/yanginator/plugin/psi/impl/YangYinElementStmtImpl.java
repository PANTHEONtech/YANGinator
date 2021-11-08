// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangYinElementArgStr;
import tech.pantheon.yanginator.plugin.psi.YangYinElementStmt;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_YIN_ELEMENT_KEYWORD;

public class YangYinElementStmtImpl extends YangStatementImpl implements YangYinElementStmt {

  public YangYinElementStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYinElementStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @NotNull
  public YangStmtend getStmtend() {
    return findNotNullChildByClass(YangStmtend.class);
  }

  @Override
  @NotNull
  public YangYinElementArgStr getYinElementArgStr() {
    return findNotNullChildByClass(YangYinElementArgStr.class);
  }

  @Override
  @NotNull
  public PsiElement getYinElementKeyword() {
    return findNotNullChildByType(YANG_YIN_ELEMENT_KEYWORD);
  }

}
