// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangOrganizationStmt;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangString;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ORGANIZATION_KEYWORD;

public class YangOrganizationStmtImpl extends YangStatementImpl implements YangOrganizationStmt {

  public YangOrganizationStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitOrganizationStmt(this);
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
  public YangStmtend getStmtend() {
    return findNotNullChildByClass(YangStmtend.class);
  }

  @Override
  @NotNull
  public YangString getString() {
    return findNotNullChildByClass(YangString.class);
  }

  @Override
  @NotNull
  public PsiElement getOrganizationKeyword() {
    return findNotNullChildByType(YANG_ORGANIZATION_KEYWORD);
  }

}
