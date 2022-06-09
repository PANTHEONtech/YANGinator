/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
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
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RFCParser {
    final static GrammarKitRFCService GRAMMARKIT_RFC_SERVICE = new GrammarKitRFCService();
    private final static String YANG_PATH_PREFIX = "rfc-parser/src/main/gen/yang-";
    private final static String GEN_PATH_PREFIX = "rfc-parser/src/main/gen/";
    private final static String PLUGIN_PATH = "intelij-plugin/src/main/gen/tech/pantheon/yanginator/plugin";


    public static void main(String[] args) throws URISyntaxException {
        generateLexer("_YangLexer.flex", PLUGIN_PATH + "/lexer");
        generateGrammar(GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/shared/rfc-3986.abnf"), GEN_PATH_PREFIX);
        generateGrammar("1_0", GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/yang-1_0/yang-rfc-6020.abnf"), YANG_PATH_PREFIX);
        generateGrammar("1_1", GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/yang-1_1/yang-rfc-7950.abnf"), YANG_PATH_PREFIX);

    }

    /**
     * Creates directory named by the version of YANG provided as a parameter, and creates
     * Backus-Naur form (.bnf) grammar for specified YANG version. The new grammar is created using
     * <code>myRFCService.transformAbnfToBnf</code>. Any files and directories located inside
     * gen directory, will be deleted automatically.
     *
     * @param yangVersion the name of directory to be created
     * @param abnfGrammar the file containing .abnf grammar for YANG format
     * @param dstPath     path where generated files will be stored
     */
    public static void generateGrammar(final String yangVersion, final File abnfGrammar, final String dstPath) {
        String path = dstPath + yangVersion;
        boolean isCreated = new File(path).mkdirs();
        if (isCreated) {
            File outputFile = new File(path + "/" + FilenameUtils.removeExtension(abnfGrammar.getName()) + "-grammar-kit.bnf");
            File outputFilev2 = new File(path + "/" + FilenameUtils.removeExtension(abnfGrammar.getName()) + "-grammar-kitv2.bnf");
            File outputFilev3 = new File(PLUGIN_PATH + "/" + "YangGrammar.bnf");
            GRAMMARKIT_RFC_SERVICE.transformAbnfToBnf(abnfGrammar, outputFile, outputFilev2, outputFilev3);
        } else {
            File directoryToBeDeleted = new File(path);
            deleteDirectory(directoryToBeDeleted);
            generateGrammar(yangVersion, abnfGrammar, dstPath);
        }
    }

    public static void generateLexer(final String lexerFileName, final String dstPath) {
        Path lexer = Paths.get(dstPath + "/" + lexerFileName);
        if (!Files.exists(lexer)) {
            boolean isCreated = new File(dstPath).mkdirs();
            if (isCreated) {

                File lexerFile = new File(dstPath + "/" + lexerFileName);
                try {
                    lexerFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                GRAMMARKIT_RFC_SERVICE.generateLexer(lexerFile, lexerFile);


            } else {
                File directoryToBeDeleted = new File(dstPath);
                deleteDirectory(directoryToBeDeleted);
                generateLexer(lexerFileName, dstPath);
            }
        } else {
            File flexer = new File(dstPath + "/" + lexerFileName);
            GRAMMARKIT_RFC_SERVICE.generateLexer(flexer, flexer);
        }
    }

    /**
     * Creates directory named by the file provided as a parameter, and creates
     * Backus-Naur form (.bnf) grammar for the file. The new grammar is created using
     * <code>myRFCService.transformAbnfToBnf</code>. Any files and directories located inside
     * gen directory, will be deleted automatically.
     *
     * @param abnfGrammar the file containing .abnf grammar
     * @param dstPath     path where generated files will be stored
     */
    public static void generateGrammar(final File abnfGrammar, final String dstPath) {
        String fileName = FilenameUtils.removeExtension(abnfGrammar.getName());
        String path = dstPath + fileName;
        boolean isCreated = new File(path).mkdirs();
        if (isCreated) {
            File outputFile = new File(path + "/" + fileName + "-grammar-kit.bnf");
            File outputFilev2 = new File(path + "/" + fileName + "-grammar-kitv2.bnf");
            File outputFilev3 = new File(path + "/" + fileName + "-grammar-kitvFinal.bnf");
            GRAMMARKIT_RFC_SERVICE.transformAbnfToBnf(abnfGrammar, outputFile, outputFilev2, outputFilev3);
        } else {
            File directoryToBeDeleted = new File(path);
            deleteDirectory(directoryToBeDeleted);
            generateGrammar(abnfGrammar, dstPath);
        }
    }

    /**
     * Delete each file and directory in which provided file is located
     *
     * @param directoryToBeDeleted the file to be deleted
     * @return <code>true</code> if and only if the file or directory is
     * successfully deleted; <code>false</code> otherwise
     */
    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}