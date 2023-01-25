// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangTypeBodyStmts extends YangNamedElement {

  @Nullable
  YangBinarySpecification getBinarySpecification();

  @Nullable
  YangBitsSpecification getBitsSpecification();

  @Nullable
  YangDecimal64Specification getDecimal64Specification();

  @Nullable
  YangEnumSpecification getEnumSpecification();

  @Nullable
  YangIdentityrefSpecification getIdentityrefSpecification();

  @Nullable
  YangInstanceIdentifierSpecification getInstanceIdentifierSpecification();

  @Nullable
  YangLeafrefSpecification getLeafrefSpecification();

  @Nullable
  YangNumericalRestrictions getNumericalRestrictions();

  @Nullable
  YangStringRestrictions getStringRestrictions();

  @Nullable
  YangUnionSpecification getUnionSpecification();

}
