// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.*;

public class YangTypeBodyStmtsImpl extends YangNamedElementImpl implements YangTypeBodyStmts {

  public YangTypeBodyStmtsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitTypeBodyStmts(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangBinarySpecification getBinarySpecification() {
    return findChildByClass(YangBinarySpecification.class);
  }

  @Override
  @Nullable
  public YangBitsSpecification getBitsSpecification() {
    return findChildByClass(YangBitsSpecification.class);
  }

  @Override
  @Nullable
  public YangDecimal64Specification getDecimal64Specification() {
    return findChildByClass(YangDecimal64Specification.class);
  }

  @Override
  @Nullable
  public YangEnumSpecification getEnumSpecification() {
    return findChildByClass(YangEnumSpecification.class);
  }

  @Override
  @Nullable
  public YangIdentityrefSpecification getIdentityrefSpecification() {
    return findChildByClass(YangIdentityrefSpecification.class);
  }

  @Override
  @Nullable
  public YangInstanceIdentifierSpecification getInstanceIdentifierSpecification() {
    return findChildByClass(YangInstanceIdentifierSpecification.class);
  }

  @Override
  @Nullable
  public YangLeafrefSpecification getLeafrefSpecification() {
    return findChildByClass(YangLeafrefSpecification.class);
  }

  @Override
  @Nullable
  public YangNumericalRestrictions getNumericalRestrictions() {
    return findChildByClass(YangNumericalRestrictions.class);
  }

  @Override
  @Nullable
  public YangStringRestrictions getStringRestrictions() {
    return findChildByClass(YangStringRestrictions.class);
  }

  @Override
  @Nullable
  public YangUnionSpecification getUnionSpecification() {
    return findChildByClass(YangUnionSpecification.class);
  }

}
