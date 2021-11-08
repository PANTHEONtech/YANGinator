// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangString extends YangNamedElement {

  @NotNull
  List<YangSingleQuoteStringSplitter> getSingleQuoteStringSplitterList();

  @NotNull
  List<YangStringSplitter> getStringSplitterList();

  @NotNull
  List<YangIdentifierLiteral> getIdentifierLiteralList();

  @Nullable
  YangNonQuotedString getNonQuotedString();

  @NotNull
  List<YangQuotedStringBodyCharacters> getQuotedStringBodyCharactersList();

  @NotNull
  List<YangSingleQuotedStringBodyCharacters> getSingleQuotedStringBodyCharactersList();

}
