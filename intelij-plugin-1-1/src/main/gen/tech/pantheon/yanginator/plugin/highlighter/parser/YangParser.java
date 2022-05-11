/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class YangParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return yang(b, l + 1);
  }

  /* ********************************************************** */
  // H_IDENTIFIER wsp H_STRING wsp? ";"
  public static boolean STMT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STMT")) return false;
    if (!nextTokenIs(b, YANG_H_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_H_IDENTIFIER);
    r = r && wsp(b, l + 1);
    r = r && consumeToken(b, YANG_H_STRING);
    r = r && STMT_3(b, l + 1);
    r = r && consumeToken(b, YANG_H_SEMICOLON);
    exit_section_(b, m, YANG_STMT, r);
    return r;
  }

  // wsp?
  private static boolean STMT_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STMT_3")) return false;
    wsp(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // H_IDENTIFIER wsp? H_STRING? wsp?
  public static boolean dummy(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dummy")) return false;
    if (!nextTokenIs(b, YANG_H_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_H_IDENTIFIER);
    r = r && dummy_1(b, l + 1);
    r = r && dummy_2(b, l + 1);
    r = r && dummy_3(b, l + 1);
    exit_section_(b, m, YANG_DUMMY, r);
    return r;
  }

  // wsp?
  private static boolean dummy_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dummy_1")) return false;
    wsp(b, l + 1);
    return true;
  }

  // H_STRING?
  private static boolean dummy_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dummy_2")) return false;
    consumeToken(b, YANG_H_STRING);
    return true;
  }

  // wsp?
  private static boolean dummy_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dummy_3")) return false;
    wsp(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // H_STRING | H_DATE_ARG | H_IDENTIFIER | H_EXTENSION_IDENTIFIER | H_BLOCK_COMMENT | H_SINGLE_LINE_COMMENT
  //  | H_SEMICOLON  h-identifier-literal
  public static boolean h_any_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h_any_token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_H_ANY_TOKEN, "<h any token>");
    r = consumeToken(b, YANG_H_STRING);
    if (!r) r = consumeToken(b, YANG_H_DATE_ARG);
    if (!r) r = consumeToken(b, YANG_H_IDENTIFIER);
    if (!r) r = consumeToken(b, YANG_H_EXTENSION_IDENTIFIER);
    if (!r) r = consumeToken(b, YANG_H_BLOCK_COMMENT);
    if (!r) r = consumeToken(b, YANG_H_SINGLE_LINE_COMMENT);
    if (!r) r = h_any_token_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // H_SEMICOLON  h-identifier-literal
  private static boolean h_any_token_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h_any_token_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_H_SEMICOLON);
    r = r && h_identifier_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // H_ANYXML_KEYWORD          |
  //     H_ARGUMENT_KEYWORD        |
  //     H_AUGMENT_KEYWORD         |
  //     H_BASE_KEYWORD            |
  //     H_BELONGS_TO_KEYWORD      |
  //     H_BIT_KEYWORD             |
  //     H_CASE_KEYWORD            |
  //     H_CHOICE_KEYWORD          |
  //     H_CONFIG_KEYWORD          |
  //     H_CONTACT_KEYWORD         |
  //     H_CONTAINER_KEYWORD       |
  //     H_DEFAULT_KEYWORD         |
  //     H_DESCRIPTION_KEYWORD     |
  //     H_ENUM_KEYWORD            |
  //     H_ERROR_APP_TAG_KEYWORD   |
  //     H_ERROR_MESSAGE_KEYWORD   |
  //     H_EXTENSION_KEYWORD       |
  //     H_DEVIATION_KEYWORD       |
  //     H_DEVIATE_KEYWORD         |
  //     H_FEATURE_KEYWORD         |
  //     H_FRACTION_DIGITS_KEYWORD |
  //     H_GROUPING_KEYWORD        |
  //     H_IDENTITY_KEYWORD        |
  //     H_IF_FEATURE_KEYWORD      |
  //     H_IMPORT_KEYWORD          |
  //     H_INCLUDE_KEYWORD         |
  //     H_INPUT_KEYWORD           |
  //     H_KEY_KEYWORD             |
  //     H_LEAF_KEYWORD            |
  //     H_LEAF_LIST_KEYWORD       |
  //     H_LENGTH_KEYWORD          |
  //     H_LIST_KEYWORD            |
  //     H_MANDATORY_KEYWORD       |
  //     H_MAX_ELEMENTS_KEYWORD    |
  //     H_MIN_ELEMENTS_KEYWORD    |
  //     H_MODULE_KEYWORD          |
  //     H_MUST_KEYWORD            |
  //     H_NAMESPACE_KEYWORD       |
  //     H_NOTIFICATION_KEYWORD    |
  //     H_ORDERED_BY_KEYWORD      |
  //     H_ORGANIZATION_KEYWORD    |
  //     H_OUTPUT_KEYWORD          |
  //     H_PATH_KEYWORD            |
  //     H_PATTERN_KEYWORD         |
  //     H_POSITION_KEYWORD        |
  //     H_PREFIX_KEYWORD          |
  //     H_PRESENCE_KEYWORD        |
  //     H_RANGE_KEYWORD           |
  //     H_REFERENCE_KEYWORD       |
  //     H_REFINE_KEYWORD          |
  //     H_REQUIRE_INSTANCE_KEYWORD|
  //     H_REVISION_KEYWORD        |
  //     H_REVISION_DATE_KEYWORD   |
  //     H_RPC_KEYWORD             |
  //     H_STATUS_KEYWORD          |
  //     H_SUBMODULE_KEYWORD       |
  //     H_TYPE_KEYWORD            |
  //     H_TYPEDEF_KEYWORD         |
  //     H_UNIQUE_KEYWORD          |
  //     H_UNITS_KEYWORD           |
  //     H_USES_KEYWORD            |
  //     H_VALUE_KEYWORD           |
  //     H_WHEN_KEYWORD            |
  //     H_YANG_VERSION_KEYWORD    |
  //     H_YIN_ELEMENT_KEYWORD     |
  //     // other keywords
  //     H_CURRENT_KEYWORD         |
  //     H_DELETE_KEYWORD          |
  //     H_DEPRECATED_KEYWORD      |
  //     H_FALSE_KEYWORD           |
  //     H_ADD_KEYWORD             |
  //     H_MAX_KEYWORD             |
  //     H_MIN_KEYWORD             |
  //     H_NOT_SUPPORTED_KEYWORD   |
  //     H_OBSOLETE_KEYWORD        |
  //     H_REPLACE_KEYWORD         |
  //     H_SYSTEM_KEYWORD          |
  //     H_TRUE_KEYWORD            |
  //     H_UNBOUNDED_KEYWORD       |
  //     H_USER_KEYWORD            |
  //     H_SEMICOLON               |
  //     H_OPERATORS               |
  //     H_LEFT_BRACE              |
  //     H_RIGHT_BRACE             |
  //     H_INVALID_ESCAPE          |
  //     H_VALID_ESCAPE
  public static boolean h_identifier_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h_identifier_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_H_IDENTIFIER_LITERAL, "<h identifier literal>");
    r = consumeToken(b, YANG_H_ANYXML_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ARGUMENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_AUGMENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_BASE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_BELONGS_TO_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_BIT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_CASE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_CHOICE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_CONFIG_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_CONTACT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_CONTAINER_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_DEFAULT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_DESCRIPTION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ENUM_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ERROR_APP_TAG_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ERROR_MESSAGE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_EXTENSION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_DEVIATION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_DEVIATE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_FEATURE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_FRACTION_DIGITS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_GROUPING_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_IDENTITY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_IF_FEATURE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_IMPORT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_INCLUDE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_INPUT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_KEY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_LEAF_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_LEAF_LIST_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_LENGTH_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_LIST_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MANDATORY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MAX_ELEMENTS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MIN_ELEMENTS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MODULE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MUST_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_NAMESPACE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_NOTIFICATION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ORDERED_BY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ORGANIZATION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_OUTPUT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_PATH_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_PATTERN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_POSITION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_PREFIX_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_PRESENCE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_RANGE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_REFERENCE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_REFINE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_REQUIRE_INSTANCE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_REVISION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_REVISION_DATE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_RPC_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_STATUS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_SUBMODULE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_TYPE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_TYPEDEF_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_UNIQUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_UNITS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_USES_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_VALUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_WHEN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_YANG_VERSION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_YIN_ELEMENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_CURRENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_DELETE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_DEPRECATED_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_FALSE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_ADD_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MAX_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_MIN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_NOT_SUPPORTED_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_OBSOLETE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_REPLACE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_SYSTEM_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_TRUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_UNBOUNDED_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_USER_KEYWORD);
    if (!r) r = consumeToken(b, YANG_H_SEMICOLON);
    if (!r) r = consumeToken(b, YANG_H_OPERATORS);
    if (!r) r = consumeToken(b, YANG_H_LEFT_BRACE);
    if (!r) r = consumeToken(b, YANG_H_RIGHT_BRACE);
    if (!r) r = consumeToken(b, YANG_H_INVALID_ESCAPE);
    if (!r) r = consumeToken(b, YANG_H_VALID_ESCAPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // H_WHITE_SPACE+
  public static boolean wsp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsp")) return false;
    if (!nextTokenIs(b, YANG_H_WHITE_SPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_H_WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, YANG_H_WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "wsp", c)) break;
    }
    exit_section_(b, m, YANG_WSP, r);
    return r;
  }

  /* ********************************************************** */
  // h-any-token (wsp h-any-token)*
  static boolean yang(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h_any_token(b, l + 1);
    r = r && yang_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (wsp h-any-token)*
  private static boolean yang_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!yang_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "yang_1", c)) break;
    }
    return true;
  }

  // wsp h-any-token
  private static boolean yang_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsp(b, l + 1);
    r = r && h_any_token(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
