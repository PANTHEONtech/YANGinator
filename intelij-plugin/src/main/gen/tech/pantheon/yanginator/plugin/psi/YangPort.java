// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangPort extends YangNamedElement {

  @NotNull
  List<YangDigit> getDigitList();

  @Nullable
  PsiElement getDigits();

  @Nullable
  PsiElement getFractions();

  @Nullable
  PsiElement getZeros();

}
