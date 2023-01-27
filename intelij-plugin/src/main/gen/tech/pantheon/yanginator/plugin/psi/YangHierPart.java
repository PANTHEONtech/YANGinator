// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangHierPart extends YangNamedElement {

  @Nullable
  YangAuthority getAuthority();

  @Nullable
  YangPathAbempty getPathAbempty();

  @Nullable
  YangPathAbsolute getPathAbsolute();

  @Nullable
  YangPathEmpty getPathEmpty();

  @Nullable
  YangPathRootless getPathRootless();

  @Nullable
  PsiElement getDoubleForwardSlash();

}
