/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;

public interface YangStmt extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @NotNull
  PsiElement getHIdentifier();

  @NotNull
  PsiElement getHSemicolon();

  @NotNull
  PsiElement getHString();

}
