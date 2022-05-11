/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import tech.pantheon.yanginator.plugin.psi.YangElementType;
import tech.pantheon.yanginator.plugin.psi.YangTokenType;
import tech.pantheon.yanginator.plugin.highlighter.psi.impl.*;

public interface YangTypes {

  IElementType YANG_DUMMY = new YangElementType("YANG_DUMMY");
  IElementType YANG_H_ANY_TOKEN = new YangElementType("YANG_H_ANY_TOKEN");
  IElementType YANG_H_IDENTIFIER_LITERAL = new YangElementType("YANG_H_IDENTIFIER_LITERAL");
  IElementType YANG_STMT = new YangElementType("YANG_STMT");
  IElementType YANG_WSP = new YangElementType("YANG_WSP");

  IElementType YANG_H_ADD_KEYWORD = new YangTokenType("add");
  IElementType YANG_H_ANYXML_KEYWORD = new YangTokenType("anyxml");
  IElementType YANG_H_ARGUMENT_KEYWORD = new YangTokenType("argument");
  IElementType YANG_H_AUGMENT_KEYWORD = new YangTokenType("augment");
  IElementType YANG_H_BASE_KEYWORD = new YangTokenType("base");
  IElementType YANG_H_BELONGS_TO_KEYWORD = new YangTokenType("belongs-to");
  IElementType YANG_H_BIT_KEYWORD = new YangTokenType("bit");
  IElementType YANG_H_BLOCK_COMMENT = new YangTokenType("H_BLOCK_COMMENT");
  IElementType YANG_H_CASE_KEYWORD = new YangTokenType("case");
  IElementType YANG_H_CHOICE_KEYWORD = new YangTokenType("choice");
  IElementType YANG_H_CONFIG_KEYWORD = new YangTokenType("config");
  IElementType YANG_H_CONTACT_KEYWORD = new YangTokenType("contact");
  IElementType YANG_H_CONTAINER_KEYWORD = new YangTokenType("container");
  IElementType YANG_H_CURRENT_KEYWORD = new YangTokenType("current");
  IElementType YANG_H_DATE_ARG = new YangTokenType("H_DATE_ARG");
  IElementType YANG_H_DEFAULT_KEYWORD = new YangTokenType("default");
  IElementType YANG_H_DELETE_KEYWORD = new YangTokenType("delete");
  IElementType YANG_H_DEPRECATED_KEYWORD = new YangTokenType("deprecated");
  IElementType YANG_H_DESCRIPTION_KEYWORD = new YangTokenType("description");
  IElementType YANG_H_DEVIATE_KEYWORD = new YangTokenType("deviate");
  IElementType YANG_H_DEVIATION_KEYWORD = new YangTokenType("deviation");
  IElementType YANG_H_ENUM_KEYWORD = new YangTokenType("enum");
  IElementType YANG_H_ERROR_APP_TAG_KEYWORD = new YangTokenType("error-app-tag");
  IElementType YANG_H_ERROR_MESSAGE_KEYWORD = new YangTokenType("error-message");
  IElementType YANG_H_EXTENSION_IDENTIFIER = new YangTokenType("H_EXTENSION_IDENTIFIER");
  IElementType YANG_H_EXTENSION_KEYWORD = new YangTokenType("extension");
  IElementType YANG_H_FALSE_KEYWORD = new YangTokenType("false");
  IElementType YANG_H_FEATURE_KEYWORD = new YangTokenType("feature");
  IElementType YANG_H_FRACTION_DIGITS_KEYWORD = new YangTokenType("fraction-digits");
  IElementType YANG_H_GROUPING_KEYWORD = new YangTokenType("grouping");
  IElementType YANG_H_IDENTIFIER = new YangTokenType("H_IDENTIFIER");
  IElementType YANG_H_IDENTITY_KEYWORD = new YangTokenType("identity");
  IElementType YANG_H_IF_FEATURE_KEYWORD = new YangTokenType("if-feature");
  IElementType YANG_H_IMPORT_KEYWORD = new YangTokenType("import");
  IElementType YANG_H_INCLUDE_KEYWORD = new YangTokenType("include");
  IElementType YANG_H_INPUT_KEYWORD = new YangTokenType("input");
  IElementType YANG_H_INVALID_ESCAPE = new YangTokenType("H_INVALID_ESCAPE");
  IElementType YANG_H_KEY_KEYWORD = new YangTokenType("key");
  IElementType YANG_H_LEAF_KEYWORD = new YangTokenType("leaf");
  IElementType YANG_H_LEAF_LIST_KEYWORD = new YangTokenType("leaf-list");
  IElementType YANG_H_LEFT_BRACE = new YangTokenType("{");
  IElementType YANG_H_LENGTH_KEYWORD = new YangTokenType("length");
  IElementType YANG_H_LIST_KEYWORD = new YangTokenType("list");
  IElementType YANG_H_MANDATORY_KEYWORD = new YangTokenType("mandatory");
  IElementType YANG_H_MAX_ELEMENTS_KEYWORD = new YangTokenType("max-elements");
  IElementType YANG_H_MAX_KEYWORD = new YangTokenType("max");
  IElementType YANG_H_MIN_ELEMENTS_KEYWORD = new YangTokenType("min-elements");
  IElementType YANG_H_MIN_KEYWORD = new YangTokenType("min");
  IElementType YANG_H_MODULE_KEYWORD = new YangTokenType("module");
  IElementType YANG_H_MUST_KEYWORD = new YangTokenType("must");
  IElementType YANG_H_NAMESPACE_KEYWORD = new YangTokenType("namespace");
  IElementType YANG_H_NOTIFICATION_KEYWORD = new YangTokenType("notification");
  IElementType YANG_H_NOT_SUPPORTED_KEYWORD = new YangTokenType("not-supported");
  IElementType YANG_H_OBSOLETE_KEYWORD = new YangTokenType("obsolete");
  IElementType YANG_H_OPERATORS = new YangTokenType("+");
  IElementType YANG_H_ORDERED_BY_KEYWORD = new YangTokenType("ordered-by");
  IElementType YANG_H_ORGANIZATION_KEYWORD = new YangTokenType("organization");
  IElementType YANG_H_OUTPUT_KEYWORD = new YangTokenType("output");
  IElementType YANG_H_PATH_KEYWORD = new YangTokenType("path");
  IElementType YANG_H_PATTERN_KEYWORD = new YangTokenType("pattern");
  IElementType YANG_H_POSITION_KEYWORD = new YangTokenType("position");
  IElementType YANG_H_PREFIX_KEYWORD = new YangTokenType("prefix");
  IElementType YANG_H_PRESENCE_KEYWORD = new YangTokenType("presence");
  IElementType YANG_H_RANGE_KEYWORD = new YangTokenType("range");
  IElementType YANG_H_REFERENCE_KEYWORD = new YangTokenType("reference");
  IElementType YANG_H_REFINE_KEYWORD = new YangTokenType("refine");
  IElementType YANG_H_REPLACE_KEYWORD = new YangTokenType("replace");
  IElementType YANG_H_REQUIRE_INSTANCE_KEYWORD = new YangTokenType("require-instance");
  IElementType YANG_H_REVISION_DATE_KEYWORD = new YangTokenType("revision-date");
  IElementType YANG_H_REVISION_KEYWORD = new YangTokenType("revision");
  IElementType YANG_H_RIGHT_BRACE = new YangTokenType("}");
  IElementType YANG_H_RPC_KEYWORD = new YangTokenType("rpc");
  IElementType YANG_H_SEMICOLON = new YangTokenType(";");
  IElementType YANG_H_SINGLE_LINE_COMMENT = new YangTokenType("H_SINGLE_LINE_COMMENT");
  IElementType YANG_H_STATUS_KEYWORD = new YangTokenType("status");
  IElementType YANG_H_STRING = new YangTokenType("H_STRING");
  IElementType YANG_H_SUBMODULE_KEYWORD = new YangTokenType("submodule");
  IElementType YANG_H_SYSTEM_KEYWORD = new YangTokenType("system");
  IElementType YANG_H_TRUE_KEYWORD = new YangTokenType("true");
  IElementType YANG_H_TYPEDEF_KEYWORD = new YangTokenType("typedef");
  IElementType YANG_H_TYPE_KEYWORD = new YangTokenType("type");
  IElementType YANG_H_UNBOUNDED_KEYWORD = new YangTokenType("unbounded");
  IElementType YANG_H_UNIQUE_KEYWORD = new YangTokenType("unique");
  IElementType YANG_H_UNITS_KEYWORD = new YangTokenType("units");
  IElementType YANG_H_USER_KEYWORD = new YangTokenType("user");
  IElementType YANG_H_USES_KEYWORD = new YangTokenType("uses");
  IElementType YANG_H_VALID_ESCAPE = new YangTokenType("H_VALID_ESCAPE");
  IElementType YANG_H_VALUE_KEYWORD = new YangTokenType("value");
  IElementType YANG_H_WHEN_KEYWORD = new YangTokenType("when");
  IElementType YANG_H_WHITE_SPACE = new YangTokenType("H_WHITE_SPACE");
  IElementType YANG_H_YANG_VERSION_KEYWORD = new YangTokenType("yang-version");
  IElementType YANG_H_YIN_ELEMENT_KEYWORD = new YangTokenType("yin-element");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == YANG_DUMMY) {
        return new YangDummyImpl(node);
      }
      else if (type == YANG_H_ANY_TOKEN) {
        return new YangHAnyTokenImpl(node);
      }
      else if (type == YANG_H_IDENTIFIER_LITERAL) {
        return new YangHIdentifierLiteralImpl(node);
      }
      else if (type == YANG_STMT) {
        return new YangStmtImpl(node);
      }
      else if (type == YANG_WSP) {
        return new YangWspImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
