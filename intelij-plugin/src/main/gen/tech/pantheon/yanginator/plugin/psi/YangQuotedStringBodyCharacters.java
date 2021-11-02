// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangQuotedStringBodyCharacters extends YangNamedElement {

  @Nullable
  YangHtab getHtab();

  @Nullable
  YangSp getSp();

  @Nullable
  YangVchar getVchar();

  @Nullable
  YangIdentifierLiteral getIdentifierLiteral();

  @Nullable
  YangNewLineCharacters getNewLineCharacters();

  @Nullable
  PsiElement getSingleLineCommentStart();

  @Nullable
  PsiElement getStringsDoubleQuote();

  @Nullable
  PsiElement getStringsSingleQuote();

}
