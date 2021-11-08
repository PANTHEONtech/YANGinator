// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryArgStr;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryStmt;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_MANDATORY_KEYWORD;

public class YangMandatoryStmtImpl extends YangStatementImpl implements YangMandatoryStmt {

  public YangMandatoryStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMandatoryStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangMandatoryArgStr getMandatoryArgStr() {
    return findNotNullChildByClass(YangMandatoryArgStr.class);
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
  public PsiElement getMandatoryKeyword() {
    return findNotNullChildByType(YANG_MANDATORY_KEYWORD);
  }

}
