// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface YangDecimalValue extends YangNamedElement {

  @NotNull
  YangIntegerValue getIntegerValue();

  @NotNull
  YangZeroIntegerValue getZeroIntegerValue();

  @NotNull
  PsiElement getDot();

}
