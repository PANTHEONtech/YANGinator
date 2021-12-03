package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheckUtils;
import tech.pantheon.yanginator.plugin.psi.YangCaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangStatusStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesAugmentStmt;
import tech.pantheon.yanginator.plugin.psi.YangWhenStmt;

import java.util.ArrayList;
import java.util.List;

public class YangUsesAugmentStmtCheck extends AbstractYangStmtCheck {
    @Override
    public boolean isApplicable(@NotNull final PsiElement element) {
        return element instanceof YangUsesAugmentStmt;
    }

    @Override
    public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        maxOne.check(element, holder, YangWhenStmt.class);
        maxOne.check(element, holder, YangStatusStmt.class);
        maxOne.check(element, holder, YangDescriptionStmt.class);
        maxOne.check(element, holder, YangReferenceStmt.class);
        final List<Class<?>> dataDefStatements = new ArrayList<>(ElementCheckUtils.getDataDefStatements());
        dataDefStatements.add(YangCaseStmt.class);
        minOne.checkMany(element, holder, dataDefStatements);
    }
}