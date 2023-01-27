// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

public interface YangTypeStmt extends YangGeneratedReferenceType {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierRefArgStr getIdentifierRefArgStr();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangTypeBodyStmts getTypeBodyStmts();

  @NotNull
  YangTypeKeyword getTypeKeyword();

  @NotNull
  List<YangUnknownStatement> getUnknownStatementList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
