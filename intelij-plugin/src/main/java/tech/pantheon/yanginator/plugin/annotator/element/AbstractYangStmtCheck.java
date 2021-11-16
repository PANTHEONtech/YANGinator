package tech.pantheon.yanginator.plugin.annotator.element;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.annotator.check.ElementCheck;
import tech.pantheon.yanginator.plugin.annotator.check.MaxOneElementCheck;
import tech.pantheon.yanginator.plugin.annotator.check.MinOneElementCheck;

public abstract class AbstractYangStmtCheck {
    protected final ElementCheck maxOne = new MaxOneElementCheck();
    protected final ElementCheck minOne = new MinOneElementCheck();

    abstract public boolean isApplicable(@NotNull final PsiElement element);

    abstract public void performCheck(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder);
}
