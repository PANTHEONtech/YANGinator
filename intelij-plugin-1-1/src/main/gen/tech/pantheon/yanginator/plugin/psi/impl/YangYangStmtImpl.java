/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangActionStmt;
import tech.pantheon.yanginator.plugin.psi.YangAnydataStmt;
import tech.pantheon.yanginator.plugin.psi.YangAnyxmlStmt;
import tech.pantheon.yanginator.plugin.psi.YangArgumentStmt;
import tech.pantheon.yanginator.plugin.psi.YangAugmentStmt;
import tech.pantheon.yanginator.plugin.psi.YangBaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangBelongsToStmt;
import tech.pantheon.yanginator.plugin.psi.YangBitStmt;
import tech.pantheon.yanginator.plugin.psi.YangCaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangChoiceStmt;
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangContactStmt;
import tech.pantheon.yanginator.plugin.psi.YangContainerStmt;
import tech.pantheon.yanginator.plugin.psi.YangDefaultStmt;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviateAddStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviateDeleteStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviateNotSupportedStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviateReplaceStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviationStmt;
import tech.pantheon.yanginator.plugin.psi.YangEnumStmt;
import tech.pantheon.yanginator.plugin.psi.YangErrorAppTagStmt;
import tech.pantheon.yanginator.plugin.psi.YangErrorMessageStmt;
import tech.pantheon.yanginator.plugin.psi.YangExtensionStmt;
import tech.pantheon.yanginator.plugin.psi.YangFeatureStmt;
import tech.pantheon.yanginator.plugin.psi.YangFractionDigitsStmt;
import tech.pantheon.yanginator.plugin.psi.YangGroupingStmt;
import tech.pantheon.yanginator.plugin.psi.YangIdentityStmt;
import tech.pantheon.yanginator.plugin.psi.YangIfFeatureStmt;
import tech.pantheon.yanginator.plugin.psi.YangImportStmt;
import tech.pantheon.yanginator.plugin.psi.YangIncludeStmt;
import tech.pantheon.yanginator.plugin.psi.YangInputStmt;
import tech.pantheon.yanginator.plugin.psi.YangKeyStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafListStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafStmt;
import tech.pantheon.yanginator.plugin.psi.YangLengthStmt;
import tech.pantheon.yanginator.plugin.psi.YangListStmt;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryStmt;
import tech.pantheon.yanginator.plugin.psi.YangMaxElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangMinElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangModifierStmt;
import tech.pantheon.yanginator.plugin.psi.YangModuleStmt;
import tech.pantheon.yanginator.plugin.psi.YangMustStmt;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceStmt;
import tech.pantheon.yanginator.plugin.psi.YangNotificationStmt;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByStmt;
import tech.pantheon.yanginator.plugin.psi.YangOrganizationStmt;
import tech.pantheon.yanginator.plugin.psi.YangOutputStmt;
import tech.pantheon.yanginator.plugin.psi.YangPathStmt;
import tech.pantheon.yanginator.plugin.psi.YangPatternStmt;
import tech.pantheon.yanginator.plugin.psi.YangPositionStmt;
import tech.pantheon.yanginator.plugin.psi.YangPrefixStmt;
import tech.pantheon.yanginator.plugin.psi.YangPresenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangRangeStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangRefineStmt;
import tech.pantheon.yanginator.plugin.psi.YangRequireInstanceStmt;
import tech.pantheon.yanginator.plugin.psi.YangRevisionDateStmt;
import tech.pantheon.yanginator.plugin.psi.YangRevisionStmt;
import tech.pantheon.yanginator.plugin.psi.YangRpcStmt;
import tech.pantheon.yanginator.plugin.psi.YangStatusStmt;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypedefStmt;
import tech.pantheon.yanginator.plugin.psi.YangUniqueStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnitsStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesAugmentStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;
import tech.pantheon.yanginator.plugin.psi.YangValueStmt;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWhenStmt;
import tech.pantheon.yanginator.plugin.psi.YangYangStmt;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionStmt;
import tech.pantheon.yanginator.plugin.psi.YangYinElementStmt;

public class YangYangStmtImpl extends YangNamedElementImpl implements YangYangStmt {

  public YangYangStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitYangStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangActionStmt getActionStmt() {
    return findChildByClass(YangActionStmt.class);
  }

  @Override
  @Nullable
  public YangAnydataStmt getAnydataStmt() {
    return findChildByClass(YangAnydataStmt.class);
  }

  @Override
  @Nullable
  public YangAnyxmlStmt getAnyxmlStmt() {
    return findChildByClass(YangAnyxmlStmt.class);
  }

  @Override
  @Nullable
  public YangArgumentStmt getArgumentStmt() {
    return findChildByClass(YangArgumentStmt.class);
  }

  @Override
  @Nullable
  public YangAugmentStmt getAugmentStmt() {
    return findChildByClass(YangAugmentStmt.class);
  }

