package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheckUtils;
import tech.pantheon.yanginator.plugin.psi.YangInputStmt;

public class YangInputStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangInputStmt;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        minOne.checkMany(element, holder, ElementCheckUtils.getDataDefStatements());
    }
}
