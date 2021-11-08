// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangDescendantPath extends YangNamedElement {

  @Nullable
  YangAbsolutePath getAbsolutePath();

  @NotNull
  YangNodeIdentifier getNodeIdentifier();

  @NotNull
  List<YangPathPredicate> getPathPredicateList();

}
