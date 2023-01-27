// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangAbsoluteURI extends YangNamedElement {

  @NotNull
  YangHierPart getHierPart();

  @Nullable
  YangQuery getQuery();

  @NotNull
  YangScheme getScheme();

  @NotNull
  PsiElement getColon();

  @Nullable
  PsiElement getQuestionMark();

}
