// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangYangStmt extends YangNamedElement {

  @Nullable
  YangBaseStmt getBaseStmt();

  @Nullable
  YangGroupingStmt getGroupingStmt();

  @Nullable
  YangIdentityStmt getIdentityStmt();

  @Nullable
  YangTypeStmt getTypeStmt();

  @Nullable
  YangTypedefStmt getTypedefStmt();

  @Nullable
  YangUsesStmt getUsesStmt();

}
