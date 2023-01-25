// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangLeafListPredicateExpr extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  YangQuotedString getQuotedString();

  @NotNull
  PsiElement getDot();

  @NotNull
  PsiElement getEquals();

}
