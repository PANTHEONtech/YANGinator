package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangLeafrefSpecification;
import tech.pantheon.yanginator.plugin.psi.YangPathStmt;
import tech.pantheon.yanginator.plugin.psi.YangRequireInstanceStmt;

public class YangLeafrefSpecificationCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangLeafrefSpecification;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        maxOne.check(element, holder, YangPathStmt.class);
        minOne.check(element, holder, YangPathStmt.class);
        maxOne.check(element, holder, YangRequireInstanceStmt.class);
    }
}
