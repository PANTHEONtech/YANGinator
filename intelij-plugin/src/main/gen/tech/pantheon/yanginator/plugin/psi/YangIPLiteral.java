// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangIPLiteral extends YangNamedElement {

  @Nullable
  YangIPv6Address getIPv6Address();

  @Nullable
  YangIPvFuture getIPvFuture();

  @NotNull
  PsiElement getClosedBracket();

  @NotNull
  PsiElement getOpenBracket();

}