  @Override
  @Nullable
  public YangBaseStmt getBaseStmt() {
    return findChildByClass(YangBaseStmt.class);
  }

  @Override
  @Nullable
  public YangBelongsToStmt getBelongsToStmt() {
    return findChildByClass(YangBelongsToStmt.class);
  }

  @Override
  @Nullable
  public YangBitStmt getBitStmt() {
    return findChildByClass(YangBitStmt.class);
  }

  @Override
  @Nullable
  public YangCaseStmt getCaseStmt() {
    return findChildByClass(YangCaseStmt.class);
  }

  @Override
  @Nullable
  public YangChoiceStmt getChoiceStmt() {
    return findChildByClass(YangChoiceStmt.class);
  }

  @Override
  @Nullable
  public YangConfigStmt getConfigStmt() {
    return findChildByClass(YangConfigStmt.class);
  }

  @Override
  @Nullable
  public YangContactStmt getContactStmt() {
    return findChildByClass(YangContactStmt.class);
  }

  @Override
  @Nullable
  public YangContainerStmt getContainerStmt() {
    return findChildByClass(YangContainerStmt.class);
  }

  @Override
  @Nullable
  public YangDefaultStmt getDefaultStmt() {
    return findChildByClass(YangDefaultStmt.class);
  }

  @Override
  @Nullable
  public YangDescriptionStmt getDescriptionStmt() {
    return findChildByClass(YangDescriptionStmt.class);
  }

  @Override
  @Nullable
  public YangDeviateAddStmt getDeviateAddStmt() {
    return findChildByClass(YangDeviateAddStmt.class);
  }

  @Override
  @Nullable
  public YangDeviateDeleteStmt getDeviateDeleteStmt() {
    return findChildByClass(YangDeviateDeleteStmt.class);
  }

  @Override
  @Nullable
  public YangDeviateNotSupportedStmt getDeviateNotSupportedStmt() {
    return findChildByClass(YangDeviateNotSupportedStmt.class);
  }

  @Override
  @Nullable
  public YangDeviateReplaceStmt getDeviateReplaceStmt() {
    return findChildByClass(YangDeviateReplaceStmt.class);
  }

  @Override
  @Nullable
  public YangDeviationStmt getDeviationStmt() {
    return findChildByClass(YangDeviationStmt.class);
  }

  @Override
  @Nullable
  public YangEnumStmt getEnumStmt() {
    return findChildByClass(YangEnumStmt.class);
  }

  @Override
  @Nullable
  public YangErrorAppTagStmt getErrorAppTagStmt() {
    return findChildByClass(YangErrorAppTagStmt.class);
  }

  @Override
  @Nullable
  public YangErrorMessageStmt getErrorMessageStmt() {
    return findChildByClass(YangErrorMessageStmt.class);
  }

  @Override
  @Nullable
  public YangExtensionStmt getExtensionStmt() {
    return findChildByClass(YangExtensionStmt.class);
  }

  @Override
  @Nullable
  public YangFeatureStmt getFeatureStmt() {
    return findChildByClass(YangFeatureStmt.class);
  }

  @Override
  @Nullable
  public YangFractionDigitsStmt getFractionDigitsStmt() {
    return findChildByClass(YangFractionDigitsStmt.class);
  }

  @Override
  @Nullable
  public YangGroupingStmt getGroupingStmt() {
    return findChildByClass(YangGroupingStmt.class);
  }

  @Override
  @Nullable
  public YangIdentityStmt getIdentityStmt() {
    return findChildByClass(YangIdentityStmt.class);
  }

  @Override
  @Nullable
  public YangIfFeatureStmt getIfFeatureStmt() {
    return findChildByClass(YangIfFeatureStmt.class);
  }

  @Override
  @Nullable
  public YangImportStmt getImportStmt() {
    return findChildByClass(YangImportStmt.class);
  }

  @Override
  @Nullable
  public YangIncludeStmt getIncludeStmt() {
    return findChildByClass(YangIncludeStmt.class);
  }

  @Override
  @Nullable
  public YangInputStmt getInputStmt() {
    return findChildByClass(YangInputStmt.class);
  }

  @Override
  @Nullable
  public YangKeyStmt getKeyStmt() {
    return findChildByClass(YangKeyStmt.class);
  }

  @Override
  @Nullable
  public YangLeafListStmt getLeafListStmt() {
    return findChildByClass(YangLeafListStmt.class);
  }

  @Override
  @Nullable
  public YangLeafStmt getLeafStmt() {
    return findChildByClass(YangLeafStmt.class);
  }

  @Override
  @Nullable
  public YangLengthStmt getLengthStmt() {
    return findChildByClass(YangLengthStmt.class);
  }

  @Override
  @Nullable
  public YangListStmt getListStmt() {
    return findChildByClass(YangListStmt.class);
  }

  @Override
  @Nullable
  public YangMandatoryStmt getMandatoryStmt() {
    return findChildByClass(YangMandatoryStmt.class);
  }

