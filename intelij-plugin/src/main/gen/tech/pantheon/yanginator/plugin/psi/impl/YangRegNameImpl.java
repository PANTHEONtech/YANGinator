// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierLiteral;
import tech.pantheon.yanginator.plugin.psi.YangPctEncoded;
import tech.pantheon.yanginator.plugin.psi.YangRegName;
import tech.pantheon.yanginator.plugin.psi.YangSubDelims;
import tech.pantheon.yanginator.plugin.psi.YangUnreserved;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangRegNameImpl extends YangNamedElementImpl implements YangRegName {

  public YangRegNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRegName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangIdentifierLiteral> getIdentifierLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangIdentifierLiteral.class);
  }

  @Override
  @NotNull
  public List<YangPctEncoded> getPctEncodedList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangPctEncoded.class);
  }

  @Override
  @NotNull
  public List<YangSubDelims> getSubDelimsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSubDelims.class);
  }

  @Override
  @NotNull
  public List<YangUnreserved> getUnreservedList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnreserved.class);
  }

}
