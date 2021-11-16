package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangModuleHeaderStmts;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceStmt;
import tech.pantheon.yanginator.plugin.psi.YangPrefixStmt;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionStmt;

public class YangModuleHeaderStmtCheck extends AbstractYangStmtCheck {

    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangModuleHeaderStmts;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        maxOne.check(element, holder, YangYangVersionStmt.class);
        maxOne.check(element, holder, YangNamespaceStmt.class);
        minOne.check(element, holder, YangNamespaceStmt.class);
        maxOne.check(element, holder, YangPrefixStmt.class);
        minOne.check(element, holder, YangPrefixStmt.class);
    }
}
