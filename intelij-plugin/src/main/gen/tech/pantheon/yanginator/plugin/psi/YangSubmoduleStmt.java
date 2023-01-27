// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangSubmoduleStmt extends YangYangStmt {

  @NotNull
  List<YangWsp> getWspList();

  @Nullable
  YangBodyStmts getBodyStmts();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierArgStr getIdentifierArgStr();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangLinkageStmts getLinkageStmts();

  @Nullable
  YangMetaStmts getMetaStmts();

  @NotNull
  List<YangRevisionStmt> getRevisionStmtList();

  @Nullable
  YangSubmoduleHeaderStmts getSubmoduleHeaderStmts();

  @NotNull
  YangSubmoduleKeyword getSubmoduleKeyword();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

}
