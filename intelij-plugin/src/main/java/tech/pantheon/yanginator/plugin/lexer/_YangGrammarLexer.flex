/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;

%%

%{
  public _YangGrammarLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _YangGrammarLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

    UNDERSCORE = "_"
    ASTERISK = "*"
    DOUBLE_QUOTE = \"
    SINGLE_QUOTE = \'
    STRINGS_SINGLE_QUOTE = {BACK_SLASH}{SINGLE_QUOTE}
    STRINGS_DOUBLE_QUOTE = {BACK_SLASH}{DOUBLE_QUOTE}
    SEMICOLON = ";"
    COLON = ":"
    LEFT_BRACE = "{"
    RIGHT_BRACE = "}"
    DOT = "."
    DOUBLE_DOT = ".."
    DASH = "-"
    LEFT_PARENTHESIS = "("
    RIGHT_PARENTHESIS = ")"
    EQUAL = "="
    OPEN_BRACKET = "["
    CLOSED_BRACKET = "]"
    FORWARD_SLASH = "/"
    PIPE = "|"
    ZERO = "0"
    LETTER=[a-zA-Z]
    ALPHA={LETTER}
    SINGLE_LINE_COMMENT_START = {FORWARD_SLASH}{2}
    BLOCK_COMMENT= "/*"( [^*] | (\*+[^*/]) )*\*+\/
    //LINE_COMMENT={SINGLE_LINE_COMMENT_START}[^\"\n\r]*{NEWLINE}
    EOL=\R
    TAB=\t
    LINEFEED=\n
    CARRIAGE_RETURN=\r
    SPACE=[\s \x0B\f]
    BACK_SLASH=\\
    POSITIVE_NUMBER=[1-9]
    OTHER_CHARACTER=.
    NEWLINE = {LINEFEED} | {CARRIAGE_RETURN}

    anyxml_keyword                 = "anyxml"
    argument_keyword               = "argument"
    augment_keyword                = "augment"
    base_keyword                   = "base"
    belongs_to_keyword             = "belongs-to"
    bit_keyword                    = "bit"
    case_keyword                   = "case"
    choice_keyword                 = "choice"
    config_keyword                 = "config"
    contact_keyword                = "contact"
    container_keyword              = "container"
    default_keyword                = "default"
    description_keyword            = "description"
    enum_keyword                   = "enum"
    error_app_tag_keyword          = "error-app-tag"
    error_message_keyword          = "error-message"
    extension_keyword              = "extension"
    deviation_keyword              = "deviation"
    deviate_keyword                = "deviate"
    feature_keyword                = "feature"
    fraction_digits_keyword        = "fraction-digits"
    grouping_keyword               = "grouping"
    identity_keyword               = "identity"
    if_feature_keyword             = "if-feature"
    import_keyword                 = "import"
    include_keyword                = "include"
    input_keyword                  = "input"
    key_keyword                    = "key"
    leaf_keyword                   = "leaf"
    leaf_list_keyword              = "leaf-list"
    length_keyword                 = "length"
    list_keyword                   = "list"
    mandatory_keyword              = "mandatory"
    max_elements_keyword           = "max-elements"
    min_elements_keyword           = "min-elements"
    module_keyword                 = "module"
    must_keyword                   = "must"
    namespace_keyword              = "namespace"
    notification_keyword           = "notification"
    ordered_by_keyword             = "ordered-by"
    organization_keyword           = "organization"
    output_keyword                 = "output"
    path_keyword                   = "path"
    pattern_keyword                = "pattern"
    position_keyword               = "position"
    prefix_keyword                 = "prefix"
    presence_keyword               = "presence"
    range_keyword                  = "range"
    reference_keyword              = "reference"
    refine_keyword                 = "refine"
    require_instance               = "require-instance"
    revision_keyword               = "revision"
    revision_date_keyword          = "revision-date"
    rpc_keyword                    = "rpc"
    status_keyword                 = "status"
    submodule_keyword              = "submodule"
    type_keyword                   = "type"
    typedef_keyword                = "typedef"
    unique_keyword                 = "unique"
    units_keyword                  = "units"
    uses_keyword                   = "uses"
    value_keyword                  = "value"
    when_keyword                   = "when"
    yang_version_keyword           = "yang-version"
    yin_element_keyword            = "yin-element"
    current_keyword                = "current"
    delete_keyword                 = "delete"
    deprecated_keyword             = "deprecated"
    false_keyword                  = "false"
    add_keyword                    = "add"
    max_keyword                    = "max"
    min_keyword                    = "min"
    not_supported_keyword          = "not-supported"
    obsolete_keyword               = "obsolete"
    replace_keyword                = "replace"
    system_keyword                 = "system"
    true_keyword                   = "true"
    unbounded_keyword              = "unbounded"
    user_keyword                   = "user"

%%
<YYINITIAL> {

    {ASTERISK}                       { return YANG_ASTERISK; }
    {DOUBLE_QUOTE}                   { return YANG_DOUBLE_QUOTE; }
    {SINGLE_QUOTE}                   { return YANG_SINGLE_QUOTE; }
    {SEMICOLON}                      { return YANG_SEMICOLON; }
    {COLON}                          { return YANG_COLON; }
    {LEFT_BRACE}                     { return YANG_LEFT_BRACE; }
    {RIGHT_BRACE}                    { return YANG_RIGHT_BRACE; }
    {DOT}                            { return YANG_DOT; }
    {DOUBLE_DOT}                     { return YANG_DOUBLE_DOT; }
    {DASH}                           { return YANG_DASH; }
    {UNDERSCORE}                     { return YANG_UNDERSCORE; }
    {LEFT_PARENTHESIS}               { return YANG_LEFT_PARENTHESIS; }
    {RIGHT_PARENTHESIS}              { return YANG_RIGHT_PARENTHESIS; }
    {EQUAL}                          { return YANG_EQUAL; }
    {OPEN_BRACKET}                   { return YANG_OPEN_BRACKET; }
    {CLOSED_BRACKET}                 { return YANG_CLOSED_BRACKET; }
    {FORWARD_SLASH}                  { return YANG_FORWARD_SLASH; }
    {PIPE}                           { return YANG_PIPE; }
    {ZERO}                           { return YANG_ZERO; }
    {anyxml_keyword}                 { return YANG_ANYXML_KEYWORD; }
    {argument_keyword}               { return YANG_ARGUMENT_KEYWORD; }
    {augment_keyword}                { return YANG_AUGMENT_KEYWORD; }
    {base_keyword}                   { return YANG_BASE_KEYWORD; }
    {belongs_to_keyword}             { return YANG_BELONGS_TO_KEYWORD; }
    {bit_keyword}                    { return YANG_BIT_KEYWORD; }
    {case_keyword}                   { return YANG_CASE_KEYWORD; }
    {choice_keyword}                 { return YANG_CHOICE_KEYWORD; }
    {config_keyword}                 { return YANG_CONFIG_KEYWORD; }
    {contact_keyword}                { return YANG_CONTACT_KEYWORD; }
    {container_keyword}              { return YANG_CONTAINER_KEYWORD; }
    {default_keyword}                { return YANG_DEFAULT_KEYWORD; }
    {description_keyword}            { return YANG_DESCRIPTION_KEYWORD; }
    {enum_keyword}                   { return YANG_ENUM_KEYWORD; }
    {error_app_tag_keyword}          { return YANG_ERROR_APP_TAG_KEYWORD; }
    {error_message_keyword}          { return YANG_ERROR_MESSAGE_KEYWORD; }
    {extension_keyword}              { return YANG_EXTENSION_KEYWORD; }
    {deviation_keyword}              { return YANG_DEVIATION_KEYWORD; }
    {deviate_keyword}                { return YANG_DEVIATE_KEYWORD; }
    {feature_keyword}                { return YANG_FEATURE_KEYWORD; }
    {fraction_digits_keyword}        { return YANG_FRACTION_DIGITS_KEYWORD; }
    {grouping_keyword}               { return YANG_GROUPING_KEYWORD; }
    {identity_keyword}               { return YANG_IDENTITY_KEYWORD; }
    {if_feature_keyword}             { return YANG_IF_FEATURE_KEYWORD; }
    {import_keyword}                 { return YANG_IMPORT_KEYWORD; }
    {include_keyword}                { return YANG_INCLUDE_KEYWORD; }
    {input_keyword}                  { return YANG_INPUT_KEYWORD; }
    {key_keyword}                    { return YANG_KEY_KEYWORD; }
    {leaf_keyword}                   { return YANG_LEAF_KEYWORD; }
    {leaf_list_keyword}              { return YANG_LEAF_LIST_KEYWORD; }
    {length_keyword}                 { return YANG_LENGTH_KEYWORD; }
    {list_keyword}                   { return YANG_LIST_KEYWORD; }
    {mandatory_keyword}              { return YANG_MANDATORY_KEYWORD; }
    {max_elements_keyword}           { return YANG_MAX_ELEMENTS_KEYWORD; }
    {min_elements_keyword}           { return YANG_MIN_ELEMENTS_KEYWORD; }
    {module_keyword}                 { return YANG_MODULE_KEYWORD; }
    {must_keyword}                   { return YANG_MUST_KEYWORD; }
    {namespace_keyword}              { return YANG_NAMESPACE_KEYWORD; }
    {notification_keyword}           { return YANG_NOTIFICATION_KEYWORD; }
    {ordered_by_keyword}             { return YANG_ORDERED_BY_KEYWORD; }
    {organization_keyword}           { return YANG_ORGANIZATION_KEYWORD; }
    {output_keyword}                 { return YANG_OUTPUT_KEYWORD; }
    {path_keyword}                   { return YANG_PATH_KEYWORD; }
    {pattern_keyword}                { return YANG_PATTERN_KEYWORD; }
    {position_keyword}               { return YANG_POSITION_KEYWORD; }
    {prefix_keyword}                 { return YANG_PREFIX_KEYWORD; }
    {presence_keyword}               { return YANG_PRESENCE_KEYWORD; }
    {range_keyword}                  { return YANG_RANGE_KEYWORD; }
    {reference_keyword}              { return YANG_REFERENCE_KEYWORD; }
    {refine_keyword}                 { return YANG_REFINE_KEYWORD; }
    {require_instance}               { return YANG_REQUIRE_INSTANCE_KEYWORD; }
    {revision_keyword}               { return YANG_REVISION_KEYWORD; }
    {revision_date_keyword}          { return YANG_REVISION_DATE_KEYWORD; }
    {rpc_keyword}                    { return YANG_RPC_KEYWORD; }
    {status_keyword}                 { return YANG_STATUS_KEYWORD; }
    {submodule_keyword}              { return YANG_SUBMODULE_KEYWORD; }
    {type_keyword}                   { return YANG_TYPE_KEYWORD; }
    {typedef_keyword}                { return YANG_TYPEDEF_KEYWORD; }
    {unique_keyword}                 { return YANG_UNIQUE_KEYWORD; }
    {units_keyword}                  { return YANG_UNITS_KEYWORD; }
    {uses_keyword}                   { return YANG_USES_KEYWORD; }
    {value_keyword}                  { return YANG_VALUE_KEYWORD; }
    {when_keyword}                   { return YANG_WHEN_KEYWORD; }
    {yang_version_keyword}           { return YANG_YANG_VERSION_KEYWORD; }
    {yin_element_keyword}            { return YANG_YIN_ELEMENT_KEYWORD; }
    {current_keyword}                { return YANG_CURRENT_KEYWORD; }
    {delete_keyword}                 { return YANG_DELETE_KEYWORD; }
    {deprecated_keyword}             { return YANG_DEPRECATED_KEYWORD; }
    {false_keyword}                  { return YANG_FALSE_KEYWORD; }
    {add_keyword}                    { return YANG_ADD_KEYWORD; }
    {max_keyword}                    { return YANG_MAX_KEYWORD; }
    {min_keyword}                    { return YANG_MIN_KEYWORD; }
    {not_supported_keyword}          { return YANG_NOT_SUPPORTED_KEYWORD; }
    {obsolete_keyword}               { return YANG_OBSOLETE_KEYWORD; }
    {replace_keyword}                { return YANG_REPLACE_KEYWORD; }
    {system_keyword}                 { return YANG_SYSTEM_KEYWORD; }
    {true_keyword}                   { return YANG_TRUE_KEYWORD; }
    {unbounded_keyword}              { return YANG_UNBOUNDED_KEYWORD; }
    {user_keyword}                   { return YANG_USER_KEYWORD; }

    {TAB}                            { return YANG_TAB; }
    {LINEFEED}                       { return YANG_LINEFEED; }
    {CARRIAGE_RETURN}                { return YANG_CARRIAGE_RETURN; }
    {SPACE}                          { return YANG_SPACE; }
    {BACK_SLASH}                     { return YANG_BACK_SLASH; }
    {POSITIVE_NUMBER}                { return YANG_POSITIVE_NUMBER; }
    {ALPHA}                          { return YANG_ALPHA; }
    {SINGLE_LINE_COMMENT_START}      { return YANG_SINGLE_LINE_COMMENT_START; }
    {BLOCK_COMMENT}                  { return YANG_BLOCK_COMMENT; }
    //{LINE_COMMENT}                   { return YANG_LINE_COMMENT; }
    {OTHER_CHARACTER}                { return YANG_OTHER_CHARACTER; }
    {STRINGS_DOUBLE_QUOTE}           { return YANG_STRINGS_DOUBLE_QUOTE; }
    {STRINGS_SINGLE_QUOTE}           { return YANG_STRINGS_SINGLE_QUOTE; }
    //{BLOCK_COMMENT_END}              { return YANG_BLOCK_COMMENT_END; }
    //{NOT_BLOCK_COMMENT_END}          { return YANG_NOT_BLOCK_COMMENT_END; }

}

[^] { return BAD_CHARACTER; }
