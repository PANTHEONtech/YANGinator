package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MinOneElementCheck implements ElementCheck{
    @Override
    public void check(@NotNull PsiElement element, @NotNull AnnotationHolder holder, @NotNull Class<? extends PsiElement> elementClass) {
        long count = 0;
        PsiElement[] children = element.getChildren();
        for (PsiElement ch : children) {
            count += Arrays.stream(ch.getChildren()).filter(elementClass::isInstance).count();
        }
        if (count < 1) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Missing " + ElementCheckUtils.translateClassName(elementClass))
                    .range(element.getLastChild())
                    .create();
        }
    }

    public void checkMany(@NotNull PsiElement element, @NotNull AnnotationHolder holder, @NotNull List<Class<?>> elementClasses) {
        long count = 0;
        PsiElement[] children = element.getChildren();
        for (Class<?> c : elementClasses) {
            for (PsiElement ch : children) {
                count += Arrays.stream(ch.getChildren()).filter(c::isInstance).count();
            }
        }
        if (count < 1) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Missing "
                            + ElementCheckUtils.translateClassName(elementClasses.get(elementClasses.size() - 1)))
                    .range(element.getLastChild())
                    .create();
        }
    }
}
