// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface YangAugmentStmt extends YangStatement {

  @NotNull
  YangAugmentArgStr getAugmentArgStr();

  @NotNull
  List<YangAugmentStmtBody> getAugmentStmtBodyList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @NotNull
  YangStmtsep getStmtsep();

  @NotNull
  PsiElement getAugmentKeyword();

  @NotNull
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getRightBrace();

}
