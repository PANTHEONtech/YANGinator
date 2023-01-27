// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangLengthPart extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLengthBoundary> getLengthBoundaryList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  PsiElement getDoubleDot();

}
