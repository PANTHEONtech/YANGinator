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

public class YangQuotedStringImpl extends YangNamedElementImpl implements YangQuotedString {

  public YangQuotedStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitQuotedString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangDquote> getDquoteList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDquote.class);
  }

  @Override
  @NotNull
  public List<YangSquote> getSquoteList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangSquote.class);
  }

  @Override
  @NotNull
  public List<YangDoubleQuotedVchar> getDoubleQuotedVcharList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangDoubleQuotedVchar.class);
  }

  @Override
  @NotNull
  public List<YangQuotedVchar> getQuotedVcharList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangQuotedVchar.class);
  }

  @Override
  @NotNull
  public List<YangStringSplitter> getStringSplitterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStringSplitter.class);
  }

}
