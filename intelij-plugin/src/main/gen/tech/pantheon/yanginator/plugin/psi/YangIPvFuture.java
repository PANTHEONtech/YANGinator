// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangIPvFuture extends YangNamedElement {

  @NotNull
  List<YangHexdig> getHexdigList();

  @NotNull
  List<YangSubDelims> getSubDelimsList();

  @NotNull
  List<YangUnreserved> getUnreservedList();

  @NotNull
  PsiElement getDot();

}
