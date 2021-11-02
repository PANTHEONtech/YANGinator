// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangPathEqualityExpr extends YangNamedElement {

  @NotNull
  List<YangStringSplitter> getStringSplitterList();

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  YangNodeIdentifier getNodeIdentifier();

  @NotNull
  YangPathKeyExpr getPathKeyExpr();

  @NotNull
  PsiElement getEqual();

}
