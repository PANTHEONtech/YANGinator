/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser.services;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tech.pantheon.yanginator.parser.services.testData.TestDataUtils.createList;

class GrammarKitRFCUtilsTest {


    @Test
    void replaceAllAbnfTokens() throws URISyntaxException {
        List<String> inputList = createList("test/00_testGrammar.txt");
        List<String> referenceList = createList("test/01_replaceAllAbnfTokens.txt");
        List<String> result = GrammarKitRFCUtils.replaceAllAbnfTokens(inputList);
        assertEquals(referenceList, result);
    }

    @Test
    void deleteWhitespaces() throws URISyntaxException {
        List<String> inputList = createList("test/01_replaceAllAbnfTokens.txt");
        List<String> referenceList = createList("test/02_deleteWhitespaces.txt");
        List<String> result = GrammarKitRFCUtils.deleteWhitespaces(inputList);
        assertEquals(referenceList, result);
    }

    @Test
    void writeDownNtoMMultiplier() throws URISyntaxException {
        List<String> inputList = createList("test/02_deleteWhitespaces.txt");
        List<String> referenceList = createList("test/03_writeDownNtoMMultiplier.txt");
        List<String> result = GrammarKitRFCUtils.rewriteNtoMMultiplier(inputList);
        assertEquals(referenceList, result);
    }

    @Test
    void writeDownBoundedMultiplierBounded() throws URISyntaxException {
        List<String> inputList = createList("test/03_writeDownNtoMMultiplier.txt");
        List<String> referenceList = createList("test/04_rewriteDigitMultiplierBounded.txt");
        List<String> result = GrammarKitRFCUtils.rewriteDigitMultiplier(inputList, GrammarKitRFCUtils.MULTIPLIER_ZERO_TO_N_TIMES);
        assertEquals(referenceList, result);
    }

    @Test
    void rewriteDigitMultiplierWord() throws URISyntaxException {
        List<String> inputList = createList("test/04_rewriteDigitMultiplierBounded.txt");
        List<String> referenceList = createList("test/05_rewriteDigitMultiplierParentheses.txt");
        List<String> result = GrammarKitRFCUtils.rewriteDigitMultiplier(inputList, GrammarKitRFCUtils.MULTIPLIER_N_TIMES_WORD);
        assertEquals(referenceList, result);
    }

    @Test
    void rewriteDigitMultiplierParentheses() throws URISyntaxException {
        List<String> inputList = createList("test/05_rewriteDigitMultiplierParentheses.txt");
        List<String> referenceList = createList("test/06_rewriteDigitMultiplierWord.txt");
        List<String> result = GrammarKitRFCUtils.rewriteDigitMultiplier(inputList, GrammarKitRFCUtils.MULTIPLIER_N_TIMES_PARENTHESES);
        assertEquals(referenceList, result);
    }

    @Test
    void trimAndAppendOperatorOneOrMore() throws URISyntaxException {
        List<String> inputList = createList("test/06_rewriteDigitMultiplierWord.txt");
        List<String> referenceList = createList("test/07_trimAndAppendOperatorPlus.txt");
        List<String> result = GrammarKitRFCUtils.trimAndAppendOperator(inputList, "1*", "+");
        assertEquals(referenceList, result);
    }

    @Test
    void trimAndAppendOperatorZeroOrMore() throws URISyntaxException {
        List<String> inputList = createList("test/07_trimAndAppendOperatorPlus.txt");
        List<String> referenceList = createList("test/08_trimAndAppendOperatorAsterisk.txt");
        List<String> result = GrammarKitRFCUtils.trimAndAppendOperator(inputList, "*", "*");
        assertEquals(referenceList, result);
    }

    @Test
    void replaceAsterWordOneOrMore() throws URISyntaxException {
        List<String> inputList = createList("test/08_trimAndAppendOperatorAsterisk.txt");
        List<String> referenceList = createList("test/09_replaceAsterWordPlus.txt");
        List<String> result = GrammarKitRFCUtils.replaceAsterWord(inputList, "1*");
        assertEquals(referenceList, result);
    }

    @Test
    void replaceAsterWordZeroOrMore() throws URISyntaxException {
        List<String> inputList = createList("test/09_replaceAsterWordPlus.txt");
        List<String> referenceList = createList("test/10_replaceAsterWordAsterisk.txt");
        List<String> result = GrammarKitRFCUtils.replaceAsterWord(inputList, "*");
        assertEquals(referenceList, result);
    }

    @Test
    void rewriteStringRules() throws URISyntaxException {
        List<String> inputList = createList("test/10_replaceAsterWordAsterisk.txt");
        List<String> referenceList = createList("test/11_rewriteStringRules.txt");
        List<String> result = GrammarKitRFCUtils.rewriteStringRules(inputList);
        assertEquals(referenceList, result);
    }

    @Test
    void replaceHexadecimalRange() throws URISyntaxException {
        List<String> inputList = createList("test/11_rewriteStringRules.txt");
        List<String> referenceList = createList("test/12_replaceHexadecimalRange.txt");
        List<String> result = GrammarKitRFCUtils.replaceHexadecimalRange(inputList);
        assertEquals(referenceList, result);
    }

    @Test
    void replaceHexadecimal() throws URISyntaxException {
        List<String> inputList = createList("test/12_replaceHexadecimalRange.txt");
        List<String> referenceList = createList("test/13_replaceHexadecimal.txt");
        List<String> result = GrammarKitRFCUtils.replaceHexadecimal(inputList);
        assertEquals(referenceList, result);
    }

    @Test
    void uniqueCombinationTest() throws URISyntaxException {
        List<String> testList = createList("inputFileV2.bnf");
        File outputFile = new File("../rfc-parser/src/test/resources/outputUniqueCombination.bnf");
        List<String> result = GrammarKitRFCUtils.replaceWords(testList, "\"1\" | \"2\" | \"3\" | \"4\" | \"5\" | \"6\" | \"7\" | \"8\" | \"9\"", "\"9\" | \"10\"", "POSITIVE_NUMBER");
        try (final PrintWriter printWriter = new PrintWriter(outputFile)) {
            result.forEach(printWriter::println);
        } catch (final IOException ignored) {
        }
        List<String> correct = createList("correctOutputUniqueCombination.bnf");
        assertEquals(result, correct);
    }

}