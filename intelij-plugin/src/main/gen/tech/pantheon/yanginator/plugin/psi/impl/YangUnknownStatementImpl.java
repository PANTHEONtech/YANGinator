// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIdentifier;
import tech.pantheon.yanginator.plugin.psi.YangOptsep;
import tech.pantheon.yanginator.plugin.psi.YangPrefix;
import tech.pantheon.yanginator.plugin.psi.YangSep;
import tech.pantheon.yanginator.plugin.psi.YangString;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement2;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangUnknownStatementImpl extends YangNamedElementImpl implements YangUnknownStatement {

  public YangUnknownStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitUnknownStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangIdentifier getIdentifier() {
    return findNotNullChildByClass(YangIdentifier.class);
  }

  @Override
  @NotNull
  public YangOptsep getOptsep() {
    return findNotNullChildByClass(YangOptsep.class);
  }

  @Override
  @NotNull
  public YangPrefix getPrefix() {
    return findNotNullChildByClass(YangPrefix.class);
  }

  @Override
  @Nullable
  public YangSep getSep() {
    return findChildByClass(YangSep.class);
  }

  @Override
  @Nullable
  public YangString getString() {
    return findChildByClass(YangString.class);
  }

  @Override
  @NotNull
  public List<YangUnknownStatement2> getUnknownStatement2List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnknownStatement2.class);
  }

  @Override
  @NotNull
  public PsiElement getColon() {
    return findNotNullChildByType(YANG_COLON);
  }

  @Override
  @Nullable
  public PsiElement getLeftBrace() {
    return findChildByType(YANG_LEFT_BRACE);
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
