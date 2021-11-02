// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import org.jetbrains.annotations.Nullable;

public interface YangStatement extends YangNamedElement {

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
  YangUnknownStatement getUnknownStatement();

  @Nullable
  YangUsesStmt getUsesStmt();

}
