// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangHtab extends YangNamedElement {

  @NotNull
  List<YangSp> getSpList();

  @Nullable
  PsiElement getTab();

}
