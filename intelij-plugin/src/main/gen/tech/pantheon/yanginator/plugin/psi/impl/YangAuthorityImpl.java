// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangAuthority;
import tech.pantheon.yanginator.plugin.psi.YangHost;
import tech.pantheon.yanginator.plugin.psi.YangPort;
import tech.pantheon.yanginator.plugin.psi.YangUserinfo;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangAuthorityImpl extends YangNamedElementImpl implements YangAuthority {

  public YangAuthorityImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitAuthority(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangHost getHost() {
    return findNotNullChildByClass(YangHost.class);
  }

  @Override
  @Nullable
  public YangPort getPort() {
    return findChildByClass(YangPort.class);
  }

  @Override
  @Nullable
  public YangUserinfo getUserinfo() {
    return findChildByClass(YangUserinfo.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

}
