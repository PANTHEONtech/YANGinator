// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface YangUnknownStatement extends YangNamedElement {

  @NotNull
  YangIdentifier getIdentifier();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangPrefix getPrefix();

  @Nullable
  YangSep getSep();

  @Nullable
  YangString getString();

  @NotNull
  List<YangUnknownStatement2> getUnknownStatement2List();

  @NotNull
  PsiElement getColon();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
