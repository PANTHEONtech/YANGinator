package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangBelongsToStmt;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionStmt;

public class YangSubmoduleHeaderStmtsCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull PsiElement element) {
        return element instanceof YangSubmoduleHeaderStmts;
    }

    @Override
    public void performCheck(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        maxOne.check(element, holder, YangYangVersionStmt.class);
        maxOne.check(element, holder, YangBelongsToStmt.class);
        minOne.check(element, holder, YangBelongsToStmt.class);
    }
}
