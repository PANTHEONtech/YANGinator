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

public class YangMaxValueArgImpl extends YangNamedElementImpl implements YangMaxValueArg {

  public YangMaxValueArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitMaxValueArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangPositiveIntegerValue getPositiveIntegerValue() {
    return findChildByClass(YangPositiveIntegerValue.class);
  }

  @Override
  @Nullable
  public YangUnboundedKeyword getUnboundedKeyword() {
    return findChildByClass(YangUnboundedKeyword.class);
  }

}
