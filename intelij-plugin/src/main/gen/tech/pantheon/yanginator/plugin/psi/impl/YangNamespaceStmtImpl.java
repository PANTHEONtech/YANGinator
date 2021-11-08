// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceStmt;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangUriStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_NAMESPACE_KEYWORD;

public class YangNamespaceStmtImpl extends YangStatementImpl implements YangNamespaceStmt {

  public YangNamespaceStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitNamespaceStmt(this);
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
  public YangUriStr getUriStr() {
    return findNotNullChildByClass(YangUriStr.class);
  }

  @Override
  @NotNull
  public PsiElement getNamespaceKeyword() {
    return findNotNullChildByType(YANG_NAMESPACE_KEYWORD);
  }

}
