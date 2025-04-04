/*
 *
 *   Copyright (c) 2021-2025 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangBinarySpecification;
import tech.pantheon.yanginator.plugin.psi.YangBitsSpecification;
import tech.pantheon.yanginator.plugin.psi.YangDecimal64Specification;
import tech.pantheon.yanginator.plugin.psi.YangEnumSpecification;
import tech.pantheon.yanginator.plugin.psi.YangIdentityrefSpecification;
import tech.pantheon.yanginator.plugin.psi.YangInstanceIdentifierSpecification;
import tech.pantheon.yanginator.plugin.psi.YangLeafrefSpecification;
import tech.pantheon.yanginator.plugin.psi.YangNumericalRestrictions;
import tech.pantheon.yanginator.plugin.psi.YangStringRestrictions;
import tech.pantheon.yanginator.plugin.psi.YangTypeBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangUnionSpecification;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangTypeBodyStmtsImpl extends YangNamedElementImpl implements YangTypeBodyStmts {

    public YangTypeBodyStmtsImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitTypeBodyStmts(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
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
