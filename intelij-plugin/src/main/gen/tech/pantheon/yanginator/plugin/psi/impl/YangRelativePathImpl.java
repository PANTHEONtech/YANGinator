// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDescendantPath;
import tech.pantheon.yanginator.plugin.psi.YangRelativePath;
import tech.pantheon.yanginator.plugin.psi.YangStringSplitter;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangRelativePathImpl extends YangNamedElementImpl implements YangRelativePath {

  public YangRelativePathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitRelativePath(this);
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
  public YangDescendantPath getDescendantPath() {
    return findNotNullChildByClass(YangDescendantPath.class);
  }

}
