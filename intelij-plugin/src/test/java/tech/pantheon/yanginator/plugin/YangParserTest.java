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

import com.intellij.testFramework.ParsingTestCase;
import java.io.IOException;

public class YangParserTest extends ParsingTestCase {

    public YangParserTest() {
        super("", "yang", new YangParserDefinition());
    }

    public void testParsingTestData() throws IOException {
        // Test is testing ParsingTestData.yang
        String name = this.getTestName();
        String psiTree;
        int indexOfErrorInParseTree = -1;
        String errorMessage = "";

        this.parseFile(name, this.loadFile(name + "." + this.myFileExt));
        psiTree = toParseTreeText(this.myFile, this.skipSpaces(), this.includeRanges());
        indexOfErrorInParseTree = psiTree.indexOf("PsiErrorElement");

        if (indexOfErrorInParseTree != -1) {
            errorMessage = "Error at index: ".concat(String.valueOf(indexOfErrorInParseTree)).concat("\n");
            var error = psiTree.substring(indexOfErrorInParseTree, psiTree.indexOf("\n",indexOfErrorInParseTree));
            errorMessage = errorMessage.concat(error);
        }
        assertTrue(errorMessage,indexOfErrorInParseTree == -1);
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData/parser";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}
