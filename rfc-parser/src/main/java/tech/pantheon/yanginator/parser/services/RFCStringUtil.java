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

import tech.pantheon.yanginator.parser.types.BnfTokenType;

public class RFCStringUtil {

    public static final BnfTokenType DOUBLE_QUOTE = new BnfTokenType("", "DOUBLE_QUOTE");
    public static final BnfTokenType SINGLE_QUOTE = new BnfTokenType("'", "SINGLE_QUOTE");
    public static final BnfTokenType SEMICOLON = new BnfTokenType(";", "SEMICOLON");
    public static final BnfTokenType COLON = new BnfTokenType(":", "COLON");
    public static final BnfTokenType LEFT_BRACE = new BnfTokenType("{", "LEFT_BRACE");
    public static final BnfTokenType RIGHT_BRACE = new BnfTokenType("}", "RIGHT_BRACE");
    public static final BnfTokenType DOT = new BnfTokenType(".", "DOT");
    public static final BnfTokenType DASH = new BnfTokenType("-", "DASH");
    public static final BnfTokenType UNDERSCORE = new BnfTokenType("_", "UNDERSCORE");
    public static final BnfTokenType EQUAL = new BnfTokenType("=", "EQUAL");
    public static final BnfTokenType LEFT_PARENTHESIS = new BnfTokenType("(", "LEFT_PARENTHESIS");
    public static final BnfTokenType RIGHT_PARENTHESIS = new BnfTokenType(")", "RIGHT_PARENTHESIS");
    public static final BnfTokenType OPEN_BRACKET = new BnfTokenType("[", "OPEN_BRACKET");
    public static final BnfTokenType CLOSED_BRACKET = new BnfTokenType("]", "CLOSED_BRACKET");
    public static final BnfTokenType FORWARD_SLASH = new BnfTokenType("/", "FORWARD_SLASH");
    public static final BnfTokenType PIPE = new BnfTokenType("|", "PIPE");
    public static final BnfTokenType ZERO = new BnfTokenType("0", "ZERO");
    public static final BnfTokenType DOUBLE_DOT = new BnfTokenType("..", "DOUBLE_DOT");

    public static final String BNFEqual = "::=";
    private static final String KEYWORD_END = "-keyword";

    private RFCStringUtil() {
    }

    public static String splitTokens(String line) {
        line = line.concat(" ");
        line = line.replaceAll("\\(\\(", "( (");
        line = line.replaceAll("\\)\\)", ") )");
        line = line.replaceAll("\\*", " * ");
        line = line.replaceAll(" \\(", " ( ");
        line = line.replaceAll("\\) ", " ) ");
        line = line.replaceAll(" \\[", " [ ");
        line = line.replaceAll("] ", " ] ");
        line = line.replaceAll("\"}\"","\"}\" )");
        line = line.replaceAll("\"\\{\""," ( \"{\"");
        line = line.replaceAll(CLOSED_BRACKET.getCharacterValue(), "] ?");

        return line;
    }

    public static String tryReplaceTokens(final String word) {
        if(word.equals(DOUBLE_QUOTE.getStringValue())){ return DOUBLE_QUOTE.getBnfValue();}
        if(word.equals(SINGLE_QUOTE.getStringValue())){ return SINGLE_QUOTE.getBnfValue();}
        if(word.equals(SEMICOLON.getStringValue())){ return SEMICOLON.getBnfValue();}
        if(word.equals(COLON.getStringValue())){ return COLON.getBnfValue();}
        if(word.equals(LEFT_BRACE.getStringValue())){ return LEFT_BRACE.getBnfValue();}
        if(word.equals(RIGHT_BRACE.getStringValue())){ return RIGHT_BRACE.getBnfValue();}
        if(word.equals(DOT.getStringValue())){ return DOT.getBnfValue();}
        if(word.equals(DASH.getStringValue())){ return DASH.getBnfValue();}
        if(word.equals(UNDERSCORE.getStringValue())){ return UNDERSCORE.getBnfValue();}
        if(word.equals(EQUAL.getStringValue())){ return EQUAL.getBnfValue();}
        if(word.equals(LEFT_PARENTHESIS.getStringValue())){ return LEFT_PARENTHESIS.getBnfValue();}
        if(word.equals(RIGHT_PARENTHESIS.getStringValue())){ return RIGHT_PARENTHESIS.getBnfValue();}
        if(word.equals(OPEN_BRACKET.getStringValue())){ return OPEN_BRACKET.getBnfValue();}
        if(word.equals(CLOSED_BRACKET.getStringValue())){ return CLOSED_BRACKET.getBnfValue();}
        if(word.equals(FORWARD_SLASH.getStringValue())){ return FORWARD_SLASH.getBnfValue();}
        if(word.equals(PIPE.getStringValue())){ return PIPE.getBnfValue();}
        if(word.equals(ZERO.getStringValue())){ return ZERO.getBnfValue();}
        if(word.equals(DOUBLE_DOT.getStringValue())){ return DOUBLE_DOT.getBnfValue();}

        return word;
    }

    public static String tryReplaceWithBnfSyntax(String word) {
        if (word.equals(OPEN_BRACKET.getCharacterValue())) {
            return LEFT_PARENTHESIS.getCharacterValue();
        }
        if (word.equals(CLOSED_BRACKET.getCharacterValue())) {
            return RIGHT_PARENTHESIS.getCharacterValue();
        }
        if (word.equals(FORWARD_SLASH.getCharacterValue())) {
            return PIPE.getCharacterValue();
        }
        if (word.equals(EQUAL.getCharacterValue())) {
            return BNFEqual;
        }
        if (word.endsWith(KEYWORD_END)) {
            word = word.replaceAll(DASH.getCharacterValue(), UNDERSCORE.getCharacterValue());
            return word.toUpperCase();
        }

        return word;
    }
}
