// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierLiteral;
import tech.pantheon.yanginator.plugin.psi.YangNonQuotedString;
import tech.pantheon.yanginator.plugin.psi.YangUnquotedStringBodyCharacters;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangNonQuotedStringImpl extends YangNamedElementImpl implements YangNonQuotedString {

  public YangNonQuotedStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitNonQuotedString(this);
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
  public List<YangUnquotedStringBodyCharacters> getUnquotedStringBodyCharactersList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnquotedStringBodyCharacters.class);
  }

}
