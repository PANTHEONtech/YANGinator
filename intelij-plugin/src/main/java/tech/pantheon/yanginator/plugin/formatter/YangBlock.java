/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.formatter;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.WrapType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        while (child != null) {
            if (YangFormatterUtils.shouldBuildBlock(child.getElementType())) {
                blocks.add(buildBlock(child));
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @NotNull
    private Block buildBlock(final ASTNode child) {
        Block block;
        if (YangFormatterUtils.shouldAlign(child.getElementType())) {
            block = new YangBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                    spacingBuilder, YangFormatterUtils.getIndentForType(child.getElementType()));
        } else {
            block = new YangBlock(child, Wrap.createWrap(WrapType.NONE, false), null,
                    spacingBuilder, YangFormatterUtils.getIndentForType(child.getElementType()));
        }
        return block;
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
}
