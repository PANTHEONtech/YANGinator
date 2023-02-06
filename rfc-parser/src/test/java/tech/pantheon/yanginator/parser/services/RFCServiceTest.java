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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RFCServiceTest {
    private static RFCService rfcService;
    private static File inputFile;
    private static File originalOutputFile;
    private static File newOutputFile;

    @BeforeAll
    static void initialize() throws URISyntaxException {
        rfcService = new RFCService();
        inputFile = rfcService.getFile("InputOriginalFile.txt");
        originalOutputFile = rfcService.getFile("OutputOriginalFile.txt");
        newOutputFile = new File("src/test/OutputTestFile.txt");
    }

    @Test
    void getResultFromFile() throws IOException {
        rfcService.getResultFromFile(inputFile, newOutputFile);
        final List<String> originalFile = Files.readAllLines(Paths.get("src/test/resources/OutputOriginalFile.txt"));
        final List<String> newFile = Files.readAllLines(Paths.get("src/test/OutputTestFile.txt"));

        assertEquals(originalFile.size(), newFile.size());

        for (int i = 0; i < originalFile.size(); i++) {
            assertEquals(originalFile.get(i), newFile.get(i));

        }
    }
}