// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangPositiveIntegerValue extends YangNamedElement {

  @NotNull
  List<YangDigit> getDigitList();

  @NotNull
  YangNonZeroDigit getNonZeroDigit();

}
