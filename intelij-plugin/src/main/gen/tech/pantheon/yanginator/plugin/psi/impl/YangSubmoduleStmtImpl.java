// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangLinkageStmts;
import tech.pantheon.yanginator.plugin.psi.YangMetaStmts;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmts;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SUBMODULE_KEYWORD;

public class YangSubmoduleStmtImpl extends YangStatementImpl implements YangSubmoduleStmt {

  public YangSubmoduleStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSubmoduleStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangBodyStmts getBodyStmts() {
    return findNotNullChildByClass(YangBodyStmts.class);
  }

  @Override
  @NotNull
  public YangIdentifierArgQuoted getIdentifierArgQuoted() {
    return findNotNullChildByClass(YangIdentifierArgQuoted.class);
  }

  @Override
  @Nullable
  public YangLinkageStmts getLinkageStmts() {
    return findChildByClass(YangLinkageStmts.class);
  }

  @Override
  @Nullable
  public YangMetaStmts getMetaStmts() {
    return findChildByClass(YangMetaStmts.class);
  }

  @Override
  @NotNull
  public List<YangOptsep> getOptsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangOptsep.class);
  }

  @Override
  @NotNull
  public YangRevisionStmts getRevisionStmts() {
    return findNotNullChildByClass(YangRevisionStmts.class);
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
  public YangSubmoduleHeaderStmts getSubmoduleHeaderStmts() {
    return findNotNullChildByClass(YangSubmoduleHeaderStmts.class);
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

  @Override
  @NotNull
  public PsiElement getSubmoduleKeyword() {
    return findNotNullChildByType(YANG_SUBMODULE_KEYWORD);
  }

}
