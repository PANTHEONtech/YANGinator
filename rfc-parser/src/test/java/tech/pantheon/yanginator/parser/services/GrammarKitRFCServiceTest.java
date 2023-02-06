/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
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

class GrammarKitRFCServiceTest {
    private static final GrammarKitRFCService rfcservice = new GrammarKitRFCService();

    @Test
    void parseInputFilev2Test() throws URISyntaxException {
        List<String> testList = createList("inputFileV2.bnf");
        File outputFile = new File("../rfc-parser/src/test/resources/outputFileV2.bnf");
        List<String> result;
        result = rfcservice.parseInputFilev2(testList);
        try (final PrintWriter printWriter = new PrintWriter(outputFile)) {
            result.forEach(printWriter::println);
        } catch (final IOException ignored) {
        }
        List<String> correct = createList("correctOutputFileV2.bnf");
        assertEquals(result, correct);

    }

    @Test
    void parseInputFilev3Test() throws URISyntaxException {
        List<String> testList = createList("inputFileV2.bnf");
        File outputFile = new File("../rfc-parser/src/test/resources/outputFileV3.bnf");
        File input = new File("../rfc-parser/src/main/gen/rfc-3986/rfc-3986-grammar-kitv2.bnf");
        List<String> result;
        result = rfcservice.parseInputFilev3(testList, createList("yang-rfc-grammar/yang-1_1/yang-rfc-7950.abnf"), input);
        try (final PrintWriter printWriter = new PrintWriter(outputFile)) {
            result.forEach(printWriter::println);
        } catch (final IOException ignored) {
        }
        result = createList("outputFileV3.bnf");
        List<String> correct = createList("correctOutputFileV3.bnf");

        assertEquals(result, correct);

    }

    @Test
    void generateLexerTest() throws URISyntaxException {
        File input = rfcservice.getFile("inputLexer.txt");
        File outputFile = new File("../rfc-parser/src/test/resources/outputLexer.txt");
        rfcservice.generateLexer(input, outputFile);
        List<String> result = createList("outputLexer.txt");
        List<String> correct = createList("correctOutputLexer.txt");

        assertEquals(result, correct);

    }

}