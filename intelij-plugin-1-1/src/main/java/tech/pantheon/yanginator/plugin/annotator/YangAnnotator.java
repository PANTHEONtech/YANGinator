/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.element.AbstractYangStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangActionStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangAnydataStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangAnyxmlStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangAugmentStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangBitStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangCaseStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangChoiceStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangContainerStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangDecimal64SpecificationCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangDeviateAddStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangDeviateDeleteStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangDeviateReplaceStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangDeviationStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangEnumStmtChange;
import tech.pantheon.yanginator.plugin.annotator.element.YangExtensionStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangFeatureStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangGroupingStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangIdentityStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangImportStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangIncludeStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangInputStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLeafListStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLeafStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLeafrefSpecificationCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLengthStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangListStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangMetaStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangModuleHeaderStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangModuleStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangMustStmtChange;
import tech.pantheon.yanginator.plugin.annotator.element.YangNotificationStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangOutputStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangPatternStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRangeStmtChange;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRevisionStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRpcStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangStringRestrictionsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangSubmoduleHeaderStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangSubmoduleStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangTypedefStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangUsesAugmentStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangUsesStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangWhenStmtCheck;

import java.util.List;

public class YangAnnotator implements Annotator {

    private static final List<AbstractYangStmtCheck> STMT_CHECKS = List.of(
            new YangModuleHeaderStmtsCheck(),
            new YangMetaStmtsCheck(),
            new YangExtensionStmtCheck(),
            new YangIdentityStmtCheck(),
            new YangFeatureStmtCheck(),
            new YangTypedefStmtCheck(),
            new YangRangeStmtChange(),
            new YangLengthStmtCheck(),
            new YangPatternStmtCheck(),
            new YangEnumStmtChange(),
            new YangBitStmtCheck(),
            new YangMustStmtChange(),
            new YangGroupingStmtCheck(),
            new YangContainerStmtCheck(),
            new YangLeafStmtCheck(),
            new YangLeafListStmtCheck(),
            new YangListStmtCheck(),
            new YangChoiceStmtCheck(),
            new YangCaseStmtCheck(),
            new YangAnyxmlStmtCheck(),
            new YangUsesStmtCheck(),
            new YangRefineStmtCheck(),
            new YangRpcStmtCheck(),
            new YangUsesAugmentStmtCheck(),
            new YangAugmentStmtCheck(),
            new YangWhenStmtCheck(),
            new YangOutputStmtCheck(),
            new YangInputStmtCheck(),
            new YangNotificationStmtCheck(),
            new YangSubmoduleHeaderStmtsCheck(),
            new YangStringRestrictionsCheck(),
            new YangLeafrefSpecificationCheck(),
            new YangDeviationStmtCheck(),
            new YangModuleStmtCheck(),
            new YangSubmoduleStmtCheck(),
            new YangImportStmtCheck(),
            new YangIncludeStmtCheck(),
            new YangRevisionStmtCheck(),
            new YangDecimal64SpecificationCheck(),
            new YangAnydataStmtCheck(),
            new YangActionStmtCheck(),
            new YangDeviateAddStmtCheck(),
            new YangDeviateDeleteStmtCheck(),
            new YangDeviateReplaceStmtCheck()
    );

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        for (AbstractYangStmtCheck stmtCheck : STMT_CHECKS) {
            if (stmtCheck.isApplicable(element)) {
                stmtCheck.performCheck(element, holder);
            }
        }
    }
}
