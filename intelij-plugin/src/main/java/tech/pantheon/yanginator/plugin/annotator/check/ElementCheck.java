package tech.pantheon.yanginator.plugin.annotator.check;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ElementCheck {
    void check(@NotNull PsiElement element, @NotNull AnnotationHolder holder, @NotNull Class<? extends PsiElement> elementClass);
    void checkMany(@NotNull PsiElement element, @NotNull AnnotationHolder holder, @NotNull List<Class<?>> elementClasses);
}