  @Override
  @Nullable
  public YangMaxElementsStmt getMaxElementsStmt() {
    return findChildByClass(YangMaxElementsStmt.class);
  }

  @Override
  @Nullable
  public YangMinElementsStmt getMinElementsStmt() {
    return findChildByClass(YangMinElementsStmt.class);
  }

  @Override
  @Nullable
  public YangModifierStmt getModifierStmt() {
    return findChildByClass(YangModifierStmt.class);
  }

  @Override
  @Nullable
  public YangModuleStmt getModuleStmt() {
    return findChildByClass(YangModuleStmt.class);
  }

  @Override
  @Nullable
  public YangMustStmt getMustStmt() {
    return findChildByClass(YangMustStmt.class);
  }

  @Override
  @Nullable
  public YangNamespaceStmt getNamespaceStmt() {
    return findChildByClass(YangNamespaceStmt.class);
  }

  @Override
  @Nullable
  public YangNotificationStmt getNotificationStmt() {
    return findChildByClass(YangNotificationStmt.class);
  }

  @Override
  @Nullable
  public YangOrderedByStmt getOrderedByStmt() {
    return findChildByClass(YangOrderedByStmt.class);
  }

  @Override
  @Nullable
  public YangOrganizationStmt getOrganizationStmt() {
    return findChildByClass(YangOrganizationStmt.class);
  }

  @Override
  @Nullable
  public YangOutputStmt getOutputStmt() {
    return findChildByClass(YangOutputStmt.class);
  }

  @Override
  @Nullable
  public YangPathStmt getPathStmt() {
    return findChildByClass(YangPathStmt.class);
  }

  @Override
  @Nullable
  public YangPatternStmt getPatternStmt() {
    return findChildByClass(YangPatternStmt.class);
  }

  @Override
  @Nullable
  public YangPositionStmt getPositionStmt() {
    return findChildByClass(YangPositionStmt.class);
  }

  @Override
  @Nullable
  public YangPrefixStmt getPrefixStmt() {
    return findChildByClass(YangPrefixStmt.class);
  }

  @Override
  @Nullable
  public YangPresenceStmt getPresenceStmt() {
    return findChildByClass(YangPresenceStmt.class);
  }

  @Override
  @Nullable
  public YangRangeStmt getRangeStmt() {
    return findChildByClass(YangRangeStmt.class);
  }

  @Override
  @Nullable
  public YangReferenceStmt getReferenceStmt() {
    return findChildByClass(YangReferenceStmt.class);
  }

  @Override
  @Nullable
  public YangRefineStmt getRefineStmt() {
    return findChildByClass(YangRefineStmt.class);
  }

  @Override
  @Nullable
  public YangRequireInstanceStmt getRequireInstanceStmt() {
    return findChildByClass(YangRequireInstanceStmt.class);
  }

  @Override
  @Nullable
  public YangRevisionDateStmt getRevisionDateStmt() {
    return findChildByClass(YangRevisionDateStmt.class);
  }

  @Override
  @Nullable
  public YangRevisionStmt getRevisionStmt() {
    return findChildByClass(YangRevisionStmt.class);
  }

  @Override
  @Nullable
  public YangRpcStmt getRpcStmt() {
    return findChildByClass(YangRpcStmt.class);
  }

  @Override
  @Nullable
  public YangStatusStmt getStatusStmt() {
    return findChildByClass(YangStatusStmt.class);
  }

  @Override
  @Nullable
  public YangSubmoduleStmt getSubmoduleStmt() {
    return findChildByClass(YangSubmoduleStmt.class);
  }

  @Override
  @Nullable
  public YangTypeStmt getTypeStmt() {
    return findChildByClass(YangTypeStmt.class);
  }

  @Override
  @Nullable
  public YangTypedefStmt getTypedefStmt() {
    return findChildByClass(YangTypedefStmt.class);
  }

  @Override
  @Nullable
  public YangUniqueStmt getUniqueStmt() {
    return findChildByClass(YangUniqueStmt.class);
  }

  @Override
  @Nullable
  public YangUnitsStmt getUnitsStmt() {
    return findChildByClass(YangUnitsStmt.class);
  }

  @Override
  @Nullable
  public YangUsesAugmentStmt getUsesAugmentStmt() {
    return findChildByClass(YangUsesAugmentStmt.class);
  }

  @Override
  @Nullable
  public YangUsesStmt getUsesStmt() {
    return findChildByClass(YangUsesStmt.class);
  }

  @Override
  @Nullable
  public YangValueStmt getValueStmt() {
    return findChildByClass(YangValueStmt.class);
  }

  @Override
  @Nullable
  public YangWhenStmt getWhenStmt() {
    return findChildByClass(YangWhenStmt.class);
  }

  @Override
  @Nullable
  public YangYangVersionStmt getYangVersionStmt() {
    return findChildByClass(YangYangVersionStmt.class);
  }

  @Override
  @Nullable
  public YangYinElementStmt getYinElementStmt() {
    return findChildByClass(YangYinElementStmt.class);
  }

}
