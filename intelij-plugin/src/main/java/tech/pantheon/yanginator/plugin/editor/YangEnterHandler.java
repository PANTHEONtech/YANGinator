package tech.pantheon.yanginator.plugin.editor;

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangPatternBody;
import tech.pantheon.yanginator.plugin.psi.YangQuotedString;

public class YangEnterHandler extends EnterHandlerDelegateAdapter {

    @Override
    public Result preprocessEnter(@NotNull PsiFile file,
                                  @NotNull Editor editor,
                                  @NotNull Ref<Integer> caretOffset,
                                  @NotNull Ref<Integer> caretAdvance,
                                  @NotNull DataContext dataContext,
                                  @NotNull EditorActionHandler originalHandler) {

        Project project = file.getProject();
        Document document = editor.getDocument();
        final int offset = caretOffset.get();

        final PsiElement element = file.findElementAt(offset - 1);
        final YangQuotedString quotedString = PsiTreeUtil.getParentOfType(element, YangQuotedString.class);
        if (quotedString == null) return Result.Continue;

        final TextRange stringRange = quotedString.getTextRange();
        if (offset <= stringRange.getStartOffset() + 1 || offset >= stringRange.getEndOffset() - 1) {
            return Result.Continue;
        }

        boolean isInsidePattern = PsiTreeUtil.getParentOfType(quotedString, YangPatternBody.class) != null;

        WriteCommandAction.runWriteCommandAction(project, () -> {
            if (isInsidePattern) {
                String text = document.getText();
                final char quoteChar = (offset > 0 && text.charAt(stringRange.getStartOffset()) == '\'') ? '\'' : '"';

                final String PATTERN_SPLIT_TEX = quoteChar + "\n+ " + quoteChar;
                document.insertString(offset, PATTERN_SPLIT_TEX);
                PsiDocumentManager.getInstance(project).commitDocument(document);

                CodeStyleManager.getInstance(project).reformatText(file, offset, offset + PATTERN_SPLIT_TEX.length());

                final int lineNumber = document.getLineNumber(offset) + 1;
                final int lineStart = document.getLineStartOffset(lineNumber);
                String lineContent = document.getText(new TextRange(lineStart, document.getLineEndOffset(lineNumber)));

                int quoteIndex = lineContent.indexOf(quoteChar);
                if (quoteIndex != -1) {
                    final int finalCaretPos = lineStart + quoteIndex + 1;
                    editor.getCaretModel().moveToOffset(finalCaretPos);
                    caretOffset.set(finalCaretPos);
                }
            } else {
                document.insertString(offset, "\n");
                PsiDocumentManager.getInstance(project).commitDocument(document);

                int newOffset = CodeStyleManager.getInstance(project).adjustLineIndent(file, offset + 1);
                editor.getCaretModel().moveToOffset(newOffset);
            }
        });

        caretOffset.set(editor.getCaretModel().getOffset());

        return Result.Stop;
    }
}