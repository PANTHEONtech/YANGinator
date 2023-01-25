// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangOrganizationStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  YangOrganizationKeyword getOrganizationKeyword();

  @Nullable
  YangQuotedString getQuotedString();

  @Nullable
  YangStmtend getStmtend();

  @Nullable
  YangString getString();

}
