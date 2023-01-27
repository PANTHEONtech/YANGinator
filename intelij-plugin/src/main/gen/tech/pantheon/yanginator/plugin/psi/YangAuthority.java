// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangAuthority extends YangNamedElement {

  @NotNull
  YangHost getHost();

  @Nullable
  YangPort getPort();

  @Nullable
  YangUserinfo getUserinfo();

  @Nullable
  PsiElement getAtSign();

  @Nullable
  PsiElement getColon();

}
