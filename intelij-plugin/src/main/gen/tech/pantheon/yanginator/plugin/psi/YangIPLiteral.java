// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
