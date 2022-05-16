/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import tech.pantheon.yanginator.plugin.psi.YangAbsoluteSchemaNodeid;
import tech.pantheon.yanginator.plugin.psi.YangDeviationArg;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

public class YangDeviationArgImpl extends YangNamedElementImpl implements YangDeviationArg {

  public YangDeviationArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitDeviationArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public YangAbsoluteSchemaNodeid getAbsoluteSchemaNodeid() {
    return findNotNullChildByClass(YangAbsoluteSchemaNodeid.class);
  }

}
