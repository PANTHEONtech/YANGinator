// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangScheme extends YangNamedElement {

  @NotNull
  List<YangDigit> getDigitList();

  @NotNull
  List<YangIdentifierLiteral> getIdentifierLiteralList();

}
