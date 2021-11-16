package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangWhenStmt;

public class YangWhenStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangWhenStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        maxOne.check(element, holder, YangDescriptionStmt.class);
        maxOne.check(element, holder, YangReferenceStmt.class);
    }
}
