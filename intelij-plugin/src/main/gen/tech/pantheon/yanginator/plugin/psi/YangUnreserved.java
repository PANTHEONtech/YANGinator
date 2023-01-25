// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangUnreserved extends YangNamedElement {

  @Nullable
  YangDigit getDigit();

  @Nullable
  PsiElement getAlpha();

  @Nullable
  PsiElement getAlphanumericalAlphaFirst();

  @Nullable
  PsiElement getAlphanumericalDigitFirst();

  @Nullable
  PsiElement getDash();

  @Nullable
  PsiElement getDate();

  @Nullable
  PsiElement getDigits();

  @Nullable
  PsiElement getDot();

  @Nullable
  PsiElement getFractions();

  @Nullable
  PsiElement getTilde();

  @Nullable
  PsiElement getUnderscore();

}
