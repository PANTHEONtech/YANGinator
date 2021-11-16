package tech.pantheon.yanginator.plugin.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.element.AbstractYangStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangAnyxmlStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangAugmentStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangBitStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangCaseStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangChoiceStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangContainerStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangDeviationStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangEnumStmtChange;
import tech.pantheon.yanginator.plugin.annotator.element.YangExtensionStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangFeatureStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangGroupingStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangIdentityStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangInputStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLeafListStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLeafStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLeafrefSpecificationCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangLengthStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangListStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangMetaStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangModuleHeaderStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangMustStmtChange;
import tech.pantheon.yanginator.plugin.annotator.element.YangNotificationStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangOutputStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangPatternStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRangeStmtChange;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineAnyxmlStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineCaseStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineChoiceStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineContainerStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineLeafListStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineLeafStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangRefineListStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangStringRestrictionsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangSubmoduleHeaderStmtsCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangTypedefStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangUsesAugmentStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangUsesStmtCheck;
import tech.pantheon.yanginator.plugin.annotator.element.YangWhenStmtCheck;

import java.util.List;

public class YangAnnotator implements Annotator {

    private static final List<AbstractYangStmtCheck> STMT_CHECKS = List.of(
            new YangModuleHeaderStmtCheck(),
            new YangMetaStmtCheck(),
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
            new YangRefineContainerStmtsCheck(),
            new YangRefineLeafStmtsCheck(),
            new YangRefineLeafListStmtsCheck(),
            new YangRefineListStmtsCheck(),
            new YangRefineChoiceStmtsCheck(),
            new YangRefineCaseStmtsCheck(),
            new YangRefineAnyxmlStmtsCheck(),
            new YangUsesAugmentStmtCheck(),
            new YangAugmentStmtCheck(),
            new YangWhenStmtCheck(),
            new YangOutputStmtCheck(),
            new YangInputStmtCheck(),
            new YangNotificationStmtCheck(),
            new YangSubmoduleHeaderStmtsCheck(),
            new YangStringRestrictionsCheck(),
            new YangLeafrefSpecificationCheck(),
            new YangDeviationStmtCheck()
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
