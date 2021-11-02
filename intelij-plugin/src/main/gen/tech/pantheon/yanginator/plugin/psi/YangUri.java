// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangUri extends YangNamedElement {

  @Nullable
  YangFragment getFragment();

  @NotNull
  YangHierPart getHierPart();

  @Nullable
  YangQuery getQuery();

  @NotNull
  YangScheme getScheme();

  @NotNull
  PsiElement getColon();

}
