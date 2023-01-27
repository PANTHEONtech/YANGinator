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

public class YangIPv6AddressImpl extends YangNamedElementImpl implements YangIPv6Address {

  public YangIPv6AddressImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitIPv6Address(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangH16> getH16List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangH16.class);
  }

  @Override
  @Nullable
  public YangLs32 getLs32() {
    return findChildByClass(YangLs32.class);
  }

  @Override
  @Nullable
  public PsiElement getDoubleColon() {
    return findChildByType(YANG_DOUBLE_COLON);
  }

}
