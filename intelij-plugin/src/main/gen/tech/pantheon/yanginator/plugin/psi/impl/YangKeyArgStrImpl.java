// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangKeyArg;
import tech.pantheon.yanginator.plugin.psi.YangKeyArgStr;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangKeyArgStrImpl extends YangNamedElementImpl implements YangKeyArgStr {

  public YangKeyArgStrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitKeyArgStr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangKeyArg getKeyArg() {
    return findNotNullChildByClass(YangKeyArg.class);
  }

}
