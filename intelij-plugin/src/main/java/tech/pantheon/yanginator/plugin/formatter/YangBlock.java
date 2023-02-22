/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter;

import com.intellij.application.options.CodeStyle;
import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.YangLanguage;
import tech.pantheon.yanginator.plugin.psi.YangTypes;

import java.util.ArrayList;
import java.util.List;

public class YangBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;
    private final Indent indent;

    protected YangBlock(@NotNull final ASTNode node, final @Nullable Wrap wrap, @Nullable final Alignment alignment,
                        SpacingBuilder spacingBuilder) {
        this(node, wrap, alignment, spacingBuilder, Indent.getNoneIndent());
    }

    protected YangBlock(@NotNull final ASTNode node, @Nullable final Wrap wrap, @Nullable final Alignment alignment,
                        final SpacingBuilder spacingBuilder, final Indent indent) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
        this.indent = indent;
    }

    @Override
    protected List<Block> buildChildren() {
        final List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        if (YangFormatterUtils.shouldBuildBeforeModule(myNode.getElementType())) {
            child = buildBeforeModule(blocks, child);
        }
        Alignment alignment = myAlignment;
        if(myNode.getElementType().equals(YangTypes.YANG_PATH_ARG_STR)) {
            alignment = Alignment.createAlignment();
        }
        while (child != null) {
            if (YangFormatterUtils.shouldBuildBlock(child.getElementType())) {
                blocks.add(buildBlock(child, alignment));
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Nullable
    private ASTNode buildBeforeModule(final List<Block> blocks, ASTNode child) {
        boolean started = false;
        while (!started && child != null) {
            if (child.getElementType() == YangTypes.YANG_MODULE_KEYWORD
                    || child.getElementType() == YangTypes.YANG_SUBMODULE_KEYWORD) {
                started = true;
            }
            if (YangFormatterUtils.shouldBuildBlock(child.getElementType())) {
                Block block = new YangBlock(child, null, null,
                        spacingBuilder, Indent.getNoneIndent());
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return child;
    }

    @NotNull
    private Block buildBlock(final ASTNode child, Alignment alignment) {
        return new YangBlock(child, null, alignment,
                spacingBuilder, YangFormatterUtils.getIndentForType(child.getElementType()));
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable final Block child1, @NotNull final Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    @Override
    public Indent getIndent() {
        return indent;
    }

    @Override
    @NotNull
    public ChildAttributes getChildAttributes(final int newChildIndex) {
        if (YangFormatterUtils.invalidYang(myNode.getElementType())) {
            return new ChildAttributes(getIndentForInvalid(newChildIndex), null);
        }
        if (YangFormatterUtils.indentSubStmt(myNode.getElementType())) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        }
        return super.getChildAttributes(newChildIndex);
    }

    private Indent getIndentForInvalid(final int newChildIndex) {
        final List<Block> subBlocks = getSubBlocks();
        if (newChildIndex < subBlocks.size()) {
            ASTNode child = ((AbstractBlock) subBlocks.get(newChildIndex - 1)).getNode();
            final boolean extraIndent = child.getElementType() == YangTypes.YANG_LEFT_BRACE;
            int newIndent = getPrevIndent(child);
            newIndent += extraIndent ? getNormalIndentSize() : 0;
            return Indent.getSpaceIndent(newIndent);
        }
        return null;
    }

    private int getPrevIndent(ASTNode child) {
        int indentSize = 0;
        while (child != null && child.getElementType() != YangTypes.YANG_LINEFEED) {
            if (child.getElementType() == YangTypes.YANG_SPACE) {
                indentSize++;
            } else {
                indentSize = 0;
            }
            child = child.getTreePrev();
        }
        return indentSize;
    }

    private int getNormalIndentSize() {
        CommonCodeStyleSettings.IndentOptions indentOptions =
                CodeStyle.getLanguageSettings(myNode.getPsi().getContainingFile(), YangLanguage.INSTANCE).getIndentOptions();
        return indentOptions != null ? indentOptions.INDENT_SIZE : 0;
    }
}