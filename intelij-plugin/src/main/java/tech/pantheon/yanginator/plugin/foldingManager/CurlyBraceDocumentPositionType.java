/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.foldingManager;

public class CurlyBraceDocumentPositionType extends DocumentPositionType {

    private final CurlyBraceStringEnum braceType;

    public CurlyBraceDocumentPositionType(final int offset, final CurlyBraceStringEnum braceType) {
        super(offset);
        this.braceType = braceType;
    }

    public CurlyBraceStringEnum getBraceType() {
        return braceType;
    }

    public boolean isLeft() {
        return this.braceType == CurlyBraceStringEnum.LEFT;
    }

    @Override
    public String toString() {
        return "CurlyBracePositionType{" +
                "offset=" + this.getOffset() +
                this.braceType.getStringValue() +
                (this.isPaired() ? "" : ":notPaired") +
                '}';
    }

    public boolean isRight() {
        return this.braceType == CurlyBraceStringEnum.RIGHT;
    }
}
