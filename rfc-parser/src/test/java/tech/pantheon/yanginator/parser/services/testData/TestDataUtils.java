/*
 *
 *   Copyright (c) 2021-2023 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser.services.testData;

import tech.pantheon.yanginator.parser.services.GrammarKitRFCService;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class TestDataUtils {
    public static final GrammarKitRFCService GRAMMARKIT_RFC_SERVICE = new GrammarKitRFCService();

    public static List<String> createList(final String filePath) throws URISyntaxException {
        File referenceFile = GRAMMARKIT_RFC_SERVICE.getFile(filePath);
        return GRAMMARKIT_RFC_SERVICE.readInputFile(referenceFile);
    }
}
