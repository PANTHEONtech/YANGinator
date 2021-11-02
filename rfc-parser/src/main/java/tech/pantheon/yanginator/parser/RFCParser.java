/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser;

import java.io.File;
import java.net.URISyntaxException;
import tech.pantheon.yanginator.parser.services.RFCService;

public class RFCParser {
    public static void main(String[] args) throws URISyntaxException {
        RFCService rfcService = new RFCService();
        File inputFile = rfcService.getFile("main/InputFile.txt");
        File outputFile = new File("RFCParser/OutputFile");
        rfcService.getResultFromFile(inputFile, outputFile);
    }
}
