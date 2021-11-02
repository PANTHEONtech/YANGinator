// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangNonQuotedString extends YangNamedElement {

  @NotNull
  List<YangIdentifierLiteral> getIdentifierLiteralList();

  @NotNull
  List<YangUnquotedStringBodyCharacters> getUnquotedStringBodyCharactersList();

}
