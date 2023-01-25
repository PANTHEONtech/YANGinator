// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangInstanceIdentifier extends YangNamedElement {

  @NotNull
  List<YangKeyPredicate> getKeyPredicateList();

  @NotNull
  List<YangLeafListPredicate> getLeafListPredicateList();

  @NotNull
  List<YangNodeIdentifier> getNodeIdentifierList();

  @NotNull
  List<YangPos> getPosList();

}
