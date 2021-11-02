// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_VALUE_KEYWORD;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangIntegerValueStr;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangStmtend;
import tech.pantheon.yanginator.plugin.psi.YangValueStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangValueStmtImpl extends YangStatementImpl implements YangValueStmt {

  public YangValueStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitValueStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIntegerValue getIntegerValue() {
    return findChildByClass(YangIntegerValue.class);
  }

  @Override
  @Nullable
  public YangIntegerValueStr getIntegerValueStr() {
    return findChildByClass(YangIntegerValueStr.class);
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
  public PsiElement getValueKeyword() {
    return findNotNullChildByType(YANG_VALUE_KEYWORD);
  }

}
