/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.foldingManager;

import java.util.Objects;

public class DocumentPositionType {
    private final int offset;
    private boolean isPaired = false;

    public DocumentPositionType(final int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return this.offset;
    }

    public boolean isPaired() {
        return this.isPaired;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final CurlyBraceDocumentPositionType that = (CurlyBraceDocumentPositionType) o;
        return this.offset == that.getOffset();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.offset);
    }

    public void setAsPaired() {
        this.isPaired = true;
    }
}
