// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangUnknownStatement2 extends YangNamedElement {

  @NotNull
  YangIdentifier getIdentifier();

  @NotNull
  YangOptsep getOptsep();

  @Nullable
  YangPrefix getPrefix();

  @Nullable
  YangSep getSep();

  @Nullable
  YangString getString();

  @NotNull
  List<YangUnknownStatement2> getUnknownStatement2List();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
