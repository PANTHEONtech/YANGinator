// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangRelativePath extends YangNamedElement {

  @NotNull
  List<YangStringSplitter> getStringSplitterList();

  @NotNull
  YangDescendantPath getDescendantPath();

}
