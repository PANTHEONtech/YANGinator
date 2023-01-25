// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangStringSplitter extends YangNamedElement {

  @NotNull
  List<YangDquote> getDquoteList();

  @NotNull
  List<YangSquote> getSquoteList();

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  PsiElement getPlusSign();

}
