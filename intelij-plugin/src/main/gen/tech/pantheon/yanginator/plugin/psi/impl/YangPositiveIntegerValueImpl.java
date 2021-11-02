// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangNonZeroDigit;
import tech.pantheon.yanginator.plugin.psi.YangPositiveIntegerValue;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangPositiveIntegerValueImpl extends YangNamedElementImpl implements YangPositiveIntegerValue {

  public YangPositiveIntegerValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitPositiveIntegerValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangDigit> getDigitList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDigit.class);
  }

  @Override
  @NotNull
  public YangNonZeroDigit getNonZeroDigit() {
    return findNotNullChildByClass(YangNonZeroDigit.class);
  }

}
