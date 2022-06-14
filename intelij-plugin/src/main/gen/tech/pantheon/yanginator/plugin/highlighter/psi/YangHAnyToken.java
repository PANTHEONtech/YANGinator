// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;

public interface YangHAnyToken extends YangNamedElement {

  @Nullable
  YangHIdentifierLiteral getHIdentifierLiteral();

  @Nullable
  PsiElement getHBlockComment();

  @Nullable
  PsiElement getHDateArg();

  @Nullable
  PsiElement getHExtensionIdentifier();

  @Nullable
  PsiElement getHIdentifier();

  @Nullable
  PsiElement getHSemicolon();

  @Nullable
  PsiElement getHSingleLineComment();

  @Nullable
  PsiElement getHString();

}
