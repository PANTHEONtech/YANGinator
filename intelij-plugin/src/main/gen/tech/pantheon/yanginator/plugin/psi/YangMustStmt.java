// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangMustStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @NotNull
  YangMustKeyword getMustKeyword();

  @Nullable
  YangQuotedString getQuotedString();

  @Nullable
  YangString getString();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
