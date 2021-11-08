// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangAbsoluteSchemaNodeidQuoted;
import tech.pantheon.yanginator.plugin.psi.YangNodeIdentifierQuoted;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangAbsoluteSchemaNodeidQuotedImpl extends YangNamedElementImpl implements YangAbsoluteSchemaNodeidQuoted {

  public YangAbsoluteSchemaNodeidQuotedImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitAbsoluteSchemaNodeidQuoted(this);
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
  public List<YangNodeIdentifierQuoted> getNodeIdentifierQuotedList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangNodeIdentifierQuoted.class);
  }

}
