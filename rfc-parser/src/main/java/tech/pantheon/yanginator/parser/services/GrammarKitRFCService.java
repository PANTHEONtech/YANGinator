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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrammarKitRFCService {

    private final Logger logger;

    public final String FILE_NOT_FOUND_MESSAGE = "File not found";


    public GrammarKitRFCService() {
        this.logger = Logger.getLogger(GrammarKitRFCService.class.getName());
    }

    /**
     * Transforms abnf input file to bnf output file. Provided input file
     * (Augmented Backus–Naur form) is stored in <code>oldGrammar</code> - list
     * of strings (lines). This list is used as an input for {@link #parseInputFile},
     * which will return transformed (Backus–Naur form) list of strings - <code>newGrammar</code>.
     * Finally, {@link #writeIntoOutputFile} stores <code>newGrammar</code> to <code>outputFile</code>.
     *
     * @param inputFile the source file of abnf grammar
     * @param outputFile the output file in which converted bnf grammar will be saved
     */
    public void transformAbnfToBnf(final File inputFile, final File outputFile) {
        final List<String> oldGrammar = this.readInputFile(inputFile);
        List<String> newGrammar = this.parseInputFile(oldGrammar);
        this.writeIntoOutputFile(outputFile, newGrammar);
    }

    /**
     * Returns a list of strings with content of <code>inputFile</code>
     *
     * @param inputFile the {@code File} to read
     * @return the list of strings
     */
    private List<String> readInputFile(final File inputFile) {
        List<String> lines = new ArrayList<>();
        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());
            }
        } catch (final IOException e) {
            this.logger.log(Level.WARNING, this.FILE_NOT_FOUND_MESSAGE, e);
        }
        return lines;
    }

    /**
     *  Transforms a list of strings <code>oldGrammar</code> from Augmented
     *  Backus–Naur form to Backus–Naur form. New list of strings formatted
     *  according to Intellij Grammar Kit .bnf standards.
     *
     * @param oldGrammar the list of strings containing .abnf grammar
     * @return the list of strings containing .bnf grammar
     * @see  <a href="/YANGinator/rfc-parser/docs/readme.md">
     * ABNF to BNF transformaiton</a>
     */
    private List<String> parseInputFile(final List<String> oldGrammar) {
        List<String> result;
        result = GrammarKitRFCUtils.replaceAllAbnfTokens(oldGrammar);
        result = GrammarKitRFCUtils.deleteWhitespaces(result);
        result = GrammarKitRFCUtils.trimAndAppendOperator(result,"1*","+");
        result = GrammarKitRFCUtils.trimAndAppendOperator(result,"*","*");
        result = GrammarKitRFCUtils.replaceAsterWord(result, "1*");
        result = GrammarKitRFCUtils.replaceAsterWord(result, "*");
        result = GrammarKitRFCUtils.replaceHexadecimalRange(result);
        result = GrammarKitRFCUtils.replaceHexadecimal(result);
        return GrammarKitRFCUtils.rewriteStringRules(result);
    }

    /**
     *  Writes the content of given list o strings
     *  (transformed bnf grammar) into <code>outputFile</code>
     *
     * @param outputFile the file into which will be the content of provided list written
     * @param lines the list of strings
     */
    private void writeIntoOutputFile(final File outputFile, final List<String> lines) {
        try (final PrintWriter printWriter = new PrintWriter(outputFile)) {
            lines.forEach(printWriter::println);
        } catch (final IOException e) {
            this.logger.log(Level.WARNING, this.FILE_NOT_FOUND_MESSAGE, e);
        }
    }

    public File getFile(final String fileName) throws URISyntaxException {
        return new File(this.getClass().getClassLoader().getResource(fileName).toURI());
    }
}
