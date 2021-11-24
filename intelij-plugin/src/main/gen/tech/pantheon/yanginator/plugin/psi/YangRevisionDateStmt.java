// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface YangRevisionDateStmt extends YangStatement {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangRevisionDate getRevisionDate();

  @NotNull
  YangStmtend getStmtend();

  @NotNull
  PsiElement getRevisionDateKeyword();

}
