// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangIdentifierRefArg extends YangNamedElement {

  @NotNull
  YangIdentifier getIdentifier();

  @Nullable
  YangPrefix getPrefix();

  @Nullable
  PsiElement getColon();

}
