// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangAugmentArgStr extends YangNamedElement {

  @NotNull
  List<YangDquote> getDquoteList();

  @NotNull
  List<YangAugmentArg> getAugmentArgList();

  @NotNull
  List<YangStringSplitter> getStringSplitterList();

}
