// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangUnreserved extends YangNamedElement {

  @Nullable
  YangDigit getDigit();

  @Nullable
  PsiElement getAlpha();

  @Nullable
  PsiElement getDash();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getUnderscore();

}
