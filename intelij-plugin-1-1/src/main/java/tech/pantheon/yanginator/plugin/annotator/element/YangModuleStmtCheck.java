/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangBodyStmts;
import tech.pantheon.yanginator.plugin.psi.YangLinkageStmts;
import tech.pantheon.yanginator.plugin.psi.YangMetaStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangModuleStmt;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmts;

public class YangModuleStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangModuleStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        minOne.check(element, holder, YangModuleHeaderStmts.class);
        maxOne.check(element, holder, YangModuleHeaderStmts.class);
        minOne.check(element, holder, YangLinkageStmts.class);
        maxOne.check(element, holder, YangLinkageStmts.class);
        minOne.check(element, holder, YangMetaStmts.class);
        maxOne.check(element, holder, YangMetaStmts.class);
        minOne.check(element, holder, YangRevisionStmts.class);
        maxOne.check(element, holder, YangRevisionStmts.class);
        minOne.check(element, holder, YangBodyStmts.class);
        maxOne.check(element, holder, YangBodyStmts.class);
        //minOne.simpleCheck(element, holder, YangModuleHeaderStmts.class);
    }
}
