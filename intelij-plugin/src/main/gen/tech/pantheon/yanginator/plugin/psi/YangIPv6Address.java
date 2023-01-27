// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangIPv6Address extends YangNamedElement {

  @NotNull
  List<YangH16> getH16List();

  @Nullable
  YangLs32 getLs32();

  @Nullable
  PsiElement getDoubleColon();

}
