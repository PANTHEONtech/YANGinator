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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tech.pantheon.yanginator.parser.generator.Extension;
import tech.pantheon.yanginator.parser.generator.FlexerToken;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
     * @param inputFile  the source file of abnf grammar
     * @param outputFile the output file in which converted bnf grammar will be saved
     */
    public void transformAbnfToBnf(final File inputFile, final File outputFile, final File outputFilev2, final File outputFilev3) {
        final List<String> oldGrammar = this.readInputFile(inputFile);
        List<String> newGrammar = this.parseInputFile(oldGrammar);
        this.writeIntoOutputFile(outputFile, newGrammar);
        newGrammar = this.parseInputFilev2(newGrammar);
        this.writeIntoOutputFile(outputFilev2, newGrammar);
        newGrammar = this.parseInputFilev3(newGrammar, oldGrammar, new File("rfc-parser/src/main/gen/rfc-3986/rfc-3986-grammar-kitv2.bnf"));
        this.writeIntoOutputFile(outputFilev3, newGrammar);

    }

    /**
     * Transforms the generated lexer file into valid form
     * with added tokens used in bnf for parsing
     *
     * @param inputFile  lexer file generated by idea
     * @param outputFile lexer file
     */
    public void generateLexer(final File inputFile, final File outputFile) {
        List<String> oldLexer = this.readInputFile(inputFile);
        List<FlexerToken> tokens = null;
        tokens = this.loadTokensFromXML(this.getFile("yang-rfc-grammar/tokens/tokens.xml"));
        oldLexer = GrammarKitRFCUtils.replaceQuotes(oldLexer);
        oldLexer = GrammarKitRFCUtils.addTokensIntoLexer(oldLexer, tokens);
        this.writeIntoOutputFile(outputFile, oldLexer);
    }

    /**
     * Returns a list of strings with content of <code>inputFile</code>
     *
     * @param inputFile the {@code File} to read
     * @return the list of strings
     */
    public List<String> readInputFile(final File inputFile) {
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
     * Transforms a list of strings <code>oldGrammar</code> from Augmented
     * Backus–Naur form to Backus–Naur form. New list of strings formatted
     * according to Intellij Grammar Kit .bnf standards.
     *
     * @param oldGrammar the list of strings containing .abnf grammar
     * @return the list of strings containing .bnf grammar
     * @see <a href="/YANGinator/rfc-parser/docs/readme.md">readme.md</a>
     */
    private List<String> parseInputFile(final List<String> oldGrammar) {
        List<String> result;
        result = GrammarKitRFCUtils.replaceAllAbnfTokens(oldGrammar);
        result = GrammarKitRFCUtils.deleteWhitespaces(result);
        result = GrammarKitRFCUtils.rewriteNtoMMultiplier(result);
        result = GrammarKitRFCUtils.rewriteDigitMultiplier(result, GrammarKitRFCUtils.MULTIPLIER_ZERO_TO_N_TIMES);
        result = GrammarKitRFCUtils.rewriteDigitMultiplier(result, GrammarKitRFCUtils.MULTIPLIER_N_TIMES_WORD);
        result = GrammarKitRFCUtils.rewriteDigitMultiplier(result, GrammarKitRFCUtils.MULTIPLIER_N_TIMES_PARENTHESES);
        result = GrammarKitRFCUtils.trimAndAppendOperator(result, "1*", "+");
        result = GrammarKitRFCUtils.trimAndAppendOperator(result, "*", "*");
        result = GrammarKitRFCUtils.replaceAsterWord(result, "1*");
        result = GrammarKitRFCUtils.replaceAsterWord(result, "*");
        result = GrammarKitRFCUtils.replaceHexadecimalRange(result);
        result = GrammarKitRFCUtils.replaceHexadecimal(result);
        return GrammarKitRFCUtils.rewriteStringRules(result);
    }

    /**
     * Writes the content of given list o strings
     * (transformed bnf grammar) into <code>outputFile</code>
     *
     * @param outputFile the file into which will be the content of provided list written
     * @param lines      the list of strings
     */
    public void writeIntoOutputFile(final File outputFile, final List<String> lines) {
        try (final PrintWriter printWriter = new PrintWriter(outputFile)) {
            lines.forEach(printWriter::println);
        } catch (final IOException e) {
            this.logger.log(Level.WARNING, this.FILE_NOT_FOUND_MESSAGE, e);
        }
    }

    public File getFile(final String fileName) {
        try {
            return new File(this.getClass().getClassLoader().getResource(fileName).toURI());
        } catch (final URISyntaxException e) {
            this.logger.log(Level.WARNING, this.FILE_NOT_FOUND_MESSAGE, e);
        }
        return null;
    }

    /**
     * Replace tokens in the bnf to increase the parsing speed
     *
     * @param oldGrammar list of strings with bnf grammar
     * @return list of strings
     */
    public List<String> parseInputFilev2(List<String> oldGrammar) {
        List<String> newGrammar = oldGrammar;
        newGrammar = GrammarKitRFCUtils.replaceWords(newGrammar, "\"1\" | \"2\" | \"3\" | \"4\" | \"5\" | \"6\" | \"7\" | \"8\" | \"9\"", "\"9\" | \"10\"", "POSITIVE_NUMBER");
        newGrammar = GrammarKitRFCUtils.replaceWords(newGrammar, "\"a\" | \"b\" | \"c\" | \"d\" | \"e\" | \"f\"", "\"f\" | \"g\"", "HEXDIGIT");
        newGrammar = GrammarKitRFCUtils.replaceWords(newGrammar, "\"v\"", "\"v\" |", "VERSION");
        return GrammarKitRFCUtils.replaceTokens(newGrammar, this.loadTokensFromXML(this.getFile("yang-rfc-grammar/tokens/tokens.xml")));

    }

    /**
     * Method adds custom rules and enhancements to bnf grammar
     *
     * @param oldGrammar list of strings with bnf grammar
     * @param abnf       list of string with abnf grammar that contains ranges for yang-char
     * @param input      file with bnf grammar that needs to be added at the end of current bnf grammar
     * @return list of strings with final bnf grammar
     */
    public List<String> parseInputFilev3(List<String> oldGrammar, List<String> abnf, File input) {
        List<String> newGrammar = oldGrammar;
        List<String> rfc3986 = new ArrayList<>();
        if (input != null) {
            rfc3986 = this.readInputFile(input);
        }
        newGrammar = GrammarKitRFCUtils.correctChanges(newGrammar);
        newGrammar = GrammarKitRFCUtils.combineLists(newGrammar, rfc3986, "RFC 3986");
        newGrammar = GrammarKitRFCUtils.addHeader(newGrammar, this.readInputFile(this.getFile("yang-rfc-grammar/tokens/header.txt")));
        //newGrammar = GrammarKitRFCUtils.combineLists(newGrammar, this.readInputFile(this.getFile("yang-rfc-grammar/tokens/highlighter.bnf")), "HIGHLIGHTER STUFF");
        newGrammar = GrammarKitRFCUncomplaintUtils.quoteDescription(newGrammar);
        newGrammar = GrammarKitRFCUtils.addAnyOrder(newGrammar);
        newGrammar = GrammarKitRFCUtils.addCheckString(newGrammar, GrammarKitRFCUtils.extractRangesFromABNF(abnf));
        newGrammar = GrammarKitRFCUncomplaintUtils.splitDeviationStmt(newGrammar);
        return GrammarKitRFCUtils.linkReferenceStmts(newGrammar, this.loadExtensionsFromXML(this.getFile("yang-rfc-grammar/tokens/extensions.xml")));


    }

    /**
     * Method loads tokens from .xml file into list of FlexerTokens. Values in xml must follow next pattern:
     * <class>
     * <token>
     * <key>"value that needs to be replaced in bnf"</key> -> value ranges are put into [] e.g.: [a-z] -> use only 1 range per key
     * <key>"multiple values can be added like this"</key>
     * <value>NAME_OF_TOKEN_THAT_WILL_REPLACE_THE_VALUE</value>
     * <lexerOnly>true/false</lexerOnly> -> true if its not meant to be replaced in bnf but only used in lexer
     * </token>
     * <token>
     * ...
     * </token>
     * </class>
     *
     * @param filename .xml file with tokens
     * @return list of FlexerTokens with token values for lexer and values for replacing them in bnf
     */
    public List<FlexerToken> loadTokensFromXML(final File filename) {
        List<FlexerToken> lines = new ArrayList<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(filename);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("token");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name, lexerValue;
                    boolean lexerOnly = false;
                    List<String> values = new ArrayList<>();
                    String merging = "";
                    int count = 0;
                    for (int j = 0; j < eElement.getElementsByTagName("key").getLength(); j++) {

                        String token = eElement.getElementsByTagName("key").item(j).getTextContent();
                        if ((token.contains("\\") && token.contains("\"")) || token.contains(" ")) {
                            token = token.substring(1, token.length() - 1);
                        } //removes quotes from \r etc..."\r" -> \r
                        if (token.charAt(0) == '\'') {
                            token = "";
                        }
                        if (!token.equals("")) {
                            count++;
                        }
                        merging += token;
                        if (eElement.getElementsByTagName("key").item(j).getTextContent().charAt(0) == '[') {
                            String[] range = eElement.getElementsByTagName("key").item(j).getTextContent().split("-");
                            for (int i = range[0].codePointAt(1); i <= range[1].codePointAt(0); i++) {
                                values.add("\"" + (char) i + "\"");
                            }
                        } else {
                            values.add(eElement.getElementsByTagName("key").item(j).getTextContent());
                        }
                    }
                    if (count > 1 && !merging.contains("{")) {
                        lexerValue = "[" + merging.replace("[", "").replace("]", "") + "]";
                    } else {
                        lexerValue = merging;
                    }
                    if (eElement.getElementsByTagName("lexerOnly").item(0).getTextContent().contains("true")) {
                        lexerOnly = true;
                    }
                    name = eElement.getElementsByTagName("value").item(0).getTextContent();
                    FlexerToken fToken = new FlexerToken(name, lexerValue, lexerOnly);
                    fToken.replaceValues(values);
                    lines.add(fToken);
                }
            }
        } catch (final IOException | SAXException | ParserConfigurationException e) {
            this.logger.log(Level.WARNING, this.FILE_NOT_FOUND_MESSAGE, e);
        }

        return lines;

    }

    public List<Extension> loadExtensionsFromXML(final File filename) {
        List<Extension> result = new ArrayList<>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(filename);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("statement");
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String pin = null;
                    if (element.hasAttribute("pin")){
                        pin = element.getElementsByTagName("pin").item(0).getTextContent();
                    }
                    String implementation = element.getElementsByTagName("implements").item(0).getTextContent();
                    String extend = element.getElementsByTagName("extends").item(0).getTextContent();
                    result.add(new Extension(name,pin,extend,implementation));
                }
            }
        } catch (final IOException | SAXException | ParserConfigurationException e) {
            this.logger.log(Level.WARNING, this.FILE_NOT_FOUND_MESSAGE, e);
        }

        return result;
    }

}
