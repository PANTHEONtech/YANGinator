package tech.pantheon.yanginator.plugin.highlighter;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.*;

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

EOL=\R
WHITE_SPACE=\s+

H_WHITE_SPACE=[ \t\n\x0B\f\r]+
H_STRING=\"([^\"])*\"
H_DATE_ARG=[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}
H_IDENTIFIER=[a-zA-Z_][0-9a-zA-Z_\-.]*
H_EXTENSION_IDENTIFIER=[a-zA-Z_][0-9a-zA-Z_\-.:]*
H_BLOCK_COMMENT="/"\*(([^*/])|"//")*\*"/"
H_SINGLE_LINE_COMMENT="//"([^\n])*
H_INVALID_ESCAPE=\\([^rRtns])
H_VALID_ESCAPE=\\[rRtns]

%%
<YYINITIAL> {
  {WHITE_SPACE}                 { return WHITE_SPACE; }

  "anyxml"                      { return YANG_H_ANYXML_KEYWORD; }
  "argument"                    { return YANG_H_ARGUMENT_KEYWORD; }
  "augment"                     { return YANG_H_AUGMENT_KEYWORD; }
  "base"                        { return YANG_H_BASE_KEYWORD; }
  "belongs-to"                  { return YANG_H_BELONGS_TO_KEYWORD; }
  "bit"                         { return YANG_H_BIT_KEYWORD; }
  "case"                        { return YANG_H_CASE_KEYWORD; }
  "choice"                      { return YANG_H_CHOICE_KEYWORD; }
  "config"                      { return YANG_H_CONFIG_KEYWORD; }
  "contact"                     { return YANG_H_CONTACT_KEYWORD; }
  "container"                   { return YANG_H_CONTAINER_KEYWORD; }
  "default"                     { return YANG_H_DEFAULT_KEYWORD; }
  "description"                 { return YANG_H_DESCRIPTION_KEYWORD; }
  "enum"                        { return YANG_H_ENUM_KEYWORD; }
  "error-app-tag"               { return YANG_H_ERROR_APP_TAG_KEYWORD; }
  "error-message"               { return YANG_H_ERROR_MESSAGE_KEYWORD; }
  "extension"                   { return YANG_H_EXTENSION_KEYWORD; }
  "deviation"                   { return YANG_H_DEVIATION_KEYWORD; }
  "deviate"                     { return YANG_H_DEVIATE_KEYWORD; }
  "feature"                     { return YANG_H_FEATURE_KEYWORD; }
  "fraction-digits"             { return YANG_H_FRACTION_DIGITS_KEYWORD; }
  "grouping"                    { return YANG_H_GROUPING_KEYWORD; }
  "identity"                    { return YANG_H_IDENTITY_KEYWORD; }
  "if-feature"                  { return YANG_H_IF_FEATURE_KEYWORD; }
  "import"                      { return YANG_H_IMPORT_KEYWORD; }
  "include"                     { return YANG_H_INCLUDE_KEYWORD; }
  "input"                       { return YANG_H_INPUT_KEYWORD; }
  "key"                         { return YANG_H_KEY_KEYWORD; }
  "leaf"                        { return YANG_H_LEAF_KEYWORD; }
  "leaf-list"                   { return YANG_H_LEAF_LIST_KEYWORD; }
  "length"                      { return YANG_H_LENGTH_KEYWORD; }
  "list"                        { return YANG_H_LIST_KEYWORD; }
  "mandatory"                   { return YANG_H_MANDATORY_KEYWORD; }
  "max-elements"                { return YANG_H_MAX_ELEMENTS_KEYWORD; }
  "min-elements"                { return YANG_H_MIN_ELEMENTS_KEYWORD; }
  "module"                      { return YANG_H_MODULE_KEYWORD; }
  "must"                        { return YANG_H_MUST_KEYWORD; }
  "namespace"                   { return YANG_H_NAMESPACE_KEYWORD; }
  "notification"                { return YANG_H_NOTIFICATION_KEYWORD; }
  "ordered-by"                  { return YANG_H_ORDERED_BY_KEYWORD; }
  "organization"                { return YANG_H_ORGANIZATION_KEYWORD; }
  "output"                      { return YANG_H_OUTPUT_KEYWORD; }
  "path"                        { return YANG_H_PATH_KEYWORD; }
  "pattern"                     { return YANG_H_PATTERN_KEYWORD; }
  "position"                    { return YANG_H_POSITION_KEYWORD; }
  "prefix"                      { return YANG_H_PREFIX_KEYWORD; }
  "presence"                    { return YANG_H_PRESENCE_KEYWORD; }
  "range"                       { return YANG_H_RANGE_KEYWORD; }
  "reference"                   { return YANG_H_REFERENCE_KEYWORD; }
  "refine"                      { return YANG_H_REFINE_KEYWORD; }
  "require-instance"            { return YANG_H_REQUIRE_INSTANCE_KEYWORD; }
  "revision"                    { return YANG_H_REVISION_KEYWORD; }
  "revision-date"               { return YANG_H_REVISION_DATE_KEYWORD; }
  "rpc"                         { return YANG_H_RPC_KEYWORD; }
  "status"                      { return YANG_H_STATUS_KEYWORD; }
  "submodule"                   { return YANG_H_SUBMODULE_KEYWORD; }
  "type"                        { return YANG_H_TYPE_KEYWORD; }
  "typedef"                     { return YANG_H_TYPEDEF_KEYWORD; }
  "unique"                      { return YANG_H_UNIQUE_KEYWORD; }
  "units"                       { return YANG_H_UNITS_KEYWORD; }
  "uses"                        { return YANG_H_USES_KEYWORD; }
  "value"                       { return YANG_H_VALUE_KEYWORD; }
  "when"                        { return YANG_H_WHEN_KEYWORD; }
  "yang-version"                { return YANG_H_YANG_VERSION_KEYWORD; }
  "yin-element"                 { return YANG_H_YIN_ELEMENT_KEYWORD; }
  "current"                     { return YANG_H_CURRENT_KEYWORD; }
  "delete"                      { return YANG_H_DELETE_KEYWORD; }
  "deprecated"                  { return YANG_H_DEPRECATED_KEYWORD; }
  "false"                       { return YANG_H_FALSE_KEYWORD; }
  "add"                         { return YANG_H_ADD_KEYWORD; }
  "max"                         { return YANG_H_MAX_KEYWORD; }
  "min"                         { return YANG_H_MIN_KEYWORD; }
  "not-supported"               { return YANG_H_NOT_SUPPORTED_KEYWORD; }
  "obsolete"                    { return YANG_H_OBSOLETE_KEYWORD; }
  "replace"                     { return YANG_H_REPLACE_KEYWORD; }
  "system"                      { return YANG_H_SYSTEM_KEYWORD; }
  "true"                        { return YANG_H_TRUE_KEYWORD; }
  "unbounded"                   { return YANG_H_UNBOUNDED_KEYWORD; }
  "user"                        { return YANG_H_USER_KEYWORD; }
  ";"                           { return YANG_H_SEMICOLON; }
  "+"                           { return YANG_H_OPERATORS; }
  "{"                           { return YANG_H_LEFT_BRACE; }
  "}"                           { return YANG_H_RIGHT_BRACE; }

  {H_WHITE_SPACE}               { return YANG_H_WHITE_SPACE; }
  {H_STRING}                    { return YANG_H_STRING; }
  {H_DATE_ARG}                  { return YANG_H_DATE_ARG; }
  {H_IDENTIFIER}                { return YANG_H_IDENTIFIER; }
  {H_EXTENSION_IDENTIFIER}      { return YANG_H_EXTENSION_IDENTIFIER; }
  {H_BLOCK_COMMENT}             { return YANG_H_BLOCK_COMMENT; }
  {H_SINGLE_LINE_COMMENT}       { return YANG_H_SINGLE_LINE_COMMENT; }
  {H_INVALID_ESCAPE}            { return YANG_H_INVALID_ESCAPE; }
  {H_VALID_ESCAPE}              { return YANG_H_VALID_ESCAPE; }

}

[^] { return BAD_CHARACTER; }
