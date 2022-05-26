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
LETTER = [a-zA-Z]
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
BLOCK_COMMENT = "/*" ( [^*] | (\*+[^*/]) )*\*+\/
DOUBLE_PIPE = "||"
DOUBLE_COLON = "::"
PARENT_FOLDER = "../"
ALPHA = {LETTER}
POSITIVE_NUMBER = {ONE} | {TWO} | {THREE} | {FOUR} | {FIVE} | {SIX} | {SEVEN} | {EIGHT} | {NINE}
STRINGS_SINGLE_QUOTE = {BACK_SLASH}{SINGLE_QUOTE}
STRINGS_DOUBLE_QUOTE = {BACK_SLASH}{DOUBLE_QUOTE}
SINGLE_LINE_COMMENT_START = {FORWARD_SLASH}{2}
NEW_LINE = {LINEFEED} | {CARRIAGE_RETURN}
VERSION = "v"
DOUBLE_FORWARD_SLASH = "//"
HEXDIG = {HEXDIGIT}
BLOCK_COMMENT_END = "*/"
ZERO_LENGHT_STRING = ""
APOSTROPHE = "’"

EOL=\R


%%
<YYINITIAL> {

  {BLOCK_COMMENT}           { return YANG_BLOCK_COMMENT; }
  {LEFT_BRACE}              { return YANG_LEFT_BRACE; }
  {RIGHT_BRACE}             { return YANG_RIGHT_BRACE; }
  {DOUBLE_QUOTE}            { return YANG_DOUBLE_QUOTE; }
  {SEMICOLON}               { return YANG_SEMICOLON; }
  {LEFT_PARENTHESIS}        { return YANG_LEFT_PARENTHESIS; }
  {RIGHT_PARENTHESIS}       { return YANG_RIGHT_PARENTHESIS; }
  {ONE}                     { return YANG_ONE; }
  {ZERO}                    { return YANG_ZERO; }
  {TWO}                     { return YANG_TWO; }
  {THREE}                   { return YANG_THREE; }
  {FOUR}                    { return YANG_FOUR; }
  {FIVE}                    { return YANG_FIVE; }
  {SIX}                     { return YANG_SIX; }
  {SEVEN}                   { return YANG_SEVEN; }
  {EIGHT}                   { return YANG_EIGHT; }
  {NINE}                    { return YANG_NINE; }
  {COLON}                   { return YANG_COLON; }
  {PIPE}                    { return YANG_PIPE; }
  {DOUBLE_DOT}              { return YANG_DOUBLE_DOT; }
  {DASH}                    { return YANG_DASH; }
  {FORWARD_SLASH}           { return YANG_FORWARD_SLASH; }
  {OPEN_BRACKET}            { return YANG_OPEN_BRACKET; }
  {CLOSED_BRACKET}          { return YANG_CLOSED_BRACKET; }
  {EQUALS}                  { return YANG_EQUALS; }
  {DOT}                     { return YANG_DOT; }
  {PARENT_FOLDER}           { return YANG_PARENT_FOLDER; }
  {ALPHA}                   { return YANG_ALPHA; }
  {UNDERSCORE}              { return YANG_UNDERSCORE; }
  {SINGLE_QUOTE}            { return YANG_SINGLE_QUOTE; }
  {CARRIAGE_RETURN}         { return YANG_CARRIAGE_RETURN; }
  {TAB}                     { return YANG_TAB; }
  {LINEFEED}                { return YANG_LINEFEED; }
  {SPACE}                   { return YANG_SPACE; }
  {QUESTION_MARK}           { return YANG_QUESTION_MARK; }
  {HASH}                    { return YANG_HASH; }
  {DOUBLE_FORWARD_SLASH}    { return YANG_DOUBLE_FORWARD_SLASH; }
  {PLUS_SIGN}               { return YANG_PLUS_SIGN; }
  {AT_SIGN}                 { return YANG_AT_SIGN; }
  {VERSION}                 { return YANG_VERSION; }
  {HEXDIG}                  { return YANG_HEXDIG; }
  {DOUBLE_COLON}            { return YANG_DOUBLE_COLON; }
  {ZERO_LENGHT_STRING}      { return YANG_ZERO_LENGHT_STRING; }
  {PERCENT_SIGN}            { return YANG_PERCENT_SIGN; }
  {TILDE}                   { return YANG_TILDE; }
  {EXCLAMATION_MARK}        { return YANG_EXCLAMATION_MARK; }
  {DOLLAR_SIGN}             { return YANG_DOLLAR_SIGN; }
  {AMPERSAND}               { return YANG_AMPERSAND; }
  {ASTERISK}                { return YANG_ASTERISK; }
  {COMMA}                   { return YANG_COMMA; }
  {APOSTROPHE}              { return YANG_APOSTROPHE; }
  {LESS_THAN_SIGN}          { return YANG_LESS_THAN_SIGN; }
  {GREATER_THAN_SIGN}       { return YANG_GREATER_THAN_SIGN; }
  {BACK_SLASH}              { return YANG_BACK_SLASH; }
  {CIRCUMFLEX_ACCENT}       { return YANG_CIRCUMFLEX_ACCENT; }
  {GRAVE_ACCENT}            { return YANG_GRAVE_ACCENT; }

}

[^] { return BAD_CHARACTER; }
