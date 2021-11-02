// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

public interface YangTypeStmt extends YangGeneratedReferenceType {

  @NotNull
  YangIdentifierRefArgQuoted getIdentifierRefArgQuoted();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @NotNull
  List<YangTypeBodyStmts> getTypeBodyStmtsList();

  @Nullable
  PsiElement getLeftBrace();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

  @NotNull
  PsiElement getTypeKeyword();

}
