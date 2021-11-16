package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ElementCheck {
    void check(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
               @NotNull final Class<? extends PsiElement> elementClass);
    void checkMany(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder,
                   @NotNull final List<Class<?>> elementClasses);
}
