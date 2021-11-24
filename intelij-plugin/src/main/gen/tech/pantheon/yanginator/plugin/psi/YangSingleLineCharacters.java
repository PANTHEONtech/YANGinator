// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangSingleLineCharacters extends YangNamedElement {

  @Nullable
  YangVchar getVchar();

  @Nullable
  YangIdentifierLiteral getIdentifierLiteral();

  @Nullable
  PsiElement getDoubleQuote();

  @Nullable
  PsiElement getSingleLineCommentStart();

  @Nullable
  PsiElement getSingleQuote();

  @Nullable
  PsiElement getSpace();

  @Nullable
  PsiElement getTab();

}
