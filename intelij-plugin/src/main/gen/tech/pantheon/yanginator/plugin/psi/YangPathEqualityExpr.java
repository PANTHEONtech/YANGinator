// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangPathEqualityExpr extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  YangNodeIdentifier getNodeIdentifier();

  @NotNull
  YangPathKeyExpr getPathKeyExpr();

  @NotNull
  PsiElement getEquals();

}
