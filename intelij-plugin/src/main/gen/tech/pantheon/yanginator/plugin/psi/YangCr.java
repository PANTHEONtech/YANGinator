// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangCr extends YangNamedElement {

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  PsiElement getCarriageReturn();

}
