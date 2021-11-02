// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_UNIQUE_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangUniqueArgStr;
import tech.pantheon.yanginator.plugin.psi.YangUniqueStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUniqueStmtImpl extends YangStatementImpl implements YangUniqueStmt {

  public YangUniqueStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUniqueStmt(this);
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
  public YangUniqueArgStr getUniqueArgStr() {
    return findNotNullChildByClass(YangUniqueArgStr.class);
  }

  @Override
  @NotNull
  public PsiElement getUniqueKeyword() {
    return findNotNullChildByType(YANG_UNIQUE_KEYWORD);
  }

}
