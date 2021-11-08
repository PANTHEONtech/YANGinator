// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangRefineAnyxmlStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineArgStr;
import tech.pantheon.yanginator.plugin.psi.YangRefineCaseStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineChoiceStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineContainerStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineLeafListStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineLeafStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineListStmts;
import tech.pantheon.yanginator.plugin.psi.YangRefineStmt;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtsep;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_REFINE_KEYWORD;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;

public class YangRefineStmtImpl extends YangStatementImpl implements YangRefineStmt {

  public YangRefineStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRefineStmt(this);
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
  @Nullable
  public YangRefineAnyxmlStmts getRefineAnyxmlStmts() {
    return findChildByClass(YangRefineAnyxmlStmts.class);
  }

  @Override
  @NotNull
  public YangRefineArgStr getRefineArgStr() {
    return findNotNullChildByClass(YangRefineArgStr.class);
  }

  @Override
  @Nullable
  public YangRefineCaseStmts getRefineCaseStmts() {
    return findChildByClass(YangRefineCaseStmts.class);
  }

  @Override
  @Nullable
  public YangRefineChoiceStmts getRefineChoiceStmts() {
    return findChildByClass(YangRefineChoiceStmts.class);
  }

  @Override
  @Nullable
  public YangRefineContainerStmts getRefineContainerStmts() {
    return findChildByClass(YangRefineContainerStmts.class);
  }

  @Override
  @Nullable
  public YangRefineLeafListStmts getRefineLeafListStmts() {
    return findChildByClass(YangRefineLeafListStmts.class);
  }

  @Override
  @Nullable
  public YangRefineLeafStmts getRefineLeafStmts() {
    return findChildByClass(YangRefineLeafStmts.class);
  }

  @Override
  @Nullable
  public YangRefineListStmts getRefineListStmts() {
    return findChildByClass(YangRefineListStmts.class);
  }

  @Override
  @NotNull
  public YangSep getSep() {
    return findNotNullChildByClass(YangSep.class);
  }

  @Override
  @Nullable
  public YangStmtsep getStmtsep() {
    return findChildByClass(YangStmtsep.class);
  }

  @Override
  @Nullable
  public PsiElement getLeftBrace() {
    return findChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @NotNull
  public PsiElement getRefineKeyword() {
    return findNotNullChildByType(YANG_REFINE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getRightBrace() {
    return findChildByType(YANG_RIGHT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(YANG_SEMICOLON);
  }

}
