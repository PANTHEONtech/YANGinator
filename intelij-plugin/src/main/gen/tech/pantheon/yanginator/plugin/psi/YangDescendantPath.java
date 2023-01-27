// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangDescendantPath extends YangNamedElement {

  @Nullable
  YangAbsolutePath getAbsolutePath();

  @NotNull
  YangNodeIdentifier getNodeIdentifier();

  @NotNull
  List<YangPathPredicate> getPathPredicateList();

}
