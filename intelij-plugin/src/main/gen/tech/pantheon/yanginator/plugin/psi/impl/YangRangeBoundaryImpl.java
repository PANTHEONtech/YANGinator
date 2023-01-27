// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangRangeBoundaryImpl extends YangNamedElementImpl implements YangRangeBoundary {

  public YangRangeBoundaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRangeBoundary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDecimalValue getDecimalValue() {
    return findChildByClass(YangDecimalValue.class);
  }

  @Override
  @Nullable
  public YangIntegerValue getIntegerValue() {
    return findChildByClass(YangIntegerValue.class);
  }

  @Override
  @Nullable
  public YangMaxKeyword getMaxKeyword() {
    return findChildByClass(YangMaxKeyword.class);
  }

  @Override
  @Nullable
  public YangMinKeyword getMinKeyword() {
    return findChildByClass(YangMinKeyword.class);
  }

}
