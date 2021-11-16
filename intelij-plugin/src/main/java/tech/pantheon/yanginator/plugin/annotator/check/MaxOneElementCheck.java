package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MaxOneElementCheck implements ElementCheck {
    @Override
    public void check(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                      @NotNull final Class<? extends PsiElement> elementClass) {
        long childrenCount = 0;
        final PsiElement[] children = element.getChildren();
        for (PsiElement child : children) {
            childrenCount += Arrays.stream(child.getChildren()).filter(elementClass::isInstance).count();
            if (childrenCount > 1) {
                holder.newAnnotation(HighlightSeverity.ERROR, "More than one "
                                + ElementCheckUtils.translateClassName(elementClass))
                        .range(child.getFirstChild())
                        .create();
                return;
            }
        }
    }


    public void checkMany(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                          @NotNull final List<Class<?>> elementClasses) {
        long childrenCount = 0;
        final PsiElement[] children = element.getChildren();
        for (Class<?>  c : elementClasses) {
            for (PsiElement ch : children) {
                childrenCount += Arrays.stream(ch.getChildren()).filter(c::isInstance).count();
            }
        }
        if (childrenCount > 1) {
            holder.newAnnotation(HighlightSeverity.ERROR, "More than one "
                            + ElementCheckUtils.translateClassName(elementClasses.get(elementClasses.size() - 1)))
                    .range(element.getLastChild())
                    .create();
        }
    }
}
