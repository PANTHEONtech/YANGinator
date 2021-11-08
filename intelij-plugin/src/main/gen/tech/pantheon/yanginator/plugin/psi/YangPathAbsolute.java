// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangPathAbsolute extends YangNamedElement {

  @NotNull
  List<YangSegment> getSegmentList();

  @Nullable
  YangSegmentNz getSegmentNz();

}
