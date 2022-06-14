// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamedElementImpl;
import tech.pantheon.yanginator.plugin.highlighter.psi.*;

public class YangStmtImpl extends YangNamedElementImpl implements YangStmt {

  public YangStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangWsp> getWspList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangWsp.class);
  }

  @Override
  @NotNull
  public PsiElement getHIdentifier() {
    return findNotNullChildByType(YANG_H_IDENTIFIER);
  }

  @Override
  @NotNull
  public PsiElement getHSemicolon() {
    return findNotNullChildByType(YANG_H_SEMICOLON);
  }

  @Override
  @NotNull
  public PsiElement getHString() {
    return findNotNullChildByType(YANG_H_STRING);
  }

}
