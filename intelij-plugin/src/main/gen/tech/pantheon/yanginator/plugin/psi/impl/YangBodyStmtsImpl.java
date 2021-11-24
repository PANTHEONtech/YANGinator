// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangComment;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentityStmt;
import tech.pantheon.yanginator.plugin.psi.YangLineComment;
import tech.pantheon.yanginator.plugin.psi.YangStatement;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnknownStatement;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import java.util.List;

public class YangBodyStmtsImpl extends YangNamedElementImpl implements YangBodyStmts {

  public YangBodyStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitBodyStmts(this);
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
  @NotNull
  public List<YangStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangStatement.class);
  }

  @Override
  @NotNull
  public List<YangComment> getCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangComment.class);
  }

  @Override
  @NotNull
  public List<YangGroupingStmt> getGroupingStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangGroupingStmt.class);
  }

  @Override
  @NotNull
  public List<YangIdentityStmt> getIdentityStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangIdentityStmt.class);
  }

  @Override
  @NotNull
  public List<YangTypedefStmt> getTypedefStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangTypedefStmt.class);
  }

  @Override
  @NotNull
  public List<YangUnknownStatement> getUnknownStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, YangUnknownStatement.class);
  }

}
