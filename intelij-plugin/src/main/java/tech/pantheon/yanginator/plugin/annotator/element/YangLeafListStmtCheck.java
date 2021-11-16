package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafListStmt;
import tech.pantheon.yanginator.plugin.psi.YangMaxElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangMinElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangStatusStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnitsStmt;
import tech.pantheon.yanginator.plugin.psi.YangWhenStmt;

public class YangLeafListStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangLeafListStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        maxOne.check(element, holder, YangWhenStmt.class);
        maxOne.check(element, holder, YangTypeStmt.class);
        minOne.check(element, holder, YangTypeStmt.class);
        maxOne.check(element, holder, YangUnitsStmt.class);
        maxOne.check(element, holder, YangConfigStmt.class);
        maxOne.check(element, holder, YangMinElementsStmt.class);
        maxOne.check(element, holder, YangMaxElementsStmt.class);
        maxOne.check(element, holder, YangOrderedByStmt.class);
        maxOne.check(element, holder, YangStatusStmt.class);
        maxOne.check(element, holder, YangDescriptionStmt.class);
        maxOne.check(element, holder, YangReferenceStmt.class);
    }
}
