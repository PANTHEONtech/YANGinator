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

import org.apache.commons.io.FilenameUtils;
import tech.pantheon.yanginator.parser.services.GrammarKitRFCService;

import java.io.File;
import java.net.URISyntaxException;

public class RFCParser {
    final static GrammarKitRFCService GRAMMARKIT_RFC_SERVICE = new GrammarKitRFCService();

    public static void main(String[] args) throws URISyntaxException {
        for (String arg : args) {
            System.out.println(arg);
        }

        generateGrammar(GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/shared/rfc-3986.abnf"));
        generateGrammar("1_0", GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/yang-1_0/yang-rfc-6020.abnf"));
        // TODO Add support for YANG 1.1
        generateGrammar("1_1", GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/yang-1_1/yang-rfc-7950.abnf"));
    }

    /**
     * Creates directory named by the version of YANG provided as a parameter, and creates
     * Backus-Naur form (.bnf) grammar for specified YANG version. The new grammar is created using
     * <code>myRFCService.transformAbnfToBnf</code>. Any files and directories located inside
     * gen directory, will be deleted automatically.
     *
     * @param yangVersion the name of directory to be created
     * @param abnfGrammar the file containing .abnf grammar for YANG format
     */
    private static void generateGrammar(final String yangVersion, final File abnfGrammar) {
        String path = "rfc-parser/src/main/gen/yang-" + yangVersion;
        boolean isCreated = new File(path).mkdir();
        if (isCreated) {
            File outputFile = new File(path + "/" + FilenameUtils.removeExtension(abnfGrammar.getName()) + "-grammar-kit.bnf");
            GRAMMARKIT_RFC_SERVICE.transformAbnfToBnf(abnfGrammar, outputFile);
        } else {
            File directoryToBeDeleted = new File(path);
            deleteDirectory(directoryToBeDeleted);
            generateGrammar(yangVersion, abnfGrammar);
        }
    }

    /**
     * Creates directory named by the file provided as a parameter, and creates
     * Backus-Naur form (.bnf) grammar for the file. The new grammar is created using
     * <code>myRFCService.transformAbnfToBnf</code>. Any files and directories located inside
     * gen directory, will be deleted automatically.
     *
     * @param abnfGrammar the file containing .abnf grammar
     */
    private static void generateGrammar(final File abnfGrammar) {
        String fileName = FilenameUtils.removeExtension(abnfGrammar.getName());
        String path = "rfc-parser/src/main/gen/" + fileName;
        boolean isCreated = new File(path).mkdir();
        if (isCreated) {
            File outputFile = new File(path + "/" + fileName + "-grammar-kit.bnf");
            GRAMMARKIT_RFC_SERVICE.transformAbnfToBnf(abnfGrammar, outputFile);
        } else {
            File directoryToBeDeleted = new File(path);
            deleteDirectory(directoryToBeDeleted);
            generateGrammar(abnfGrammar);
        }
    }

    /**
     * Delete each file and directory in which provided file is located
     *
     * @param directoryToBeDeleted the file to be deleted
     * @return <code>true</code> if and only if the file or directory is
     * successfully deleted; <code>false</code> otherwise
     */
    private static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}