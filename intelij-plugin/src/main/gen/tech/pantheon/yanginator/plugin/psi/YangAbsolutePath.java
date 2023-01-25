// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangAbsolutePath extends YangNamedElement {

  @NotNull
  List<YangNodeIdentifier> getNodeIdentifierList();

  @NotNull
  List<YangPathPredicate> getPathPredicateList();

}
