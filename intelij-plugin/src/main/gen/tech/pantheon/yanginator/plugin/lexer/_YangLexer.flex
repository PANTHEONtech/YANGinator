package tech.pantheon.yanginator.plugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;

%%

%{
  public _YangLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _YangLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

UNDERSCORE = "_"
ASTERISK = "*"
BACK_SLASH = \\
DOUBLE_QUOTE = \"
SINGLE_QUOTE = [\'"'"]
SEMICOLON = ";"
COLON = ":"
DOUBLE_COLON = "::"
LEFT_BRACE = "{"
RIGHT_BRACE = "}"
DOT = "."
DOUBLE_DOT = ".."
DASH = "-"
LEFT_PARENTHESIS = "("
RIGHT_PARENTHESIS = ")"
EQUALS = "="
OPEN_BRACKET = "["
CLOSED_BRACKET = "]"
FORWARD_SLASH = "/"
PIPE = "|"
ZERO = "0"
ONE = "1"
TWO = "2"
THREE = "3"
FOUR = "4"
FIVE = "5"
SIX = "6"
SEVEN = "7"
EIGHT = "8"
NINE = "9"
HEXDIGIT = [a-f]
LETTERS = [a-zA-Z]+
EXCLAMATION_MARK = "!"
HASH = "#"
DOLLAR_SIGN = "$"
PERCENT_SIGN = "%"
AMPERSAND = "&"
PLUS_SIGN = "+"
COMMA = ","
LESS_THAN_SIGN = "<"
GREATER_THAN_SIGN = ">"
QUESTION_MARK = "?"
AT_SIGN = "@"
CIRCUMFLEX_ACCENT = "^"
GRAVE_ACCENT = "`"
TILDE = "~"
EOL = \R
TAB = \t
LINEFEED = \n
CARRIAGE_RETURN = \r
SPACE = [\s \x0B\f]
OTHER_CHARACTER = "."
DOUBLE_PIPE = "||"
DOUBLE_COLON = "::"
PARENT_FOLDER = "../"
ALPHA = {LETTERS}
POSITIVE_NUMBER = {ONE} | {TWO} | {THREE} | {FOUR} | {FIVE} | {SIX} | {SEVEN} | {EIGHT} | {NINE}
STRINGS_SINGLE_QUOTE = {BACK_SLASH}{SINGLE_QUOTE}
STRINGS_DOUBLE_QUOTE = {BACK_SLASH}{DOUBLE_QUOTE}
NEW_LINE = {LINEFEED} | {CARRIAGE_RETURN}
VERSION = "v"
DOUBLE_FORWARD_SLASH = "//"
HEXDIG = {HEXDIGIT}
ZERO_LENGTH_STRING = ""
APOSTROPHE = "’"
DATE = \d{4}-(1[0-2]|0[1-9])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])
DIGITS = [0-9]{2,999}
IPV4 = ((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)
ALPHANUMERICAL_ALPHA_FIRST = ([a-zA-Z]+[0-9]+([a-zA-Z]+[0-9]*)+)|([a-zA-Z]+[0-9]+)+
ALPHANUMERICAL_DIGIT_FIRST = ([0-9]+[a-zA-Z]+([0-9]+[a-zA-Z]*)+)|([0-9]+[a-zA-Z]+)+
FRACTIONS = 1[0-8]
ZEROS = 0{2,999}
CHARS = [^\w;{}\\ \"\-.]|[^\W_]+
ESCAPES = \\[nt\"\\]

EOL=\R


%%
<YYINITIAL> {

  {ZERO_LENGTH_STRING}             { return YANG_ZERO_LENGTH_STRING; }
  {LINEFEED}                       { return YANG_LINEFEED; }
  {CARRIAGE_RETURN}                { return YANG_CARRIAGE_RETURN; }
  {ONE}                            { return YANG_ONE; }
  {TWO}                            { return YANG_TWO; }
  {THREE}                          { return YANG_THREE; }
  {FOUR}                           { return YANG_FOUR; }
  {FIVE}                           { return YANG_FIVE; }
  {SIX}                            { return YANG_SIX; }
  {SEVEN}                          { return YANG_SEVEN; }
  {EIGHT}                          { return YANG_EIGHT; }
  {NINE}                           { return YANG_NINE; }
  {DATE}                           { return YANG_DATE; }
  {FRACTIONS}                      { return YANG_FRACTIONS; }
  {ZEROS}                          { return YANG_ZEROS; }
  {ESCAPES}                        { return YANG_ESCAPES; }
  {LEFT_BRACE}                     { return YANG_LEFT_BRACE; }
  {RIGHT_BRACE}                    { return YANG_RIGHT_BRACE; }
  {DOUBLE_QUOTE}                   { return YANG_DOUBLE_QUOTE; }
  {DOT}                            { return YANG_DOT; }
  {SEMICOLON}                      { return YANG_SEMICOLON; }
  {LEFT_PARENTHESIS}               { return YANG_LEFT_PARENTHESIS; }
  {RIGHT_PARENTHESIS}              { return YANG_RIGHT_PARENTHESIS; }
  {COLON}                          { return YANG_COLON; }
  {PIPE}                           { return YANG_PIPE; }
  {DOUBLE_DOT}                     { return YANG_DOUBLE_DOT; }
  {FORWARD_SLASH}                  { return YANG_FORWARD_SLASH; }
  {OPEN_BRACKET}                   { return YANG_OPEN_BRACKET; }
  {CLOSED_BRACKET}                 { return YANG_CLOSED_BRACKET; }
  {EQUALS}                         { return YANG_EQUALS; }
  {PARENT_FOLDER}                  { return YANG_PARENT_FOLDER; }
  {ALPHA}                          { return YANG_ALPHA; }
  {UNDERSCORE}                     { return YANG_UNDERSCORE; }
  {ALPHANUMERICAL_ALPHA_FIRST}     { return YANG_ALPHANUMERICAL_ALPHA_FIRST; }
  {ALPHANUMERICAL_DIGIT_FIRST}     { return YANG_ALPHANUMERICAL_DIGIT_FIRST; }
  {DIGITS}                         { return YANG_DIGITS; }
  {DASH}                           { return YANG_DASH; }
  {ZERO}                           { return YANG_ZERO; }
  {SINGLE_QUOTE}                   { return YANG_SINGLE_QUOTE; }
  {TAB}                            { return YANG_TAB; }
  {SPACE}                          { return YANG_SPACE; }
  {QUESTION_MARK}                  { return YANG_QUESTION_MARK; }
  {HASH}                           { return YANG_HASH; }
  {PLUS_SIGN}                      { return YANG_PLUS_SIGN; }
  {AT_SIGN}                        { return YANG_AT_SIGN; }
  {VERSION}                        { return YANG_VERSION; }
  {HEXDIG}                         { return YANG_HEXDIG; }
  {DOUBLE_COLON}                   { return YANG_DOUBLE_COLON; }
  {IPV4}                           { return YANG_IPV4; }
  {PERCENT_SIGN}                   { return YANG_PERCENT_SIGN; }
  {TILDE}                          { return YANG_TILDE; }
  {EXCLAMATION_MARK}               { return YANG_EXCLAMATION_MARK; }
  {DOLLAR_SIGN}                    { return YANG_DOLLAR_SIGN; }
  {AMPERSAND}                      { return YANG_AMPERSAND; }
  {ASTERISK}                       { return YANG_ASTERISK; }
  {COMMA}                          { return YANG_COMMA; }
  {BACK_SLASH}                     { return YANG_BACK_SLASH; }
  {CHARS}                          { return YANG_CHARS; }
  {APOSTROPHE}                     { return YANG_APOSTROPHE; }
  {LESS_THAN_SIGN}                 { return YANG_LESS_THAN_SIGN; }
  {GREATER_THAN_SIGN}              { return YANG_GREATER_THAN_SIGN; }
  {CIRCUMFLEX_ACCENT}              { return YANG_CIRCUMFLEX_ACCENT; }
  {GRAVE_ACCENT}                   { return YANG_GRAVE_ACCENT; }


}

[^] { return BAD_CHARACTER; }
