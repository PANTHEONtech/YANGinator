/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.pantheon.yanginator.plugin.highlighter.psi.YangTypes.*;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamedElementImpl;
import tech.pantheon.yanginator.plugin.highlighter.psi.*;

public class YangHIdentifierLiteralImpl extends YangNamedElementImpl implements YangHIdentifierLiteral {

  public YangHIdentifierLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitHIdentifierLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getHAddKeyword() {
    return findChildByType(YANG_H_ADD_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHAnyxmlKeyword() {
    return findChildByType(YANG_H_ANYXML_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHArgumentKeyword() {
    return findChildByType(YANG_H_ARGUMENT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHAugmentKeyword() {
    return findChildByType(YANG_H_AUGMENT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHBaseKeyword() {
    return findChildByType(YANG_H_BASE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHBelongsToKeyword() {
    return findChildByType(YANG_H_BELONGS_TO_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHBitKeyword() {
    return findChildByType(YANG_H_BIT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHCaseKeyword() {
    return findChildByType(YANG_H_CASE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHChoiceKeyword() {
    return findChildByType(YANG_H_CHOICE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHConfigKeyword() {
    return findChildByType(YANG_H_CONFIG_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHContactKeyword() {
    return findChildByType(YANG_H_CONTACT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHContainerKeyword() {
    return findChildByType(YANG_H_CONTAINER_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHCurrentKeyword() {
    return findChildByType(YANG_H_CURRENT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHDefaultKeyword() {
    return findChildByType(YANG_H_DEFAULT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHDeleteKeyword() {
    return findChildByType(YANG_H_DELETE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHDeprecatedKeyword() {
    return findChildByType(YANG_H_DEPRECATED_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHDescriptionKeyword() {
    return findChildByType(YANG_H_DESCRIPTION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHDeviateKeyword() {
    return findChildByType(YANG_H_DEVIATE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHDeviationKeyword() {
    return findChildByType(YANG_H_DEVIATION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHEnumKeyword() {
    return findChildByType(YANG_H_ENUM_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHErrorAppTagKeyword() {
    return findChildByType(YANG_H_ERROR_APP_TAG_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHErrorMessageKeyword() {
    return findChildByType(YANG_H_ERROR_MESSAGE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHExtensionKeyword() {
    return findChildByType(YANG_H_EXTENSION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHFalseKeyword() {
    return findChildByType(YANG_H_FALSE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHFeatureKeyword() {
    return findChildByType(YANG_H_FEATURE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHFractionDigitsKeyword() {
    return findChildByType(YANG_H_FRACTION_DIGITS_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHGroupingKeyword() {
    return findChildByType(YANG_H_GROUPING_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHIdentityKeyword() {
    return findChildByType(YANG_H_IDENTITY_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHIfFeatureKeyword() {
    return findChildByType(YANG_H_IF_FEATURE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHImportKeyword() {
    return findChildByType(YANG_H_IMPORT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHIncludeKeyword() {
    return findChildByType(YANG_H_INCLUDE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHInputKeyword() {
    return findChildByType(YANG_H_INPUT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHInvalidEscape() {
    return findChildByType(YANG_H_INVALID_ESCAPE);
  }

  @Override
  @Nullable
  public PsiElement getHKeyKeyword() {
    return findChildByType(YANG_H_KEY_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHLeafKeyword() {
    return findChildByType(YANG_H_LEAF_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHLeafListKeyword() {
    return findChildByType(YANG_H_LEAF_LIST_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHLeftBrace() {
    return findChildByType(YANG_H_LEFT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getHLengthKeyword() {
    return findChildByType(YANG_H_LENGTH_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHListKeyword() {
    return findChildByType(YANG_H_LIST_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHMandatoryKeyword() {
    return findChildByType(YANG_H_MANDATORY_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHMaxElementsKeyword() {
    return findChildByType(YANG_H_MAX_ELEMENTS_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHMaxKeyword() {
    return findChildByType(YANG_H_MAX_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHMinElementsKeyword() {
    return findChildByType(YANG_H_MIN_ELEMENTS_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHMinKeyword() {
    return findChildByType(YANG_H_MIN_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHModuleKeyword() {
    return findChildByType(YANG_H_MODULE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHMustKeyword() {
    return findChildByType(YANG_H_MUST_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHNamespaceKeyword() {
    return findChildByType(YANG_H_NAMESPACE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHNotificationKeyword() {
    return findChildByType(YANG_H_NOTIFICATION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHNotSupportedKeyword() {
    return findChildByType(YANG_H_NOT_SUPPORTED_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHObsoleteKeyword() {
    return findChildByType(YANG_H_OBSOLETE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHOperators() {
    return findChildByType(YANG_H_OPERATORS);
  }

  @Override
  @Nullable
  public PsiElement getHOrderedByKeyword() {
    return findChildByType(YANG_H_ORDERED_BY_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHOrganizationKeyword() {
    return findChildByType(YANG_H_ORGANIZATION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHOutputKeyword() {
    return findChildByType(YANG_H_OUTPUT_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHPathKeyword() {
    return findChildByType(YANG_H_PATH_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHPatternKeyword() {
    return findChildByType(YANG_H_PATTERN_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHPositionKeyword() {
    return findChildByType(YANG_H_POSITION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHPrefixKeyword() {
    return findChildByType(YANG_H_PREFIX_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHPresenceKeyword() {
    return findChildByType(YANG_H_PRESENCE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHRangeKeyword() {
    return findChildByType(YANG_H_RANGE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHReferenceKeyword() {
    return findChildByType(YANG_H_REFERENCE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHRefineKeyword() {
    return findChildByType(YANG_H_REFINE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHReplaceKeyword() {
    return findChildByType(YANG_H_REPLACE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHRequireInstanceKeyword() {
    return findChildByType(YANG_H_REQUIRE_INSTANCE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHRevisionDateKeyword() {
    return findChildByType(YANG_H_REVISION_DATE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHRevisionKeyword() {
    return findChildByType(YANG_H_REVISION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHRightBrace() {
    return findChildByType(YANG_H_RIGHT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getHRpcKeyword() {
    return findChildByType(YANG_H_RPC_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHSemicolon() {
    return findChildByType(YANG_H_SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getHStatusKeyword() {
    return findChildByType(YANG_H_STATUS_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHSubmoduleKeyword() {
    return findChildByType(YANG_H_SUBMODULE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHSystemKeyword() {
    return findChildByType(YANG_H_SYSTEM_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHTrueKeyword() {
    return findChildByType(YANG_H_TRUE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHTypedefKeyword() {
    return findChildByType(YANG_H_TYPEDEF_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHTypeKeyword() {
    return findChildByType(YANG_H_TYPE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHUnboundedKeyword() {
    return findChildByType(YANG_H_UNBOUNDED_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHUniqueKeyword() {
    return findChildByType(YANG_H_UNIQUE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHUnitsKeyword() {
    return findChildByType(YANG_H_UNITS_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHUserKeyword() {
    return findChildByType(YANG_H_USER_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHUsesKeyword() {
    return findChildByType(YANG_H_USES_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHValidEscape() {
    return findChildByType(YANG_H_VALID_ESCAPE);
  }

  @Override
  @Nullable
  public PsiElement getHValueKeyword() {
    return findChildByType(YANG_H_VALUE_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHWhenKeyword() {
    return findChildByType(YANG_H_WHEN_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHYangVersionKeyword() {
    return findChildByType(YANG_H_YANG_VERSION_KEYWORD);
  }

  @Override
  @Nullable
  public PsiElement getHYinElementKeyword() {
    return findChildByType(YANG_H_YIN_ELEMENT_KEYWORD);
  }

}
