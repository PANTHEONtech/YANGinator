// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangRangeBoundary extends YangNamedElement {

  @Nullable
  YangDecimalValue getDecimalValue();

  @Nullable
  YangIntegerValue getIntegerValue();

  @Nullable
  PsiElement getMaxKeyword();

  @Nullable
  PsiElement getMinKeyword();

}
