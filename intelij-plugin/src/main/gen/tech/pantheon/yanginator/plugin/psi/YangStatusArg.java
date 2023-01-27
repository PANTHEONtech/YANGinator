// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangStatusArg extends YangNamedElement {

  @Nullable
  YangCurrentKeyword getCurrentKeyword();

  @Nullable
  YangDeprecatedKeyword getDeprecatedKeyword();

  @Nullable
  YangObsoleteKeyword getObsoleteKeyword();

}
