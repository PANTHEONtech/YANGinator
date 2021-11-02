// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangComment extends YangNamedElement {

  @Nullable
  YangLineComment getLineComment();

  @Nullable
  PsiElement getBlockComment();

}
