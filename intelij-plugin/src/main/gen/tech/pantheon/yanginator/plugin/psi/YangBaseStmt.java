// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

public interface YangBaseStmt extends YangGeneratedReferenceType {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  YangBaseKeyword getBaseKeyword();

  @NotNull
  List<YangComment> getCommentList();

  @Nullable
  YangIdentifierRefArgStr getIdentifierRefArgStr();

  @NotNull
  List<YangLineBreak> getLineBreakList();

  @Nullable
  YangStmtend getStmtend();

}
