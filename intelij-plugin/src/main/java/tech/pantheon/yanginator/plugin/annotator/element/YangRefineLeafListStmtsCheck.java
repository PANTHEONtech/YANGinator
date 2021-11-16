package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangMaxElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangMinElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangRefineLeafListStmts;

public class YangRefineLeafListStmtsCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangRefineLeafListStmts;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        maxOne.check(element, holder, YangConfigStmt.class);
        maxOne.check(element, holder, YangMinElementsStmt.class);
        maxOne.check(element, holder, YangMaxElementsStmt.class);
        maxOne.check(element, holder, YangDescriptionStmt.class);
        maxOne.check(element, holder, YangReferenceStmt.class);
    }
}
