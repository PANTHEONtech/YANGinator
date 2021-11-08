// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangPredicateExpr extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @Nullable
  YangNodeIdentifier getNodeIdentifier();

  @NotNull
  YangNonQuotedString getNonQuotedString();

  @Nullable
  PsiElement getDot();

  @NotNull
  PsiElement getEqual();

}
