// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface YangNotificationStmt extends YangStatement {

  @NotNull
  YangIdentifierArgQuoted getIdentifierArgQuoted();

  @NotNull
  List<YangNotificationStmtBody> getNotificationStmtBodyList();

  @NotNull
  YangOptsep getOptsep();

  @NotNull
  YangSep getSep();

  @Nullable
  YangStmtsep getStmtsep();

  @Nullable
  PsiElement getLeftBrace();

  @NotNull
  PsiElement getNotificationKeyword();

  @Nullable
  PsiElement getRightBrace();

  @Nullable
  PsiElement getSemicolon();

}
