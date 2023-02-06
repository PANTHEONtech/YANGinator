/*
 *
 *   Copyright (c) 2021-2022 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.parser.services;

import com.google.common.collect.ImmutableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Deprecated
public class RFCService {

    private final Logger logger;

    private final String FILE_WAS_NOT_FOUND_MESSAGE = "File was not found";

    public final static String RFC6020CommentStart = ";;";
    public final static String BLOCK_COMMENT_START = "/*";
    public final static String BLOCK_COMMENT_END = "*/";
    public final static String SINGLE_COMMENT_START = "//";
    public final static String NEWLINE = "\n";
    public final static String ASTERISK = "*";
    public final static String SPACE = " ";

    private final String ORDER_WORD = "order";
    private final String THESE_WORD = "these";
    private final String ONE_TO_M_MULTIPLICATION = "+";
    private final String BODY_STMT_END = "-body";
    private final String QUESTION_MARK = "?";

    private final List<String> HEADER_STARTS = ImmutableList.of("Bjorklund", "RFC");

    public RFCService() {
        this.logger = Logger.getLogger(RFCService.class.getName());
    }

    public void getResultFromFile(final File inputFile, final File outputFile) {
        final List<String> declarations = new ArrayList<>();
        this.readAndParse(inputFile, declarations);
        this.writeIntoFile(outputFile, declarations);
    }

    private void writeIntoFile(final File outputFile, final List<String> declarations) {
        try (final PrintWriter printWriter = new PrintWriter(outputFile)) {
            declarations.forEach(printWriter::println);

        } catch (final IOException e) {
            this.logger.log(Level.WARNING, this.FILE_WAS_NOT_FOUND_MESSAGE, e);
        }
    }

    private void readAndParse(final File inputFile, final List<String> declarations) {
        try (final Scanner myReader = new Scanner(inputFile)) {
            List<String> declarationText = new ArrayList<>();
            while (myReader.hasNextLine()) {
                declarationText = this.processSingleLine(declarations, myReader, declarationText);

            }

        } catch (final FileNotFoundException e) {
            this.logger.log(Level.WARNING, this.FILE_WAS_NOT_FOUND_MESSAGE, e);
        }
    }

    private List<String> processSingleLine(
            final List<String> declarations, final Scanner myReader, List<String> declarationText
    ) {
        var line = myReader.nextLine();
        line = RFCStringUtil.splitTokens(line);

        final var newLine = Arrays.stream(line.split(SPACE))
                .filter(i -> !i.equals(""))
                .collect(Collectors.toList());

        if (this.containsEqual(declarationText, newLine)) {
            declarationText = this.fixDeclarationTextList(declarationText);
            declarations.add(String.join(SPACE, declarationText));
            declarationText.clear();
        }
        if (!newLine.isEmpty()) {
            this.fixComments(declarationText, newLine);
        }

        return declarationText;
    }

    private boolean containsEqual(final List<String> declarationText, final List<String> newLine) {
        return newLine.stream().anyMatch(j -> j.equals(RFCStringUtil.EQUAL.getCharacterValue()))
                && !declarationText.isEmpty();
    }

    private void fixComments(final List<String> declarationText, final List<String> newLine) {
        // rfc6020 uses only single line comments so no need to search more than once
        final var indexOfComment = newLine.indexOf(RFC6020CommentStart);
        if (indexOfComment != -1) {
            this.fixComment(newLine, indexOfComment);
        }
        this.assignNewLine(declarationText, newLine);
    }

    private List<String> fixDeclarationTextList(List<String> declarationText) {
        this.fixNamingInTextInList(declarationText);
        this.fixMultiplicityInList(declarationText);
        this.fixNewLineCommentsInList(declarationText);
        declarationText = this.getFixedAnyOrderStmtsInList(declarationText);

        return declarationText;
    }

    private List<String> getFixedAnyOrderStmtsInList(final List<String> declarationTextList) {
        final int indexOfCommentStart = declarationTextList.indexOf(RFC6020CommentStart);
        if (indexOfCommentStart == -1
                || declarationTextList.size() <= (indexOfCommentStart + 6)
                || !declarationTextList.get(indexOfCommentStart + 7).equals(this.ORDER_WORD)) {

            return declarationTextList;
        }

        boolean inAnyOrderPart = false;
        final List<String> anyOrderList = new ArrayList<>();
        final List<String> newDeclarationTextList = new ArrayList<>();

        int bracketCount = 0;
        for (int idx = 0; idx < declarationTextList.size(); idx++) {
            if (this.isAnyOrderPart(declarationTextList, idx)) {
                idx += 10;
                inAnyOrderPart = true;
                this.defineStmtBodyForAnyOrderStmt(declarationTextList, newDeclarationTextList);
                this.addStmtBodyForAnyOrderStmt(declarationTextList, anyOrderList);
            }
            if (inAnyOrderPart) {
                bracketCount = this.updateBracketCount(declarationTextList, bracketCount, idx);
                this.addWordsToListsForAnyOrderStmts(declarationTextList, anyOrderList, bracketCount, idx);
                inAnyOrderPart = this.checkIfAnyOrderEnd(declarationTextList, idx);
            } else {
                newDeclarationTextList.add(declarationTextList.get(idx));
            }

        }
        anyOrderList.add(NEWLINE);
        anyOrderList.addAll(newDeclarationTextList);

        return anyOrderList;
    }

    private boolean checkIfAnyOrderEnd(final List<String> declarationTextList, final int idx) {
        return declarationTextList.size() <= (idx + 1)
                || !declarationTextList.get(idx + 1).equals(RFCStringUtil.RIGHT_BRACE.getBnfValue());
    }

    private void addWordsToListsForAnyOrderStmts(
            final List<String> declarationTextList,
            final List<String> anyOrderList,
            final int bracketCount,
            final int idx
    ) {
        if (declarationTextList.get(idx).equals(NEWLINE) && bracketCount == 0) {
            if (this.isMultiplier(declarationTextList.get(idx - 1))) {
                if (this.rightBraceOnIndex(declarationTextList, idx)) {
                    anyOrderList.add(anyOrderList.size() - 1, RFCStringUtil.PIPE.getCharacterValue());
                }
                anyOrderList.add(anyOrderList.size() - 1, SINGLE_COMMENT_START);
            } else {
                if (this.rightBraceOnIndex(declarationTextList, idx)) {
                    anyOrderList.add(RFCStringUtil.PIPE.getCharacterValue());
                }
            }
        }
        anyOrderList.add(declarationTextList.get(idx));
    }

    private boolean rightBraceOnIndex(final List<String> declarationTextList, final int idx) {
        return declarationTextList.size() != (idx + 1)
                && !declarationTextList.get(idx + 1).equals(RFCStringUtil.RIGHT_BRACE.getBnfValue());
    }

    private boolean isMultiplier(final String word) {
        return word.equals(ASTERISK)
                || word.equals(this.QUESTION_MARK)
                || word.equals(this.ONE_TO_M_MULTIPLICATION);
    }

    private int updateBracketCount(final List<String> declarationTextList, int bracketCount, final int idx) {
        if (declarationTextList.get(idx).equals(RFCStringUtil.LEFT_PARENTHESIS.getCharacterValue())) {
            bracketCount++;
        } else if (declarationTextList.get(idx).equals(RFCStringUtil.RIGHT_PARENTHESIS.getCharacterValue())) {
            bracketCount--;
        }
        return bracketCount;
    }

    private void addStmtBodyForAnyOrderStmt(final List<String> declarationTextList, final List<String> anyOrderList) {
        anyOrderList.add(declarationTextList.get(0).concat(this.BODY_STMT_END));
        anyOrderList.add(RFCStringUtil.BNFEqual);
    }

    private void defineStmtBodyForAnyOrderStmt
            (final List<String> declarationTextList, final List<String> newDeclarationTextList) {
        newDeclarationTextList.add(declarationTextList.get(0).concat(this.BODY_STMT_END));
        newDeclarationTextList.add(this.ONE_TO_M_MULTIPLICATION);
        newDeclarationTextList.add(NEWLINE);
    }

    private boolean isAnyOrderPart(final List<String> declarationTextList, final int idx) {
        return declarationTextList.get(idx).equals(SINGLE_COMMENT_START)
                && declarationTextList.get(idx + 1).equals(RFC6020CommentStart)
                && declarationTextList.get(idx + 2).equals(this.THESE_WORD)
                && declarationTextList.get((idx + 8)).equals(this.ORDER_WORD);
    }


    private void fixNewLineCommentsInList(final List<String> declarationText) {
        final int indexOfAsterisk = declarationText.indexOf(BLOCK_COMMENT_START);
        if (declarationText.get(declarationText.size() - 1).equals(BLOCK_COMMENT_END)
                && declarationText.get(indexOfAsterisk + 1).equals(RFC6020CommentStart)
        ) {
            declarationText.add(indexOfAsterisk, NEWLINE.concat(NEWLINE));
            declarationText.add(declarationText.size(), NEWLINE);
        }
    }


    private void fixMultiplicityInList(final List<String> declarationString) {
        var indexOfAsterisk = declarationString.indexOf(ASTERISK);

        while (indexOfAsterisk != -1) {
            final boolean numericMultiplier = this.hasNumericMultiplier(declarationString, indexOfAsterisk);
            if (numericMultiplier) {
                if (!declarationString.get(indexOfAsterisk - 1).equals("1")) {
                    // rfc6020 does not contain multiplier greater than 1*
                    this.logger.log(Level.WARNING, "Multiplier is more than one");
                    return;
                }
            }
            final int idx = this.processSingleMultiplicity(declarationString, indexOfAsterisk, numericMultiplier);
            indexOfAsterisk = this.tryFindAnotherAsterisk(declarationString, indexOfAsterisk, idx);

        }
    }

    private int processSingleMultiplicity(final List<String> declarationString, final int indexOfAsterisk, final boolean numericMultiplier) {
        boolean done = false;
        int parentesisSkipCount = 0;
        int idx = indexOfAsterisk + 1;
        while (!done) {
            final var currentString = declarationString.get(idx);
            if (currentString.equals(RFCStringUtil.LEFT_PARENTHESIS.getCharacterValue())) {
                parentesisSkipCount++;
            } else if (currentString.equals(RFCStringUtil.RIGHT_PARENTHESIS.getCharacterValue())) {
                parentesisSkipCount--;
            }
            if (parentesisSkipCount == 0) {
                idx = this.fixSingleMultiplicity(declarationString, indexOfAsterisk, numericMultiplier, idx);
                done = true;
            }
            idx++;

        }
        return idx;
    }

    private int tryFindAnotherAsterisk(final List<String> declarationString, int indexOfAsterisk, final int idx) {
        if (indexOfAsterisk == (idx - 2)) {
            indexOfAsterisk = this.findAnotherAsterisk(idx, declarationString);
        } else {
            indexOfAsterisk = this.findAnotherAsterisk(indexOfAsterisk, declarationString);
        }
        return indexOfAsterisk;
    }

    private int fixSingleMultiplicity(
            final List<String> declarationString,
            final int indexOfAsterisk,
            final boolean numericMultiplier,
            int idx
    ) {
        if (numericMultiplier) {
            declarationString.add(idx + 1, this.ONE_TO_M_MULTIPLICATION);
        } else {
            declarationString.add(idx + 1, ASTERISK);
        }
        declarationString.remove(indexOfAsterisk);
        if (numericMultiplier) {
            declarationString.remove(indexOfAsterisk - 1);
            idx--;
        }
        return idx;
    }

    private int findAnotherAsterisk(int startIndex, final List<String> declarationString) {
        for (; startIndex < declarationString.size(); startIndex++) {
            if (this.hasUnrepairedMultiplier(startIndex, declarationString)) {
                return startIndex;
            }

        }
        return -1;
    }

    private boolean hasUnrepairedMultiplier(final int startIndex, final List<String> declarationString) {
        return declarationString.get(startIndex).equals(ASTERISK)
                && !declarationString.get(startIndex - 1)
                .equals(RFCStringUtil.RIGHT_PARENTHESIS.getCharacterValue());
    }

    private boolean hasNumericMultiplier(final List<String> declarationString, final int indexOfAsterisk) {
        return indexOfAsterisk != 0 && declarationString.get(indexOfAsterisk - 1).chars().allMatch(Character::isDigit);
    }

    private void assignNewLine(final List<String> declarationText, final List<String> newLine) {
        final var firstWord = newLine.get(0);
        if (!this.isHeader(firstWord)) {
            declarationText.addAll(newLine);
            declarationText.add(NEWLINE);
        }
    }

    private boolean isHeader(final String firstWord) {
        return this.HEADER_STARTS.contains(firstWord);
    }

    private void fixNamingInTextInList(final List<String> declarationText) {
        for (int idx = 0; idx < declarationText.size(); idx++) {
            var text = declarationText.get(idx);
            if (text.equals("<")) {
                this.fixFreeFormRule(declarationText, idx);
                break;
            }
            text = this.tryFixedMultiplication(text, declarationText, idx);
            text = RFCStringUtil.tryReplaceTokens(text);
            text = RFCStringUtil.tryReplaceWithBnfSyntax(text);
            declarationText.set(idx, text);

        }
    }

    private void fixComment(final List<String> declarationText, final int textIndex) {
        declarationText.add(textIndex, SINGLE_COMMENT_START);
    }

    // rule that starts with '<' and ends with '>'
    private void fixFreeFormRule(final List<String> declarationText, final int textIndex) {
        declarationText.set(textIndex, BLOCK_COMMENT_START);
        declarationText.set(declarationText.size() - 1, BLOCK_COMMENT_END);
        declarationText.add(textIndex, RFCStringUtil.RIGHT_PARENTHESIS.getBnfValue());
        declarationText.add(textIndex, RFCStringUtil.DOUBLE_QUOTE.getBnfValue());
        declarationText.add(textIndex, this.getFreeFormRule(declarationText));
        declarationText.add(textIndex, RFCStringUtil.DOUBLE_QUOTE.getBnfValue());
        declarationText.add(textIndex, RFCStringUtil.LEFT_PARENTHESIS.getBnfValue());
        declarationText.add(textIndex, RFCStringUtil.PIPE.getBnfValue());
        declarationText.add(textIndex, this.getFreeFormRule(declarationText));
    }

    private String getFreeFormRule(final List<String> declarationText) {
        final int FREE_FORM_RULE_NAME_OFFSET = 3;
        return declarationText.get(declarationText.size() - FREE_FORM_RULE_NAME_OFFSET);
    }

    private String tryFixedMultiplication(String text, final List<String> declarationText, final int textIndex) {
        if (this.isMultiplication(text)) {
            final int repetitions = Character.getNumericValue(text.charAt(0));
            text = text.substring(1);
            for (int idx = 1; idx < repetitions; idx++) {
                declarationText.add(textIndex + idx, text);

            }
        }
        return text;
    }

    private boolean isMultiplication(final String text) {
        return text.length() > 1 && !Character.isDigit(text.charAt(text.length() - 1)) && Character.isDigit(text.charAt(0));
    }

    public File getFile(final String fileName) throws URISyntaxException {
        return new File(this.getClass().getClassLoader().getResource(fileName).toURI());
    }
}
