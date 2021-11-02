// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangAuthority extends YangNamedElement {

  @NotNull
  YangHost getHost();

  @Nullable
  YangPort getPort();

  @Nullable
  YangUserinfo getUserinfo();

  @Nullable
  PsiElement getColon();

}
