// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_TYPEDEF_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmtBody;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceTypeImpl;

public class YangTypedefStmtImpl extends YangGeneratedReferenceTypeImpl implements YangTypedefStmt {

  public YangTypedefStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitTypedefStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangIdentifierArgQuoted getIdentifierArgQuoted() {
    return findNotNullChildByClass(YangIdentifierArgQuoted.class);
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
  public List<YangTypedefStmtBody> getTypedefStmtBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangTypedefStmtBody.class);
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
  public PsiElement getTypedefKeyword() {
    return findNotNullChildByType(YANG_TYPEDEF_KEYWORD);
  }

}
