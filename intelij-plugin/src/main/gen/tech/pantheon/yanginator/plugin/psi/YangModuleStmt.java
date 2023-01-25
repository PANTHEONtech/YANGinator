// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangModuleStmt extends YangYangStmt {

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

  @Nullable
  YangModuleHeaderStmts getModuleHeaderStmts();

  @NotNull
  YangModuleKeyword getModuleKeyword();

  @NotNull
  List<YangRevisionStmt> getRevisionStmtList();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

}
