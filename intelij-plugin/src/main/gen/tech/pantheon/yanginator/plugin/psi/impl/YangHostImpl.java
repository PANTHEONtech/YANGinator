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

public class YangHostImpl extends YangNamedElementImpl implements YangHost {

  public YangHostImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitHost(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangIPLiteral getIPLiteral() {
    return findChildByClass(YangIPLiteral.class);
  }

  @Override
  @Nullable
  public YangIPv4Address getIPv4Address() {
    return findChildByClass(YangIPv4Address.class);
  }

  @Override
  @Nullable
  public YangRegName getRegName() {
    return findChildByClass(YangRegName.class);
  }

}
