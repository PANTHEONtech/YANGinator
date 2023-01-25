// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;

public interface YangDummy extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  PsiElement getHIdentifier();

  @Nullable
  PsiElement getHString();

}
