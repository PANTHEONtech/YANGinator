// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static com.intellij.lang.parser.GeneratedParserUtilBase.TRUE_CONDITION;
import static com.intellij.lang.parser.GeneratedParserUtilBase._AND_;
import static com.intellij.lang.parser.GeneratedParserUtilBase._COLLAPSE_;
import static com.intellij.lang.parser.GeneratedParserUtilBase._NONE_;
import static com.intellij.lang.parser.GeneratedParserUtilBase._NOT_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.adapt_builder_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.consumeToken;
import static com.intellij.lang.parser.GeneratedParserUtilBase.create_token_set_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.current_position_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.empty_element_parsed_guard_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.enter_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.eof;
import static com.intellij.lang.parser.GeneratedParserUtilBase.exit_section_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.nextTokenIs;
import static com.intellij.lang.parser.GeneratedParserUtilBase.recursion_guard_;
import static com.intellij.lang.parser.GeneratedParserUtilBase.report_error_;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class YangParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
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

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(YANG_ANYXML_STMT, YANG_ARGUMENT_STMT, YANG_AUGMENT_STMT, YANG_BELONGS_TO_STMT,
      YANG_BIT_STMT, YANG_CASE_STMT, YANG_CHOICE_STMT, YANG_CONFIG_STMT,
      YANG_CONTACT_STMT, YANG_CONTAINER_STMT, YANG_DATA_DEF_STMT, YANG_DEFAULT_STMT,
      YANG_DESCRIPTION_STMT, YANG_DEVIATE_ADD_STMT, YANG_DEVIATE_DELETE_STMT, YANG_DEVIATE_NOT_SUPPORTED_STMT,
      YANG_DEVIATE_REPLACE_STMT, YANG_DEVIATION_STMT, YANG_ENUM_STMT, YANG_ERROR_APP_TAG_STMT,
      YANG_ERROR_MESSAGE_STMT, YANG_EXTENSION_STMT, YANG_FEATURE_STMT, YANG_FRACTION_DIGITS_STMT,
      YANG_IF_FEATURE_STMT, YANG_IMPORT_STMT, YANG_INCLUDE_STMT, YANG_INPUT_STMT,
      YANG_KEY_STMT, YANG_LEAF_LIST_STMT, YANG_LEAF_STMT, YANG_LENGTH_STMT,
      YANG_LIST_STMT, YANG_MANDATORY_STMT, YANG_MAX_ELEMENTS_STMT, YANG_MIN_ELEMENTS_STMT,
      YANG_MODULE_STMT, YANG_MUST_STMT, YANG_NAMESPACE_STMT, YANG_NOTIFICATION_STMT,
      YANG_ORDERED_BY_STMT, YANG_ORGANIZATION_STMT, YANG_OUTPUT_STMT, YANG_PATH_STMT,
      YANG_PATTERN_STMT, YANG_POSITION_STMT, YANG_PREFIX_STMT, YANG_PRESENCE_STMT,
      YANG_RANGE_STMT, YANG_REFERENCE_STMT, YANG_REFINE_STMT, YANG_REQUIRE_INSTANCE_STMT,
      YANG_REVISION_DATE_STMT, YANG_REVISION_STMT, YANG_RPC_STMT, YANG_SHORT_CASE_STMT,
      YANG_STATEMENT, YANG_STATUS_STMT, YANG_SUBMODULE_STMT, YANG_UNIQUE_STMT,
      YANG_UNITS_STMT, YANG_USES_AUGMENT_STMT, YANG_VALUE_STMT, YANG_WHEN_STMT,
      YANG_YANG_VERSION_STMT, YANG_YIN_ELEMENT_STMT),
  };

  /* ********************************************************** */
  // comment? CARRIAGE_RETURN comment?
  static boolean CR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CR")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CR_0(b, l + 1);
    r = r && consumeToken(b, YANG_CARRIAGE_RETURN);
    r = r && CR_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comment?
  private static boolean CR_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CR_0")) return false;
    comment(b, l + 1);
    return true;
  }

  // comment?
  private static boolean CR_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CR_2")) return false;
    comment(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CR LF
  static boolean CRLF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CRLF")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CR(b, l + 1);
    r = r && LF(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // POSITIVE_NUMBER | ZERO
  public static boolean DIGIT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DIGIT")) return false;
    if (!nextTokenIs(b, "<digit>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DIGIT, "<digit>");
    r = consumeToken(b, YANG_POSITIVE_NUMBER);
    if (!r) r = consumeToken(b, YANG_ZERO);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DIGIT | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
  public static boolean HEXDIG(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HEXDIG")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_HEXDIG, "<hexdig>");
    r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, "a");
    if (!r) r = consumeToken(b, "b");
    if (!r) r = consumeToken(b, "c");
    if (!r) r = consumeToken(b, "d");
    if (!r) r = consumeToken(b, "e");
    if (!r) r = consumeToken(b, "f");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (SP SP SP SP) | TAB
  static boolean HTAB(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HTAB")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = HTAB_0(b, l + 1);
    if (!r) r = consumeToken(b, YANG_TAB);
    exit_section_(b, m, null, r);
    return r;
  }

  // SP SP SP SP
  private static boolean HTAB_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HTAB_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SP(b, l + 1);
    r = r && SP(b, l + 1);
    r = r && SP(b, l + 1);
    r = r && SP(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPEN_BRACKET ( IPv6address | IPvFuture ) CLOSED_BRACKET
  public static boolean IP_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IP_literal")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && IP_literal_1(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    exit_section_(b, m, YANG_IP_LITERAL, r);
    return r;
  }

  // IPv6address | IPvFuture
  private static boolean IP_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IP_literal_1")) return false;
    boolean r;
    r = IPv6address(b, l + 1);
    if (!r) r = IPvFuture(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // dec-octet DOT dec-octet DOT dec-octet DOT dec-octet
  public static boolean IPv4address(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv4address")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_I_PV_4_ADDRESS, "<i pv 4 address>");
    r = dec_octet(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && dec_octet(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && dec_octet(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && dec_octet(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  // |                                                                                              "::" ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  // | (                                                                                     h16 )? "::" ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  // | ( ( h16 ":" ) ?                                                                       h16 )? "::" ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  // | ( ( h16 ":" ) ? ( h16 ":" ) ?                                                         h16 )? "::" ( h16 ":" ) ( h16 ":" ) ls32
  // | ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                                           h16 )? "::" ( h16 ":" )  ls32
  // | ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                             h16 )? "::"              ls32
  // | ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?               h16 )? "::"              h16
  // | ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? h16 )? "::"
  public static boolean IPv6address(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_I_PV_6_ADDRESS, "<i pv 6 address>");
    r = IPv6address_0(b, l + 1);
    if (!r) r = IPv6address_1(b, l + 1);
    if (!r) r = IPv6address_2(b, l + 1);
    if (!r) r = IPv6address_3(b, l + 1);
    if (!r) r = IPv6address_4(b, l + 1);
    if (!r) r = IPv6address_5(b, l + 1);
    if (!r) r = IPv6address_6(b, l + 1);
    if (!r) r = IPv6address_7(b, l + 1);
    if (!r) r = IPv6address_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  private static boolean IPv6address_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_0_0(b, l + 1);
    r = r && IPv6address_0_1(b, l + 1);
    r = r && IPv6address_0_2(b, l + 1);
    r = r && IPv6address_0_3(b, l + 1);
    r = r && IPv6address_0_4(b, l + 1);
    r = r && IPv6address_0_5(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // "::" ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  private static boolean IPv6address_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "::");
    r = r && IPv6address_1_1(b, l + 1);
    r = r && IPv6address_1_2(b, l + 1);
    r = r && IPv6address_1_3(b, l + 1);
    r = r && IPv6address_1_4(b, l + 1);
    r = r && IPv6address_1_5(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_1_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_1_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_1_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // (                                                                                     h16 )? "::" ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  private static boolean IPv6address_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_2_0(b, l + 1);
    r = r && consumeToken(b, "::");
    r = r && IPv6address_2_2(b, l + 1);
    r = r && IPv6address_2_3(b, l + 1);
    r = r && IPv6address_2_4(b, l + 1);
    r = r && IPv6address_2_5(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (                                                                                     h16 )?
  private static boolean IPv6address_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_0")) return false;
    IPv6address_2_0_0(b, l + 1);
    return true;
  }

  // (                                                                                     h16 )
  private static boolean IPv6address_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_2_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_2_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ?                                                                       h16 )? "::" ( h16 ":" ) ( h16 ":" ) ( h16 ":" ) ls32
  private static boolean IPv6address_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_3_0(b, l + 1);
    r = r && consumeToken(b, "::");
    r = r && IPv6address_3_2(b, l + 1);
    r = r && IPv6address_3_3(b, l + 1);
    r = r && IPv6address_3_4(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ?                                                                       h16 )?
  private static boolean IPv6address_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0")) return false;
    IPv6address_3_0_0(b, l + 1);
    return true;
  }

  // ( h16 ":" ) ?                                                                       h16
  private static boolean IPv6address_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_3_0_0_0(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0_0_0")) return false;
    IPv6address_3_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_3_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_3_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_3_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ?                                                         h16 )? "::" ( h16 ":" ) ( h16 ":" ) ls32
  private static boolean IPv6address_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_4_0(b, l + 1);
    r = r && consumeToken(b, "::");
    r = r && IPv6address_4_2(b, l + 1);
    r = r && IPv6address_4_3(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ?                                                         h16 )?
  private static boolean IPv6address_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0")) return false;
    IPv6address_4_0_0(b, l + 1);
    return true;
  }

  // ( h16 ":" ) ? ( h16 ":" ) ?                                                         h16
  private static boolean IPv6address_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_4_0_0_0(b, l + 1);
    r = r && IPv6address_4_0_0_1(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_4_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_0")) return false;
    IPv6address_4_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_4_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_4_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_1")) return false;
    IPv6address_4_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_4_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_4_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_4_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                                           h16 )? "::" ( h16 ":" )  ls32
  private static boolean IPv6address_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_5_0(b, l + 1);
    r = r && consumeToken(b, "::");
    r = r && IPv6address_5_2(b, l + 1);
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                                           h16 )?
  private static boolean IPv6address_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0")) return false;
    IPv6address_5_0_0(b, l + 1);
    return true;
  }

  // ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                                           h16
  private static boolean IPv6address_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_5_0_0_0(b, l + 1);
    r = r && IPv6address_5_0_0_1(b, l + 1);
    r = r && IPv6address_5_0_0_2(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_5_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_0")) return false;
    IPv6address_5_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_5_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_5_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_1")) return false;
    IPv6address_5_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_5_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_5_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_2")) return false;
    IPv6address_5_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_5_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // h16 ":"
  private static boolean IPv6address_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_5_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                             h16 )? "::"              ls32
  private static boolean IPv6address_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_6_0(b, l + 1);
    r = r && consumeToken(b, "::");
    r = r && ls32(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                             h16 )?
  private static boolean IPv6address_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0")) return false;
    IPv6address_6_0_0(b, l + 1);
    return true;
  }

  // ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?                             h16
  private static boolean IPv6address_6_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_6_0_0_0(b, l + 1);
    r = r && IPv6address_6_0_0_1(b, l + 1);
    r = r && IPv6address_6_0_0_2(b, l + 1);
    r = r && IPv6address_6_0_0_3(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_6_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_0")) return false;
    IPv6address_6_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_6_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_6_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_1")) return false;
    IPv6address_6_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_6_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_6_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_2")) return false;
    IPv6address_6_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_6_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_6_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_3")) return false;
    IPv6address_6_0_0_3_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_6_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_6_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?               h16 )? "::"              h16
  private static boolean IPv6address_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_7_0(b, l + 1);
    r = r && consumeToken(b, "::");
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?               h16 )?
  private static boolean IPv6address_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0")) return false;
    IPv6address_7_0_0(b, l + 1);
    return true;
  }

  // ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ?               h16
  private static boolean IPv6address_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_7_0_0_0(b, l + 1);
    r = r && IPv6address_7_0_0_1(b, l + 1);
    r = r && IPv6address_7_0_0_2(b, l + 1);
    r = r && IPv6address_7_0_0_3(b, l + 1);
    r = r && IPv6address_7_0_0_4(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_7_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_0")) return false;
    IPv6address_7_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_7_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_7_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_1")) return false;
    IPv6address_7_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_7_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_7_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_2")) return false;
    IPv6address_7_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_7_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_7_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_3")) return false;
    IPv6address_7_0_0_3_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_7_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_7_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_4")) return false;
    IPv6address_7_0_0_4_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_7_0_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_7_0_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? h16 )? "::"
  private static boolean IPv6address_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_8_0(b, l + 1);
    r = r && consumeToken(b, "::");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? h16 )?
  private static boolean IPv6address_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0")) return false;
    IPv6address_8_0_0(b, l + 1);
    return true;
  }

  // ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? ( h16 ":" ) ? h16
  private static boolean IPv6address_8_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPv6address_8_0_0_0(b, l + 1);
    r = r && IPv6address_8_0_0_1(b, l + 1);
    r = r && IPv6address_8_0_0_2(b, l + 1);
    r = r && IPv6address_8_0_0_3(b, l + 1);
    r = r && IPv6address_8_0_0_4(b, l + 1);
    r = r && IPv6address_8_0_0_5(b, l + 1);
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_8_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_0")) return false;
    IPv6address_8_0_0_0_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_8_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_8_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_1")) return false;
    IPv6address_8_0_0_1_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_8_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_8_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_2")) return false;
    IPv6address_8_0_0_2_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_8_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_8_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_3")) return false;
    IPv6address_8_0_0_3_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_8_0_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_8_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_4")) return false;
    IPv6address_8_0_0_4_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_8_0_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( h16 ":" ) ?
  private static boolean IPv6address_8_0_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_5")) return false;
    IPv6address_8_0_0_5_0(b, l + 1);
    return true;
  }

  // h16 ":"
  private static boolean IPv6address_8_0_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPv6address_8_0_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "v" HEXDIG + DOT ( unreserved | sub-delims | COLON ) +
  public static boolean IPvFuture(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_I_PV_FUTURE, "<i pv future>");
    r = consumeToken(b, "v");
    r = r && IPvFuture_1(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && IPvFuture_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HEXDIG +
  private static boolean IPvFuture_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = HEXDIG(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!HEXDIG(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IPvFuture_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ( unreserved | sub-delims | COLON ) +
  private static boolean IPvFuture_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IPvFuture_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!IPvFuture_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IPvFuture_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // unreserved | sub-delims | COLON
  private static boolean IPvFuture_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IPvFuture_3_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_COLON);
    return r;
  }

  /* ********************************************************** */
  // LINEFEED | LINE_COMMENT
  static boolean LF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LF")) return false;
    if (!nextTokenIs(b, "", YANG_LINEFEED, YANG_SINGLE_LINE_COMMENT_START)) return false;
    boolean r;
    r = consumeToken(b, YANG_LINEFEED);
    if (!r) r = LINE_COMMENT(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SINGLE_LINE_COMMENT_START ( single-line-characters )* new-line-characters?
  public static boolean LINE_COMMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINE_COMMENT")) return false;
    if (!nextTokenIs(b, YANG_SINGLE_LINE_COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    r = r && LINE_COMMENT_1(b, l + 1);
    r = r && LINE_COMMENT_2(b, l + 1);
    exit_section_(b, m, YANG_LINE_COMMENT, r);
    return r;
  }

  // ( single-line-characters )*
  private static boolean LINE_COMMENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINE_COMMENT_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LINE_COMMENT_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LINE_COMMENT_1", c)) break;
    }
    return true;
  }

  // ( single-line-characters )
  private static boolean LINE_COMMENT_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINE_COMMENT_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = single_line_characters(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // new-line-characters?
  private static boolean LINE_COMMENT_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINE_COMMENT_2")) return false;
    new_line_characters(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SINGLE_QUOTE sep? "+" sep? SINGLE_QUOTE
  public static boolean SINGLE_QUOTE_STRING_SPLITTER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_QUOTE_STRING_SPLITTER")) return false;
    if (!nextTokenIs(b, YANG_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SINGLE_QUOTE);
    r = r && SINGLE_QUOTE_STRING_SPLITTER_1(b, l + 1);
    r = r && consumeToken(b, "+");
    r = r && SINGLE_QUOTE_STRING_SPLITTER_3(b, l + 1);
    r = r && consumeToken(b, YANG_SINGLE_QUOTE);
    exit_section_(b, m, YANG_SINGLE_QUOTE_STRING_SPLITTER, r);
    return r;
  }

  // sep?
  private static boolean SINGLE_QUOTE_STRING_SPLITTER_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_QUOTE_STRING_SPLITTER_1")) return false;
    sep(b, l + 1);
    return true;
  }

  // sep?
  private static boolean SINGLE_QUOTE_STRING_SPLITTER_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_QUOTE_STRING_SPLITTER_3")) return false;
    sep(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT? SPACE BLOCK_COMMENT?
  static boolean SP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SP")) return false;
    if (!nextTokenIs(b, "", YANG_BLOCK_COMMENT, YANG_SPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SP_0(b, l + 1);
    r = r && consumeToken(b, YANG_SPACE);
    r = r && SP_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BLOCK_COMMENT?
  private static boolean SP_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SP_0")) return false;
    consumeToken(b, YANG_BLOCK_COMMENT);
    return true;
  }

  // BLOCK_COMMENT?
  private static boolean SP_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SP_2")) return false;
    consumeToken(b, YANG_BLOCK_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE sep? "+" sep? DOUBLE_QUOTE
  public static boolean STRING_SPLITTER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STRING_SPLITTER")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && STRING_SPLITTER_1(b, l + 1);
    r = r && consumeToken(b, "+");
    r = r && STRING_SPLITTER_3(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_STRING_SPLITTER, r);
    return r;
  }

  // sep?
  private static boolean STRING_SPLITTER_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STRING_SPLITTER_1")) return false;
    sep(b, l + 1);
    return true;
  }

  // sep?
  private static boolean STRING_SPLITTER_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STRING_SPLITTER_3")) return false;
    sep(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // deviate-replace-stmt
  //   | deviate-delete-stmt
  //   | deviate-add-stmt
  //   | deviate-not-supported-stmt
  //   | deviation-stmt
  //   | notification-stmt
  //   | output-stmt
  //   | input-stmt
  //   | rpc-stmt
  //   | when-stmt
  //   | augment-stmt
  //   | uses-augment-stmt
  //   | refine-stmt
  //   | uses-stmt
  //   | anyxml-stmt
  //   | case-stmt
  //   | short-case-stmt
  //   | choice-stmt
  //   | unique-stmt
  //   | key-stmt
  //   | list-stmt
  //   | leaf-list-stmt
  //   | leaf-stmt
  //   | container-stmt
  //   | grouping-stmt
  //   | value-stmt
  //   | max-elements-stmt
  //   | min-elements-stmt
  //   | error-app-tag-stmt
  //   | error-message-stmt
  //   | must-stmt
  //   | ordered-by-stmt
  //   | presence-stmt
  //   | mandatory-stmt
  //   | config-stmt
  //   | status-stmt
  //   | position-stmt
  //   | bit-stmt
  //   | require-instance-stmt
  //   | path-stmt
  //   | enum-stmt
  //   | default-stmt
  //   | pattern-stmt
  //   | length-stmt
  //   | fraction-digits-stmt
  //   | range-stmt
  //   | type-stmt
  //   | typedef-stmt
  //   | if-feature-stmt
  //   | feature-stmt
  //   | base-stmt
  //   | identity-stmt
  //   | yin-element-stmt
  //   | argument-stmt
  //   | extension-stmt
  //   | revision-date-stmt
  //   | revision-stmt
  //   | units-stmt
  //   | reference-stmt
  //   | description-stmt
  //   | contact-stmt
  //   | organization-stmt
  //   | belongs-to-stmt
  //   | prefix-stmt
  //   | namespace-stmt
  //   | include-stmt
  //   | import-stmt
  //   | yang-version-stmt
  //   | unknown-statement
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, YANG_STATEMENT, "<statement>");
    r = deviate_replace_stmt(b, l + 1);
    if (!r) r = deviate_delete_stmt(b, l + 1);
    if (!r) r = deviate_add_stmt(b, l + 1);
    if (!r) r = deviate_not_supported_stmt(b, l + 1);
    if (!r) r = deviation_stmt(b, l + 1);
    if (!r) r = notification_stmt(b, l + 1);
    if (!r) r = output_stmt(b, l + 1);
    if (!r) r = input_stmt(b, l + 1);
    if (!r) r = rpc_stmt(b, l + 1);
    if (!r) r = when_stmt(b, l + 1);
    if (!r) r = augment_stmt(b, l + 1);
    if (!r) r = uses_augment_stmt(b, l + 1);
    if (!r) r = refine_stmt(b, l + 1);
    if (!r) r = uses_stmt(b, l + 1);
    if (!r) r = anyxml_stmt(b, l + 1);
    if (!r) r = case_stmt(b, l + 1);
    if (!r) r = short_case_stmt(b, l + 1);
    if (!r) r = choice_stmt(b, l + 1);
    if (!r) r = unique_stmt(b, l + 1);
    if (!r) r = key_stmt(b, l + 1);
    if (!r) r = list_stmt(b, l + 1);
    if (!r) r = leaf_list_stmt(b, l + 1);
    if (!r) r = leaf_stmt(b, l + 1);
    if (!r) r = container_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    if (!r) r = value_stmt(b, l + 1);
    if (!r) r = max_elements_stmt(b, l + 1);
    if (!r) r = min_elements_stmt(b, l + 1);
    if (!r) r = error_app_tag_stmt(b, l + 1);
    if (!r) r = error_message_stmt(b, l + 1);
    if (!r) r = must_stmt(b, l + 1);
    if (!r) r = ordered_by_stmt(b, l + 1);
    if (!r) r = presence_stmt(b, l + 1);
    if (!r) r = mandatory_stmt(b, l + 1);
    if (!r) r = config_stmt(b, l + 1);
    if (!r) r = status_stmt(b, l + 1);
    if (!r) r = position_stmt(b, l + 1);
    if (!r) r = bit_stmt(b, l + 1);
    if (!r) r = require_instance_stmt(b, l + 1);
    if (!r) r = path_stmt(b, l + 1);
    if (!r) r = enum_stmt(b, l + 1);
    if (!r) r = default_stmt(b, l + 1);
    if (!r) r = pattern_stmt(b, l + 1);
    if (!r) r = length_stmt(b, l + 1);
    if (!r) r = fraction_digits_stmt(b, l + 1);
    if (!r) r = range_stmt(b, l + 1);
    if (!r) r = type_stmt(b, l + 1);
    if (!r) r = typedef_stmt(b, l + 1);
    if (!r) r = if_feature_stmt(b, l + 1);
    if (!r) r = feature_stmt(b, l + 1);
    if (!r) r = base_stmt(b, l + 1);
    if (!r) r = identity_stmt(b, l + 1);
    if (!r) r = yin_element_stmt(b, l + 1);
    if (!r) r = argument_stmt(b, l + 1);
    if (!r) r = extension_stmt(b, l + 1);
    if (!r) r = revision_date_stmt(b, l + 1);
    if (!r) r = revision_stmt(b, l + 1);
    if (!r) r = units_stmt(b, l + 1);
    if (!r) r = reference_stmt(b, l + 1);
    if (!r) r = description_stmt(b, l + 1);
    if (!r) r = contact_stmt(b, l + 1);
    if (!r) r = organization_stmt(b, l + 1);
    if (!r) r = belongs_to_stmt(b, l + 1);
    if (!r) r = prefix_stmt(b, l + 1);
    if (!r) r = namespace_stmt(b, l + 1);
    if (!r) r = include_stmt(b, l + 1);
    if (!r) r = import_stmt(b, l + 1);
    if (!r) r = yang_version_stmt(b, l + 1);
    if (!r) r = unknown_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Statement (';'|&'}')
  static boolean StatementWithSemi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Statement(b, l + 1);
    p = r; // pin = 1
    r = r && StatementWithSemi_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ';'|&'}'
  private static boolean StatementWithSemi_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ";");
    if (!r) r = StatementWithSemi_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean StatementWithSemi_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // StatementWithSemi*
  static boolean Statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StatementWithSemi(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Statements", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // scheme COLON hier-part ( "?" query ) ? ( "#" fragment ) ?
  public static boolean URI(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI")) return false;
    if (!nextTokenIs(b, YANG_ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = scheme(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && hier_part(b, l + 1);
    r = r && URI_3(b, l + 1);
    r = r && URI_4(b, l + 1);
    exit_section_(b, m, YANG_URI, r);
    return r;
  }

  // ( "?" query ) ?
  private static boolean URI_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_3")) return false;
    URI_3_0(b, l + 1);
    return true;
  }

  // "?" query
  private static boolean URI_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?");
    r = r && query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( "#" fragment ) ?
  private static boolean URI_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_4")) return false;
    URI_4_0(b, l + 1);
    return true;
  }

  // "#" fragment
  private static boolean URI_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "URI_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "#");
    r = r && fragment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OTHER_CHARACTER | SINGLE_LINE_COMMENT_START
  //  | DIGIT  | ALPHA | POSITIVE_NUMBER |  ASTERISK
  //  | SEMICOLON | COLON | LEFT_BRACE | RIGHT_BRACE | DOT | DOUBLE_DOT | DASH | UNDERSCORE
  //  | LEFT_PARENTHESIS | RIGHT_PARENTHESIS | EQUAL | OPEN_BRACKET | CLOSED_BRACKET | FORWARD_SLASH | BACK_SLASH | PIPE
  public static boolean VCHAR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VCHAR")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_VCHAR, "<vchar>");
    r = consumeToken(b, YANG_OTHER_CHARACTER);
    if (!r) r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_ALPHA);
    if (!r) r = consumeToken(b, YANG_POSITIVE_NUMBER);
    if (!r) r = consumeToken(b, YANG_ASTERISK);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = consumeToken(b, YANG_COLON);
    if (!r) r = consumeToken(b, YANG_LEFT_BRACE);
    if (!r) r = consumeToken(b, YANG_RIGHT_BRACE);
    if (!r) r = consumeToken(b, YANG_DOT);
    if (!r) r = consumeToken(b, YANG_DOUBLE_DOT);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = consumeToken(b, YANG_LEFT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_RIGHT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_EQUAL);
    if (!r) r = consumeToken(b, YANG_OPEN_BRACKET);
    if (!r) r = consumeToken(b, YANG_CLOSED_BRACKET);
    if (!r) r = consumeToken(b, YANG_FORWARD_SLASH);
    if (!r) r = consumeToken(b, YANG_BACK_SLASH);
    if (!r) r = consumeToken(b, YANG_PIPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT? (SP | HTAB) BLOCK_COMMENT?
  static boolean WSP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WSP")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP_0(b, l + 1);
    r = r && WSP_1(b, l + 1);
    r = r && WSP_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BLOCK_COMMENT?
  private static boolean WSP_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WSP_0")) return false;
    consumeToken(b, YANG_BLOCK_COMMENT);
    return true;
  }

  // SP | HTAB
  private static boolean WSP_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WSP_1")) return false;
    boolean r;
    r = SP(b, l + 1);
    if (!r) r = HTAB(b, l + 1);
    return r;
  }

  // BLOCK_COMMENT?
  private static boolean WSP_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WSP_2")) return false;
    consumeToken(b, YANG_BLOCK_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // ( FORWARD_SLASH ( node-identifier path-predicate * ) ) +
  public static boolean absolute_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_path_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!absolute_path_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_path", c)) break;
    }
    exit_section_(b, m, YANG_ABSOLUTE_PATH, r);
    return r;
  }

  // FORWARD_SLASH ( node-identifier path-predicate * )
  private static boolean absolute_path_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && absolute_path_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-identifier path-predicate *
  private static boolean absolute_path_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier(b, l + 1);
    r = r && absolute_path_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // path-predicate *
  private static boolean absolute_path_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_path_0_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_predicate(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_path_0_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (FORWARD_SLASH node-identifier )+
  public static boolean absolute_schema_nodeid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!absolute_schema_nodeid_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_schema_nodeid", c)) break;
    }
    exit_section_(b, m, YANG_ABSOLUTE_SCHEMA_NODEID, r);
    return r;
  }

  // FORWARD_SLASH node-identifier
  private static boolean absolute_schema_nodeid_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && node_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( STRING_SPLITTER? FORWARD_SLASH STRING_SPLITTER?  node-identifier-quoted STRING_SPLITTER?) +
  public static boolean absolute_schema_nodeid_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_quoted")) return false;
    if (!nextTokenIs(b, "<absolute schema nodeid quoted>", YANG_DOUBLE_QUOTE, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ABSOLUTE_SCHEMA_NODEID_QUOTED, "<absolute schema nodeid quoted>");
    r = absolute_schema_nodeid_quoted_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!absolute_schema_nodeid_quoted_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "absolute_schema_nodeid_quoted", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_SPLITTER? FORWARD_SLASH STRING_SPLITTER?  node-identifier-quoted STRING_SPLITTER?
  private static boolean absolute_schema_nodeid_quoted_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_quoted_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid_quoted_0_0(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && absolute_schema_nodeid_quoted_0_2(b, l + 1);
    r = r && node_identifier_quoted(b, l + 1);
    r = r && absolute_schema_nodeid_quoted_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean absolute_schema_nodeid_quoted_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_quoted_0_0")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean absolute_schema_nodeid_quoted_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_quoted_0_2")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean absolute_schema_nodeid_quoted_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "absolute_schema_nodeid_quoted_0_4")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ANYXML_KEYWORD sep identifier-arg-quoted optsep
  //  ( anyxml-sub-stmt | SEMICOLON )
  public static boolean anyxml_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt")) return false;
    if (!nextTokenIs(b, YANG_ANYXML_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ANYXML_STMT, null);
    r = consumeToken(b, YANG_ANYXML_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && anyxml_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // anyxml-sub-stmt | SEMICOLON
  private static boolean anyxml_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_4")) return false;
    boolean r;
    r = anyxml_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( must-stmt stmtsep ) | // *
  //  ( config-stmt stmtsep ) | // ?
  //  ( mandatory-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean anyxml_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ANYXML_STMT_BODY, "<anyxml stmt body>");
    r = anyxml_stmt_body_0(b, l + 1);
    if (!r) r = anyxml_stmt_body_1(b, l + 1);
    if (!r) r = anyxml_stmt_body_2(b, l + 1);
    if (!r) r = anyxml_stmt_body_3(b, l + 1);
    if (!r) r = anyxml_stmt_body_4(b, l + 1);
    if (!r) r = anyxml_stmt_body_5(b, l + 1);
    if (!r) r = anyxml_stmt_body_6(b, l + 1);
    if (!r) r = anyxml_stmt_body_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean anyxml_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean anyxml_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // must-stmt stmtsep
  private static boolean anyxml_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean anyxml_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mandatory-stmt stmtsep
  private static boolean anyxml_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean anyxml_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean anyxml_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean anyxml_stmt_body_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_stmt_body_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                         anyxml-stmt-body *
  //                         RIGHT_BRACE
  static boolean anyxml_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, anyxml_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // anyxml-stmt-body *
  private static boolean anyxml_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyxml_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!anyxml_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "anyxml_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ARGUMENT_KEYWORD sep identifier-arg-quoted optsep
  //  ( argument-sub-stmt | SEMICOLON )
  public static boolean argument_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_stmt")) return false;
    if (!nextTokenIs(b, YANG_ARGUMENT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ARGUMENT_STMT, null);
    r = consumeToken(b, YANG_ARGUMENT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && argument_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // argument-sub-stmt | SEMICOLON
  private static boolean argument_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_stmt_4")) return false;
    boolean r;
    r = argument_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                       ( yin-element-stmt stmtsep ) ?
  //                       RIGHT_BRACE
  static boolean argument_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, argument_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( yin-element-stmt stmtsep ) ?
  private static boolean argument_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_sub_stmt_2")) return false;
    argument_sub_stmt_2_0(b, l + 1);
    return true;
  }

  // yin-element-stmt stmtsep
  private static boolean argument_sub_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_sub_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = yin_element_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid
  public static boolean augment_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_arg")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid(b, l + 1);
    exit_section_(b, m, YANG_AUGMENT_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid-quoted
  public static boolean augment_arg_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_arg_quoted")) return false;
    if (!nextTokenIs(b, "<augment arg quoted>", YANG_DOUBLE_QUOTE, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUGMENT_ARG_QUOTED, "<augment arg quoted>");
    r = absolute_schema_nodeid_quoted(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // augment-arg | ( DOUBLE_QUOTE augment-arg-quoted DOUBLE_QUOTE )
  public static boolean augment_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_arg_str")) return false;
    if (!nextTokenIs(b, "<augment arg str>", YANG_DOUBLE_QUOTE, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUGMENT_ARG_STR, "<augment arg str>");
    r = augment_arg(b, l + 1);
    if (!r) r = augment_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE augment-arg-quoted DOUBLE_QUOTE
  private static boolean augment_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && augment_arg_quoted(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AUGMENT_KEYWORD sep augment-arg-str optsep
  //  LEFT_BRACE stmtsep
  //  augment-stmt-body +
  //  RIGHT_BRACE
  public static boolean augment_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt")) return false;
    if (!nextTokenIs(b, YANG_AUGMENT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUGMENT_STMT, null);
    r = consumeToken(b, YANG_AUGMENT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, augment_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, augment_stmt_6(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // augment-stmt-body +
  private static boolean augment_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = augment_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!augment_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "augment_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( data-def-stmt stmtsep ) |
  //  ( case-stmt stmtsep ) )
  public static boolean augment_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUGMENT_STMT_BODY, "<augment stmt body>");
    r = augment_stmt_body_0(b, l + 1);
    if (!r) r = augment_stmt_body_1(b, l + 1);
    if (!r) r = augment_stmt_body_2(b, l + 1);
    if (!r) r = augment_stmt_body_3(b, l + 1);
    if (!r) r = augment_stmt_body_4(b, l + 1);
    if (!r) r = augment_stmt_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean augment_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean augment_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean augment_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean augment_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean augment_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( data-def-stmt stmtsep ) |
  //  ( case-stmt stmtsep )
  private static boolean augment_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = augment_stmt_body_5_0(b, l + 1);
    if (!r) r = augment_stmt_body_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean augment_stmt_body_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // case-stmt stmtsep
  private static boolean augment_stmt_body_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "augment_stmt_body_5_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( userinfo "@" ) ? host ( COLON port ) ?
  public static boolean authority(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_AUTHORITY, "<authority>");
    r = authority_0(b, l + 1);
    r = r && host(b, l + 1);
    r = r && authority_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( userinfo "@" ) ?
  private static boolean authority_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_0")) return false;
    authority_0_0(b, l + 1);
    return true;
  }

  // userinfo "@"
  private static boolean authority_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = userinfo(b, l + 1);
    r = r && consumeToken(b, "@");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COLON port ) ?
  private static boolean authority_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_2")) return false;
    authority_2_0(b, l + 1);
    return true;
  }

  // COLON port
  private static boolean authority_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "authority_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_COLON);
    r = r && port(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BASE_KEYWORD sep identifier-ref-arg-quoted
  //  optsep stmtend
  public static boolean base_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_stmt")) return false;
    if (!nextTokenIs(b, YANG_BASE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_BASE_STMT, null);
    r = consumeToken(b, YANG_BASE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_ref_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // BELONGS_TO_KEYWORD sep identifier-arg-quoted
  //  optsep
  //  LEFT_BRACE stmtsep
  //  prefix-stmt stmtsep
  //  RIGHT_BRACE
  public static boolean belongs_to_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "belongs_to_stmt")) return false;
    if (!nextTokenIs(b, YANG_BELONGS_TO_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_BELONGS_TO_STMT, null);
    r = consumeToken(b, YANG_BELONGS_TO_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, prefix_stmt(b, l + 1)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // BIT_KEYWORD sep identifier-arg-quoted optsep
  //  ( bit-sub-stmt | SEMICOLON )
  public static boolean bit_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt")) return false;
    if (!nextTokenIs(b, YANG_BIT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_BIT_STMT, null);
    r = consumeToken(b, YANG_BIT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && bit_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // bit-sub-stmt | SEMICOLON
  private static boolean bit_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_4")) return false;
    boolean r;
    r = bit_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( position-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean bit_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BIT_STMT_BODY, "<bit stmt body>");
    r = bit_stmt_body_0(b, l + 1);
    if (!r) r = bit_stmt_body_1(b, l + 1);
    if (!r) r = bit_stmt_body_2(b, l + 1);
    if (!r) r = bit_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // position-stmt stmtsep
  private static boolean bit_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = position_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean bit_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean bit_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean bit_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                          bit-stmt-body *
  //                          RIGHT_BRACE
  static boolean bit_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, bit_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // bit-stmt-body *
  private static boolean bit_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bit_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bit_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ( bit-stmt stmtsep ) +
  public static boolean bits_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bits_specification")) return false;
    if (!nextTokenIs(b, YANG_BIT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bits_specification_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!bits_specification_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bits_specification", c)) break;
    }
    exit_section_(b, m, YANG_BITS_SPECIFICATION, r);
    return r;
  }

  // bit-stmt stmtsep
  private static boolean bits_specification_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bits_specification_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bit_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // body-sub-stmt +
  public static boolean body_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_BODY_STMTS, "<body stmts>");
    r = body_sub_stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!body_sub_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "body_stmts", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // extension-stmt |
  //  feature-stmt |
  //  identity-stmt |
  //  typedef-stmt |
  //  grouping-stmt |
  //  data-def-stmt |
  //  augment-stmt |
  //  rpc-stmt |
  //  notification-stmt |
  //  deviation-stmt
  static boolean body_stmts_base(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_stmts_base")) return false;
    boolean r;
    r = extension_stmt(b, l + 1);
    if (!r) r = feature_stmt(b, l + 1);
    if (!r) r = identity_stmt(b, l + 1);
    if (!r) r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    if (!r) r = data_def_stmt(b, l + 1);
    if (!r) r = augment_stmt(b, l + 1);
    if (!r) r = rpc_stmt(b, l + 1);
    if (!r) r = notification_stmt(b, l + 1);
    if (!r) r = deviation_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // body-stmts-base stmtsep
  static boolean body_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_sub_stmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = body_stmts_base(b, l + 1);
    p = r; // pin = 1
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, p, YangParser::recover_rule_body);
    return r || p;
  }

  /* ********************************************************** */
  // CASE_KEYWORD sep identifier-arg-quoted optsep
  //  ( case-sub-stmt | SEMICOLON )
  public static boolean case_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt")) return false;
    if (!nextTokenIs(b, YANG_CASE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_CASE_STMT, null);
    r = consumeToken(b, YANG_CASE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && case_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // case-sub-stmt | SEMICOLON
  private static boolean case_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_4")) return false;
    boolean r;
    r = case_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( data-def-stmt stmtsep )
  public static boolean case_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CASE_STMT_BODY, "<case stmt body>");
    r = case_stmt_body_0(b, l + 1);
    if (!r) r = case_stmt_body_1(b, l + 1);
    if (!r) r = case_stmt_body_2(b, l + 1);
    if (!r) r = case_stmt_body_3(b, l + 1);
    if (!r) r = case_stmt_body_4(b, l + 1);
    if (!r) r = case_stmt_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean case_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean case_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean case_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean case_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean case_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean case_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                           case-stmt-body +
  //                           RIGHT_BRACE
  static boolean case_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, case_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // case-stmt-body +
  private static boolean case_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "case_sub_stmt_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!case_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "case_sub_stmt_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CHOICE_KEYWORD sep identifier-arg-quoted optsep
  //  ( choice-sub-stmt | SEMICOLON )
  public static boolean choice_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt")) return false;
    if (!nextTokenIs(b, YANG_CHOICE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_CHOICE_STMT, null);
    r = consumeToken(b, YANG_CHOICE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && choice_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // choice-sub-stmt | SEMICOLON
  private static boolean choice_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_4")) return false;
    boolean r;
    r = choice_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( default-stmt stmtsep ) | // ?
  //  ( config-stmt stmtsep ) | // ?
  //  ( mandatory-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( short-case-stmt | case-stmt ) stmtsep )
  public static boolean choice_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CHOICE_STMT_BODY, "<choice stmt body>");
    r = choice_stmt_body_0(b, l + 1);
    if (!r) r = choice_stmt_body_1(b, l + 1);
    if (!r) r = choice_stmt_body_2(b, l + 1);
    if (!r) r = choice_stmt_body_3(b, l + 1);
    if (!r) r = choice_stmt_body_4(b, l + 1);
    if (!r) r = choice_stmt_body_5(b, l + 1);
    if (!r) r = choice_stmt_body_6(b, l + 1);
    if (!r) r = choice_stmt_body_7(b, l + 1);
    if (!r) r = choice_stmt_body_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean choice_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean choice_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // default-stmt stmtsep
  private static boolean choice_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean choice_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mandatory-stmt stmtsep
  private static boolean choice_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean choice_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean choice_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean choice_stmt_body_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( short-case-stmt | case-stmt ) stmtsep
  private static boolean choice_stmt_body_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = choice_stmt_body_8_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // short-case-stmt | case-stmt
  private static boolean choice_stmt_body_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_stmt_body_8_0")) return false;
    boolean r;
    r = short_case_stmt(b, l + 1);
    if (!r) r = case_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                             choice-stmt-body *
  //                             RIGHT_BRACE
  static boolean choice_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, choice_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // choice-stmt-body *
  private static boolean choice_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "choice_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!choice_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "choice_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LINE_COMMENT | BLOCK_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", YANG_BLOCK_COMMENT, YANG_SINGLE_LINE_COMMENT_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_COMMENT, "<comment>");
    r = LINE_COMMENT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_BLOCK_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD | FALSE_KEYWORD
  public static boolean config_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_arg")) return false;
    if (!nextTokenIs(b, "<config arg>", YANG_FALSE_KEYWORD, YANG_TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONFIG_ARG, "<config arg>");
    r = consumeToken(b, YANG_TRUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FALSE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // config-arg | ( DOUBLE_QUOTE config-arg DOUBLE_QUOTE )
  public static boolean config_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONFIG_ARG_STR, "<config arg str>");
    r = config_arg(b, l + 1);
    if (!r) r = config_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE config-arg DOUBLE_QUOTE
  private static boolean config_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && config_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONFIG_KEYWORD sep
  //  config-arg-str stmtend
  public static boolean config_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_stmt")) return false;
    if (!nextTokenIs(b, YANG_CONFIG_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONFIG_STMT, null);
    r = consumeToken(b, YANG_CONFIG_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, config_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // CONTACT_KEYWORD sep string optsep stmtend
  public static boolean contact_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contact_stmt")) return false;
    if (!nextTokenIs(b, YANG_CONTACT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTACT_STMT, null);
    r = consumeToken(b, YANG_CONTACT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // CONTAINER_KEYWORD sep identifier-arg-quoted optsep
  //  ( container-sub-stmt | SEMICOLON )
  public static boolean container_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt")) return false;
    if (!nextTokenIs(b, YANG_CONTAINER_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTAINER_STMT, null);
    r = consumeToken(b, YANG_CONTAINER_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && container_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // container-sub-stmt | SEMICOLON
  private static boolean container_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_4")) return false;
    boolean r;
    r = container_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( must-stmt stmtsep ) | // *
  //  ( presence-stmt stmtsep ) | // ?
  //  ( config-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( data-def-stmt stmtsep )
  public static boolean container_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CONTAINER_STMT_BODY, "<container stmt body>");
    r = container_stmt_body_0(b, l + 1);
    if (!r) r = container_stmt_body_1(b, l + 1);
    if (!r) r = container_stmt_body_2(b, l + 1);
    if (!r) r = container_stmt_body_3(b, l + 1);
    if (!r) r = container_stmt_body_4(b, l + 1);
    if (!r) r = container_stmt_body_5(b, l + 1);
    if (!r) r = container_stmt_body_6(b, l + 1);
    if (!r) r = container_stmt_body_7(b, l + 1);
    if (!r) r = container_stmt_body_8(b, l + 1);
    if (!r) r = container_stmt_body_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean container_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean container_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // must-stmt stmtsep
  private static boolean container_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // presence-stmt stmtsep
  private static boolean container_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = presence_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean container_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean container_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean container_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean container_stmt_body_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean container_stmt_body_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = container_stmt_body_8_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean container_stmt_body_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_8_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean container_stmt_body_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_stmt_body_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                                container-stmt-body *
  //                                RIGHT_BRACE
  static boolean container_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, container_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // container-stmt-body *
  private static boolean container_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!container_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "container_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ( CURRENT_KEYWORD | splitted-current-keyword ) STRING_SPLITTER?  (WSP STRING_SPLITTER?)* LEFT_PARENTHESIS
  // STRING_SPLITTER? (WSP STRING_SPLITTER?)* RIGHT_PARENTHESIS
  public static boolean current_function_invocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_CURRENT_FUNCTION_INVOCATION, "<current function invocation>");
    r = current_function_invocation_0(b, l + 1);
    r = r && current_function_invocation_1(b, l + 1);
    r = r && current_function_invocation_2(b, l + 1);
    r = r && consumeToken(b, YANG_LEFT_PARENTHESIS);
    r = r && current_function_invocation_4(b, l + 1);
    r = r && current_function_invocation_5(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_PARENTHESIS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CURRENT_KEYWORD | splitted-current-keyword
  private static boolean current_function_invocation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_CURRENT_KEYWORD);
    if (!r) r = splitted_current_keyword(b, l + 1);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean current_function_invocation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean current_function_invocation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!current_function_invocation_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "current_function_invocation_2", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean current_function_invocation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && current_function_invocation_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean current_function_invocation_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_2_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean current_function_invocation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_4")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean current_function_invocation_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!current_function_invocation_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "current_function_invocation_5", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean current_function_invocation_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && current_function_invocation_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean current_function_invocation_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "current_function_invocation_5_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // container-stmt |
  //  leaf-stmt |
  //  leaf-list-stmt |
  //  list-stmt |
  //  choice-stmt |
  //  anyxml-stmt |
  //  uses-stmt
  public static boolean data_def_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_def_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, YANG_DATA_DEF_STMT, "<data def stmt>");
    r = container_stmt(b, l + 1);
    if (!r) r = leaf_stmt(b, l + 1);
    if (!r) r = leaf_list_stmt(b, l + 1);
    if (!r) r = list_stmt(b, l + 1);
    if (!r) r = choice_stmt(b, l + 1);
    if (!r) r = anyxml_stmt(b, l + 1);
    if (!r) r = uses_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_SPLITTER? DIGIT STRING_SPLITTER? DIGIT STRING_SPLITTER? DIGIT STRING_SPLITTER? DIGIT
  //     STRING_SPLITTER? DASH STRING_SPLITTER? DIGIT STRING_SPLITTER? DIGIT STRING_SPLITTER? DASH STRING_SPLITTER?
  //      DIGIT STRING_SPLITTER? DIGIT
  public static boolean date_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DATE_ARG, "<date arg>");
    r = date_arg_0(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_2(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_4(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_6(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_8(b, l + 1);
    r = r && consumeToken(b, YANG_DASH);
    r = r && date_arg_10(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_12(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_14(b, l + 1);
    r = r && consumeToken(b, YANG_DASH);
    r = r && date_arg_16(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && date_arg_18(b, l + 1);
    r = r && DIGIT(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_0")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_2")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_4")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_6")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_8")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_10")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_12")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_14")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_16")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean date_arg_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_18")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DIGIT DIGIT DIGIT DIGIT DASH DIGIT DIGIT DASH DIGIT DIGIT
  public static boolean date_arg_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_quoted")) return false;
    if (!nextTokenIs(b, "<date arg quoted>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DATE_ARG_QUOTED, "<date arg quoted>");
    r = DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && consumeToken(b, YANG_DASH);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    r = r && consumeToken(b, YANG_DASH);
    r = r && DIGIT(b, l + 1);
    r = r && DIGIT(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // date-arg | ( DOUBLE_QUOTE date-arg-quoted DOUBLE_QUOTE )
  public static boolean date_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DATE_ARG_STR, "<date arg str>");
    r = date_arg(b, l + 1);
    if (!r) r = date_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE date-arg-quoted DOUBLE_QUOTE
  private static boolean date_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && date_arg_quoted(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DIGIT | (POSITIVE_NUMBER? POSITIVE_NUMBER? POSITIVE_NUMBER? )
  public static boolean dec_octet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEC_OCTET, "<dec octet>");
    r = DIGIT(b, l + 1);
    if (!r) r = dec_octet_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // POSITIVE_NUMBER? POSITIVE_NUMBER? POSITIVE_NUMBER?
  private static boolean dec_octet_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dec_octet_1_0(b, l + 1);
    r = r && dec_octet_1_1(b, l + 1);
    r = r && dec_octet_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // POSITIVE_NUMBER?
  private static boolean dec_octet_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_1_0")) return false;
    consumeToken(b, YANG_POSITIVE_NUMBER);
    return true;
  }

  // POSITIVE_NUMBER?
  private static boolean dec_octet_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_1_1")) return false;
    consumeToken(b, YANG_POSITIVE_NUMBER);
    return true;
  }

  // POSITIVE_NUMBER?
  private static boolean dec_octet_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_octet_1_2")) return false;
    consumeToken(b, YANG_POSITIVE_NUMBER);
    return true;
  }

  /* ********************************************************** */
  // integer-value DOT zero-integer-value
  public static boolean decimal_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DECIMAL_VALUE, "<decimal value>");
    r = integer_value(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    r = r && zero_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fraction-digits-stmt stmtsep
  public static boolean decimal64_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal64_specification")) return false;
    if (!nextTokenIs(b, YANG_FRACTION_DIGITS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fraction_digits_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, YANG_DECIMAL_64_SPECIFICATION, r);
    return r;
  }

  /* ********************************************************** */
  // DEFAULT_KEYWORD sep string stmtend
  public static boolean default_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "default_stmt")) return false;
    if (!nextTokenIs(b, YANG_DEFAULT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEFAULT_STMT, null);
    r = consumeToken(b, YANG_DEFAULT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // node-identifier
  //  ( path-predicate * absolute-path ) ?
  public static boolean descendant_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCENDANT_PATH, "<descendant path>");
    r = node_identifier(b, l + 1);
    r = r && descendant_path_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( path-predicate * absolute-path ) ?
  private static boolean descendant_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path_1")) return false;
    descendant_path_1_0(b, l + 1);
    return true;
  }

  // path-predicate * absolute-path
  private static boolean descendant_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = descendant_path_1_0_0(b, l + 1);
    r = r && absolute_path(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // path-predicate *
  private static boolean descendant_path_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_path_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_predicate(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "descendant_path_1_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // node-identifier
  //  absolute-schema-nodeid
  public static boolean descendant_schema_nodeid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "descendant_schema_nodeid")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCENDANT_SCHEMA_NODEID, "<descendant schema nodeid>");
    r = node_identifier(b, l + 1);
    r = r && absolute_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DESCRIPTION_KEYWORD sep string optsep stmtend
  public static boolean description_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description_stmt")) return false;
    if (!nextTokenIs(b, YANG_DESCRIPTION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DESCRIPTION_STMT, null);
    r = consumeToken(b, YANG_DESCRIPTION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // DEVIATE_KEYWORD sep ADD_KEYWORD optsep
  //  ( deviate-add-sub-stmt | SEMICOLON )
  public static boolean deviate_add_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt")) return false;
    if (!nextTokenIs(b, YANG_DEVIATE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_ADD_STMT, null);
    r = consumeToken(b, YANG_DEVIATE_KEYWORD);
    r = r && sep(b, l + 1);
    r = r && consumeToken(b, YANG_ADD_KEYWORD);
    p = r; // pin = 3
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && deviate_add_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // deviate-add-sub-stmt | SEMICOLON
  private static boolean deviate_add_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_stmt_4")) return false;
    boolean r;
    r = deviate_add_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                                  ( units-stmt stmtsep ) ?
  //                                  ( must-stmt stmtsep ) *
  //                                  ( unique-stmt stmtsep ) *
  //                                  ( default-stmt stmtsep ) ?
  //                                  ( config-stmt stmtsep ) ?
  //                                  ( mandatory-stmt stmtsep ) ?
  //                                  ( min-elements-stmt stmtsep ) ?
  //                                  ( max-elements-stmt stmtsep ) ?
  //                                  RIGHT_BRACE
  static boolean deviate_add_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, deviate_add_sub_stmt_2(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_3(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_4(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_5(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_6(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_7(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_8(b, l + 1)) && r;
    r = p && report_error_(b, deviate_add_sub_stmt_9(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( units-stmt stmtsep ) ?
  private static boolean deviate_add_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_2")) return false;
    deviate_add_sub_stmt_2_0(b, l + 1);
    return true;
  }

  // units-stmt stmtsep
  private static boolean deviate_add_sub_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = units_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( must-stmt stmtsep ) *
  private static boolean deviate_add_sub_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!deviate_add_sub_stmt_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_add_sub_stmt_3", c)) break;
    }
    return true;
  }

  // must-stmt stmtsep
  private static boolean deviate_add_sub_stmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( unique-stmt stmtsep ) *
  private static boolean deviate_add_sub_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!deviate_add_sub_stmt_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_add_sub_stmt_4", c)) break;
    }
    return true;
  }

  // unique-stmt stmtsep
  private static boolean deviate_add_sub_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unique_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( default-stmt stmtsep ) ?
  private static boolean deviate_add_sub_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_5")) return false;
    deviate_add_sub_stmt_5_0(b, l + 1);
    return true;
  }

  // default-stmt stmtsep
  private static boolean deviate_add_sub_stmt_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( config-stmt stmtsep ) ?
  private static boolean deviate_add_sub_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_6")) return false;
    deviate_add_sub_stmt_6_0(b, l + 1);
    return true;
  }

  // config-stmt stmtsep
  private static boolean deviate_add_sub_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( mandatory-stmt stmtsep ) ?
  private static boolean deviate_add_sub_stmt_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_7")) return false;
    deviate_add_sub_stmt_7_0(b, l + 1);
    return true;
  }

  // mandatory-stmt stmtsep
  private static boolean deviate_add_sub_stmt_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( min-elements-stmt stmtsep ) ?
  private static boolean deviate_add_sub_stmt_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_8")) return false;
    deviate_add_sub_stmt_8_0(b, l + 1);
    return true;
  }

  // min-elements-stmt stmtsep
  private static boolean deviate_add_sub_stmt_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = min_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( max-elements-stmt stmtsep ) ?
  private static boolean deviate_add_sub_stmt_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_9")) return false;
    deviate_add_sub_stmt_9_0(b, l + 1);
    return true;
  }

  // max-elements-stmt stmtsep
  private static boolean deviate_add_sub_stmt_9_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_add_sub_stmt_9_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = max_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEVIATE_KEYWORD sep DELETE_KEYWORD optsep
  //  ( deviate-delete-sub-stmt | SEMICOLON )
  public static boolean deviate_delete_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt")) return false;
    if (!nextTokenIs(b, YANG_DEVIATE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_DELETE_STMT, null);
    r = consumeToken(b, YANG_DEVIATE_KEYWORD);
    r = r && sep(b, l + 1);
    r = r && consumeToken(b, YANG_DELETE_KEYWORD);
    p = r; // pin = 3
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && deviate_delete_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // deviate-delete-sub-stmt | SEMICOLON
  private static boolean deviate_delete_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_stmt_4")) return false;
    boolean r;
    r = deviate_delete_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                                     ( units-stmt stmtsep ) ?
  //                                     ( must-stmt stmtsep ) *
  //                                     ( unique-stmt stmtsep ) *
  //                                     ( default-stmt stmtsep ) ?
  //                                     RIGHT_BRACE
  static boolean deviate_delete_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, deviate_delete_sub_stmt_2(b, l + 1)) && r;
    r = p && report_error_(b, deviate_delete_sub_stmt_3(b, l + 1)) && r;
    r = p && report_error_(b, deviate_delete_sub_stmt_4(b, l + 1)) && r;
    r = p && report_error_(b, deviate_delete_sub_stmt_5(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( units-stmt stmtsep ) ?
  private static boolean deviate_delete_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_2")) return false;
    deviate_delete_sub_stmt_2_0(b, l + 1);
    return true;
  }

  // units-stmt stmtsep
  private static boolean deviate_delete_sub_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = units_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( must-stmt stmtsep ) *
  private static boolean deviate_delete_sub_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!deviate_delete_sub_stmt_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_delete_sub_stmt_3", c)) break;
    }
    return true;
  }

  // must-stmt stmtsep
  private static boolean deviate_delete_sub_stmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( unique-stmt stmtsep ) *
  private static boolean deviate_delete_sub_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!deviate_delete_sub_stmt_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviate_delete_sub_stmt_4", c)) break;
    }
    return true;
  }

  // unique-stmt stmtsep
  private static boolean deviate_delete_sub_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unique_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( default-stmt stmtsep ) ?
  private static boolean deviate_delete_sub_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_5")) return false;
    deviate_delete_sub_stmt_5_0(b, l + 1);
    return true;
  }

  // default-stmt stmtsep
  private static boolean deviate_delete_sub_stmt_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_delete_sub_stmt_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEVIATE_KEYWORD sep
  //  NOT_SUPPORTED_KEYWORD optsep
  //  ( SEMICOLON |
  //  ( LEFT_BRACE stmtsep
  //  RIGHT_BRACE ) )
  public static boolean deviate_not_supported_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_not_supported_stmt")) return false;
    if (!nextTokenIs(b, YANG_DEVIATE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_NOT_SUPPORTED_STMT, null);
    r = consumeToken(b, YANG_DEVIATE_KEYWORD);
    r = r && sep(b, l + 1);
    r = r && consumeToken(b, YANG_NOT_SUPPORTED_KEYWORD);
    p = r; // pin = 3
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && deviate_not_supported_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SEMICOLON |
  //  ( LEFT_BRACE stmtsep
  //  RIGHT_BRACE )
  private static boolean deviate_not_supported_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_not_supported_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = deviate_not_supported_stmt_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_BRACE stmtsep
  //  RIGHT_BRACE
  private static boolean deviate_not_supported_stmt_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_not_supported_stmt_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEVIATE_KEYWORD sep REPLACE_KEYWORD optsep
  //  ( deviate-replace-sub-stmt | SEMICOLON )
  public static boolean deviate_replace_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt")) return false;
    if (!nextTokenIs(b, YANG_DEVIATE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATE_REPLACE_STMT, null);
    r = consumeToken(b, YANG_DEVIATE_KEYWORD);
    r = r && sep(b, l + 1);
    r = r && consumeToken(b, YANG_REPLACE_KEYWORD);
    p = r; // pin = 3
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && deviate_replace_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // deviate-replace-sub-stmt | SEMICOLON
  private static boolean deviate_replace_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_stmt_4")) return false;
    boolean r;
    r = deviate_replace_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                                      ( type-stmt stmtsep ) ?
  //                                      ( units-stmt stmtsep ) ?
  //                                      ( default-stmt stmtsep ) ?
  //                                      ( config-stmt stmtsep ) ?
  //                                      ( mandatory-stmt stmtsep ) ?
  //                                      ( min-elements-stmt stmtsep ) ?
  //                                      ( max-elements-stmt stmtsep ) ?
  //                                      RIGHT_BRACE
  static boolean deviate_replace_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, deviate_replace_sub_stmt_2(b, l + 1)) && r;
    r = p && report_error_(b, deviate_replace_sub_stmt_3(b, l + 1)) && r;
    r = p && report_error_(b, deviate_replace_sub_stmt_4(b, l + 1)) && r;
    r = p && report_error_(b, deviate_replace_sub_stmt_5(b, l + 1)) && r;
    r = p && report_error_(b, deviate_replace_sub_stmt_6(b, l + 1)) && r;
    r = p && report_error_(b, deviate_replace_sub_stmt_7(b, l + 1)) && r;
    r = p && report_error_(b, deviate_replace_sub_stmt_8(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( type-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_2")) return false;
    deviate_replace_sub_stmt_2_0(b, l + 1);
    return true;
  }

  // type-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( units-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_3")) return false;
    deviate_replace_sub_stmt_3_0(b, l + 1);
    return true;
  }

  // units-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = units_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( default-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_4")) return false;
    deviate_replace_sub_stmt_4_0(b, l + 1);
    return true;
  }

  // default-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( config-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_5")) return false;
    deviate_replace_sub_stmt_5_0(b, l + 1);
    return true;
  }

  // config-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( mandatory-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_6")) return false;
    deviate_replace_sub_stmt_6_0(b, l + 1);
    return true;
  }

  // mandatory-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( min-elements-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_7")) return false;
    deviate_replace_sub_stmt_7_0(b, l + 1);
    return true;
  }

  // min-elements-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = min_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( max-elements-stmt stmtsep ) ?
  private static boolean deviate_replace_sub_stmt_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_8")) return false;
    deviate_replace_sub_stmt_8_0(b, l + 1);
    return true;
  }

  // max-elements-stmt stmtsep
  private static boolean deviate_replace_sub_stmt_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviate_replace_sub_stmt_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = max_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid
  public static boolean deviation_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_arg")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = absolute_schema_nodeid(b, l + 1);
    exit_section_(b, m, YANG_DEVIATION_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // deviation-arg | ( DOUBLE_QUOTE deviation-arg DOUBLE_QUOTE )
  public static boolean deviation_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_arg_str")) return false;
    if (!nextTokenIs(b, "<deviation arg str>", YANG_DOUBLE_QUOTE, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATION_ARG_STR, "<deviation arg str>");
    r = deviation_arg(b, l + 1);
    if (!r) r = deviation_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE deviation-arg DOUBLE_QUOTE
  private static boolean deviation_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && deviation_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEVIATION_KEYWORD sep
  //  deviation-arg-str optsep
  //  LEFT_BRACE stmtsep
  //  deviation-stmt-body +
  //  RIGHT_BRACE
  public static boolean deviation_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt")) return false;
    if (!nextTokenIs(b, YANG_DEVIATION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATION_STMT, null);
    r = consumeToken(b, YANG_DEVIATION_KEYWORD);
    r = r && sep(b, l + 1);
    r = r && deviation_arg_str(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, deviation_stmt_6(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // deviation-stmt-body +
  private static boolean deviation_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deviation_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!deviation_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviation_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( deviation-stmt-body-args stmtsep )
  public static boolean deviation_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_DEVIATION_STMT_BODY, "<deviation stmt body>");
    r = deviation_stmt_body_0(b, l + 1);
    if (!r) r = deviation_stmt_body_1(b, l + 1);
    if (!r) r = deviation_stmt_body_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // description-stmt stmtsep
  private static boolean deviation_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean deviation_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // deviation-stmt-body-args stmtsep
  private static boolean deviation_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deviation_stmt_body_args(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // deviate-not-supported-stmt |
  //  (
  //     deviate-add-stmt |
  //     deviate-replace-stmt |
  //     deviate-delete-stmt
  //  ) +
  public static boolean deviation_stmt_body_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body_args")) return false;
    if (!nextTokenIs(b, YANG_DEVIATE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deviate_not_supported_stmt(b, l + 1);
    if (!r) r = deviation_stmt_body_args_1(b, l + 1);
    exit_section_(b, m, YANG_DEVIATION_STMT_BODY_ARGS, r);
    return r;
  }

  // (
  //     deviate-add-stmt |
  //     deviate-replace-stmt |
  //     deviate-delete-stmt
  //  ) +
  private static boolean deviation_stmt_body_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body_args_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = deviation_stmt_body_args_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!deviation_stmt_body_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "deviation_stmt_body_args_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // deviate-add-stmt |
  //     deviate-replace-stmt |
  //     deviate-delete-stmt
  private static boolean deviation_stmt_body_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "deviation_stmt_body_args_1_0")) return false;
    boolean r;
    r = deviate_add_stmt(b, l + 1);
    if (!r) r = deviate_replace_stmt(b, l + 1);
    if (!r) r = deviate_delete_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( enum-stmt stmtsep ) +
  public static boolean enum_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_specification")) return false;
    if (!nextTokenIs(b, YANG_ENUM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_specification_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!enum_specification_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_specification", c)) break;
    }
    exit_section_(b, m, YANG_ENUM_SPECIFICATION, r);
    return r;
  }

  // enum-stmt stmtsep
  private static boolean enum_specification_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_specification_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ENUM_KEYWORD sep string optsep
  //  ( enum-sub-stmt | SEMICOLON )
  public static boolean enum_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt")) return false;
    if (!nextTokenIs(b, YANG_ENUM_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ENUM_STMT, null);
    r = consumeToken(b, YANG_ENUM_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && enum_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum-sub-stmt | SEMICOLON
  private static boolean enum_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_4")) return false;
    boolean r;
    r = enum_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( value-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean enum_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ENUM_STMT_BODY, "<enum stmt body>");
    r = enum_stmt_body_0(b, l + 1);
    if (!r) r = enum_stmt_body_1(b, l + 1);
    if (!r) r = enum_stmt_body_2(b, l + 1);
    if (!r) r = enum_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // value-stmt stmtsep
  private static boolean enum_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean enum_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean enum_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean enum_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                           enum-stmt-body *
  //                           RIGHT_BRACE
  static boolean enum_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, enum_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum-stmt-body *
  private static boolean enum_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ERROR_APP_TAG_KEYWORD sep string stmtend
  public static boolean error_app_tag_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_app_tag_stmt")) return false;
    if (!nextTokenIs(b, YANG_ERROR_APP_TAG_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ERROR_APP_TAG_STMT, null);
    r = consumeToken(b, YANG_ERROR_APP_TAG_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ERROR_MESSAGE_KEYWORD sep string stmtend
  public static boolean error_message_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "error_message_stmt")) return false;
    if (!nextTokenIs(b, YANG_ERROR_MESSAGE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ERROR_MESSAGE_STMT, null);
    r = consumeToken(b, YANG_ERROR_MESSAGE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // EXTENSION_KEYWORD sep identifier-arg-quoted optsep
  //  ( extension-sub-stmt | SEMICOLON )
  public static boolean extension_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt")) return false;
    if (!nextTokenIs(b, YANG_EXTENSION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_EXTENSION_STMT, null);
    r = consumeToken(b, YANG_EXTENSION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && extension_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // extension-sub-stmt | SEMICOLON
  private static boolean extension_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_4")) return false;
    boolean r;
    r = extension_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( argument-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean extension_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_EXTENSION_STMT_BODY, "<extension stmt body>");
    r = extension_stmt_body_0(b, l + 1);
    if (!r) r = extension_stmt_body_1(b, l + 1);
    if (!r) r = extension_stmt_body_2(b, l + 1);
    if (!r) r = extension_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argument-stmt stmtsep
  private static boolean extension_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean extension_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean extension_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean extension_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                        extension-stmt-body *
  //                        RIGHT_BRACE
  static boolean extension_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, extension_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // extension-stmt-body *
  private static boolean extension_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!extension_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // FEATURE_KEYWORD sep identifier-arg-quoted optsep
  //  ( feature-sub-stmt | SEMICOLON )
  public static boolean feature_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt")) return false;
    if (!nextTokenIs(b, YANG_FEATURE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_FEATURE_STMT, null);
    r = consumeToken(b, YANG_FEATURE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && feature_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // feature-sub-stmt | SEMICOLON
  private static boolean feature_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_4")) return false;
    boolean r;
    r = feature_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean feature_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FEATURE_STMT_BODY, "<feature stmt body>");
    r = feature_stmt_body_0(b, l + 1);
    if (!r) r = feature_stmt_body_1(b, l + 1);
    if (!r) r = feature_stmt_body_2(b, l + 1);
    if (!r) r = feature_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean feature_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean feature_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean feature_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean feature_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                              feature-stmt-body +
  //                              RIGHT_BRACE
  static boolean feature_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, feature_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // feature-stmt-body +
  private static boolean feature_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "feature_sub_stmt_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = feature_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!feature_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "feature_sub_stmt_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( "1" ( ZERO | "1" | "2" | "3" | "4" |
  //  "5" | "6" | "7" | "8" ) ? )
  //  | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
  public static boolean fraction_digits_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRACTION_DIGITS_ARG, "<fraction digits arg>");
    r = fraction_digits_arg_0(b, l + 1);
    if (!r) r = consumeToken(b, "2");
    if (!r) r = consumeToken(b, "3");
    if (!r) r = consumeToken(b, "4");
    if (!r) r = consumeToken(b, "5");
    if (!r) r = consumeToken(b, "6");
    if (!r) r = consumeToken(b, "7");
    if (!r) r = consumeToken(b, "8");
    if (!r) r = consumeToken(b, "9");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "1" ( ZERO | "1" | "2" | "3" | "4" |
  //  "5" | "6" | "7" | "8" ) ?
  private static boolean fraction_digits_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "1");
    r = r && fraction_digits_arg_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ZERO | "1" | "2" | "3" | "4" |
  //  "5" | "6" | "7" | "8" ) ?
  private static boolean fraction_digits_arg_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_0_1")) return false;
    fraction_digits_arg_0_1_0(b, l + 1);
    return true;
  }

  // ZERO | "1" | "2" | "3" | "4" |
  //  "5" | "6" | "7" | "8"
  private static boolean fraction_digits_arg_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = consumeToken(b, "1");
    if (!r) r = consumeToken(b, "2");
    if (!r) r = consumeToken(b, "3");
    if (!r) r = consumeToken(b, "4");
    if (!r) r = consumeToken(b, "5");
    if (!r) r = consumeToken(b, "6");
    if (!r) r = consumeToken(b, "7");
    if (!r) r = consumeToken(b, "8");
    return r;
  }

  /* ********************************************************** */
  // fraction-digits-arg | ( DOUBLE_QUOTE fraction-digits-arg DOUBLE_QUOTE )
  public static boolean fraction_digits_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRACTION_DIGITS_ARG_STR, "<fraction digits arg str>");
    r = fraction_digits_arg(b, l + 1);
    if (!r) r = fraction_digits_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE fraction-digits-arg DOUBLE_QUOTE
  private static boolean fraction_digits_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && fraction_digits_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FRACTION_DIGITS_KEYWORD sep
  //  fraction-digits-arg-str stmtend
  public static boolean fraction_digits_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fraction_digits_stmt")) return false;
    if (!nextTokenIs(b, YANG_FRACTION_DIGITS_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRACTION_DIGITS_STMT, null);
    r = consumeToken(b, YANG_FRACTION_DIGITS_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, fraction_digits_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // query
  public static boolean fragment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fragment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_FRAGMENT, "<fragment>");
    r = query(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // GROUPING_KEYWORD sep identifier-arg-quoted optsep
  //  ( grouping-sub-stmt | SEMICOLON )
  public static boolean grouping_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt")) return false;
    if (!nextTokenIs(b, YANG_GROUPING_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_GROUPING_STMT, null);
    r = consumeToken(b, YANG_GROUPING_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && grouping_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // grouping-sub-stmt | SEMICOLON
  private static boolean grouping_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_4")) return false;
    boolean r;
    r = grouping_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  (  (typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( data-def-stmt stmtsep )
  public static boolean grouping_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_GROUPING_STMT_BODY, "<grouping stmt body>");
    r = grouping_stmt_body_0(b, l + 1);
    if (!r) r = grouping_stmt_body_1(b, l + 1);
    if (!r) r = grouping_stmt_body_2(b, l + 1);
    if (!r) r = grouping_stmt_body_3(b, l + 1);
    if (!r) r = grouping_stmt_body_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // status-stmt stmtsep
  private static boolean grouping_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean grouping_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean grouping_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean grouping_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = grouping_stmt_body_3_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean grouping_stmt_body_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body_3_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean grouping_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                               grouping-stmt-body *
  //                               RIGHT_BRACE
  static boolean grouping_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, grouping_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // grouping-stmt-body *
  private static boolean grouping_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "grouping_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!grouping_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "grouping_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ( HEXDIG HEXDIG HEXDIG HEXDIG )+
  public static boolean h16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h16")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_H_16, "<h 16>");
    r = h16_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!h16_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "h16", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HEXDIG HEXDIG HEXDIG HEXDIG
  private static boolean h16_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "h16_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = HEXDIG(b, l + 1);
    r = r && HEXDIG(b, l + 1);
    r = r && HEXDIG(b, l + 1);
    r = r && HEXDIG(b, l + 1);
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
  //     H_SEMICOLON
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
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "//" authority path-abempty
  //  | path-absolute
  //  | path-rootless
  //  | path-empty
  public static boolean hier_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hier_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_HIER_PART, "<hier part>");
    r = hier_part_0(b, l + 1);
    if (!r) r = path_absolute(b, l + 1);
    if (!r) r = path_rootless(b, l + 1);
    if (!r) r = path_empty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "//" authority path-abempty
  private static boolean hier_part_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hier_part_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "//");
    r = r && authority(b, l + 1);
    r = r && path_abempty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // H_NOT_STRING | H_STRING | H_WHITE_SPACE | H_DATE_ARG | H_IDENTIFIER |  H_EXTENSION_IDENTIFIER |
  //     H_BLOCK_COMMENT | H_SINGLE_LINE_COMMENT | BLOCK_COMMENT_END | H_FS | H_A
  public static boolean highlighter_tokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "highlighter_tokens")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_HIGHLIGHTER_TOKENS, "<highlighter tokens>");
    r = consumeToken(b, YANG_H_NOT_STRING);
    if (!r) r = consumeToken(b, YANG_H_STRING);
    if (!r) r = consumeToken(b, YANG_H_WHITE_SPACE);
    if (!r) r = consumeToken(b, YANG_H_DATE_ARG);
    if (!r) r = consumeToken(b, YANG_H_IDENTIFIER);
    if (!r) r = consumeToken(b, YANG_H_EXTENSION_IDENTIFIER);
    if (!r) r = consumeToken(b, YANG_H_BLOCK_COMMENT);
    if (!r) r = consumeToken(b, YANG_H_SINGLE_LINE_COMMENT);
    if (!r) r = consumeToken(b, YANG_BLOCK_COMMENT_END);
    if (!r) r = consumeToken(b, YANG_H_FS);
    if (!r) r = consumeToken(b, YANG_H_A);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IP-literal | IPv4address | reg-name
  public static boolean host(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "host")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_HOST, "<host>");
    r = IP_literal(b, l + 1);
    if (!r) r = IPv4address(b, l + 1);
    if (!r) r = reg_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier-quoted
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER, "<identifier>");
    r = identifier_quoted(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean identifier_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_ARG, "<identifier arg>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier-arg | ( DOUBLE_QUOTE identifier-arg DOUBLE_QUOTE )
  public static boolean identifier_arg_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_arg_quoted")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_ARG_QUOTED, "<identifier arg quoted>");
    r = identifier_arg(b, l + 1);
    if (!r) r = identifier_arg_quoted_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE identifier-arg DOUBLE_QUOTE
  private static boolean identifier_arg_quoted_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_arg_quoted_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && identifier_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANYXML_KEYWORD          |
  //         ARGUMENT_KEYWORD        |
  //         AUGMENT_KEYWORD         |
  //         BASE_KEYWORD            |
  //         BELONGS_TO_KEYWORD      |
  //         BIT_KEYWORD             |
  //         CASE_KEYWORD            |
  //         CHOICE_KEYWORD          |
  //         CONFIG_KEYWORD          |
  //         CONTACT_KEYWORD         |
  //         CONTAINER_KEYWORD       |
  //         DEFAULT_KEYWORD         |
  //         DESCRIPTION_KEYWORD     |
  //         ENUM_KEYWORD            |
  //         ERROR_APP_TAG_KEYWORD   |
  //         ERROR_MESSAGE_KEYWORD   |
  //         EXTENSION_KEYWORD       |
  //         DEVIATION_KEYWORD       |
  //         DEVIATE_KEYWORD         |
  //         FEATURE_KEYWORD         |
  //         FRACTION_DIGITS_KEYWORD |
  //         GROUPING_KEYWORD        |
  //         IDENTITY_KEYWORD        |
  //         IF_FEATURE_KEYWORD      |
  //         IMPORT_KEYWORD          |
  //         INCLUDE_KEYWORD         |
  //         INPUT_KEYWORD           |
  //         KEY_KEYWORD             |
  //         LEAF_KEYWORD            |
  //         LEAF_LIST_KEYWORD       |
  //         LENGTH_KEYWORD          |
  //         LIST_KEYWORD            |
  //         MANDATORY_KEYWORD       |
  //         MAX_ELEMENTS_KEYWORD    |
  //         MIN_ELEMENTS_KEYWORD    |
  //         MODULE_KEYWORD          |
  //         MUST_KEYWORD            |
  //         NAMESPACE_KEYWORD       |
  //         NOTIFICATION_KEYWORD    |
  //         ORDERED_BY_KEYWORD      |
  //         ORGANIZATION_KEYWORD    |
  //         OUTPUT_KEYWORD          |
  //         PATH_KEYWORD            |
  //         PATTERN_KEYWORD         |
  //         POSITION_KEYWORD        |
  //         PREFIX_KEYWORD          |
  //         PRESENCE_KEYWORD        |
  //         RANGE_KEYWORD           |
  //         REFERENCE_KEYWORD       |
  //         REFINE_KEYWORD          |
  //         REQUIRE_INSTANCE_KEYWORD|
  //         REVISION_KEYWORD        |
  //         REVISION_DATE_KEYWORD   |
  //         RPC_KEYWORD             |
  //         STATUS_KEYWORD          |
  //         SUBMODULE_KEYWORD       |
  //         TYPE_KEYWORD            |
  //         TYPEDEF_KEYWORD         |
  //         UNIQUE_KEYWORD          |
  //         UNITS_KEYWORD           |
  //         USES_KEYWORD            |
  //         VALUE_KEYWORD           |
  //         WHEN_KEYWORD            |
  //         YANG_VERSION_KEYWORD    |
  //         YIN_ELEMENT_KEYWORD     |
  //         // other keywords
  //         CURRENT_KEYWORD         |
  //         DELETE_KEYWORD          |
  //         DEPRECATED_KEYWORD      |
  //         FALSE_KEYWORD           |
  //         ADD_KEYWORD             |
  //         MAX_KEYWORD             |
  //         MIN_KEYWORD             |
  //         NOT_SUPPORTED_KEYWORD   |
  //         OBSOLETE_KEYWORD        |
  //         REPLACE_KEYWORD         |
  //         SYSTEM_KEYWORD          |
  //         TRUE_KEYWORD            |
  //         UNBOUNDED_KEYWORD       |
  //         USER_KEYWORD
  public static boolean identifier_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_LITERAL, "<identifier literal>");
    r = consumeToken(b, YANG_ANYXML_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ARGUMENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_AUGMENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_BASE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_BELONGS_TO_KEYWORD);
    if (!r) r = consumeToken(b, YANG_BIT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_CASE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_CHOICE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_CONFIG_KEYWORD);
    if (!r) r = consumeToken(b, YANG_CONTACT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_CONTAINER_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DEFAULT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DESCRIPTION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ENUM_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ERROR_APP_TAG_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ERROR_MESSAGE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_EXTENSION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DEVIATION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DEVIATE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FEATURE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FRACTION_DIGITS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_GROUPING_KEYWORD);
    if (!r) r = consumeToken(b, YANG_IDENTITY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_IF_FEATURE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_IMPORT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_INCLUDE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_INPUT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_KEY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_LEAF_KEYWORD);
    if (!r) r = consumeToken(b, YANG_LEAF_LIST_KEYWORD);
    if (!r) r = consumeToken(b, YANG_LENGTH_KEYWORD);
    if (!r) r = consumeToken(b, YANG_LIST_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MANDATORY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MAX_ELEMENTS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MIN_ELEMENTS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MODULE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MUST_KEYWORD);
    if (!r) r = consumeToken(b, YANG_NAMESPACE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_NOTIFICATION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ORDERED_BY_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ORGANIZATION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_OUTPUT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_PATH_KEYWORD);
    if (!r) r = consumeToken(b, YANG_PATTERN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_POSITION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_PREFIX_KEYWORD);
    if (!r) r = consumeToken(b, YANG_PRESENCE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_RANGE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_REFERENCE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_REFINE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_REQUIRE_INSTANCE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_REVISION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_REVISION_DATE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_RPC_KEYWORD);
    if (!r) r = consumeToken(b, YANG_STATUS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_SUBMODULE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_TYPE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_TYPEDEF_KEYWORD);
    if (!r) r = consumeToken(b, YANG_UNIQUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_UNITS_KEYWORD);
    if (!r) r = consumeToken(b, YANG_USES_KEYWORD);
    if (!r) r = consumeToken(b, YANG_VALUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_WHEN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_YANG_VERSION_KEYWORD);
    if (!r) r = consumeToken(b, YANG_YIN_ELEMENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_CURRENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DELETE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DEPRECATED_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FALSE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_ADD_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MAX_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MIN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_NOT_SUPPORTED_KEYWORD);
    if (!r) r = consumeToken(b, YANG_OBSOLETE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_REPLACE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_SYSTEM_KEYWORD);
    if (!r) r = consumeToken(b, YANG_TRUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_UNBOUNDED_KEYWORD);
    if (!r) r = consumeToken(b, YANG_USER_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_SPLITTER? !(('X'|'x') ('M'|'m') ('L'|'l')) (ALPHA | UNDERSCORE | identifier-literal) STRING_SPLITTER? (ALPHA | DIGIT | UNDERSCORE | DASH | DOT | identifier-literal | STRING_SPLITTER)*
  public static boolean identifier_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_QUOTED, "<identifier quoted>");
    r = identifier_quoted_0(b, l + 1);
    r = r && identifier_quoted_1(b, l + 1);
    r = r && identifier_quoted_2(b, l + 1);
    r = r && identifier_quoted_3(b, l + 1);
    r = r && identifier_quoted_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean identifier_quoted_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_0")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // !(('X'|'x') ('M'|'m') ('L'|'l'))
  private static boolean identifier_quoted_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !identifier_quoted_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('X'|'x') ('M'|'m') ('L'|'l')
  private static boolean identifier_quoted_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_quoted_1_0_0(b, l + 1);
    r = r && identifier_quoted_1_0_1(b, l + 1);
    r = r && identifier_quoted_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'X'|'x'
  private static boolean identifier_quoted_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, "X");
    if (!r) r = consumeToken(b, "x");
    return r;
  }

  // 'M'|'m'
  private static boolean identifier_quoted_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, "M");
    if (!r) r = consumeToken(b, "m");
    return r;
  }

  // 'L'|'l'
  private static boolean identifier_quoted_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_1_0_2")) return false;
    boolean r;
    r = consumeToken(b, "L");
    if (!r) r = consumeToken(b, "l");
    return r;
  }

  // ALPHA | UNDERSCORE | identifier-literal
  private static boolean identifier_quoted_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_2")) return false;
    boolean r;
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = identifier_literal(b, l + 1);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean identifier_quoted_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_3")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (ALPHA | DIGIT | UNDERSCORE | DASH | DOT | identifier-literal | STRING_SPLITTER)*
  private static boolean identifier_quoted_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier_quoted_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifier_quoted_4", c)) break;
    }
    return true;
  }

  // ALPHA | DIGIT | UNDERSCORE | DASH | DOT | identifier-literal | STRING_SPLITTER
  private static boolean identifier_quoted_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_quoted_4_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_DOT);
    if (!r) r = identifier_literal(b, l + 1);
    if (!r) r = STRING_SPLITTER(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (prefix COLON)? identifier
  public static boolean identifier_ref_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_REF_ARG, "<identifier ref arg>");
    r = identifier_ref_arg_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (prefix COLON)?
  private static boolean identifier_ref_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg_0")) return false;
    identifier_ref_arg_0_0(b, l + 1);
    return true;
  }

  // prefix COLON
  private static boolean identifier_ref_arg_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-ref-arg | ( DOUBLE_QUOTE identifier-ref-arg DOUBLE_QUOTE )
  public static boolean identifier_ref_arg_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg_quoted")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTIFIER_REF_ARG_QUOTED, "<identifier ref arg quoted>");
    r = identifier_ref_arg(b, l + 1);
    if (!r) r = identifier_ref_arg_quoted_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE identifier-ref-arg DOUBLE_QUOTE
  private static boolean identifier_ref_arg_quoted_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_ref_arg_quoted_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && identifier_ref_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTITY_KEYWORD sep identifier-arg-quoted optsep
  //  ( identity-sub-stmt | SEMICOLON )
  public static boolean identity_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt")) return false;
    if (!nextTokenIs(b, YANG_IDENTITY_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTITY_STMT, null);
    r = consumeToken(b, YANG_IDENTITY_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && identity_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // identity-sub-stmt | SEMICOLON
  private static boolean identity_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_4")) return false;
    boolean r;
    r = identity_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( base-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean identity_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_IDENTITY_STMT_BODY, "<identity stmt body>");
    r = identity_stmt_body_0(b, l + 1);
    if (!r) r = identity_stmt_body_1(b, l + 1);
    if (!r) r = identity_stmt_body_2(b, l + 1);
    if (!r) r = identity_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // base-stmt stmtsep
  private static boolean identity_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = base_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean identity_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean identity_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean identity_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                               identity-stmt-body *
  //                               RIGHT_BRACE
  static boolean identity_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, identity_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // identity-stmt-body *
  private static boolean identity_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identity_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identity_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identity_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // base-stmt stmtsep
  public static boolean identityref_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identityref_specification")) return false;
    if (!nextTokenIs(b, YANG_BASE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = base_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, YANG_IDENTITYREF_SPECIFICATION, r);
    return r;
  }

  /* ********************************************************** */
  // IF_FEATURE_KEYWORD sep identifier-ref-arg-quoted
  //  optsep stmtend
  public static boolean if_feature_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_feature_stmt")) return false;
    if (!nextTokenIs(b, YANG_IF_FEATURE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_IF_FEATURE_STMT, null);
    r = consumeToken(b, YANG_IF_FEATURE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_ref_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IMPORT_KEYWORD sep identifier-arg-quoted optsep
  //  LEFT_BRACE stmtsep
  //  prefix-stmt stmtsep
  //  ( revision-date-stmt stmtsep ) ?
  //  RIGHT_BRACE  stmtsep
  public static boolean import_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt")) return false;
    if (!nextTokenIs(b, YANG_IMPORT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_IMPORT_STMT, null);
    r = consumeToken(b, YANG_IMPORT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, prefix_stmt(b, l + 1)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, import_stmt_8(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_RIGHT_BRACE)) && r;
    r = p && stmtsep(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( revision-date-stmt stmtsep ) ?
  private static boolean import_stmt_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_8")) return false;
    import_stmt_8_0(b, l + 1);
    return true;
  }

  // revision-date-stmt stmtsep
  private static boolean import_stmt_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stmt_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = revision_date_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INCLUDE_KEYWORD sep identifier-arg-quoted optsep
  //  ( include-stmt-body | SEMICOLON ) stmtsep
  public static boolean include_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt")) return false;
    if (!nextTokenIs(b, YANG_INCLUDE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_INCLUDE_STMT, null);
    r = consumeToken(b, YANG_INCLUDE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, include_stmt_4(b, l + 1)) && r;
    r = p && stmtsep(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // include-stmt-body | SEMICOLON
  private static boolean include_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_4")) return false;
    boolean r;
    r = include_stmt_body(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                       ( revision-date-stmt stmtsep ) ?
  //                       RIGHT_BRACE
  static boolean include_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_body")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, include_stmt_body_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( revision-date-stmt stmtsep ) ?
  private static boolean include_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_body_2")) return false;
    include_stmt_body_2_0(b, l + 1);
    return true;
  }

  // revision-date-stmt stmtsep
  private static boolean include_stmt_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_stmt_body_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = revision_date_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INPUT_KEYWORD optsep
  //  LEFT_BRACE stmtsep
  //  input-stmt-body +
  //  RIGHT_BRACE
  public static boolean input_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt")) return false;
    if (!nextTokenIs(b, YANG_INPUT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_INPUT_STMT, null);
    r = consumeToken(b, YANG_INPUT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, input_stmt_4(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // input-stmt-body +
  private static boolean input_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = input_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!input_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "input_stmt_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( ( typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( data-def-stmt stmtsep )
  public static boolean input_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INPUT_STMT_BODY, "<input stmt body>");
    r = input_stmt_body_0(b, l + 1);
    if (!r) r = input_stmt_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean input_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = input_stmt_body_0_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean input_stmt_body_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_body_0_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean input_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( FORWARD_SLASH ( node-identifier predicate * ) ) +
  public static boolean instance_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instance_identifier_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!instance_identifier_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_identifier", c)) break;
    }
    exit_section_(b, m, YANG_INSTANCE_IDENTIFIER, r);
    return r;
  }

  // FORWARD_SLASH ( node-identifier predicate * )
  private static boolean instance_identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && instance_identifier_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-identifier predicate *
  private static boolean instance_identifier_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier(b, l + 1);
    r = r && instance_identifier_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // predicate *
  private static boolean instance_identifier_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_0_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!predicate(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instance_identifier_0_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // require-instance-stmt stmtsep
  public static boolean instance_identifier_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instance_identifier_specification")) return false;
    if (!nextTokenIs(b, YANG_REQUIRE_INSTANCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = require_instance_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, YANG_INSTANCE_IDENTIFIER_SPECIFICATION, r);
    return r;
  }

  /* ********************************************************** */
  // ("-" non-negative-integer-value) | non-negative-integer-value
  public static boolean integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_INTEGER_VALUE, "<integer value>");
    r = integer_value_0(b, l + 1);
    if (!r) r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "-" non-negative-integer-value
  private static boolean integer_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "-");
    r = r && non_negative_integer_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_QUOTE (("-" non-negative-integer-value) | non-negative-integer-value) DOUBLE_QUOTE
  public static boolean integer_value_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_str")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && integer_value_str_1(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, YANG_INTEGER_VALUE_STR, r);
    return r;
  }

  // ("-" non-negative-integer-value) | non-negative-integer-value
  private static boolean integer_value_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_value_str_1_0(b, l + 1);
    if (!r) r = non_negative_integer_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "-" non-negative-integer-value
  private static boolean integer_value_str_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_value_str_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "-");
    r = r && non_negative_integer_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // node-identifier ( sep node-identifier ) *
  public static boolean key_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_ARG, "<key arg>");
    r = node_identifier(b, l + 1);
    r = r && key_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( sep node-identifier ) *
  private static boolean key_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_arg_1", c)) break;
    }
    return true;
  }

  // sep node-identifier
  private static boolean key_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && node_identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // key-arg | ( DOUBLE_QUOTE key-arg DOUBLE_QUOTE )
  public static boolean key_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_ARG_STR, "<key arg str>");
    r = key_arg(b, l + 1);
    if (!r) r = key_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE key-arg DOUBLE_QUOTE
  private static boolean key_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && key_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KEY_KEYWORD sep key-arg-str stmtend
  public static boolean key_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_stmt")) return false;
    if (!nextTokenIs(b, YANG_KEY_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_KEY_STMT, null);
    r = consumeToken(b, YANG_KEY_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, key_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LEAF_LIST_KEYWORD sep identifier-arg-quoted optsep
  //  LEFT_BRACE stmtsep
  //  leaf-list-stmt-body +
  //  RIGHT_BRACE
  public static boolean leaf_list_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEAF_LIST_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_LIST_STMT, null);
    r = consumeToken(b, YANG_LEAF_LIST_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, leaf_list_stmt_6(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // leaf-list-stmt-body +
  private static boolean leaf_list_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leaf_list_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!leaf_list_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_list_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  (type-stmt stmtsep) |
  //  ( units-stmt stmtsep ) | // ?
  //  ( must-stmt stmtsep ) | // *
  //  ( config-stmt stmtsep ) | // ?
  //  ( min-elements-stmt stmtsep ) | // ?
  //  ( max-elements-stmt stmtsep ) | // ?
  //  ( ordered-by-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean leaf_list_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_LIST_STMT_BODY, "<leaf list stmt body>");
    r = leaf_list_stmt_body_0(b, l + 1);
    if (!r) r = leaf_list_stmt_body_1(b, l + 1);
    if (!r) r = leaf_list_stmt_body_2(b, l + 1);
    if (!r) r = leaf_list_stmt_body_3(b, l + 1);
    if (!r) r = leaf_list_stmt_body_4(b, l + 1);
    if (!r) r = leaf_list_stmt_body_5(b, l + 1);
    if (!r) r = leaf_list_stmt_body_6(b, l + 1);
    if (!r) r = leaf_list_stmt_body_7(b, l + 1);
    if (!r) r = leaf_list_stmt_body_8(b, l + 1);
    if (!r) r = leaf_list_stmt_body_9(b, l + 1);
    if (!r) r = leaf_list_stmt_body_10(b, l + 1);
    if (!r) r = leaf_list_stmt_body_11(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean leaf_list_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean leaf_list_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type-stmt stmtsep
  private static boolean leaf_list_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // units-stmt stmtsep
  private static boolean leaf_list_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = units_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // must-stmt stmtsep
  private static boolean leaf_list_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean leaf_list_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // min-elements-stmt stmtsep
  private static boolean leaf_list_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = min_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // max-elements-stmt stmtsep
  private static boolean leaf_list_stmt_body_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = max_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ordered-by-stmt stmtsep
  private static boolean leaf_list_stmt_body_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ordered_by_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean leaf_list_stmt_body_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean leaf_list_stmt_body_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean leaf_list_stmt_body_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_list_stmt_body_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEAF_KEYWORD sep identifier-arg-quoted optsep
  //  LEFT_BRACE stmtsep
  //  leaf-stmt-body +
  //  RIGHT_BRACE
  public static boolean leaf_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEAF_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_STMT, null);
    r = consumeToken(b, YANG_LEAF_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, leaf_stmt_6(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // leaf-stmt-body +
  private static boolean leaf_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leaf_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!leaf_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leaf_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( type-stmt stmtsep) |
  //  ( units-stmt stmtsep ) | // ?
  //  ( must-stmt stmtsep ) | // *
  //  ( default-stmt stmtsep ) | // ?
  //  ( config-stmt stmtsep ) | // ?
  //  ( mandatory-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean leaf_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAF_STMT_BODY, "<leaf stmt body>");
    r = leaf_stmt_body_0(b, l + 1);
    if (!r) r = leaf_stmt_body_1(b, l + 1);
    if (!r) r = leaf_stmt_body_2(b, l + 1);
    if (!r) r = leaf_stmt_body_3(b, l + 1);
    if (!r) r = leaf_stmt_body_4(b, l + 1);
    if (!r) r = leaf_stmt_body_5(b, l + 1);
    if (!r) r = leaf_stmt_body_6(b, l + 1);
    if (!r) r = leaf_stmt_body_7(b, l + 1);
    if (!r) r = leaf_stmt_body_8(b, l + 1);
    if (!r) r = leaf_stmt_body_9(b, l + 1);
    if (!r) r = leaf_stmt_body_10(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean leaf_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean leaf_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type-stmt stmtsep
  private static boolean leaf_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // units-stmt stmtsep
  private static boolean leaf_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = units_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // must-stmt stmtsep
  private static boolean leaf_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // default-stmt stmtsep
  private static boolean leaf_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean leaf_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mandatory-stmt stmtsep
  private static boolean leaf_stmt_body_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean leaf_stmt_body_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean leaf_stmt_body_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean leaf_stmt_body_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leaf_stmt_body_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // leafref-specification-body +
  public static boolean leafref_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leafref_specification")) return false;
    if (!nextTokenIs(b, "<leafref specification>", YANG_PATH_KEYWORD, YANG_REQUIRE_INSTANCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAFREF_SPECIFICATION, "<leafref specification>");
    r = leafref_specification_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!leafref_specification_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "leafref_specification", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (path-stmt stmtsep) |
  //  ( require-instance-stmt stmtsep )
  public static boolean leafref_specification_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leafref_specification_body")) return false;
    if (!nextTokenIs(b, "<leafref specification body>", YANG_PATH_KEYWORD, YANG_REQUIRE_INSTANCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LEAFREF_SPECIFICATION_BODY, "<leafref specification body>");
    r = leafref_specification_body_0(b, l + 1);
    if (!r) r = leafref_specification_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path-stmt stmtsep
  private static boolean leafref_specification_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leafref_specification_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // require-instance-stmt stmtsep
  private static boolean leafref_specification_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leafref_specification_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = require_instance_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // length-part ( optsep PIPE optsep length-part ) *
  public static boolean length_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_ARG, "<length arg>");
    r = length_part(b, l + 1);
    r = r && length_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( optsep PIPE optsep length-part ) *
  private static boolean length_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!length_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "length_arg_1", c)) break;
    }
    return true;
  }

  // optsep PIPE optsep length-part
  private static boolean length_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_PIPE);
    r = r && optsep(b, l + 1);
    r = r && length_part(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // length-arg | ( DOUBLE_QUOTE length-arg DOUBLE_QUOTE )
  public static boolean length_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_ARG_STR, "<length arg str>");
    r = length_arg(b, l + 1);
    if (!r) r = length_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE length-arg DOUBLE_QUOTE
  private static boolean length_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && length_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MIN_KEYWORD | MAX_KEYWORD |
  //  non-negative-integer-value
  public static boolean length_boundary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_boundary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_BOUNDARY, "<length boundary>");
    r = consumeToken(b, YANG_MIN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MAX_KEYWORD);
    if (!r) r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // length-boundary
  //  ( optsep DOUBLE_DOT optsep length-boundary ) ?
  public static boolean length_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_PART, "<length part>");
    r = length_boundary(b, l + 1);
    r = r && length_part_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( optsep DOUBLE_DOT optsep length-boundary ) ?
  private static boolean length_part_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_part_1")) return false;
    length_part_1_0(b, l + 1);
    return true;
  }

  // optsep DOUBLE_DOT optsep length-boundary
  private static boolean length_part_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_part_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_DOT);
    r = r && optsep(b, l + 1);
    r = r && length_boundary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LENGTH_KEYWORD sep length-arg-str optsep
  //  ( length-sub-stmt | SEMICOLON )
  public static boolean length_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt")) return false;
    if (!nextTokenIs(b, YANG_LENGTH_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_STMT, null);
    r = consumeToken(b, YANG_LENGTH_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, length_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && length_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // length-sub-stmt | SEMICOLON
  private static boolean length_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_4")) return false;
    boolean r;
    r = length_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( error-message-stmt stmtsep ) | // ?
  //  ( error-app-tag-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean length_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LENGTH_STMT_BODY, "<length stmt body>");
    r = length_stmt_body_0(b, l + 1);
    if (!r) r = length_stmt_body_1(b, l + 1);
    if (!r) r = length_stmt_body_2(b, l + 1);
    if (!r) r = length_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // error-message-stmt stmtsep
  private static boolean length_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_message_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // error-app-tag-stmt stmtsep
  private static boolean length_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_app_tag_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean length_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean length_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                             length-stmt-body *
  //                             RIGHT_BRACE
  static boolean length_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, length_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // length-stmt-body *
  private static boolean length_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "length_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!length_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "length_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CRLF | LF
  static boolean line_break(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_break")) return false;
    boolean r;
    r = CRLF(b, l + 1);
    if (!r) r = LF(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // linkage-stmts-body +
  public static boolean linkage_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LINKAGE_STMTS, "<linkage stmts>");
    r = linkage_stmts_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!linkage_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "linkage_stmts", c)) break;
    }
    exit_section_(b, l, m, r, false, YangParser::recover_rule_linkage);
    return r;
  }

  /* ********************************************************** */
  // ( import-stmt stmtsep ) | // *
  //  ( include-stmt stmtsep )
  public static boolean linkage_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts_body")) return false;
    if (!nextTokenIs(b, "<linkage stmts body>", YANG_IMPORT_KEYWORD, YANG_INCLUDE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LINKAGE_STMTS_BODY, "<linkage stmts body>");
    r = linkage_stmts_body_0(b, l + 1);
    if (!r) r = linkage_stmts_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // import-stmt stmtsep
  private static boolean linkage_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = import_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // include-stmt stmtsep
  private static boolean linkage_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linkage_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = include_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LIST_KEYWORD sep identifier-arg-quoted optsep
  //  LEFT_BRACE stmtsep
  //  list-stmt-body +
  //  RIGHT_BRACE
  //  stmtsep
  public static boolean list_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt")) return false;
    if (!nextTokenIs(b, YANG_LIST_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_LIST_STMT, null);
    r = consumeToken(b, YANG_LIST_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, list_stmt_6(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_RIGHT_BRACE)) && r;
    r = p && stmtsep(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // list-stmt-body +
  private static boolean list_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!list_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( must-stmt stmtsep ) | // *
  //  ( key-stmt stmtsep ) | // ?
  //  ( unique-stmt stmtsep ) | // *
  //  ( config-stmt stmtsep ) | // ?
  //  ( min-elements-stmt stmtsep ) | // ?
  //  ( max-elements-stmt stmtsep ) | // ?
  //  ( ordered-by-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( data-def-stmt stmtsep )
  public static boolean list_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LIST_STMT_BODY, "<list stmt body>");
    r = list_stmt_body_0(b, l + 1);
    if (!r) r = list_stmt_body_1(b, l + 1);
    if (!r) r = list_stmt_body_2(b, l + 1);
    if (!r) r = list_stmt_body_3(b, l + 1);
    if (!r) r = list_stmt_body_4(b, l + 1);
    if (!r) r = list_stmt_body_5(b, l + 1);
    if (!r) r = list_stmt_body_6(b, l + 1);
    if (!r) r = list_stmt_body_7(b, l + 1);
    if (!r) r = list_stmt_body_8(b, l + 1);
    if (!r) r = list_stmt_body_9(b, l + 1);
    if (!r) r = list_stmt_body_10(b, l + 1);
    if (!r) r = list_stmt_body_11(b, l + 1);
    if (!r) r = list_stmt_body_12(b, l + 1);
    if (!r) r = list_stmt_body_13(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean list_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean list_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // must-stmt stmtsep
  private static boolean list_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // key-stmt stmtsep
  private static boolean list_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unique-stmt stmtsep
  private static boolean list_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unique_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean list_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // min-elements-stmt stmtsep
  private static boolean list_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = min_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // max-elements-stmt stmtsep
  private static boolean list_stmt_body_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = max_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ordered-by-stmt stmtsep
  private static boolean list_stmt_body_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ordered_by_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean list_stmt_body_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean list_stmt_body_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean list_stmt_body_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean list_stmt_body_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_stmt_body_12_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean list_stmt_body_12_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_12_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean list_stmt_body_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_stmt_body_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( h16 ":" h16 ) | IPv4address
  public static boolean ls32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ls32")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_LS_32, "<ls 32>");
    r = ls32_0(b, l + 1);
    if (!r) r = IPv4address(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // h16 ":" h16
  private static boolean ls32_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ls32_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = h16(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && h16(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD | FALSE_KEYWORD
  public static boolean mandatory_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_arg")) return false;
    if (!nextTokenIs(b, "<mandatory arg>", YANG_FALSE_KEYWORD, YANG_TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MANDATORY_ARG, "<mandatory arg>");
    r = consumeToken(b, YANG_TRUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FALSE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // mandatory-arg | ( DOUBLE_QUOTE mandatory-arg DOUBLE_QUOTE )
  public static boolean mandatory_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MANDATORY_ARG_STR, "<mandatory arg str>");
    r = mandatory_arg(b, l + 1);
    if (!r) r = mandatory_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE mandatory-arg DOUBLE_QUOTE
  private static boolean mandatory_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && mandatory_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MANDATORY_KEYWORD sep
  //  mandatory-arg-str stmtend
  public static boolean mandatory_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mandatory_stmt")) return false;
    if (!nextTokenIs(b, YANG_MANDATORY_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_MANDATORY_STMT, null);
    r = consumeToken(b, YANG_MANDATORY_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, mandatory_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MAX_ELEMENTS_KEYWORD sep
  //  max-value-arg-str stmtend
  public static boolean max_elements_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_elements_stmt")) return false;
    if (!nextTokenIs(b, YANG_MAX_ELEMENTS_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_ELEMENTS_STMT, null);
    r = consumeToken(b, YANG_MAX_ELEMENTS_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, max_value_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // UNBOUNDED_KEYWORD |
  //  positive-integer-value
  public static boolean max_value_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_value_arg")) return false;
    if (!nextTokenIs(b, "<max value arg>", YANG_POSITIVE_NUMBER, YANG_UNBOUNDED_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_VALUE_ARG, "<max value arg>");
    r = consumeToken(b, YANG_UNBOUNDED_KEYWORD);
    if (!r) r = positive_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // max-value-arg | ( DOUBLE_QUOTE max-value-arg DOUBLE_QUOTE )
  public static boolean max_value_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_value_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MAX_VALUE_ARG_STR, "<max value arg str>");
    r = max_value_arg(b, l + 1);
    if (!r) r = max_value_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE max-value-arg DOUBLE_QUOTE
  private static boolean max_value_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_value_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && max_value_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // meta-stmts-body +
  public static boolean meta_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_META_STMTS, "<meta stmts>");
    r = meta_stmts_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!meta_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "meta_stmts", c)) break;
    }
    exit_section_(b, l, m, r, false, YangParser::recover_rule_meta);
    return r;
  }

  /* ********************************************************** */
  // ( organization-stmt stmtsep ) | // ?
  //  ( contact-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean meta_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_META_STMTS_BODY, "<meta stmts body>");
    r = meta_stmts_body_0(b, l + 1);
    if (!r) r = meta_stmts_body_1(b, l + 1);
    if (!r) r = meta_stmts_body_2(b, l + 1);
    if (!r) r = meta_stmts_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // organization-stmt stmtsep
  private static boolean meta_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = organization_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // contact-stmt stmtsep
  private static boolean meta_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = contact_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean meta_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean meta_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MIN_ELEMENTS_KEYWORD sep
  //  min-value-arg-str stmtend
  public static boolean min_elements_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_elements_stmt")) return false;
    if (!nextTokenIs(b, YANG_MIN_ELEMENTS_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_ELEMENTS_STMT, null);
    r = consumeToken(b, YANG_MIN_ELEMENTS_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, min_value_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // non-negative-integer-value
  public static boolean min_value_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_value_arg")) return false;
    if (!nextTokenIs(b, "<min value arg>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_VALUE_ARG, "<min value arg>");
    r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // min-value-arg | ( DOUBLE_QUOTE min-value-arg DOUBLE_QUOTE )
  public static boolean min_value_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_value_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MIN_VALUE_ARG_STR, "<min value arg str>");
    r = min_value_arg(b, l + 1);
    if (!r) r = min_value_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE min-value-arg DOUBLE_QUOTE
  private static boolean min_value_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_value_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && min_value_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // module-header-stmts-body +
  public static boolean module_header_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_header_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODULE_HEADER_STMTS, "<module header stmts>");
    r = module_header_stmts_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!module_header_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_header_stmts", c)) break;
    }
    exit_section_(b, l, m, r, false, YangParser::recover_rule_header);
    return r;
  }

  /* ********************************************************** */
  // ( yang-version-stmt stmtsep ) | // ?
  //  namespace-stmt stmtsep |
  //  prefix-stmt stmtsep
  public static boolean module_header_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_header_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODULE_HEADER_STMTS_BODY, "<module header stmts body>");
    r = module_header_stmts_body_0(b, l + 1);
    if (!r) r = module_header_stmts_body_1(b, l + 1);
    if (!r) r = module_header_stmts_body_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // yang-version-stmt stmtsep
  private static boolean module_header_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_header_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = yang_version_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // namespace-stmt stmtsep
  private static boolean module_header_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_header_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespace_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefix-stmt stmtsep
  private static boolean module_header_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_header_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // optsep MODULE_KEYWORD sep identifier-arg-quoted
  //  optsep
  //  LEFT_BRACE stmtsep
  //  module-header-stmts?
  //  linkage-stmts?
  //  meta-stmts?
  //  revision-stmts?
  //  body-stmts?
  //  RIGHT_BRACE optsep
  public static boolean module_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_MODULE_STMT, "<module stmt>");
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_MODULE_KEYWORD);
    p = r; // pin = 2
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, module_stmt_7(b, l + 1)) && r;
    r = p && report_error_(b, module_stmt_8(b, l + 1)) && r;
    r = p && report_error_(b, module_stmt_9(b, l + 1)) && r;
    r = p && report_error_(b, module_stmt_10(b, l + 1)) && r;
    r = p && report_error_(b, module_stmt_11(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_RIGHT_BRACE)) && r;
    r = p && optsep(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // module-header-stmts?
  private static boolean module_stmt_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt_7")) return false;
    module_header_stmts(b, l + 1);
    return true;
  }

  // linkage-stmts?
  private static boolean module_stmt_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt_8")) return false;
    linkage_stmts(b, l + 1);
    return true;
  }

  // meta-stmts?
  private static boolean module_stmt_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt_9")) return false;
    meta_stmts(b, l + 1);
    return true;
  }

  // revision-stmts?
  private static boolean module_stmt_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt_10")) return false;
    revision_stmts(b, l + 1);
    return true;
  }

  // body-stmts?
  private static boolean module_stmt_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_stmt_11")) return false;
    body_stmts(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MUST_KEYWORD sep string optsep
  //  ( must-sub-stmt | SEMICOLON )
  public static boolean must_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt")) return false;
    if (!nextTokenIs(b, YANG_MUST_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_MUST_STMT, null);
    r = consumeToken(b, YANG_MUST_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && must_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // must-sub-stmt | SEMICOLON
  private static boolean must_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_4")) return false;
    boolean r;
    r = must_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( error-message-stmt stmtsep ) | // ?
  //  ( error-app-tag-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean must_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_MUST_STMT_BODY, "<must stmt body>");
    r = must_stmt_body_0(b, l + 1);
    if (!r) r = must_stmt_body_1(b, l + 1);
    if (!r) r = must_stmt_body_2(b, l + 1);
    if (!r) r = must_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // error-message-stmt stmtsep
  private static boolean must_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_message_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // error-app-tag-stmt stmtsep
  private static boolean must_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_app_tag_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean must_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean must_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                            must-stmt-body *
  //                            RIGHT_BRACE
  static boolean must_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, must_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // must-stmt-body *
  private static boolean must_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "must_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!must_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "must_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NAMESPACE_KEYWORD sep uri-str optsep stmtend
  public static boolean namespace_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_stmt")) return false;
    if (!nextTokenIs(b, YANG_NAMESPACE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_NAMESPACE_STMT, null);
    r = consumeToken(b, YANG_NAMESPACE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, uri_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LINEFEED | CARRIAGE_RETURN
  public static boolean new_line_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_line_characters")) return false;
    if (!nextTokenIs(b, "<new line characters>", YANG_CARRIAGE_RETURN, YANG_LINEFEED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NEW_LINE_CHARACTERS, "<new line characters>");
    r = consumeToken(b, YANG_LINEFEED);
    if (!r) r = consumeToken(b, YANG_CARRIAGE_RETURN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( prefix COLON )? identifier
  public static boolean node_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NODE_IDENTIFIER, "<node identifier>");
    r = node_identifier_0(b, l + 1);
    r = r && identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( prefix COLON )?
  private static boolean node_identifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_0")) return false;
    node_identifier_0_0(b, l + 1);
    return true;
  }

  // prefix COLON
  private static boolean node_identifier_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (STRING_SPLITTER? prefix-quoted STRING_SPLITTER? COLON ) ? STRING_SPLITTER? identifier-quoted
  public static boolean node_identifier_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_quoted")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NODE_IDENTIFIER_QUOTED, "<node identifier quoted>");
    r = node_identifier_quoted_0(b, l + 1);
    r = r && node_identifier_quoted_1(b, l + 1);
    r = r && identifier_quoted(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (STRING_SPLITTER? prefix-quoted STRING_SPLITTER? COLON ) ?
  private static boolean node_identifier_quoted_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_quoted_0")) return false;
    node_identifier_quoted_0_0(b, l + 1);
    return true;
  }

  // STRING_SPLITTER? prefix-quoted STRING_SPLITTER? COLON
  private static boolean node_identifier_quoted_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_quoted_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier_quoted_0_0_0(b, l + 1);
    r = r && prefix_quoted(b, l + 1);
    r = r && node_identifier_quoted_0_0_2(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean node_identifier_quoted_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_quoted_0_0_0")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean node_identifier_quoted_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_quoted_0_0_2")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean node_identifier_quoted_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_identifier_quoted_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ZERO | positive-integer-value
  public static boolean non_negative_integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_negative_integer_value")) return false;
    if (!nextTokenIs(b, "<non negative integer value>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NON_NEGATIVE_INTEGER_VALUE, "<non negative integer value>");
    r = consumeToken(b, YANG_ZERO);
    if (!r) r = positive_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (identifier-literal | unquoted-string-body-characters)+
  public static boolean non_quoted_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_quoted_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NON_QUOTED_STRING, "<non quoted string>");
    r = non_quoted_string_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!non_quoted_string_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "non_quoted_string", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier-literal | unquoted-string-body-characters
  private static boolean non_quoted_string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_quoted_string_0")) return false;
    boolean r;
    r = identifier_literal(b, l + 1);
    if (!r) r = unquoted_string_body_characters(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // POSITIVE_NUMBER
  public static boolean non_zero_digit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_zero_digit")) return false;
    if (!nextTokenIs(b, YANG_POSITIVE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_POSITIVE_NUMBER);
    exit_section_(b, m, YANG_NON_ZERO_DIGIT, r);
    return r;
  }

  /* ********************************************************** */
  // NOTIFICATION_KEYWORD sep
  //  identifier-arg-quoted optsep
  //  ( notification-sub-stmt | SEMICOLON )
  public static boolean notification_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt")) return false;
    if (!nextTokenIs(b, YANG_NOTIFICATION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOTIFICATION_STMT, null);
    r = consumeToken(b, YANG_NOTIFICATION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && notification_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // notification-sub-stmt | SEMICOLON
  private static boolean notification_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_4")) return false;
    boolean r;
    r = notification_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( data-def-stmt stmtsep )
  public static boolean notification_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_NOTIFICATION_STMT_BODY, "<notification stmt body>");
    r = notification_stmt_body_0(b, l + 1);
    if (!r) r = notification_stmt_body_1(b, l + 1);
    if (!r) r = notification_stmt_body_2(b, l + 1);
    if (!r) r = notification_stmt_body_3(b, l + 1);
    if (!r) r = notification_stmt_body_4(b, l + 1);
    if (!r) r = notification_stmt_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean notification_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean notification_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean notification_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean notification_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean notification_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = notification_stmt_body_4_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean notification_stmt_body_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_4_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean notification_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                               notification-stmt-body *
  //                               RIGHT_BRACE
  static boolean notification_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, notification_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // notification-stmt-body *
  private static boolean notification_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notification_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!notification_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "notification_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // range-stmt stmtsep
  public static boolean numerical_restrictions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numerical_restrictions")) return false;
    if (!nextTokenIs(b, YANG_RANGE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = range_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, YANG_NUMERICAL_RESTRICTIONS, r);
    return r;
  }

  /* ********************************************************** */
  // ( WSP | line-break )*
  static boolean optsep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optsep")) return false;
    while (true) {
      int c = current_position_(b);
      if (!optsep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "optsep", c)) break;
    }
    return true;
  }

  // WSP | line-break
  private static boolean optsep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optsep_0")) return false;
    boolean r;
    r = WSP(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // USER_KEYWORD | SYSTEM_KEYWORD
  public static boolean ordered_by_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_arg")) return false;
    if (!nextTokenIs(b, "<ordered by arg>", YANG_SYSTEM_KEYWORD, YANG_USER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORDERED_BY_ARG, "<ordered by arg>");
    r = consumeToken(b, YANG_USER_KEYWORD);
    if (!r) r = consumeToken(b, YANG_SYSTEM_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ordered-by-arg | ( DOUBLE_QUOTE ordered-by-arg DOUBLE_QUOTE )
  public static boolean ordered_by_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORDERED_BY_ARG_STR, "<ordered by arg str>");
    r = ordered_by_arg(b, l + 1);
    if (!r) r = ordered_by_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE ordered-by-arg DOUBLE_QUOTE
  private static boolean ordered_by_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && ordered_by_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ORDERED_BY_KEYWORD sep
  //  ordered-by-arg-str stmtend
  public static boolean ordered_by_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ordered_by_stmt")) return false;
    if (!nextTokenIs(b, YANG_ORDERED_BY_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORDERED_BY_STMT, null);
    r = consumeToken(b, YANG_ORDERED_BY_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, ordered_by_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ORGANIZATION_KEYWORD sep string
  //  optsep stmtend
  public static boolean organization_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "organization_stmt")) return false;
    if (!nextTokenIs(b, YANG_ORGANIZATION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_ORGANIZATION_STMT, null);
    r = consumeToken(b, YANG_ORGANIZATION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // OUTPUT_KEYWORD optsep
  //  LEFT_BRACE stmtsep
  //  output-stmt-body +
  //  RIGHT_BRACE
  public static boolean output_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt")) return false;
    if (!nextTokenIs(b, YANG_OUTPUT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_OUTPUT_STMT, null);
    r = consumeToken(b, YANG_OUTPUT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, optsep(b, l + 1));
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, output_stmt_4(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // output-stmt-body +
  private static boolean output_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = output_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!output_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "output_stmt_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( ( typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( data-def-stmt stmtsep )
  public static boolean output_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_OUTPUT_STMT_BODY, "<output stmt body>");
    r = output_stmt_body_0(b, l + 1);
    if (!r) r = output_stmt_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean output_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = output_stmt_body_0_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean output_stmt_body_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_body_0_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean output_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( FORWARD_SLASH segment ) *
  public static boolean path_abempty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_abempty")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ABEMPTY, "<path abempty>");
    while (true) {
      int c = current_position_(b);
      if (!path_abempty_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_abempty", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_abempty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_abempty_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FORWARD_SLASH ( segment-nz ( FORWARD_SLASH segment ) * ) ?
  public static boolean path_absolute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute")) return false;
    if (!nextTokenIs(b, YANG_FORWARD_SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && path_absolute_1(b, l + 1);
    exit_section_(b, m, YANG_PATH_ABSOLUTE, r);
    return r;
  }

  // ( segment-nz ( FORWARD_SLASH segment ) * ) ?
  private static boolean path_absolute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1")) return false;
    path_absolute_1_0(b, l + 1);
    return true;
  }

  // segment-nz ( FORWARD_SLASH segment ) *
  private static boolean path_absolute_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = segment_nz(b, l + 1);
    r = r && path_absolute_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( FORWARD_SLASH segment ) *
  private static boolean path_absolute_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_absolute_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_absolute_1_0_1", c)) break;
    }
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_absolute_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_absolute_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // absolute-path | relative-path
  public static boolean path_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ARG, "<path arg>");
    r = absolute_path(b, l + 1);
    if (!r) r = relative_path(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // path-arg | ( DOUBLE_QUOTE path-arg DOUBLE_QUOTE )
  public static boolean path_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ARG_STR, "<path arg str>");
    r = path_arg(b, l + 1);
    if (!r) r = path_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE path-arg DOUBLE_QUOTE
  private static boolean path_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && path_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pchar
  public static boolean path_empty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_empty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_EMPTY, "<path empty>");
    r = pchar(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // node-identifier (WSP STRING_SPLITTER?)* STRING_SPLITTER? EQUAL STRING_SPLITTER? (WSP STRING_SPLITTER?)* path-key-expr
  public static boolean path_equality_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_EQUALITY_EXPR, "<path equality expr>");
    r = node_identifier(b, l + 1);
    r = r && path_equality_expr_1(b, l + 1);
    r = r && path_equality_expr_2(b, l + 1);
    r = r && consumeToken(b, YANG_EQUAL);
    r = r && path_equality_expr_4(b, l + 1);
    r = r && path_equality_expr_5(b, l + 1);
    r = r && path_key_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean path_equality_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_equality_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_equality_expr_1", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean path_equality_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && path_equality_expr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_equality_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_1_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean path_equality_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_2")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean path_equality_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_4")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean path_equality_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_equality_expr_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_equality_expr_5", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean path_equality_expr_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && path_equality_expr_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_equality_expr_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_equality_expr_5_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING_SPLITTER? current-function-invocation STRING_SPLITTER? (WSP STRING_SPLITTER?)* FORWARD_SLASH STRING_SPLITTER? (WSP STRING_SPLITTER?)*
  //  rel-path-keyexpr
  public static boolean path_key_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_KEY_EXPR, "<path key expr>");
    r = path_key_expr_0(b, l + 1);
    r = r && current_function_invocation(b, l + 1);
    r = r && path_key_expr_2(b, l + 1);
    r = r && path_key_expr_3(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && path_key_expr_5(b, l + 1);
    r = r && path_key_expr_6(b, l + 1);
    r = r && rel_path_keyexpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_key_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_0")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean path_key_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_2")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean path_key_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_key_expr_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_key_expr_3", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean path_key_expr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && path_key_expr_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_key_expr_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_3_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean path_key_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_5")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean path_key_expr_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_key_expr_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_key_expr_6", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean path_key_expr_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && path_key_expr_6_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_key_expr_6_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_key_expr_6_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET STRING_SPLITTER? (WSP STRING_SPLITTER?)* path-equality-expr (WSP STRING_SPLITTER?)* STRING_SPLITTER? CLOSED_BRACKET STRING_SPLITTER?
  public static boolean path_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && path_predicate_1(b, l + 1);
    r = r && path_predicate_2(b, l + 1);
    r = r && path_equality_expr(b, l + 1);
    r = r && path_predicate_4(b, l + 1);
    r = r && path_predicate_5(b, l + 1);
    r = r && consumeToken(b, YANG_CLOSED_BRACKET);
    r = r && path_predicate_7(b, l + 1);
    exit_section_(b, m, YANG_PATH_PREDICATE, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean path_predicate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_predicate_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_predicate_2", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean path_predicate_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && path_predicate_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_predicate_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_2_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // (WSP STRING_SPLITTER?)*
  private static boolean path_predicate_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_predicate_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_predicate_4", c)) break;
    }
    return true;
  }

  // WSP STRING_SPLITTER?
  private static boolean path_predicate_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WSP(b, l + 1);
    r = r && path_predicate_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean path_predicate_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_4_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean path_predicate_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_5")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean path_predicate_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_predicate_7")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // segment-nz ( FORWARD_SLASH segment ) *
  public static boolean path_rootless(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_rootless")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_ROOTLESS, "<path rootless>");
    r = segment_nz(b, l + 1);
    r = r && path_rootless_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( FORWARD_SLASH segment ) *
  private static boolean path_rootless_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_rootless_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_rootless_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_rootless_1", c)) break;
    }
    return true;
  }

  // FORWARD_SLASH segment
  private static boolean path_rootless_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_rootless_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_FORWARD_SLASH);
    r = r && segment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PATH_KEYWORD sep path-arg-str stmtend
  public static boolean path_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_stmt")) return false;
    if (!nextTokenIs(b, YANG_PATH_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATH_STMT, null);
    r = consumeToken(b, YANG_PATH_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, path_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PATTERN_KEYWORD sep string optsep
  //  ( pattern-sub-stmt | SEMICOLON )
  public static boolean pattern_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt")) return false;
    if (!nextTokenIs(b, YANG_PATTERN_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATTERN_STMT, null);
    r = consumeToken(b, YANG_PATTERN_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && pattern_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // pattern-sub-stmt | SEMICOLON
  private static boolean pattern_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_4")) return false;
    boolean r;
    r = pattern_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( error-message-stmt stmtsep ) | // ?
  //  ( error-app-tag-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean pattern_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PATTERN_STMT_BODY, "<pattern stmt body>");
    r = pattern_stmt_body_0(b, l + 1);
    if (!r) r = pattern_stmt_body_1(b, l + 1);
    if (!r) r = pattern_stmt_body_2(b, l + 1);
    if (!r) r = pattern_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // error-message-stmt stmtsep
  private static boolean pattern_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_message_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // error-app-tag-stmt stmtsep
  private static boolean pattern_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_app_tag_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean pattern_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean pattern_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                              pattern-stmt-body *
  //                              RIGHT_BRACE
  static boolean pattern_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, pattern_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // pattern-stmt-body *
  private static boolean pattern_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // unreserved | pct-encoded | sub-delims | COLON | "@" | identifier-literal
  public static boolean pchar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pchar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PCHAR, "<pchar>");
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_COLON);
    if (!r) r = consumeToken(b, "@");
    if (!r) r = identifier_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "%" HEXDIG HEXDIG
  public static boolean pct_encoded(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pct_encoded")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PCT_ENCODED, "<pct encoded>");
    r = consumeToken(b, "%");
    r = r && HEXDIG(b, l + 1);
    r = r && HEXDIG(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DIGIT *
  public static boolean port(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "port")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_PORT, "<port>");
    while (true) {
      int c = current_position_(b);
      if (!DIGIT(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "port", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // non-negative-integer-value
  public static boolean pos(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pos")) return false;
    if (!nextTokenIs(b, "<pos>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_POS, "<pos>");
    r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // POSITION_KEYWORD sep
  //  position-value-arg-str stmtend
  public static boolean position_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_stmt")) return false;
    if (!nextTokenIs(b, YANG_POSITION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_POSITION_STMT, null);
    r = consumeToken(b, YANG_POSITION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, position_value_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // non-negative-integer-value
  public static boolean position_value_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_value_arg")) return false;
    if (!nextTokenIs(b, "<position value arg>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_POSITION_VALUE_ARG, "<position value arg>");
    r = non_negative_integer_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // position-value-arg | ( DOUBLE_QUOTE position-value-arg DOUBLE_QUOTE )
  public static boolean position_value_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_value_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_POSITION_VALUE_ARG_STR, "<position value arg str>");
    r = position_value_arg(b, l + 1);
    if (!r) r = position_value_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE position-value-arg DOUBLE_QUOTE
  private static boolean position_value_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "position_value_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && position_value_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // non-zero-digit DIGIT*
  public static boolean positive_integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positive_integer_value")) return false;
    if (!nextTokenIs(b, YANG_POSITIVE_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_zero_digit(b, l + 1);
    r = r && positive_integer_value_1(b, l + 1);
    exit_section_(b, m, YANG_POSITIVE_INTEGER_VALUE, r);
    return r;
  }

  // DIGIT*
  private static boolean positive_integer_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positive_integer_value_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DIGIT(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "positive_integer_value_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OPEN_BRACKET WSP * ( predicate-expr | pos ) * WSP "] ?"
  public static boolean predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate")) return false;
    if (!nextTokenIs(b, YANG_OPEN_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_OPEN_BRACKET);
    r = r && predicate_1(b, l + 1);
    r = r && predicate_2(b, l + 1);
    r = r && WSP(b, l + 1);
    r = r && consumeToken(b, "] ?");
    exit_section_(b, m, YANG_PREDICATE, r);
    return r;
  }

  // WSP *
  private static boolean predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "predicate_1", c)) break;
    }
    return true;
  }

  // ( predicate-expr | pos ) *
  private static boolean predicate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!predicate_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "predicate_2", c)) break;
    }
    return true;
  }

  // predicate-expr | pos
  private static boolean predicate_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_2_0")) return false;
    boolean r;
    r = predicate_expr(b, l + 1);
    if (!r) r = pos(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( node-identifier | DOT ) WSP * EQUAL WSP *
  //  ( ( DOUBLE_QUOTE non-quoted-string DOUBLE_QUOTE ) |
  //  ( SINGLE_QUOTE non-quoted-string SINGLE_QUOTE ) )
  public static boolean predicate_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREDICATE_EXPR, "<predicate expr>");
    r = predicate_expr_0(b, l + 1);
    r = r && predicate_expr_1(b, l + 1);
    r = r && consumeToken(b, YANG_EQUAL);
    r = r && predicate_expr_3(b, l + 1);
    r = r && predicate_expr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // node-identifier | DOT
  private static boolean predicate_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr_0")) return false;
    boolean r;
    r = node_identifier(b, l + 1);
    if (!r) r = consumeToken(b, YANG_DOT);
    return r;
  }

  // WSP *
  private static boolean predicate_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "predicate_expr_1", c)) break;
    }
    return true;
  }

  // WSP *
  private static boolean predicate_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "predicate_expr_3", c)) break;
    }
    return true;
  }

  // ( DOUBLE_QUOTE non-quoted-string DOUBLE_QUOTE ) |
  //  ( SINGLE_QUOTE non-quoted-string SINGLE_QUOTE )
  private static boolean predicate_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = predicate_expr_4_0(b, l + 1);
    if (!r) r = predicate_expr_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOUBLE_QUOTE non-quoted-string DOUBLE_QUOTE
  private static boolean predicate_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && non_quoted_string(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // SINGLE_QUOTE non-quoted-string SINGLE_QUOTE
  private static boolean predicate_expr_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_expr_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SINGLE_QUOTE);
    r = r && non_quoted_string(b, l + 1);
    r = r && consumeToken(b, YANG_SINGLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX, "<prefix>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefix
  public static boolean prefix_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_ARG, "<prefix arg>");
    r = prefix(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefix-quoted
  public static boolean prefix_arg_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_arg_quoted")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_ARG_QUOTED, "<prefix arg quoted>");
    r = prefix_quoted(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefix-arg | ( DOUBLE_QUOTE prefix-arg-quoted DOUBLE_QUOTE )
  public static boolean prefix_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_ARG_STR, "<prefix arg str>");
    r = prefix_arg(b, l + 1);
    if (!r) r = prefix_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE prefix-arg-quoted DOUBLE_QUOTE
  private static boolean prefix_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && prefix_arg_quoted(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-quoted
  public static boolean prefix_quoted(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_quoted")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_QUOTED, "<prefix quoted>");
    r = identifier_quoted(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PREFIX_KEYWORD sep prefix-arg-str
  //  optsep stmtend
  public static boolean prefix_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_stmt")) return false;
    if (!nextTokenIs(b, YANG_PREFIX_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_PREFIX_STMT, null);
    r = consumeToken(b, YANG_PREFIX_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, prefix_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PRESENCE_KEYWORD sep string stmtend
  public static boolean presence_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "presence_stmt")) return false;
    if (!nextTokenIs(b, YANG_PRESENCE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_PRESENCE_STMT, null);
    r = consumeToken(b, YANG_PRESENCE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ( pchar | FORWARD_SLASH | "?" ) *
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_QUERY, "<query>");
    while (true) {
      int c = current_position_(b);
      if (!query_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "query", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // pchar | FORWARD_SLASH | "?"
  private static boolean query_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_0")) return false;
    boolean r;
    r = pchar(b, l + 1);
    if (!r) r = consumeToken(b, YANG_FORWARD_SLASH);
    if (!r) r = consumeToken(b, "?");
    return r;
  }

  /* ********************************************************** */
  // new-line-characters | VCHAR | SP | HTAB | identifier-literal | SINGLE_LINE_COMMENT_START
  //     | STRINGS_DOUBLE_QUOTE | STRINGS_SINGLE_QUOTE
  public static boolean quoted_string_body_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quoted_string_body_characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_QUOTED_STRING_BODY_CHARACTERS, "<quoted string body characters>");
    r = new_line_characters(b, l + 1);
    if (!r) r = VCHAR(b, l + 1);
    if (!r) r = SP(b, l + 1);
    if (!r) r = HTAB(b, l + 1);
    if (!r) r = identifier_literal(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    if (!r) r = consumeToken(b, YANG_STRINGS_DOUBLE_QUOTE);
    if (!r) r = consumeToken(b, YANG_STRINGS_SINGLE_QUOTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // range-part ( optsep PIPE optsep range-part ) *
  public static boolean range_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_ARG, "<range arg>");
    r = range_part(b, l + 1);
    r = r && range_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( optsep PIPE optsep range-part ) *
  private static boolean range_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!range_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "range_arg_1", c)) break;
    }
    return true;
  }

  // optsep PIPE optsep range-part
  private static boolean range_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_PIPE);
    r = r && optsep(b, l + 1);
    r = r && range_part(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // range-arg | ( DOUBLE_QUOTE range-arg DOUBLE_QUOTE )
  public static boolean range_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_ARG_STR, "<range arg str>");
    r = range_arg(b, l + 1);
    if (!r) r = range_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE range-arg DOUBLE_QUOTE
  private static boolean range_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && range_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MIN_KEYWORD | MAX_KEYWORD |
  //  integer-value | decimal-value
  public static boolean range_boundary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_boundary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_BOUNDARY, "<range boundary>");
    r = consumeToken(b, YANG_MIN_KEYWORD);
    if (!r) r = consumeToken(b, YANG_MAX_KEYWORD);
    if (!r) r = integer_value(b, l + 1);
    if (!r) r = decimal_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // range-boundary
  //  ( optsep DOUBLE_DOT optsep range-boundary ) ?
  public static boolean range_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_part")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_PART, "<range part>");
    r = range_boundary(b, l + 1);
    r = r && range_part_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( optsep DOUBLE_DOT optsep range-boundary ) ?
  private static boolean range_part_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_part_1")) return false;
    range_part_1_0(b, l + 1);
    return true;
  }

  // optsep DOUBLE_DOT optsep range-boundary
  private static boolean range_part_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_part_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_DOT);
    r = r && optsep(b, l + 1);
    r = r && range_boundary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RANGE_KEYWORD sep range-arg-str optsep
  //  ( range-sub-stmt | SEMICOLON )
  public static boolean range_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt")) return false;
    if (!nextTokenIs(b, YANG_RANGE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_STMT, null);
    r = consumeToken(b, YANG_RANGE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, range_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && range_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // range-sub-stmt | SEMICOLON
  private static boolean range_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_4")) return false;
    boolean r;
    r = range_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( error-message-stmt stmtsep ) | // ?
  //  ( error-app-tag-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean range_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RANGE_STMT_BODY, "<range stmt body>");
    r = range_stmt_body_0(b, l + 1);
    if (!r) r = range_stmt_body_1(b, l + 1);
    if (!r) r = range_stmt_body_2(b, l + 1);
    if (!r) r = range_stmt_body_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // error-message-stmt stmtsep
  private static boolean range_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_message_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // error-app-tag-stmt stmtsep
  private static boolean range_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = error_app_tag_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean range_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean range_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                            range-stmt-body *
  //                            RIGHT_BRACE
  static boolean range_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, range_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // range-stmt-body *
  private static boolean range_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!range_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "range_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !(body-stmts-base |
  // (RIGHT_BRACE stmtsep <<eof>>))
  static boolean recover_rule_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_rule_body_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // body-stmts-base |
  // (RIGHT_BRACE stmtsep <<eof>>)
  private static boolean recover_rule_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = body_stmts_base(b, l + 1);
    if (!r) r = recover_rule_body_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RIGHT_BRACE stmtsep <<eof>>
  private static boolean recover_rule_body_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_body_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !( module-header-stmts |
  //   submodule-header-stmts |
  //   linkage-stmts |
  //   meta-stmts |
  //   revision-stmts |
  //   body-stmts |
  //   (RIGHT_BRACE stmtsep <<eof>>))
  static boolean recover_rule_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_rule_header_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // module-header-stmts |
  //   submodule-header-stmts |
  //   linkage-stmts |
  //   meta-stmts |
  //   revision-stmts |
  //   body-stmts |
  //   (RIGHT_BRACE stmtsep <<eof>>)
  private static boolean recover_rule_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_header_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_header_stmts(b, l + 1);
    if (!r) r = submodule_header_stmts(b, l + 1);
    if (!r) r = linkage_stmts(b, l + 1);
    if (!r) r = meta_stmts(b, l + 1);
    if (!r) r = revision_stmts(b, l + 1);
    if (!r) r = body_stmts(b, l + 1);
    if (!r) r = recover_rule_header_0_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RIGHT_BRACE stmtsep <<eof>>
  private static boolean recover_rule_header_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_header_0_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(linkage-stmts |
  //  meta-stmts |
  //  revision-stmts |
  //  body-stmts |
  //  (RIGHT_BRACE stmtsep <<eof>>))
  static boolean recover_rule_linkage(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_linkage")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_rule_linkage_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // linkage-stmts |
  //  meta-stmts |
  //  revision-stmts |
  //  body-stmts |
  //  (RIGHT_BRACE stmtsep <<eof>>)
  private static boolean recover_rule_linkage_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_linkage_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = linkage_stmts(b, l + 1);
    if (!r) r = meta_stmts(b, l + 1);
    if (!r) r = revision_stmts(b, l + 1);
    if (!r) r = body_stmts(b, l + 1);
    if (!r) r = recover_rule_linkage_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RIGHT_BRACE stmtsep <<eof>>
  private static boolean recover_rule_linkage_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_linkage_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(meta-stmts |
  //   revision-stmts |
  //   body-stmts |
  //   (RIGHT_BRACE stmtsep <<eof>>))
  static boolean recover_rule_meta(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_meta")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_rule_meta_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // meta-stmts |
  //   revision-stmts |
  //   body-stmts |
  //   (RIGHT_BRACE stmtsep <<eof>>)
  private static boolean recover_rule_meta_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_meta_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = meta_stmts(b, l + 1);
    if (!r) r = revision_stmts(b, l + 1);
    if (!r) r = body_stmts(b, l + 1);
    if (!r) r = recover_rule_meta_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RIGHT_BRACE stmtsep <<eof>>
  private static boolean recover_rule_meta_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_meta_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(revision-stmts |
  //  body-stmts |
  //  (RIGHT_BRACE stmtsep <<eof>>))
  static boolean recover_rule_revision(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_revision")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_rule_revision_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // revision-stmts |
  //  body-stmts |
  //  (RIGHT_BRACE stmtsep <<eof>>)
  private static boolean recover_rule_revision_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_revision_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = revision_stmts(b, l + 1);
    if (!r) r = body_stmts(b, l + 1);
    if (!r) r = recover_rule_revision_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RIGHT_BRACE stmtsep <<eof>>
  private static boolean recover_rule_revision_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_rule_revision_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_RIGHT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // REFERENCE_KEYWORD sep string optsep stmtend
  public static boolean reference_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_stmt")) return false;
    if (!nextTokenIs(b, YANG_REFERENCE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFERENCE_STMT, null);
    r = consumeToken(b, YANG_REFERENCE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // refine-anyxml-stmts-body *
  public static boolean refine_anyxml_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_ANYXML_STMTS, "<refine anyxml stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_anyxml_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_anyxml_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( must-stmt stmtsep ) | // *
  //  ( config-stmt stmtsep ) | // ?
  //  ( mandatory-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_anyxml_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_ANYXML_STMTS_BODY, "<refine anyxml stmts body>");
    r = refine_anyxml_stmts_body_0(b, l + 1);
    if (!r) r = refine_anyxml_stmts_body_1(b, l + 1);
    if (!r) r = refine_anyxml_stmts_body_2(b, l + 1);
    if (!r) r = refine_anyxml_stmts_body_3(b, l + 1);
    if (!r) r = refine_anyxml_stmts_body_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt stmtsep
  private static boolean refine_anyxml_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean refine_anyxml_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mandatory-stmt stmtsep
  private static boolean refine_anyxml_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_anyxml_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_anyxml_stmts_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_anyxml_stmts_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // descendant-schema-nodeid
  public static boolean refine_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_ARG, "<refine arg>");
    r = descendant_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // refine-arg | ( DOUBLE_QUOTE refine-arg DOUBLE_QUOTE )
  public static boolean refine_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_ARG_STR, "<refine arg str>");
    r = refine_arg(b, l + 1);
    if (!r) r = refine_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE refine-arg DOUBLE_QUOTE
  private static boolean refine_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && refine_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refine-case-stmts-body *
  public static boolean refine_case_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_case_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_CASE_STMTS, "<refine case stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_case_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_case_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_case_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_case_stmts_body")) return false;
    if (!nextTokenIs(b, "<refine case stmts body>", YANG_DESCRIPTION_KEYWORD, YANG_REFERENCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_CASE_STMTS_BODY, "<refine case stmts body>");
    r = refine_case_stmts_body_0(b, l + 1);
    if (!r) r = refine_case_stmts_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_case_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_case_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_case_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_case_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refine-choice-stmts-body *
  public static boolean refine_choice_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_CHOICE_STMTS, "<refine choice stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_choice_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_choice_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( default-stmt stmtsep ) | // ?
  //  ( config-stmt stmtsep ) | // ?
  //  ( mandatory-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_choice_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_CHOICE_STMTS_BODY, "<refine choice stmts body>");
    r = refine_choice_stmts_body_0(b, l + 1);
    if (!r) r = refine_choice_stmts_body_1(b, l + 1);
    if (!r) r = refine_choice_stmts_body_2(b, l + 1);
    if (!r) r = refine_choice_stmts_body_3(b, l + 1);
    if (!r) r = refine_choice_stmts_body_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // default-stmt stmtsep
  private static boolean refine_choice_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean refine_choice_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mandatory-stmt stmtsep
  private static boolean refine_choice_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_choice_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_choice_stmts_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_choice_stmts_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refine-container-stmts-body *
  public static boolean refine_container_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_CONTAINER_STMTS, "<refine container stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_container_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_container_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( must-stmt stmtsep ) | // *
  //  ( presence-stmt stmtsep ) | // ?
  //  ( config-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_container_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_CONTAINER_STMTS_BODY, "<refine container stmts body>");
    r = refine_container_stmts_body_0(b, l + 1);
    if (!r) r = refine_container_stmts_body_1(b, l + 1);
    if (!r) r = refine_container_stmts_body_2(b, l + 1);
    if (!r) r = refine_container_stmts_body_3(b, l + 1);
    if (!r) r = refine_container_stmts_body_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt stmtsep
  private static boolean refine_container_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // presence-stmt stmtsep
  private static boolean refine_container_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = presence_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean refine_container_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_container_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_container_stmts_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_container_stmts_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refine-leaf-list-stmts-body *
  public static boolean refine_leaf_list_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_LEAF_LIST_STMTS, "<refine leaf list stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_leaf_list_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_leaf_list_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( must-stmt stmtsep ) | // *
  //  ( config-stmt stmtsep ) | // ?
  //  ( min-elements-stmt stmtsep ) | // ?
  //  ( max-elements-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_leaf_list_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_LEAF_LIST_STMTS_BODY, "<refine leaf list stmts body>");
    r = refine_leaf_list_stmts_body_0(b, l + 1);
    if (!r) r = refine_leaf_list_stmts_body_1(b, l + 1);
    if (!r) r = refine_leaf_list_stmts_body_2(b, l + 1);
    if (!r) r = refine_leaf_list_stmts_body_3(b, l + 1);
    if (!r) r = refine_leaf_list_stmts_body_4(b, l + 1);
    if (!r) r = refine_leaf_list_stmts_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt stmtsep
  private static boolean refine_leaf_list_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean refine_leaf_list_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // min-elements-stmt stmtsep
  private static boolean refine_leaf_list_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = min_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // max-elements-stmt stmtsep
  private static boolean refine_leaf_list_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = max_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_leaf_list_stmts_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_leaf_list_stmts_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_list_stmts_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refine-leaf-stmts-body *
  public static boolean refine_leaf_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_LEAF_STMTS, "<refine leaf stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_leaf_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_leaf_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( must-stmt stmtsep ) | // *
  //  ( default-stmt stmtsep ) | // ?
  //  ( config-stmt stmtsep ) | // ?
  //  ( mandatory-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_leaf_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_LEAF_STMTS_BODY, "<refine leaf stmts body>");
    r = refine_leaf_stmts_body_0(b, l + 1);
    if (!r) r = refine_leaf_stmts_body_1(b, l + 1);
    if (!r) r = refine_leaf_stmts_body_2(b, l + 1);
    if (!r) r = refine_leaf_stmts_body_3(b, l + 1);
    if (!r) r = refine_leaf_stmts_body_4(b, l + 1);
    if (!r) r = refine_leaf_stmts_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt stmtsep
  private static boolean refine_leaf_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // default-stmt stmtsep
  private static boolean refine_leaf_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean refine_leaf_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mandatory-stmt stmtsep
  private static boolean refine_leaf_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mandatory_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_leaf_stmts_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_leaf_stmts_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_leaf_stmts_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // refine-list-stmts-body *
  public static boolean refine_list_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_LIST_STMTS, "<refine list stmts>");
    while (true) {
      int c = current_position_(b);
      if (!refine_list_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "refine_list_stmts", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( must-stmt stmtsep ) | // *
  //  ( config-stmt stmtsep ) | // ?
  //  ( min-elements-stmt stmtsep ) | // ?
  //  ( max-elements-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean refine_list_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_LIST_STMTS_BODY, "<refine list stmts body>");
    r = refine_list_stmts_body_0(b, l + 1);
    if (!r) r = refine_list_stmts_body_1(b, l + 1);
    if (!r) r = refine_list_stmts_body_2(b, l + 1);
    if (!r) r = refine_list_stmts_body_3(b, l + 1);
    if (!r) r = refine_list_stmts_body_4(b, l + 1);
    if (!r) r = refine_list_stmts_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // must-stmt stmtsep
  private static boolean refine_list_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = must_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // config-stmt stmtsep
  private static boolean refine_list_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // min-elements-stmt stmtsep
  private static boolean refine_list_stmts_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = min_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // max-elements-stmt stmtsep
  private static boolean refine_list_stmts_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = max_elements_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean refine_list_stmts_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean refine_list_stmts_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_list_stmts_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // REFINE_KEYWORD sep refine-arg-str optsep
  //  ( refine-sub-stmt | SEMICOLON )
  public static boolean refine_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt")) return false;
    if (!nextTokenIs(b, YANG_REFINE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_REFINE_STMT, null);
    r = consumeToken(b, YANG_REFINE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, refine_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && refine_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // refine-sub-stmt | SEMICOLON
  private static boolean refine_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_stmt_4")) return false;
    boolean r;
    r = refine_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                             ( refine-container-stmts |
  //                             refine-leaf-stmts |
  //                             refine-leaf-list-stmts |
  //                             refine-list-stmts |
  //                             refine-choice-stmts |
  //                             refine-case-stmts |
  //                             refine-anyxml-stmts )
  //                             RIGHT_BRACE
  static boolean refine_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, refine_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // refine-container-stmts |
  //                             refine-leaf-stmts |
  //                             refine-leaf-list-stmts |
  //                             refine-list-stmts |
  //                             refine-choice-stmts |
  //                             refine-case-stmts |
  //                             refine-anyxml-stmts
  private static boolean refine_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refine_sub_stmt_2")) return false;
    boolean r;
    r = refine_container_stmts(b, l + 1);
    if (!r) r = refine_leaf_stmts(b, l + 1);
    if (!r) r = refine_leaf_list_stmts(b, l + 1);
    if (!r) r = refine_list_stmts(b, l + 1);
    if (!r) r = refine_choice_stmts(b, l + 1);
    if (!r) r = refine_case_stmts(b, l + 1);
    if (!r) r = refine_anyxml_stmts(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( unreserved | pct-encoded | sub-delims | identifier-literal) *
  public static boolean reg_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reg_name")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_REG_NAME, "<reg name>");
    while (true) {
      int c = current_position_(b);
      if (!reg_name_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "reg_name", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // unreserved | pct-encoded | sub-delims | identifier-literal
  private static boolean reg_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reg_name_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = identifier_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( DOUBLE_DOT WSP * FORWARD_SLASH WSP * ) +
  //  ( node-identifier WSP * FORWARD_SLASH WSP * ) *
  //  node-identifier
  public static boolean rel_path_keyexpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr")) return false;
    if (!nextTokenIs(b, YANG_DOUBLE_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rel_path_keyexpr_0(b, l + 1);
    r = r && rel_path_keyexpr_1(b, l + 1);
    r = r && node_identifier(b, l + 1);
    exit_section_(b, m, YANG_REL_PATH_KEYEXPR, r);
    return r;
  }

  // ( DOUBLE_DOT WSP * FORWARD_SLASH WSP * ) +
  private static boolean rel_path_keyexpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rel_path_keyexpr_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!rel_path_keyexpr_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DOUBLE_DOT WSP * FORWARD_SLASH WSP *
  private static boolean rel_path_keyexpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_DOT);
    r = r && rel_path_keyexpr_0_0_1(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && rel_path_keyexpr_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WSP *
  private static boolean rel_path_keyexpr_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_0_0_1", c)) break;
    }
    return true;
  }

  // WSP *
  private static boolean rel_path_keyexpr_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_0_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_0_0_3", c)) break;
    }
    return true;
  }

  // ( node-identifier WSP * FORWARD_SLASH WSP * ) *
  private static boolean rel_path_keyexpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!rel_path_keyexpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_1", c)) break;
    }
    return true;
  }

  // node-identifier WSP * FORWARD_SLASH WSP *
  private static boolean rel_path_keyexpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_identifier(b, l + 1);
    r = r && rel_path_keyexpr_1_0_1(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && rel_path_keyexpr_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WSP *
  private static boolean rel_path_keyexpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_1_0_1", c)) break;
    }
    return true;
  }

  // WSP *
  private static boolean rel_path_keyexpr_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_path_keyexpr_1_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!WSP(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rel_path_keyexpr_1_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ((( DOT STRING_SPLITTER? DOT) | DOUBLE_DOT) FORWARD_SLASH STRING_SPLITTER? ) + descendant-path
  public static boolean relative_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path")) return false;
    if (!nextTokenIs(b, "<relative path>", YANG_DOT, YANG_DOUBLE_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RELATIVE_PATH, "<relative path>");
    r = relative_path_0(b, l + 1);
    r = r && descendant_path(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((( DOT STRING_SPLITTER? DOT) | DOUBLE_DOT) FORWARD_SLASH STRING_SPLITTER? ) +
  private static boolean relative_path_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relative_path_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!relative_path_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relative_path_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (( DOT STRING_SPLITTER? DOT) | DOUBLE_DOT) FORWARD_SLASH STRING_SPLITTER?
  private static boolean relative_path_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relative_path_0_0_0(b, l + 1);
    r = r && consumeToken(b, YANG_FORWARD_SLASH);
    r = r && relative_path_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( DOT STRING_SPLITTER? DOT) | DOUBLE_DOT
  private static boolean relative_path_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relative_path_0_0_0_0(b, l + 1);
    if (!r) r = consumeToken(b, YANG_DOUBLE_DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT STRING_SPLITTER? DOT
  private static boolean relative_path_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOT);
    r = r && relative_path_0_0_0_0_1(b, l + 1);
    r = r && consumeToken(b, YANG_DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean relative_path_0_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0_0_0_0_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean relative_path_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relative_path_0_0_2")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD | FALSE_KEYWORD
  public static boolean require_instance_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_arg")) return false;
    if (!nextTokenIs(b, "<require instance arg>", YANG_FALSE_KEYWORD, YANG_TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REQUIRE_INSTANCE_ARG, "<require instance arg>");
    r = consumeToken(b, YANG_TRUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FALSE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // require-instance-arg | ( DOUBLE_QUOTE require-instance-arg DOUBLE_QUOTE )
  public static boolean require_instance_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REQUIRE_INSTANCE_ARG_STR, "<require instance arg str>");
    r = require_instance_arg(b, l + 1);
    if (!r) r = require_instance_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE require-instance-arg DOUBLE_QUOTE
  private static boolean require_instance_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && require_instance_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // REQUIRE_INSTANCE_KEYWORD sep
  //  require-instance-arg-str stmtend
  public static boolean require_instance_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "require_instance_stmt")) return false;
    if (!nextTokenIs(b, YANG_REQUIRE_INSTANCE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_REQUIRE_INSTANCE_STMT, null);
    r = consumeToken(b, YANG_REQUIRE_INSTANCE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, require_instance_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // date-arg-str
  public static boolean revision_date(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_date")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_DATE, "<revision date>");
    r = date_arg_str(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // REVISION_DATE_KEYWORD sep revision-date stmtend
  public static boolean revision_date_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_date_stmt")) return false;
    if (!nextTokenIs(b, YANG_REVISION_DATE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_DATE_STMT, null);
    r = consumeToken(b, YANG_REVISION_DATE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, revision_date(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // REVISION_KEYWORD sep revision-date optsep
  //  ( revision-sub-stmt | SEMICOLON )
  public static boolean revision_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt")) return false;
    if (!nextTokenIs(b, YANG_REVISION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_STMT, null);
    r = consumeToken(b, YANG_REVISION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, revision_date(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && revision_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // revision-sub-stmt | SEMICOLON
  private static boolean revision_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmt_4")) return false;
    boolean r;
    r = revision_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( revision-stmt stmtsep ) +
  public static boolean revision_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_REVISION_STMTS, "<revision stmts>");
    r = revision_stmts_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!revision_stmts_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "revision_stmts", c)) break;
    }
    exit_section_(b, l, m, r, false, YangParser::recover_rule_revision);
    return r;
  }

  // revision-stmt stmtsep
  private static boolean revision_stmts_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_stmts_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = revision_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && stmtsep(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                        ( description-stmt stmtsep ) ?
  //                        ( reference-stmt stmtsep ) ?
  //                        RIGHT_BRACE
  static boolean revision_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, revision_sub_stmt_2(b, l + 1)) && r;
    r = p && report_error_(b, revision_sub_stmt_3(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( description-stmt stmtsep ) ?
  private static boolean revision_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_sub_stmt_2")) return false;
    revision_sub_stmt_2_0(b, l + 1);
    return true;
  }

  // description-stmt stmtsep
  private static boolean revision_sub_stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_sub_stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( reference-stmt stmtsep ) ?
  private static boolean revision_sub_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_sub_stmt_3")) return false;
    revision_sub_stmt_3_0(b, l + 1);
    return true;
  }

  // reference-stmt stmtsep
  private static boolean revision_sub_stmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "revision_sub_stmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RPC_KEYWORD sep identifier-arg-quoted optsep
  //  ( rpc-sub-stmt | SEMICOLON )
  public static boolean rpc_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt")) return false;
    if (!nextTokenIs(b, YANG_RPC_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_RPC_STMT, null);
    r = consumeToken(b, YANG_RPC_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && rpc_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // rpc-sub-stmt | SEMICOLON
  private static boolean rpc_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_4")) return false;
    boolean r;
    r = rpc_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( typedef-stmt |
  //  grouping-stmt ) stmtsep ) | // *
  //  ( input-stmt stmtsep ) | // ?
  //  ( output-stmt stmtsep )
  public static boolean rpc_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_RPC_STMT_BODY, "<rpc stmt body>");
    r = rpc_stmt_body_0(b, l + 1);
    if (!r) r = rpc_stmt_body_1(b, l + 1);
    if (!r) r = rpc_stmt_body_2(b, l + 1);
    if (!r) r = rpc_stmt_body_3(b, l + 1);
    if (!r) r = rpc_stmt_body_4(b, l + 1);
    if (!r) r = rpc_stmt_body_5(b, l + 1);
    if (!r) r = rpc_stmt_body_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean rpc_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean rpc_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean rpc_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean rpc_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( typedef-stmt |
  //  grouping-stmt ) stmtsep
  private static boolean rpc_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rpc_stmt_body_4_0(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typedef-stmt |
  //  grouping-stmt
  private static boolean rpc_stmt_body_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_4_0")) return false;
    boolean r;
    r = typedef_stmt(b, l + 1);
    if (!r) r = grouping_stmt(b, l + 1);
    return r;
  }

  // input-stmt stmtsep
  private static boolean rpc_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = input_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // output-stmt stmtsep
  private static boolean rpc_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = output_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                          rpc-stmt-body *
  //                          RIGHT_BRACE
  static boolean rpc_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, rpc_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // rpc-stmt-body *
  private static boolean rpc_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!rpc_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rpc_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // absolute-schema-nodeid |
  //  descendant-schema-nodeid
  public static boolean schema_nodeid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_nodeid")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SCHEMA_NODEID, "<schema nodeid>");
    r = absolute_schema_nodeid(b, l + 1);
    if (!r) r = descendant_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ALPHA ( ALPHA | DIGIT | "+" | DASH | DOT | identifier-literal) *
  public static boolean scheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme")) return false;
    if (!nextTokenIs(b, YANG_ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_ALPHA);
    r = r && scheme_1(b, l + 1);
    exit_section_(b, m, YANG_SCHEME, r);
    return r;
  }

  // ( ALPHA | DIGIT | "+" | DASH | DOT | identifier-literal) *
  private static boolean scheme_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!scheme_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "scheme_1", c)) break;
    }
    return true;
  }

  // ALPHA | DIGIT | "+" | DASH | DOT | identifier-literal
  private static boolean scheme_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_1_0")) return false;
    boolean r;
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_DOT);
    if (!r) r = identifier_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // pchar *
  public static boolean segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_SEGMENT, "<segment>");
    while (true) {
      int c = current_position_(b);
      if (!pchar(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "segment", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // pchar +
  public static boolean segment_nz(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "segment_nz")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SEGMENT_NZ, "<segment nz>");
    r = pchar(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!pchar(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "segment_nz", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (WSP | line-break)+
  static boolean sep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!sep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sep", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // WSP | line-break
  private static boolean sep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sep_0")) return false;
    boolean r;
    r = WSP(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // container-stmt |
  //  leaf-stmt |
  //  leaf-list-stmt |
  //  list-stmt |
  //  anyxml-stmt
  public static boolean short_case_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "short_case_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, YANG_SHORT_CASE_STMT, "<short case stmt>");
    r = container_stmt(b, l + 1);
    if (!r) r = leaf_stmt(b, l + 1);
    if (!r) r = leaf_list_stmt(b, l + 1);
    if (!r) r = list_stmt(b, l + 1);
    if (!r) r = anyxml_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VCHAR | SP | HTAB | identifier-literal | SINGLE_LINE_COMMENT_START
  //     | DOUBLE_QUOTE | SINGLE_QUOTE
  public static boolean single_line_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_line_characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SINGLE_LINE_CHARACTERS, "<single line characters>");
    r = VCHAR(b, l + 1);
    if (!r) r = SP(b, l + 1);
    if (!r) r = HTAB(b, l + 1);
    if (!r) r = identifier_literal(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    if (!r) r = consumeToken(b, YANG_DOUBLE_QUOTE);
    if (!r) r = consumeToken(b, YANG_SINGLE_QUOTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // new-line-characters | VCHAR | SP | HTAB | identifier-literal | SINGLE_LINE_COMMENT_START
  //     | STRINGS_DOUBLE_QUOTE | STRINGS_SINGLE_QUOTE
  public static boolean single_quoted_string_body_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_quoted_string_body_characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SINGLE_QUOTED_STRING_BODY_CHARACTERS, "<single quoted string body characters>");
    r = new_line_characters(b, l + 1);
    if (!r) r = VCHAR(b, l + 1);
    if (!r) r = SP(b, l + 1);
    if (!r) r = HTAB(b, l + 1);
    if (!r) r = identifier_literal(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    if (!r) r = consumeToken(b, YANG_STRINGS_DOUBLE_QUOTE);
    if (!r) r = consumeToken(b, YANG_STRINGS_SINGLE_QUOTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "c" STRING_SPLITTER? "u" STRING_SPLITTER? "r" STRING_SPLITTER? "r" STRING_SPLITTER? "e"
  //     STRING_SPLITTER? "n" STRING_SPLITTER? "t"
  public static boolean splitted_current_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SPLITTED_CURRENT_KEYWORD, "<splitted current keyword>");
    r = consumeToken(b, "c");
    r = r && splitted_current_keyword_1(b, l + 1);
    r = r && consumeToken(b, "u");
    r = r && splitted_current_keyword_3(b, l + 1);
    r = r && consumeToken(b, "r");
    r = r && splitted_current_keyword_5(b, l + 1);
    r = r && consumeToken(b, "r");
    r = r && splitted_current_keyword_7(b, l + 1);
    r = r && consumeToken(b, "e");
    r = r && splitted_current_keyword_9(b, l + 1);
    r = r && consumeToken(b, "n");
    r = r && splitted_current_keyword_11(b, l + 1);
    r = r && consumeToken(b, "t");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING_SPLITTER?
  private static boolean splitted_current_keyword_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword_1")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean splitted_current_keyword_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword_3")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean splitted_current_keyword_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword_5")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean splitted_current_keyword_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword_7")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean splitted_current_keyword_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword_9")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  // STRING_SPLITTER?
  private static boolean splitted_current_keyword_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "splitted_current_keyword_11")) return false;
    STRING_SPLITTER(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CURRENT_KEYWORD |
  //  OBSOLETE_KEYWORD |
  //  DEPRECATED_KEYWORD
  public static boolean status_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STATUS_ARG, "<status arg>");
    r = consumeToken(b, YANG_CURRENT_KEYWORD);
    if (!r) r = consumeToken(b, YANG_OBSOLETE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_DEPRECATED_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // status-arg | ( DOUBLE_QUOTE status-arg DOUBLE_QUOTE )
  public static boolean status_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STATUS_ARG_STR, "<status arg str>");
    r = status_arg(b, l + 1);
    if (!r) r = status_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE status-arg DOUBLE_QUOTE
  private static boolean status_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && status_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STATUS_KEYWORD sep status-arg-str stmtend
  public static boolean status_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_stmt")) return false;
    if (!nextTokenIs(b, YANG_STATUS_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_STATUS_STMT, null);
    r = consumeToken(b, YANG_STATUS_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, status_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // SEMICOLON | (LEFT_BRACE unknown-statement* RIGHT_BRACE)
  public static boolean stmtend(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtend")) return false;
    if (!nextTokenIs(b, "<stmtend>", YANG_LEFT_BRACE, YANG_SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STMTEND, "<stmtend>");
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = stmtend_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_BRACE unknown-statement* RIGHT_BRACE
  private static boolean stmtend_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtend_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtend_1_1(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // unknown-statement*
  private static boolean stmtend_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtend_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unknown_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stmtend_1_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (WSP | line-break  | unknown-statement)*
  static boolean stmtsep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtsep")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stmtsep_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stmtsep", c)) break;
    }
    return true;
  }

  // WSP | line-break  | unknown-statement
  private static boolean stmtsep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtsep_0")) return false;
    boolean r;
    r = WSP(b, l + 1);
    if (!r) r = line_break(b, l + 1);
    if (!r) r = unknown_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (DOUBLE_QUOTE (identifier-literal | new-line-characters | SP | HTAB | quoted-string-body-characters | SINGLE_QUOTE | STRING_SPLITTER) *  DOUBLE_QUOTE)
  //     | ( non-quoted-string) |
  //     ( SINGLE_QUOTE (identifier-literal | single-quoted-string-body-characters | SINGLE_QUOTE_STRING_SPLITTER)* SINGLE_QUOTE)
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STRING, "<string>");
    r = string_0(b, l + 1);
    if (!r) r = string_1(b, l + 1);
    if (!r) r = string_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE (identifier-literal | new-line-characters | SP | HTAB | quoted-string-body-characters | SINGLE_QUOTE | STRING_SPLITTER) *  DOUBLE_QUOTE
  private static boolean string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && string_0_1(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifier-literal | new-line-characters | SP | HTAB | quoted-string-body-characters | SINGLE_QUOTE | STRING_SPLITTER) *
  private static boolean string_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_0_1", c)) break;
    }
    return true;
  }

  // identifier-literal | new-line-characters | SP | HTAB | quoted-string-body-characters | SINGLE_QUOTE | STRING_SPLITTER
  private static boolean string_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_0_1_0")) return false;
    boolean r;
    r = identifier_literal(b, l + 1);
    if (!r) r = new_line_characters(b, l + 1);
    if (!r) r = SP(b, l + 1);
    if (!r) r = HTAB(b, l + 1);
    if (!r) r = quoted_string_body_characters(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SINGLE_QUOTE);
    if (!r) r = STRING_SPLITTER(b, l + 1);
    return r;
  }

  // ( non-quoted-string)
  private static boolean string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_quoted_string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SINGLE_QUOTE (identifier-literal | single-quoted-string-body-characters | SINGLE_QUOTE_STRING_SPLITTER)* SINGLE_QUOTE
  private static boolean string_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_SINGLE_QUOTE);
    r = r && string_2_1(b, l + 1);
    r = r && consumeToken(b, YANG_SINGLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifier-literal | single-quoted-string-body-characters | SINGLE_QUOTE_STRING_SPLITTER)*
  private static boolean string_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!string_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_2_1", c)) break;
    }
    return true;
  }

  // identifier-literal | single-quoted-string-body-characters | SINGLE_QUOTE_STRING_SPLITTER
  private static boolean string_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_2_1_0")) return false;
    boolean r;
    r = identifier_literal(b, l + 1);
    if (!r) r = single_quoted_string_body_characters(b, l + 1);
    if (!r) r = SINGLE_QUOTE_STRING_SPLITTER(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // string-restrictions-body *
  public static boolean string_restrictions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_STRING_RESTRICTIONS, "<string restrictions>");
    while (true) {
      int c = current_position_(b);
      if (!string_restrictions_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "string_restrictions", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( length-stmt stmtsep ) | // ?
  //  ( pattern-stmt stmtsep )
  public static boolean string_restrictions_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions_body")) return false;
    if (!nextTokenIs(b, "<string restrictions body>", YANG_LENGTH_KEYWORD, YANG_PATTERN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_STRING_RESTRICTIONS_BODY, "<string restrictions body>");
    r = string_restrictions_body_0(b, l + 1);
    if (!r) r = string_restrictions_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // length-stmt stmtsep
  private static boolean string_restrictions_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = length_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // pattern-stmt stmtsep
  private static boolean string_restrictions_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_restrictions_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "!" | "$" | "&" | SINGLE_QUOTE | LEFT_PARENTHESIS | RIGHT_PARENTHESIS
  //     | "+" | "," | SEMICOLON | EQUAL
  public static boolean sub_delims(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_delims")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUB_DELIMS, "<sub delims>");
    r = consumeToken(b, "!");
    if (!r) r = consumeToken(b, "$");
    if (!r) r = consumeToken(b, "&");
    if (!r) r = consumeToken(b, YANG_SINGLE_QUOTE);
    if (!r) r = consumeToken(b, YANG_LEFT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_RIGHT_PARENTHESIS);
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, ",");
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = consumeToken(b, YANG_EQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // submodule-header-stmts-body +
  public static boolean submodule_header_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_header_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUBMODULE_HEADER_STMTS, "<submodule header stmts>");
    r = submodule_header_stmts_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!submodule_header_stmts_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "submodule_header_stmts", c)) break;
    }
    exit_section_(b, l, m, r, false, YangParser::recover_rule_header);
    return r;
  }

  /* ********************************************************** */
  // ( yang-version-stmt stmtsep ) | // ?
  //  belongs-to-stmt stmtsep
  public static boolean submodule_header_stmts_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_header_stmts_body")) return false;
    if (!nextTokenIs(b, "<submodule header stmts body>", YANG_BELONGS_TO_KEYWORD, YANG_YANG_VERSION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUBMODULE_HEADER_STMTS_BODY, "<submodule header stmts body>");
    r = submodule_header_stmts_body_0(b, l + 1);
    if (!r) r = submodule_header_stmts_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // yang-version-stmt stmtsep
  private static boolean submodule_header_stmts_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_header_stmts_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = yang_version_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // belongs-to-stmt stmtsep
  private static boolean submodule_header_stmts_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_header_stmts_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = belongs_to_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // optsep SUBMODULE_KEYWORD sep identifier-arg-quoted
  //  optsep
  //  ( LEFT_BRACE stmtsep
  //  submodule-header-stmts?
  //  linkage-stmts?
  //  meta-stmts?
  //  revision-stmts?
  //  body-stmts?
  //  RIGHT_BRACE ) optsep
  public static boolean submodule_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_SUBMODULE_STMT, "<submodule stmt>");
    r = optsep(b, l + 1);
    r = r && consumeToken(b, YANG_SUBMODULE_KEYWORD);
    p = r; // pin = 2
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, submodule_stmt_5(b, l + 1)) && r;
    r = p && optsep(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // LEFT_BRACE stmtsep
  //  submodule-header-stmts?
  //  linkage-stmts?
  //  meta-stmts?
  //  revision-stmts?
  //  body-stmts?
  //  RIGHT_BRACE
  private static boolean submodule_stmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_LEFT_BRACE);
    r = r && stmtsep(b, l + 1);
    r = r && submodule_stmt_5_2(b, l + 1);
    r = r && submodule_stmt_5_3(b, l + 1);
    r = r && submodule_stmt_5_4(b, l + 1);
    r = r && submodule_stmt_5_5(b, l + 1);
    r = r && submodule_stmt_5_6(b, l + 1);
    r = r && consumeToken(b, YANG_RIGHT_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // submodule-header-stmts?
  private static boolean submodule_stmt_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt_5_2")) return false;
    submodule_header_stmts(b, l + 1);
    return true;
  }

  // linkage-stmts?
  private static boolean submodule_stmt_5_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt_5_3")) return false;
    linkage_stmts(b, l + 1);
    return true;
  }

  // meta-stmts?
  private static boolean submodule_stmt_5_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt_5_4")) return false;
    meta_stmts(b, l + 1);
    return true;
  }

  // revision-stmts?
  private static boolean submodule_stmt_5_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt_5_5")) return false;
    revision_stmts(b, l + 1);
    return true;
  }

  // body-stmts?
  private static boolean submodule_stmt_5_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "submodule_stmt_5_6")) return false;
    body_stmts(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT
  public static boolean tokens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokens")) return false;
    if (!nextTokenIs(b, YANG_BLOCK_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_BLOCK_COMMENT);
    exit_section_(b, m, YANG_TOKENS, r);
    return r;
  }

  /* ********************************************************** */
  // numerical-restrictions |
  //  decimal64-specification |
  //  enum-specification |
  //  leafref-specification |
  //  identityref-specification |
  //  instance-identifier-specification |
  //  bits-specification |
  //  union-specification |
  //  string-restrictions
  public static boolean type_body_stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_body_stmts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPE_BODY_STMTS, "<type body stmts>");
    r = numerical_restrictions(b, l + 1);
    if (!r) r = decimal64_specification(b, l + 1);
    if (!r) r = enum_specification(b, l + 1);
    if (!r) r = leafref_specification(b, l + 1);
    if (!r) r = identityref_specification(b, l + 1);
    if (!r) r = instance_identifier_specification(b, l + 1);
    if (!r) r = bits_specification(b, l + 1);
    if (!r) r = union_specification(b, l + 1);
    if (!r) r = string_restrictions(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TYPE_KEYWORD sep identifier-ref-arg-quoted optsep
  //  ( type-sub-stmt | SEMICOLON )
  public static boolean type_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_stmt")) return false;
    if (!nextTokenIs(b, YANG_TYPE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPE_STMT, null);
    r = consumeToken(b, YANG_TYPE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_ref_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && type_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // type-sub-stmt | SEMICOLON
  private static boolean type_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_stmt_4")) return false;
    boolean r;
    r = type_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                           type-body-stmts
  //                           RIGHT_BRACE
  static boolean type_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, type_body_stmts(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TYPEDEF_KEYWORD sep identifier-arg-quoted optsep
  //  LEFT_BRACE stmtsep
  //  typedef-stmt-body +
  //  RIGHT_BRACE
  public static boolean typedef_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt")) return false;
    if (!nextTokenIs(b, YANG_TYPEDEF_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPEDEF_STMT, null);
    r = consumeToken(b, YANG_TYPEDEF_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, typedef_stmt_6(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // typedef-stmt-body +
  private static boolean typedef_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typedef_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!typedef_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typedef_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (type-stmt stmtsep) |
  //  ( units-stmt stmtsep ) | // ?
  //  ( default-stmt stmtsep ) | // ?
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean typedef_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_TYPEDEF_STMT_BODY, "<typedef stmt body>");
    r = typedef_stmt_body_0(b, l + 1);
    if (!r) r = typedef_stmt_body_1(b, l + 1);
    if (!r) r = typedef_stmt_body_2(b, l + 1);
    if (!r) r = typedef_stmt_body_3(b, l + 1);
    if (!r) r = typedef_stmt_body_4(b, l + 1);
    if (!r) r = typedef_stmt_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type-stmt stmtsep
  private static boolean typedef_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // units-stmt stmtsep
  private static boolean typedef_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = units_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // default-stmt stmtsep
  private static boolean typedef_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = default_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean typedef_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean typedef_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean typedef_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedef_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( type-stmt stmtsep ) +
  public static boolean union_specification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_specification")) return false;
    if (!nextTokenIs(b, YANG_TYPE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = union_specification_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!union_specification_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "union_specification", c)) break;
    }
    exit_section_(b, m, YANG_UNION_SPECIFICATION, r);
    return r;
  }

  // type-stmt stmtsep
  private static boolean union_specification_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_specification_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // descendant-schema-nodeid
  //  ( sep descendant-schema-nodeid ) *
  public static boolean unique_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNIQUE_ARG, "<unique arg>");
    r = descendant_schema_nodeid(b, l + 1);
    r = r && unique_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( sep descendant-schema-nodeid ) *
  private static boolean unique_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unique_arg_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unique_arg_1", c)) break;
    }
    return true;
  }

  // sep descendant-schema-nodeid
  private static boolean unique_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && descendant_schema_nodeid(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unique-arg | ( DOUBLE_QUOTE unique-arg DOUBLE_QUOTE )
  public static boolean unique_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNIQUE_ARG_STR, "<unique arg str>");
    r = unique_arg(b, l + 1);
    if (!r) r = unique_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE unique-arg DOUBLE_QUOTE
  private static boolean unique_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && unique_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // UNIQUE_KEYWORD sep unique-arg-str stmtend
  public static boolean unique_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unique_stmt")) return false;
    if (!nextTokenIs(b, YANG_UNIQUE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNIQUE_STMT, null);
    r = consumeToken(b, YANG_UNIQUE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, unique_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // UNITS_KEYWORD sep string optsep stmtend
  public static boolean units_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "units_stmt")) return false;
    if (!nextTokenIs(b, YANG_UNITS_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNITS_STMT, null);
    r = consumeToken(b, YANG_UNITS_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // prefix COLON identifier ( sep string ) ? optsep
  //  ( SEMICOLON | unknown-sub-statement )
  public static boolean unknown_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNKNOWN_STATEMENT, "<unknown statement>");
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    r = r && identifier(b, l + 1);
    r = r && unknown_statement_3(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && unknown_statement_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( sep string ) ?
  private static boolean unknown_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_3")) return false;
    unknown_statement_3_0(b, l + 1);
    return true;
  }

  // sep string
  private static boolean unknown_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON | unknown-sub-statement
  private static boolean unknown_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement_5")) return false;
    boolean r;
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = unknown_sub_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( prefix COLON ) ? identifier ( sep string ) ? optsep
  //  ( SEMICOLON | unknown-sub-statement )
  public static boolean unknown_statement2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNKNOWN_STATEMENT_2, "<unknown statement 2>");
    r = unknown_statement2_0(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && unknown_statement2_2(b, l + 1);
    r = r && optsep(b, l + 1);
    r = r && unknown_statement2_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( prefix COLON ) ?
  private static boolean unknown_statement2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement2_0")) return false;
    unknown_statement2_0_0(b, l + 1);
    return true;
  }

  // prefix COLON
  private static boolean unknown_statement2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix(b, l + 1);
    r = r && consumeToken(b, YANG_COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( sep string ) ?
  private static boolean unknown_statement2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement2_2")) return false;
    unknown_statement2_2_0(b, l + 1);
    return true;
  }

  // sep string
  private static boolean unknown_statement2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sep(b, l + 1);
    r = r && string(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMICOLON | unknown-sub-statement
  private static boolean unknown_statement2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_statement2_4")) return false;
    boolean r;
    r = consumeToken(b, YANG_SEMICOLON);
    if (!r) r = unknown_sub_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE unknown-statement2 * RIGHT_BRACE
  static boolean unknown_sub_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_sub_statement")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, unknown_sub_statement_1(b, l + 1));
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unknown-statement2 *
  private static boolean unknown_sub_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unknown_sub_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unknown_statement2(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unknown_sub_statement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // unquoted-vchar | identifier-literal | SINGLE_LINE_COMMENT_START
  public static boolean unquoted_string_body_characters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquoted_string_body_characters")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNQUOTED_STRING_BODY_CHARACTERS, "<unquoted string body characters>");
    r = unquoted_vchar(b, l + 1);
    if (!r) r = identifier_literal(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OTHER_CHARACTER | SINGLE_LINE_COMMENT_START
  //  | DIGIT  | ALPHA | POSITIVE_NUMBER |  ASTERISK
  //  | COLON | LEFT_BRACE | RIGHT_BRACE | DOT | DOUBLE_DOT | DASH | UNDERSCORE
  //  | LEFT_PARENTHESIS | RIGHT_PARENTHESIS | EQUAL | OPEN_BRACKET | CLOSED_BRACKET | FORWARD_SLASH | BACK_SLASH | PIPE
  public static boolean unquoted_vchar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unquoted_vchar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNQUOTED_VCHAR, "<unquoted vchar>");
    r = consumeToken(b, YANG_OTHER_CHARACTER);
    if (!r) r = consumeToken(b, YANG_SINGLE_LINE_COMMENT_START);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_ALPHA);
    if (!r) r = consumeToken(b, YANG_POSITIVE_NUMBER);
    if (!r) r = consumeToken(b, YANG_ASTERISK);
    if (!r) r = consumeToken(b, YANG_COLON);
    if (!r) r = consumeToken(b, YANG_LEFT_BRACE);
    if (!r) r = consumeToken(b, YANG_RIGHT_BRACE);
    if (!r) r = consumeToken(b, YANG_DOT);
    if (!r) r = consumeToken(b, YANG_DOUBLE_DOT);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = consumeToken(b, YANG_LEFT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_RIGHT_PARENTHESIS);
    if (!r) r = consumeToken(b, YANG_EQUAL);
    if (!r) r = consumeToken(b, YANG_OPEN_BRACKET);
    if (!r) r = consumeToken(b, YANG_CLOSED_BRACKET);
    if (!r) r = consumeToken(b, YANG_FORWARD_SLASH);
    if (!r) r = consumeToken(b, YANG_BACK_SLASH);
    if (!r) r = consumeToken(b, YANG_PIPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ALPHA | DIGIT | DASH | DOT | UNDERSCORE | "~"
  public static boolean unreserved(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unreserved")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_UNRESERVED, "<unreserved>");
    r = consumeToken(b, YANG_ALPHA);
    if (!r) r = DIGIT(b, l + 1);
    if (!r) r = consumeToken(b, YANG_DASH);
    if (!r) r = consumeToken(b, YANG_DOT);
    if (!r) r = consumeToken(b, YANG_UNDERSCORE);
    if (!r) r = consumeToken(b, "~");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // URI | (DOUBLE_QUOTE URI DOUBLE_QUOTE)
  public static boolean uri_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uri_str")) return false;
    if (!nextTokenIs(b, "<uri str>", YANG_ALPHA, YANG_DOUBLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_URI_STR, "<uri str>");
    r = URI(b, l + 1);
    if (!r) r = uri_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE URI DOUBLE_QUOTE
  private static boolean uri_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uri_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && URI(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( unreserved | pct-encoded | sub-delims | COLON ) *
  public static boolean userinfo(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userinfo")) return false;
    Marker m = enter_section_(b, l, _NONE_, YANG_USERINFO, "<userinfo>");
    while (true) {
      int c = current_position_(b);
      if (!userinfo_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "userinfo", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // unreserved | pct-encoded | sub-delims | COLON
  private static boolean userinfo_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "userinfo_0")) return false;
    boolean r;
    r = unreserved(b, l + 1);
    if (!r) r = pct_encoded(b, l + 1);
    if (!r) r = sub_delims(b, l + 1);
    if (!r) r = consumeToken(b, YANG_COLON);
    return r;
  }

  /* ********************************************************** */
  // descendant-schema-nodeid
  public static boolean uses_augment_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_AUGMENT_ARG, "<uses augment arg>");
    r = descendant_schema_nodeid(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // uses-augment-arg | ( DOUBLE_QUOTE uses-augment-arg DOUBLE_QUOTE )
  public static boolean uses_augment_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_AUGMENT_ARG_STR, "<uses augment arg str>");
    r = uses_augment_arg(b, l + 1);
    if (!r) r = uses_augment_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE uses-augment-arg DOUBLE_QUOTE
  private static boolean uses_augment_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && uses_augment_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AUGMENT_KEYWORD sep uses-augment-arg-str optsep
  //  LEFT_BRACE stmtsep
  //  uses-augment-stmt-body +
  //  RIGHT_BRACE
  public static boolean uses_augment_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt")) return false;
    if (!nextTokenIs(b, YANG_AUGMENT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_AUGMENT_STMT, null);
    r = consumeToken(b, YANG_AUGMENT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, uses_augment_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, YANG_LEFT_BRACE)) && r;
    r = p && report_error_(b, stmtsep(b, l + 1)) && r;
    r = p && report_error_(b, uses_augment_stmt_6(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // uses-augment-stmt-body +
  private static boolean uses_augment_stmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = uses_augment_stmt_body(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!uses_augment_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_augment_stmt_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( ( data-def-stmt stmtsep ) |
  //  ( case-stmt stmtsep ) )
  public static boolean uses_augment_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_AUGMENT_STMT_BODY, "<uses augment stmt body>");
    r = uses_augment_stmt_body_0(b, l + 1);
    if (!r) r = uses_augment_stmt_body_1(b, l + 1);
    if (!r) r = uses_augment_stmt_body_2(b, l + 1);
    if (!r) r = uses_augment_stmt_body_3(b, l + 1);
    if (!r) r = uses_augment_stmt_body_4(b, l + 1);
    if (!r) r = uses_augment_stmt_body_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean uses_augment_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean uses_augment_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean uses_augment_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean uses_augment_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean uses_augment_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( data-def-stmt stmtsep ) |
  //  ( case-stmt stmtsep )
  private static boolean uses_augment_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = uses_augment_stmt_body_5_0(b, l + 1);
    if (!r) r = uses_augment_stmt_body_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // data-def-stmt stmtsep
  private static boolean uses_augment_stmt_body_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = data_def_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // case-stmt stmtsep
  private static boolean uses_augment_stmt_body_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_augment_stmt_body_5_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = case_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // USES_KEYWORD sep identifier-ref-arg-quoted optsep
  //  ( uses-sub-stmt | SEMICOLON )
  public static boolean uses_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt")) return false;
    if (!nextTokenIs(b, YANG_USES_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_STMT, null);
    r = consumeToken(b, YANG_USES_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, identifier_ref_arg_quoted(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && uses_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // uses-sub-stmt | SEMICOLON
  private static boolean uses_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_4")) return false;
    boolean r;
    r = uses_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( when-stmt stmtsep ) | // ?
  //  ( if-feature-stmt stmtsep ) | // *
  //  ( status-stmt stmtsep ) | // ?
  //  ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep ) | // ?
  //  ( refine-stmt stmtsep ) | // *
  //  ( uses-augment-stmt stmtsep )
  public static boolean uses_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_USES_STMT_BODY, "<uses stmt body>");
    r = uses_stmt_body_0(b, l + 1);
    if (!r) r = uses_stmt_body_1(b, l + 1);
    if (!r) r = uses_stmt_body_2(b, l + 1);
    if (!r) r = uses_stmt_body_3(b, l + 1);
    if (!r) r = uses_stmt_body_4(b, l + 1);
    if (!r) r = uses_stmt_body_5(b, l + 1);
    if (!r) r = uses_stmt_body_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // when-stmt stmtsep
  private static boolean uses_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = when_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // if-feature-stmt stmtsep
  private static boolean uses_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_feature_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // status-stmt stmtsep
  private static boolean uses_stmt_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = status_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // description-stmt stmtsep
  private static boolean uses_stmt_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean uses_stmt_body_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // refine-stmt stmtsep
  private static boolean uses_stmt_body_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = refine_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // uses-augment-stmt stmtsep
  private static boolean uses_stmt_body_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_stmt_body_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = uses_augment_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                           uses-stmt-body *
  //                           RIGHT_BRACE
  static boolean uses_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, uses_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // uses-stmt-body *
  private static boolean uses_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uses_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!uses_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "uses_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VALUE_KEYWORD sep ( integer-value | integer-value-str ) stmtend
  public static boolean value_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_stmt")) return false;
    if (!nextTokenIs(b, YANG_VALUE_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_VALUE_STMT, null);
    r = consumeToken(b, YANG_VALUE_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, value_stmt_2(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // integer-value | integer-value-str
  private static boolean value_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_stmt_2")) return false;
    boolean r;
    r = integer_value(b, l + 1);
    if (!r) r = integer_value_str(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // WHEN_KEYWORD sep string optsep
  //  ( when-sub-stmt | SEMICOLON )
  public static boolean when_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt")) return false;
    if (!nextTokenIs(b, YANG_WHEN_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_WHEN_STMT, null);
    r = consumeToken(b, YANG_WHEN_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, string(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && when_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // when-sub-stmt | SEMICOLON
  private static boolean when_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_4")) return false;
    boolean r;
    r = when_sub_stmt(b, l + 1);
    if (!r) r = consumeToken(b, YANG_SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ( description-stmt stmtsep ) | // ?
  //  ( reference-stmt stmtsep )
  public static boolean when_stmt_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_body")) return false;
    if (!nextTokenIs(b, "<when stmt body>", YANG_DESCRIPTION_KEYWORD, YANG_REFERENCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_WHEN_STMT_BODY, "<when stmt body>");
    r = when_stmt_body_0(b, l + 1);
    if (!r) r = when_stmt_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // description-stmt stmtsep
  private static boolean when_stmt_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = description_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // reference-stmt stmtsep
  private static boolean when_stmt_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_stmt_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_stmt(b, l + 1);
    r = r && stmtsep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE stmtsep
  //                           when-stmt-body *
  //                           RIGHT_BRACE
  static boolean when_sub_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_sub_stmt")) return false;
    if (!nextTokenIs(b, YANG_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, YANG_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmtsep(b, l + 1));
    r = p && report_error_(b, when_sub_stmt_2(b, l + 1)) && r;
    r = p && consumeToken(b, YANG_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // when-stmt-body *
  private static boolean when_sub_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "when_sub_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!when_stmt_body(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "when_sub_stmt_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // module-stmt | submodule-stmt
  static boolean yang(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang")) return false;
    boolean r;
    r = module_stmt(b, l + 1);
    if (!r) r = submodule_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "1" (DOT "1")?
  public static boolean yang_version_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_VERSION_ARG, "<yang version arg>");
    r = consumeToken(b, "1");
    r = r && yang_version_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOT "1")?
  private static boolean yang_version_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg_1")) return false;
    yang_version_arg_1_0(b, l + 1);
    return true;
  }

  // DOT "1"
  private static boolean yang_version_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOT);
    r = r && consumeToken(b, "1");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // yang-version-arg | ( DOUBLE_QUOTE yang-version-arg DOUBLE_QUOTE )
  public static boolean yang_version_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_VERSION_ARG_STR, "<yang version arg str>");
    r = yang_version_arg(b, l + 1);
    if (!r) r = yang_version_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE yang-version-arg DOUBLE_QUOTE
  private static boolean yang_version_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && yang_version_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // YANG_VERSION_KEYWORD sep yang-version-arg-str
  //  optsep stmtend
  public static boolean yang_version_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yang_version_stmt")) return false;
    if (!nextTokenIs(b, YANG_YANG_VERSION_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_YANG_VERSION_STMT, null);
    r = consumeToken(b, YANG_YANG_VERSION_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, yang_version_arg_str(b, l + 1)) && r;
    r = p && report_error_(b, optsep(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD | FALSE_KEYWORD
  public static boolean yin_element_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_arg")) return false;
    if (!nextTokenIs(b, "<yin element arg>", YANG_FALSE_KEYWORD, YANG_TRUE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YIN_ELEMENT_ARG, "<yin element arg>");
    r = consumeToken(b, YANG_TRUE_KEYWORD);
    if (!r) r = consumeToken(b, YANG_FALSE_KEYWORD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // yin-element-arg | ( DOUBLE_QUOTE yin-element-arg DOUBLE_QUOTE )
  public static boolean yin_element_arg_str(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_arg_str")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_YIN_ELEMENT_ARG_STR, "<yin element arg str>");
    r = yin_element_arg(b, l + 1);
    if (!r) r = yin_element_arg_str_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOUBLE_QUOTE yin-element-arg DOUBLE_QUOTE
  private static boolean yin_element_arg_str_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_arg_str_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YANG_DOUBLE_QUOTE);
    r = r && yin_element_arg(b, l + 1);
    r = r && consumeToken(b, YANG_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // YIN_ELEMENT_KEYWORD sep yin-element-arg-str stmtend
  public static boolean yin_element_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yin_element_stmt")) return false;
    if (!nextTokenIs(b, YANG_YIN_ELEMENT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YANG_YIN_ELEMENT_STMT, null);
    r = consumeToken(b, YANG_YIN_ELEMENT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, sep(b, l + 1));
    r = p && report_error_(b, yin_element_arg_str(b, l + 1)) && r;
    r = p && stmtend(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // DIGIT+
  public static boolean zero_integer_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zero_integer_value")) return false;
    if (!nextTokenIs(b, "<zero integer value>", YANG_POSITIVE_NUMBER, YANG_ZERO)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, YANG_ZERO_INTEGER_VALUE, "<zero integer value>");
    r = DIGIT(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!DIGIT(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "zero_integer_value", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
