// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

import java.util.List;

public interface YangBaseStmt extends YangGeneratedReferenceType {

  @NotNull
  List<YangLineComment> getLineCommentList();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierRefArgQuoted getIdentifierRefArgQuoted();

  @Nullable
  YangStmtend getStmtend();

  @NotNull
  PsiElement getBaseKeyword();

}
