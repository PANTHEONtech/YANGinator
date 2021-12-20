// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangIdentifierArgQuoted;
import tech.pantheon.yanginator.plugin.psi.YangLineComment;
import tech.pantheon.yanginator.plugin.psi.YangLinkageStmts;
import tech.pantheon.yanginator.plugin.psi.YangMetaStmts;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmts;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SUBMODULE_KEYWORD;

public class YangSubmoduleStmtImpl extends YangStatementImpl implements YangSubmoduleStmt {

  public YangSubmoduleStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitSubmoduleStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<YangLineComment> getLineCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangLineComment.class);
  }

  @Override
  @Nullable
  public YangBodyStmts getBodyStmts() {
    return findChildByClass(YangBodyStmts.class);
  }

  @Override
  @NotNull
  public List<YangComment> getCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangComment.class);
  }

  @Override
  @Nullable
  public YangIdentifierArgQuoted getIdentifierArgQuoted() {
    return findChildByClass(YangIdentifierArgQuoted.class);
  }

  @Override
  @Nullable
  public YangLinkageStmts getLinkageStmts() {
    return findChildByClass(YangLinkageStmts.class);
  }

  @Override
  @Nullable
  public YangMetaStmts getMetaStmts() {
    return findChildByClass(YangMetaStmts.class);
  }

  @Override
  @Nullable
  public YangRevisionStmts getRevisionStmts() {
    return findChildByClass(YangRevisionStmts.class);
  }

  @Override
  @Nullable
  public YangSubmoduleHeaderStmts getSubmoduleHeaderStmts() {
    return findChildByClass(YangSubmoduleHeaderStmts.class);
  }

  @Override
  @NotNull
  public List<YangUnknownStatement> getUnknownStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnknownStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getLeftBrace() {
    return findChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getRightBrace() {
    return findChildByType(YANG_RIGHT_BRACE);
  }

  @Override
  @NotNull
  public PsiElement getSubmoduleKeyword() {
    return findNotNullChildByType(YANG_SUBMODULE_KEYWORD);
  }

}
