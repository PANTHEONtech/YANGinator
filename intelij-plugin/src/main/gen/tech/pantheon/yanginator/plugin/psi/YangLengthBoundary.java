// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangLengthBoundary extends YangNamedElement {

  @Nullable
  YangNonNegativeIntegerValue getNonNegativeIntegerValue();

  @Nullable
  PsiElement getMaxKeyword();

  @Nullable
  PsiElement getMinKeyword();

}
