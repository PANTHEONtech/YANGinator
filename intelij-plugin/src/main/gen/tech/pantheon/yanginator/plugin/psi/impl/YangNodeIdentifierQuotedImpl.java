// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierQuoted;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifierQuoted;
import tech.pantheon.yanginator.plugin.psi.YangPrefixQuoted;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

public class YangNodeIdentifierQuotedImpl extends YangNamedElementImpl implements YangNodeIdentifierQuoted {

  public YangNodeIdentifierQuotedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitNodeIdentifierQuoted(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangStringSplitter> getStringSplitterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
  }

  @Override
  @NotNull
  public YangIdentifierQuoted getIdentifierQuoted() {
    return findNotNullChildByClass(YangIdentifierQuoted.class);
  }

  @Override
  @Nullable
  public YangPrefixQuoted getPrefixQuoted() {
    return findChildByClass(YangPrefixQuoted.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

}
