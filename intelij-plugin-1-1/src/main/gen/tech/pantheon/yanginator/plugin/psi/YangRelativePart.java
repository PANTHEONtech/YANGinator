/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface YangRelativePart extends YangNamedElement {

  @Nullable
  YangAuthority getAuthority();

  @Nullable
  YangPathAbempty getPathAbempty();

  @Nullable
  YangPathAbsolute getPathAbsolute();

  @Nullable
  YangPathEmpty getPathEmpty();

  @Nullable
  YangPathNoscheme getPathNoscheme();

  @Nullable
  PsiElement getDoubleForwardSlash();

}
