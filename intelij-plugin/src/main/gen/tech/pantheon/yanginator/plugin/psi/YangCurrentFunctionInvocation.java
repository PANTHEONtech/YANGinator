// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangCurrentFunctionInvocation extends YangNamedElement {

  @NotNull
  List<YangStringSplitter> getStringSplitterList();

  @NotNull
  List<YangWsp> getWspList();

  @Nullable
  YangSplittedCurrentKeyword getSplittedCurrentKeyword();

  @Nullable
  PsiElement getCurrentKeyword();

  @NotNull
  PsiElement getLeftParenthesis();

  @NotNull
  PsiElement getRightParenthesis();

}
