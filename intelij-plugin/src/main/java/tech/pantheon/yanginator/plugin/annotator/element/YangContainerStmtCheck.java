package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.MaxOneElementCheck;
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangContainerStmt;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangPresenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangStatusStmt;
import tech.pantheon.yanginator.plugin.psi.YangWhenStmt;

public class YangContainerStmtCheck extends AbstractYangStmtCheck {
    MaxOneElementCheck m = new MaxOneElementCheck();

    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangContainerStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        maxOne.check(element, holder, YangWhenStmt.class);
        maxOne.check(element, holder, YangPresenceStmt.class);
        maxOne.check(element, holder, YangConfigStmt.class);
        maxOne.check(element, holder, YangStatusStmt.class);
        maxOne.check(element, holder, YangDescriptionStmt.class);
        maxOne.check(element, holder, YangReferenceStmt.class);
    }
}
