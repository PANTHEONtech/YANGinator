// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangRegName extends YangNamedElement {

  @NotNull
  List<YangIdentifierLiteral> getIdentifierLiteralList();

  @NotNull
  List<YangPctEncoded> getPctEncodedList();

  @NotNull
  List<YangSubDelims> getSubDelimsList();

  @NotNull
  List<YangUnreserved> getUnreservedList();

}
