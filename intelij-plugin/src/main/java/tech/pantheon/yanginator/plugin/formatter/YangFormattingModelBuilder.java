package tech.pantheon.yanginator.plugin.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.FormattingContext;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.WrapType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.YangLanguage;
import tech.pantheon.yanginator.plugin.formatter.settings.YangCodeStyleSettings;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

public class YangFormattingModelBuilder implements FormattingModelBuilder {
    @Override
    public @NotNull FormattingModel createModel(@NotNull final FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new YangBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(codeStyleSettings)),
                        codeStyleSettings);
    }

    private static SpacingBuilder createSpaceBuilder(final CodeStyleSettings settings) {
        final YangCodeStyleSettings yangSetting = settings.getCustomSettings(YangCodeStyleSettings.class);
        return new SpacingBuilder(settings, YangLanguage.INSTANCE)
                .after(YangTypes.YANG_TYPE_KEYWORD)
                .spaceIf(yangSetting.SPACE_AFTER_KEYWORD)
                .before(YangTypes.YANG_IDENTIFIER)
                .none();
    }
}
