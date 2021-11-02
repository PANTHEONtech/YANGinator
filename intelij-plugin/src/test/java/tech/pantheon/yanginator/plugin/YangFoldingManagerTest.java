/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

public class YangFoldingManagerTest extends LightJavaCodeInsightFixtureTestCase {

    @Override
    protected String getTestDataPath() {
        return "src/test/testData/folding";
    }

    public void testFolding() {
        this.myFixture.testFolding(this.getTestDataPath() + "/folding-test-data.yang");
    }

    public void testNoFoldingDescriptorsInFile() {
        this.myFixture.testFolding(this.getTestDataPath() + "/no-folding-descriptors-test-data.yang");
    }
}


