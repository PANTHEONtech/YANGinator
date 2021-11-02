// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangPchar extends YangNamedElement {

  @Nullable
  YangIdentifierLiteral getIdentifierLiteral();

  @Nullable
  YangPctEncoded getPctEncoded();

  @Nullable
  YangSubDelims getSubDelims();

  @Nullable
  YangUnreserved getUnreserved();

  @Nullable
  PsiElement getColon();

}
