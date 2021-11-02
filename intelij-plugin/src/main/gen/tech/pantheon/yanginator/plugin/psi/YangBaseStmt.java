// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.reference.YangGeneratedReferenceType;

public interface YangBaseStmt extends YangGeneratedReferenceType {

  @NotNull
  YangIdentifierRefArgQuoted getIdentifierRefArgQuoted();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtend getStmtend();

  @NotNull
  PsiElement getBaseKeyword();

}
