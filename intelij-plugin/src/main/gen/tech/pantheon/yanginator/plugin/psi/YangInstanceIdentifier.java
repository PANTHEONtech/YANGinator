// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangInstanceIdentifier extends YangNamedElement {

  @NotNull
  List<YangNodeIdentifier> getNodeIdentifierList();

  @NotNull
  List<YangPredicate> getPredicateList();

}
