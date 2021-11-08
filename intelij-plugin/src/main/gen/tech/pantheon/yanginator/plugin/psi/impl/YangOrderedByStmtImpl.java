// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByArgStr;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByStmt;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ORDERED_BY_KEYWORD;

public class YangOrderedByStmtImpl extends YangStatementImpl implements YangOrderedByStmt {

  public YangOrderedByStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitOrderedByStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangOrderedByArgStr getOrderedByArgStr() {
    return findNotNullChildByClass(YangOrderedByArgStr.class);
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
  public PsiElement getOrderedByKeyword() {
    return findNotNullChildByType(YANG_ORDERED_BY_KEYWORD);
  }

}
