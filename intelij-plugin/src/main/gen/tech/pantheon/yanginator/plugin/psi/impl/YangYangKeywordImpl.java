/*
 *
 *   Copyright (c) 2021-2025 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangActionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangAnydataKeyword;
import tech.pantheon.yanginator.plugin.psi.YangAnyxmlKeyword;
import tech.pantheon.yanginator.plugin.psi.YangArgumentKeyword;
import tech.pantheon.yanginator.plugin.psi.YangAugmentKeyword;
import tech.pantheon.yanginator.plugin.psi.YangBaseKeyword;
import tech.pantheon.yanginator.plugin.psi.YangBelongsToKeyword;
import tech.pantheon.yanginator.plugin.psi.YangBitKeyword;
import tech.pantheon.yanginator.plugin.psi.YangCaseKeyword;
import tech.pantheon.yanginator.plugin.psi.YangChoiceKeyword;
import tech.pantheon.yanginator.plugin.psi.YangConfigKeyword;
import tech.pantheon.yanginator.plugin.psi.YangContactKeyword;
import tech.pantheon.yanginator.plugin.psi.YangContainerKeyword;
import tech.pantheon.yanginator.plugin.psi.YangDefaultKeyword;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangDeviateKeyword;
import tech.pantheon.yanginator.plugin.psi.YangDeviationKeyword;
import tech.pantheon.yanginator.plugin.psi.YangEnumKeyword;
import tech.pantheon.yanginator.plugin.psi.YangErrorAppTagKeyword;
import tech.pantheon.yanginator.plugin.psi.YangErrorMessageKeyword;
import tech.pantheon.yanginator.plugin.psi.YangExtensionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangFeatureKeyword;
import tech.pantheon.yanginator.plugin.psi.YangFractionDigitsKeyword;
import tech.pantheon.yanginator.plugin.psi.YangGroupingKeyword;
import tech.pantheon.yanginator.plugin.psi.YangIdentityKeyword;
import tech.pantheon.yanginator.plugin.psi.YangIfFeatureKeyword;
import tech.pantheon.yanginator.plugin.psi.YangImportKeyword;
import tech.pantheon.yanginator.plugin.psi.YangIncludeKeyword;
import tech.pantheon.yanginator.plugin.psi.YangInputKeyword;
import tech.pantheon.yanginator.plugin.psi.YangKeyKeyword;
import tech.pantheon.yanginator.plugin.psi.YangLeafKeyword;
import tech.pantheon.yanginator.plugin.psi.YangLeafListKeyword;
import tech.pantheon.yanginator.plugin.psi.YangLengthKeyword;
import tech.pantheon.yanginator.plugin.psi.YangListKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMaxElementsKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMinElementsKeyword;
import tech.pantheon.yanginator.plugin.psi.YangModifierKeyword;
import tech.pantheon.yanginator.plugin.psi.YangModuleKeyword;
import tech.pantheon.yanginator.plugin.psi.YangMustKeyword;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceKeyword;
import tech.pantheon.yanginator.plugin.psi.YangNotificationKeyword;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByKeyword;
import tech.pantheon.yanginator.plugin.psi.YangOrganizationKeyword;
import tech.pantheon.yanginator.plugin.psi.YangOutputKeyword;
import tech.pantheon.yanginator.plugin.psi.YangPathKeyword;
import tech.pantheon.yanginator.plugin.psi.YangPatternKeyword;
import tech.pantheon.yanginator.plugin.psi.YangPositionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangPrefixKeyword;
import tech.pantheon.yanginator.plugin.psi.YangPresenceKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRangeKeyword;
import tech.pantheon.yanginator.plugin.psi.YangReferenceKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRefineKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRequireInstanceKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRevisionDateKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRevisionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangRpcKeyword;
import tech.pantheon.yanginator.plugin.psi.YangStatusKeyword;
import tech.pantheon.yanginator.plugin.psi.YangSubmoduleKeyword;
import tech.pantheon.yanginator.plugin.psi.YangTypeKeyword;
import tech.pantheon.yanginator.plugin.psi.YangTypedefKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUniqueKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUnitsKeyword;
import tech.pantheon.yanginator.plugin.psi.YangUsesKeyword;
import tech.pantheon.yanginator.plugin.psi.YangValueKeyword;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;
import tech.pantheon.yanginator.plugin.psi.YangWhenKeyword;
import tech.pantheon.yanginator.plugin.psi.YangYangKeyword;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionKeyword;
import tech.pantheon.yanginator.plugin.psi.YangYinElementKeyword;

public class YangYangKeywordImpl extends YangNamedElementImpl implements YangYangKeyword {

    public YangYangKeywordImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull YangVisitor visitor) {
        visitor.visitYangKeyword(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof YangVisitor) accept((YangVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public YangActionKeyword getActionKeyword() {
        return findChildByClass(YangActionKeyword.class);
    }

    @Override
    @Nullable
    public YangAnydataKeyword getAnydataKeyword() {
        return findChildByClass(YangAnydataKeyword.class);
    }

    @Override
    @Nullable
    public YangAnyxmlKeyword getAnyxmlKeyword() {
        return findChildByClass(YangAnyxmlKeyword.class);
    }

    @Override
    @Nullable
    public YangArgumentKeyword getArgumentKeyword() {
        return findChildByClass(YangArgumentKeyword.class);
    }

    @Override
    @Nullable
    public YangAugmentKeyword getAugmentKeyword() {
        return findChildByClass(YangAugmentKeyword.class);
    }

    @Override
    @Nullable
    public YangBaseKeyword getBaseKeyword() {
        return findChildByClass(YangBaseKeyword.class);
    }

    @Override
    @Nullable
    public YangBelongsToKeyword getBelongsToKeyword() {
        return findChildByClass(YangBelongsToKeyword.class);
    }

    @Override
    @Nullable
    public YangBitKeyword getBitKeyword() {
        return findChildByClass(YangBitKeyword.class);
    }

    @Override
    @Nullable
    public YangCaseKeyword getCaseKeyword() {
        return findChildByClass(YangCaseKeyword.class);
    }

    @Override
    @Nullable
    public YangChoiceKeyword getChoiceKeyword() {
        return findChildByClass(YangChoiceKeyword.class);
    }

    @Override
    @Nullable
    public YangConfigKeyword getConfigKeyword() {
        return findChildByClass(YangConfigKeyword.class);
    }

    @Override
    @Nullable
    public YangContactKeyword getContactKeyword() {
        return findChildByClass(YangContactKeyword.class);
    }

    @Override
    @Nullable
    public YangContainerKeyword getContainerKeyword() {
        return findChildByClass(YangContainerKeyword.class);
    }

    @Override
    @Nullable
    public YangDefaultKeyword getDefaultKeyword() {
        return findChildByClass(YangDefaultKeyword.class);
    }

    @Override
    @Nullable
    public YangDescriptionKeyword getDescriptionKeyword() {
        return findChildByClass(YangDescriptionKeyword.class);
    }

    @Override
    @Nullable
    public YangDeviateKeyword getDeviateKeyword() {
        return findChildByClass(YangDeviateKeyword.class);
    }

    @Override
    @Nullable
    public YangDeviationKeyword getDeviationKeyword() {
        return findChildByClass(YangDeviationKeyword.class);
    }

    @Override
    @Nullable
    public YangEnumKeyword getEnumKeyword() {
        return findChildByClass(YangEnumKeyword.class);
    }

    @Override
    @Nullable
    public YangErrorAppTagKeyword getErrorAppTagKeyword() {
        return findChildByClass(YangErrorAppTagKeyword.class);
    }

    @Override
    @Nullable
    public YangErrorMessageKeyword getErrorMessageKeyword() {
        return findChildByClass(YangErrorMessageKeyword.class);
    }

    @Override
    @Nullable
    public YangExtensionKeyword getExtensionKeyword() {
        return findChildByClass(YangExtensionKeyword.class);
    }

    @Override
    @Nullable
    public YangFeatureKeyword getFeatureKeyword() {
        return findChildByClass(YangFeatureKeyword.class);
    }

    @Override
    @Nullable
    public YangFractionDigitsKeyword getFractionDigitsKeyword() {
        return findChildByClass(YangFractionDigitsKeyword.class);
    }

    @Override
    @Nullable
    public YangGroupingKeyword getGroupingKeyword() {
        return findChildByClass(YangGroupingKeyword.class);
    }

    @Override
    @Nullable
    public YangIdentityKeyword getIdentityKeyword() {
        return findChildByClass(YangIdentityKeyword.class);
    }

    @Override
    @Nullable
    public YangIfFeatureKeyword getIfFeatureKeyword() {
        return findChildByClass(YangIfFeatureKeyword.class);
    }

    @Override
    @Nullable
    public YangImportKeyword getImportKeyword() {
        return findChildByClass(YangImportKeyword.class);
    }

    @Override
    @Nullable
    public YangIncludeKeyword getIncludeKeyword() {
        return findChildByClass(YangIncludeKeyword.class);
    }

    @Override
    @Nullable
    public YangInputKeyword getInputKeyword() {
        return findChildByClass(YangInputKeyword.class);
    }

    @Override
    @Nullable
    public YangKeyKeyword getKeyKeyword() {
        return findChildByClass(YangKeyKeyword.class);
    }

    @Override
    @Nullable
    public YangLeafKeyword getLeafKeyword() {
        return findChildByClass(YangLeafKeyword.class);
    }

    @Override
    @Nullable
    public YangLeafListKeyword getLeafListKeyword() {
        return findChildByClass(YangLeafListKeyword.class);
    }

    @Override
    @Nullable
    public YangLengthKeyword getLengthKeyword() {
        return findChildByClass(YangLengthKeyword.class);
    }

    @Override
    @Nullable
    public YangListKeyword getListKeyword() {
        return findChildByClass(YangListKeyword.class);
    }

    @Override
    @Nullable
    public YangMandatoryKeyword getMandatoryKeyword() {
        return findChildByClass(YangMandatoryKeyword.class);
    }

    @Override
    @Nullable
    public YangMaxElementsKeyword getMaxElementsKeyword() {
        return findChildByClass(YangMaxElementsKeyword.class);
    }

    @Override
    @Nullable
    public YangMinElementsKeyword getMinElementsKeyword() {
        return findChildByClass(YangMinElementsKeyword.class);
    }

    @Override
    @Nullable
    public YangModifierKeyword getModifierKeyword() {
        return findChildByClass(YangModifierKeyword.class);
    }

    @Override
    @Nullable
    public YangModuleKeyword getModuleKeyword() {
        return findChildByClass(YangModuleKeyword.class);
    }

    @Override
    @Nullable
    public YangMustKeyword getMustKeyword() {
        return findChildByClass(YangMustKeyword.class);
    }

    @Override
    @Nullable
    public YangNamespaceKeyword getNamespaceKeyword() {
        return findChildByClass(YangNamespaceKeyword.class);
    }

    @Override
    @Nullable
    public YangNotificationKeyword getNotificationKeyword() {
        return findChildByClass(YangNotificationKeyword.class);
    }

    @Override
    @Nullable
    public YangOrderedByKeyword getOrderedByKeyword() {
        return findChildByClass(YangOrderedByKeyword.class);
    }

    @Override
    @Nullable
    public YangOrganizationKeyword getOrganizationKeyword() {
        return findChildByClass(YangOrganizationKeyword.class);
    }

    @Override
    @Nullable
    public YangOutputKeyword getOutputKeyword() {
        return findChildByClass(YangOutputKeyword.class);
    }

    @Override
    @Nullable
    public YangPathKeyword getPathKeyword() {
        return findChildByClass(YangPathKeyword.class);
    }

    @Override
    @Nullable
    public YangPatternKeyword getPatternKeyword() {
        return findChildByClass(YangPatternKeyword.class);
    }

    @Override
    @Nullable
    public YangPositionKeyword getPositionKeyword() {
        return findChildByClass(YangPositionKeyword.class);
    }

    @Override
    @Nullable
    public YangPrefixKeyword getPrefixKeyword() {
        return findChildByClass(YangPrefixKeyword.class);
    }

    @Override
    @Nullable
    public YangPresenceKeyword getPresenceKeyword() {
        return findChildByClass(YangPresenceKeyword.class);
    }

    @Override
    @Nullable
    public YangRangeKeyword getRangeKeyword() {
        return findChildByClass(YangRangeKeyword.class);
    }

    @Override
    @Nullable
    public YangReferenceKeyword getReferenceKeyword() {
        return findChildByClass(YangReferenceKeyword.class);
    }

    @Override
    @Nullable
    public YangRefineKeyword getRefineKeyword() {
        return findChildByClass(YangRefineKeyword.class);
    }

    @Override
    @Nullable
    public YangRequireInstanceKeyword getRequireInstanceKeyword() {
        return findChildByClass(YangRequireInstanceKeyword.class);
    }

    @Override
    @Nullable
    public YangRevisionDateKeyword getRevisionDateKeyword() {
        return findChildByClass(YangRevisionDateKeyword.class);
    }

    @Override
    @Nullable
    public YangRevisionKeyword getRevisionKeyword() {
        return findChildByClass(YangRevisionKeyword.class);
    }

    @Override
    @Nullable
    public YangRpcKeyword getRpcKeyword() {
        return findChildByClass(YangRpcKeyword.class);
    }

    @Override
    @Nullable
    public YangStatusKeyword getStatusKeyword() {
        return findChildByClass(YangStatusKeyword.class);
    }

    @Override
    @Nullable
    public YangSubmoduleKeyword getSubmoduleKeyword() {
        return findChildByClass(YangSubmoduleKeyword.class);
    }

    @Override
    @Nullable
    public YangTypeKeyword getTypeKeyword() {
        return findChildByClass(YangTypeKeyword.class);
    }

    @Override
    @Nullable
    public YangTypedefKeyword getTypedefKeyword() {
        return findChildByClass(YangTypedefKeyword.class);
    }

    @Override
    @Nullable
    public YangUniqueKeyword getUniqueKeyword() {
        return findChildByClass(YangUniqueKeyword.class);
    }

    @Override
    @Nullable
    public YangUnitsKeyword getUnitsKeyword() {
        return findChildByClass(YangUnitsKeyword.class);
    }

    @Override
    @Nullable
    public YangUsesKeyword getUsesKeyword() {
        return findChildByClass(YangUsesKeyword.class);
    }

    @Override
    @Nullable
    public YangValueKeyword getValueKeyword() {
        return findChildByClass(YangValueKeyword.class);
    }

    @Override
    @Nullable
    public YangWhenKeyword getWhenKeyword() {
        return findChildByClass(YangWhenKeyword.class);
    }

    @Override
    @Nullable
    public YangYangVersionKeyword getYangVersionKeyword() {
        return findChildByClass(YangYangVersionKeyword.class);
    }

    @Override
    @Nullable
    public YangYinElementKeyword getYinElementKeyword() {
        return findChildByClass(YangYinElementKeyword.class);
    }

}
