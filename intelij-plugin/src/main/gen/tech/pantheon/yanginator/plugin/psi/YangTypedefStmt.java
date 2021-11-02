// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

public interface YangTypedefStmt extends YangGeneratedReferenceType {

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  List<YangTypedefStmtBody> getTypedefStmtBodyList();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

  @NotNull
  PsiElement getTypedefKeyword();

}
