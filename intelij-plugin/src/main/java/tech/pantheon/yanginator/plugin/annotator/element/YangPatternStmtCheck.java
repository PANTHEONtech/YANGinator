package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangErrorAppTagStmt;
import tech.pantheon.yanginator.plugin.psi.YangErrorMessageStmt;
import tech.pantheon.yanginator.plugin.psi.YangPatternStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;

public class YangPatternStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangPatternStmt;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        maxOne.check(element, holder, YangErrorMessageStmt.class);
        maxOne.check(element, holder, YangErrorAppTagStmt.class);
        maxOne.check(element, holder, YangDescriptionStmt.class);
        maxOne.check(element, holder, YangReferenceStmt.class);
    }
}
