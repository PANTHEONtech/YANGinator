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
package tech.pantheon.yanginator.plugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import tech.pantheon.yanginator.plugin.psi.impl.YangAbsolutePathImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAbsoluteSchemaNodeidImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAbsoluteURIImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangActionKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangActionStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAddKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAddKeywordStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAndKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAnydataKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAnydataStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAnyxmlKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAnyxmlStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangArgumentKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangArgumentStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAugmentArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAugmentArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAugmentKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAugmentStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangAuthorityImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBackslashQuoteImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBaseKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBaseStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBelongsToKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBelongsToStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBinarySpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBitIsSetFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBitIsSetKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBitKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBitStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBitsSpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBlockCommentBodyImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBlockCommentEndImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBlockCommentImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBlockCommentStartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangBodyStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCaseKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCaseStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangChoiceKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangChoiceStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCommentImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangConfigArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangConfigArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangConfigKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangConfigStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangContactKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangContactStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangContainerKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangContainerStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCrlfImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCurrentFunctionInvocationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangCurrentKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDataDefStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDateArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDateArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDecOctetImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDecimal64SpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDecimalValueImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDefaultKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDefaultStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeleteKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeleteKeywordStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeprecatedKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDerefFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDerefKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDerivedFromFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDerivedFromKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDerivedFromOrSelfFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDerivedFromOrSelfKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDescendantPathImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDescendantSchemaNodeidImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDescriptionKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDescriptionStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviateAddStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviateDeleteStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviateKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviateNotSupportedStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviateReplaceStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviationArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviationArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviationKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviationStmtBodyArgsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDeviationStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDigitImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDoubleBackslashImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDoubleForwardSlashImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDoubleQuotedVcharImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangDquoteImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangEnumKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangEnumSpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangEnumStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangEnumValueFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangEnumValueKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangErrorAppTagKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangErrorAppTagStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangErrorMessageKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangErrorMessageStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangExtensionKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangExtensionStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFalseKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFeatureKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFeatureStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFileReferenceImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFractionDigitsArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFractionDigitsArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFractionDigitsKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFractionDigitsStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFragmentImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyEndImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyIdentityImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyNodeIdentityImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyNodeImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyNodeStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyStartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionBodyStringStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangGenDelimsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangGroupingKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangGroupingStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangH16Impl;
import tech.pantheon.yanginator.plugin.psi.impl.YangHierPartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangHostImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangHtabImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIPLiteralImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIPv4AddressImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIPv6AddressImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIPvFutureImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierRefArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierRefArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentifierRefImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentityKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentityStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIdentityrefSpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIfFeatureExprImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIfFeatureExprStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIfFeatureFactorImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIfFeatureKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIfFeatureStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIfFeatureTermImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangImportKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangImportStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIncludeKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIncludeStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIndentableQuotedStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIndentableStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangInputKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangInputStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangInstanceIdentifierImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangInstanceIdentifierSpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIntegerValueImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangIntegerValueStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangInvertMatchKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangKeyArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangKeyArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangKeyKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangKeyPredicateExprImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangKeyPredicateImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangKeyStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafListKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafListPredicateExprImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafListPredicateImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafListStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLeafrefSpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLengthArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLengthArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLengthBoundaryImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLengthKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLengthPartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLengthStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLfImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLineBreakImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLinkageStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangListKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangListStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangLs32Impl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMandatoryArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMandatoryArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMandatoryKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMandatoryStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMaxElementsKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMaxElementsStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMaxKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMaxValueArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMaxValueArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMetaStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMinElementsKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMinElementsStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMinKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMinValueArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMinValueArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModifierArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModifierArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModifierKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModifierStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModuleHeaderStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModuleKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangModuleStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMustKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangMustStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamespaceKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNamespaceStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNodeIdentifierImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNonNegativeIntegerValueImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNonZeroDigitImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNotKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNotSupportedKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNotSupportedKeywordStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNotificationKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNotificationStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangNumericalRestrictionsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangObsoleteKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrderedByArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrderedByArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrderedByKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrderedByStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrganizationKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOrganizationStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOutputKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangOutputStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathAbemptyImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathAbsoluteImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathEmptyImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathEqualityExprImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathKeyExprImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathNoschemeImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathPredicateImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathRootlessImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPathStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPatternBodyImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPatternKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPatternStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPcharImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPctEncodedImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPortImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPosImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPositionKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPositionStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPositionValueArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPositionValueArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPositiveIntegerValueImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPrefixArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPrefixArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPrefixImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPrefixKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPrefixStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPresenceKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangPresenceStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangQueryImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangQuotedPathArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangQuotedStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangQuotedVcharImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangQuotedXpathFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRangeArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRangeArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRangeBoundaryImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRangeKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRangePartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRangeStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangReferenceKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangReferenceStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRefineArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRefineArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRefineKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRefineStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRegNameImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRelPathKeyexprImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRelativePartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRelativePathImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRelativeRefImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRematchFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRematchKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangReplaceKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangReplaceKeywordStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRequireInstanceArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRequireInstanceArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRequireInstanceKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRequireInstanceStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangReservedImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRevisionDateImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRevisionDateKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRevisionDateStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRevisionKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRevisionStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRevisionStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRpcKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangRpcStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSchemaNodeidImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSchemeImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSegmentImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSegmentNzImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSegmentNzNcImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSpImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriAuthorityImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriHierPartImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriHostImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriIPLiteralImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriIPvFutureImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriPathAbemptyImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriPathAbsoluteImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriPathRootlessImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriPcharImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriQueryImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriRegNameImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriSegmentImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriSegmentNzImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriSubDelimsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUriUserinfoImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSquoteUrifragmentImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStatusArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStatusArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStatusKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStatusStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStmtendImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStringRestrictionsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangStringSplitterImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSubDelimsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSubmoduleHeaderStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSubmoduleKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSubmoduleStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangSystemKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangTrueKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangTypeBodyStmtsImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangTypeKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangTypeStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangTypedefKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangTypedefStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangURIReferenceImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUnboundedKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUnionSpecificationImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUniqueArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUniqueArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUniqueKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUniqueStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUnitsKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUnitsStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUnknownStatementImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUnreservedImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUriImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUriStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUserKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUserinfoImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUsesAugmentArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUsesAugmentArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUsesAugmentStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUsesKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangUsesStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangValueKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangValueStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangVcharImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangWhenKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangWhenStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangWspImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangXPathFunctionImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangCharImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangStringImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangVersionArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangVersionArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangVersionKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYangVersionStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYinElementArgImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYinElementArgStrImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYinElementKeywordImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangYinElementStmtImpl;
import tech.pantheon.yanginator.plugin.psi.impl.YangZeroIntegerValueImpl;

public interface YangTypes {

    IElementType YANG_ABSOLUTE_PATH = new YangElementType("YANG_ABSOLUTE_PATH");
    IElementType YANG_ABSOLUTE_SCHEMA_NODEID = new YangElementType("YANG_ABSOLUTE_SCHEMA_NODEID");
    IElementType YANG_ABSOLUTE_URI = new YangElementType("YANG_ABSOLUTE_URI");
    IElementType YANG_ACTION_KEYWORD = new YangElementType("YANG_ACTION_KEYWORD");
    IElementType YANG_ACTION_STMT = new YangElementType("YANG_ACTION_STMT");
    IElementType YANG_ADD_KEYWORD = new YangElementType("YANG_ADD_KEYWORD");
    IElementType YANG_ADD_KEYWORD_STR = new YangElementType("YANG_ADD_KEYWORD_STR");
    IElementType YANG_AND_KEYWORD = new YangElementType("YANG_AND_KEYWORD");
    IElementType YANG_ANYDATA_KEYWORD = new YangElementType("YANG_ANYDATA_KEYWORD");
    IElementType YANG_ANYDATA_STMT = new YangElementType("YANG_ANYDATA_STMT");
    IElementType YANG_ANYXML_KEYWORD = new YangElementType("YANG_ANYXML_KEYWORD");
    IElementType YANG_ANYXML_STMT = new YangElementType("YANG_ANYXML_STMT");
    IElementType YANG_ARGUMENT_KEYWORD = new YangElementType("YANG_ARGUMENT_KEYWORD");
    IElementType YANG_ARGUMENT_STMT = new YangElementType("YANG_ARGUMENT_STMT");
    IElementType YANG_AUGMENT_ARG = new YangElementType("YANG_AUGMENT_ARG");
    IElementType YANG_AUGMENT_ARG_STR = new YangElementType("YANG_AUGMENT_ARG_STR");
    IElementType YANG_AUGMENT_KEYWORD = new YangElementType("YANG_AUGMENT_KEYWORD");
    IElementType YANG_AUGMENT_STMT = new YangElementType("YANG_AUGMENT_STMT");
    IElementType YANG_AUTHORITY = new YangElementType("YANG_AUTHORITY");
    IElementType YANG_BACKSLASH_QUOTE = new YangElementType("YANG_BACKSLASH_QUOTE");
    IElementType YANG_BASE_KEYWORD = new YangElementType("YANG_BASE_KEYWORD");
    IElementType YANG_BASE_STMT = new YangElementType("YANG_BASE_STMT");
    IElementType YANG_BELONGS_TO_KEYWORD = new YangElementType("YANG_BELONGS_TO_KEYWORD");
    IElementType YANG_BELONGS_TO_STMT = new YangElementType("YANG_BELONGS_TO_STMT");
    IElementType YANG_BINARY_SPECIFICATION = new YangElementType("YANG_BINARY_SPECIFICATION");
    IElementType YANG_BITS_SPECIFICATION = new YangElementType("YANG_BITS_SPECIFICATION");
    IElementType YANG_BIT_IS_SET_FUNCTION = new YangElementType("YANG_BIT_IS_SET_FUNCTION");
    IElementType YANG_BIT_IS_SET_KEYWORD = new YangElementType("YANG_BIT_IS_SET_KEYWORD");
    IElementType YANG_BIT_KEYWORD = new YangElementType("YANG_BIT_KEYWORD");
    IElementType YANG_BIT_STMT = new YangElementType("YANG_BIT_STMT");
    IElementType YANG_BLOCK_COMMENT = new YangElementType("YANG_BLOCK_COMMENT");
    IElementType YANG_BLOCK_COMMENT_BODY = new YangElementType("YANG_BLOCK_COMMENT_BODY");
    IElementType YANG_BLOCK_COMMENT_END = new YangElementType("YANG_BLOCK_COMMENT_END");
    IElementType YANG_BLOCK_COMMENT_START = new YangElementType("YANG_BLOCK_COMMENT_START");
    IElementType YANG_BODY_STMTS = new YangElementType("YANG_BODY_STMTS");
    IElementType YANG_CASE_KEYWORD = new YangElementType("YANG_CASE_KEYWORD");
    IElementType YANG_CASE_STMT = new YangElementType("YANG_CASE_STMT");
    IElementType YANG_CHOICE_KEYWORD = new YangElementType("YANG_CHOICE_KEYWORD");
    IElementType YANG_CHOICE_STMT = new YangElementType("YANG_CHOICE_STMT");
    IElementType YANG_COMMENT = new YangElementType("YANG_COMMENT");
    IElementType YANG_CONFIG_ARG = new YangElementType("YANG_CONFIG_ARG");
    IElementType YANG_CONFIG_ARG_STR = new YangElementType("YANG_CONFIG_ARG_STR");
    IElementType YANG_CONFIG_KEYWORD = new YangElementType("YANG_CONFIG_KEYWORD");
    IElementType YANG_CONFIG_STMT = new YangElementType("YANG_CONFIG_STMT");
    IElementType YANG_CONTACT_KEYWORD = new YangElementType("YANG_CONTACT_KEYWORD");
    IElementType YANG_CONTACT_STMT = new YangElementType("YANG_CONTACT_STMT");
    IElementType YANG_CONTAINER_KEYWORD = new YangElementType("YANG_CONTAINER_KEYWORD");
    IElementType YANG_CONTAINER_STMT = new YangElementType("YANG_CONTAINER_STMT");
    IElementType YANG_CR = new YangElementType("YANG_CR");
    IElementType YANG_CRLF = new YangElementType("YANG_CRLF");
    IElementType YANG_CURRENT_FUNCTION_INVOCATION = new YangElementType("YANG_CURRENT_FUNCTION_INVOCATION");
    IElementType YANG_CURRENT_KEYWORD = new YangElementType("YANG_CURRENT_KEYWORD");
    IElementType YANG_DATA_DEF_STMT = new YangElementType("YANG_DATA_DEF_STMT");
    IElementType YANG_DATE_ARG = new YangElementType("YANG_DATE_ARG");
    IElementType YANG_DATE_ARG_STR = new YangElementType("YANG_DATE_ARG_STR");
    IElementType YANG_DECIMAL_64_SPECIFICATION = new YangElementType("YANG_DECIMAL_64_SPECIFICATION");
    IElementType YANG_DECIMAL_VALUE = new YangElementType("YANG_DECIMAL_VALUE");
    IElementType YANG_DEC_OCTET = new YangElementType("YANG_DEC_OCTET");
    IElementType YANG_DEFAULT_KEYWORD = new YangElementType("YANG_DEFAULT_KEYWORD");
    IElementType YANG_DEFAULT_STMT = new YangElementType("YANG_DEFAULT_STMT");
    IElementType YANG_DELETE_KEYWORD = new YangElementType("YANG_DELETE_KEYWORD");
    IElementType YANG_DELETE_KEYWORD_STR = new YangElementType("YANG_DELETE_KEYWORD_STR");
    IElementType YANG_DEPRECATED_KEYWORD = new YangElementType("YANG_DEPRECATED_KEYWORD");
    IElementType YANG_DEREF_FUNCTION = new YangElementType("YANG_DEREF_FUNCTION");
    IElementType YANG_DEREF_KEYWORD = new YangElementType("YANG_DEREF_KEYWORD");
    IElementType YANG_DERIVED_FROM_FUNCTION = new YangElementType("YANG_DERIVED_FROM_FUNCTION");
    IElementType YANG_DERIVED_FROM_KEYWORD = new YangElementType("YANG_DERIVED_FROM_KEYWORD");
    IElementType YANG_DERIVED_FROM_OR_SELF_FUNCTION = new YangElementType("YANG_DERIVED_FROM_OR_SELF_FUNCTION");
    IElementType YANG_DERIVED_FROM_OR_SELF_KEYWORD = new YangElementType("YANG_DERIVED_FROM_OR_SELF_KEYWORD");
    IElementType YANG_DESCENDANT_PATH = new YangElementType("YANG_DESCENDANT_PATH");
    IElementType YANG_DESCENDANT_SCHEMA_NODEID = new YangElementType("YANG_DESCENDANT_SCHEMA_NODEID");
    IElementType YANG_DESCRIPTION_KEYWORD = new YangElementType("YANG_DESCRIPTION_KEYWORD");
    IElementType YANG_DESCRIPTION_STMT = new YangElementType("YANG_DESCRIPTION_STMT");
    IElementType YANG_DEVIATE_ADD_STMT = new YangElementType("YANG_DEVIATE_ADD_STMT");
    IElementType YANG_DEVIATE_DELETE_STMT = new YangElementType("YANG_DEVIATE_DELETE_STMT");
    IElementType YANG_DEVIATE_KEYWORD = new YangElementType("YANG_DEVIATE_KEYWORD");
    IElementType YANG_DEVIATE_NOT_SUPPORTED_STMT = new YangElementType("YANG_DEVIATE_NOT_SUPPORTED_STMT");
    IElementType YANG_DEVIATE_REPLACE_STMT = new YangElementType("YANG_DEVIATE_REPLACE_STMT");
    IElementType YANG_DEVIATION_ARG = new YangElementType("YANG_DEVIATION_ARG");
    IElementType YANG_DEVIATION_ARG_STR = new YangElementType("YANG_DEVIATION_ARG_STR");
    IElementType YANG_DEVIATION_KEYWORD = new YangElementType("YANG_DEVIATION_KEYWORD");
    IElementType YANG_DEVIATION_STMT = new YangElementType("YANG_DEVIATION_STMT");
    IElementType YANG_DEVIATION_STMT_BODY_ARGS = new YangElementType("YANG_DEVIATION_STMT_BODY_ARGS");
    IElementType YANG_DIGIT = new YangElementType("YANG_DIGIT");
    IElementType YANG_DOUBLE_BACKSLASH = new YangElementType("YANG_DOUBLE_BACKSLASH");
    IElementType YANG_DOUBLE_FORWARD_SLASH = new YangElementType("YANG_DOUBLE_FORWARD_SLASH");
    IElementType YANG_DOUBLE_QUOTED_VCHAR = new YangElementType("YANG_DOUBLE_QUOTED_VCHAR");
    IElementType YANG_DQUOTE = new YangElementType("YANG_DQUOTE");
    IElementType YANG_ENUM_KEYWORD = new YangElementType("YANG_ENUM_KEYWORD");
    IElementType YANG_ENUM_SPECIFICATION = new YangElementType("YANG_ENUM_SPECIFICATION");
    IElementType YANG_ENUM_STMT = new YangElementType("YANG_ENUM_STMT");
    IElementType YANG_ENUM_VALUE_FUNCTION = new YangElementType("YANG_ENUM_VALUE_FUNCTION");
    IElementType YANG_ENUM_VALUE_KEYWORD = new YangElementType("YANG_ENUM_VALUE_KEYWORD");
    IElementType YANG_ERROR_APP_TAG_KEYWORD = new YangElementType("YANG_ERROR_APP_TAG_KEYWORD");
    IElementType YANG_ERROR_APP_TAG_STMT = new YangElementType("YANG_ERROR_APP_TAG_STMT");
    IElementType YANG_ERROR_MESSAGE_KEYWORD = new YangElementType("YANG_ERROR_MESSAGE_KEYWORD");
    IElementType YANG_ERROR_MESSAGE_STMT = new YangElementType("YANG_ERROR_MESSAGE_STMT");
    IElementType YANG_EXTENSION_KEYWORD = new YangElementType("YANG_EXTENSION_KEYWORD");
    IElementType YANG_EXTENSION_STMT = new YangElementType("YANG_EXTENSION_STMT");
    IElementType YANG_FALSE_KEYWORD = new YangElementType("YANG_FALSE_KEYWORD");
    IElementType YANG_FEATURE_KEYWORD = new YangElementType("YANG_FEATURE_KEYWORD");
    IElementType YANG_FEATURE_STMT = new YangElementType("YANG_FEATURE_STMT");
    IElementType YANG_FILE_REFERENCE = new YangElementType("YANG_FILE_REFERENCE");
    IElementType YANG_FRACTION_DIGITS_ARG = new YangElementType("YANG_FRACTION_DIGITS_ARG");
    IElementType YANG_FRACTION_DIGITS_ARG_STR = new YangElementType("YANG_FRACTION_DIGITS_ARG_STR");
    IElementType YANG_FRACTION_DIGITS_KEYWORD = new YangElementType("YANG_FRACTION_DIGITS_KEYWORD");
    IElementType YANG_FRACTION_DIGITS_STMT = new YangElementType("YANG_FRACTION_DIGITS_STMT");
    IElementType YANG_FRAGMENT = new YangElementType("YANG_FRAGMENT");
    IElementType YANG_FUNCTION = new YangElementType("YANG_FUNCTION");
    IElementType YANG_FUNCTION_BODY_END = new YangElementType("YANG_FUNCTION_BODY_END");
    IElementType YANG_FUNCTION_BODY_IDENTITY = new YangElementType("YANG_FUNCTION_BODY_IDENTITY");
    IElementType YANG_FUNCTION_BODY_NODE = new YangElementType("YANG_FUNCTION_BODY_NODE");
    IElementType YANG_FUNCTION_BODY_NODE_IDENTITY = new YangElementType("YANG_FUNCTION_BODY_NODE_IDENTITY");
    IElementType YANG_FUNCTION_BODY_NODE_STRING = new YangElementType("YANG_FUNCTION_BODY_NODE_STRING");
    IElementType YANG_FUNCTION_BODY_START = new YangElementType("YANG_FUNCTION_BODY_START");
    IElementType YANG_FUNCTION_BODY_STRING = new YangElementType("YANG_FUNCTION_BODY_STRING");
    IElementType YANG_FUNCTION_BODY_STRING_STRING = new YangElementType("YANG_FUNCTION_BODY_STRING_STRING");
    IElementType YANG_GEN_DELIMS = new YangElementType("YANG_GEN_DELIMS");
    IElementType YANG_GROUPING_KEYWORD = new YangElementType("YANG_GROUPING_KEYWORD");
    IElementType YANG_GROUPING_STMT = new YangElementType("YANG_GROUPING_STMT");
    IElementType YANG_HIER_PART = new YangElementType("YANG_HIER_PART");
    IElementType YANG_HOST = new YangElementType("YANG_HOST");
    IElementType YANG_HTAB = new YangElementType("YANG_HTAB");
    IElementType YANG_H_16 = new YangElementType("YANG_H_16");
    IElementType YANG_IDENTIFIER = new YangElementType("YANG_IDENTIFIER");
    IElementType YANG_IDENTIFIER_ARG = new YangElementType("YANG_IDENTIFIER_ARG");
    IElementType YANG_IDENTIFIER_ARG_STR = new YangElementType("YANG_IDENTIFIER_ARG_STR");
    IElementType YANG_IDENTIFIER_REF = new YangElementType("YANG_IDENTIFIER_REF");
    IElementType YANG_IDENTIFIER_REF_ARG = new YangElementType("YANG_IDENTIFIER_REF_ARG");
    IElementType YANG_IDENTIFIER_REF_ARG_STR = new YangElementType("YANG_IDENTIFIER_REF_ARG_STR");
    IElementType YANG_IDENTITYREF_SPECIFICATION = new YangElementType("YANG_IDENTITYREF_SPECIFICATION");
    IElementType YANG_IDENTITY_KEYWORD = new YangElementType("YANG_IDENTITY_KEYWORD");
    IElementType YANG_IDENTITY_STMT = new YangElementType("YANG_IDENTITY_STMT");
    IElementType YANG_IF_FEATURE_EXPR = new YangElementType("YANG_IF_FEATURE_EXPR");
    IElementType YANG_IF_FEATURE_EXPR_STR = new YangElementType("YANG_IF_FEATURE_EXPR_STR");
    IElementType YANG_IF_FEATURE_FACTOR = new YangElementType("YANG_IF_FEATURE_FACTOR");
    IElementType YANG_IF_FEATURE_KEYWORD = new YangElementType("YANG_IF_FEATURE_KEYWORD");
    IElementType YANG_IF_FEATURE_STMT = new YangElementType("YANG_IF_FEATURE_STMT");
    IElementType YANG_IF_FEATURE_TERM = new YangElementType("YANG_IF_FEATURE_TERM");
    IElementType YANG_IMPORT_KEYWORD = new YangElementType("YANG_IMPORT_KEYWORD");
    IElementType YANG_IMPORT_STMT = new YangElementType("YANG_IMPORT_STMT");
    IElementType YANG_INCLUDE_KEYWORD = new YangElementType("YANG_INCLUDE_KEYWORD");
    IElementType YANG_INCLUDE_STMT = new YangElementType("YANG_INCLUDE_STMT");
    IElementType YANG_INDENTABLE_QUOTED_STRING = new YangElementType("YANG_INDENTABLE_QUOTED_STRING");
    IElementType YANG_INDENTABLE_STRING = new YangElementType("YANG_INDENTABLE_STRING");
    IElementType YANG_INPUT_KEYWORD = new YangElementType("YANG_INPUT_KEYWORD");
    IElementType YANG_INPUT_STMT = new YangElementType("YANG_INPUT_STMT");
    IElementType YANG_INSTANCE_IDENTIFIER = new YangElementType("YANG_INSTANCE_IDENTIFIER");
    IElementType YANG_INSTANCE_IDENTIFIER_SPECIFICATION = new YangElementType("YANG_INSTANCE_IDENTIFIER_SPECIFICATION");
    IElementType YANG_INTEGER_VALUE = new YangElementType("YANG_INTEGER_VALUE");
    IElementType YANG_INTEGER_VALUE_STR = new YangElementType("YANG_INTEGER_VALUE_STR");
    IElementType YANG_INVERT_MATCH_KEYWORD = new YangElementType("YANG_INVERT_MATCH_KEYWORD");
    IElementType YANG_IP_LITERAL = new YangElementType("YANG_IP_LITERAL");
    IElementType YANG_I_PV_4_ADDRESS = new YangElementType("YANG_I_PV_4_ADDRESS");
    IElementType YANG_I_PV_6_ADDRESS = new YangElementType("YANG_I_PV_6_ADDRESS");
    IElementType YANG_I_PV_FUTURE = new YangElementType("YANG_I_PV_FUTURE");
    IElementType YANG_KEY_ARG = new YangElementType("YANG_KEY_ARG");
    IElementType YANG_KEY_ARG_STR = new YangElementType("YANG_KEY_ARG_STR");
    IElementType YANG_KEY_KEYWORD = new YangElementType("YANG_KEY_KEYWORD");
    IElementType YANG_KEY_PREDICATE = new YangElementType("YANG_KEY_PREDICATE");
    IElementType YANG_KEY_PREDICATE_EXPR = new YangElementType("YANG_KEY_PREDICATE_EXPR");
    IElementType YANG_KEY_STMT = new YangElementType("YANG_KEY_STMT");
    IElementType YANG_LEAFREF_SPECIFICATION = new YangElementType("YANG_LEAFREF_SPECIFICATION");
    IElementType YANG_LEAF_KEYWORD = new YangElementType("YANG_LEAF_KEYWORD");
    IElementType YANG_LEAF_LIST_KEYWORD = new YangElementType("YANG_LEAF_LIST_KEYWORD");
    IElementType YANG_LEAF_LIST_PREDICATE = new YangElementType("YANG_LEAF_LIST_PREDICATE");
    IElementType YANG_LEAF_LIST_PREDICATE_EXPR = new YangElementType("YANG_LEAF_LIST_PREDICATE_EXPR");
    IElementType YANG_LEAF_LIST_STMT = new YangElementType("YANG_LEAF_LIST_STMT");
    IElementType YANG_LEAF_STMT = new YangElementType("YANG_LEAF_STMT");
    IElementType YANG_LENGTH_ARG = new YangElementType("YANG_LENGTH_ARG");
    IElementType YANG_LENGTH_ARG_STR = new YangElementType("YANG_LENGTH_ARG_STR");
    IElementType YANG_LENGTH_BOUNDARY = new YangElementType("YANG_LENGTH_BOUNDARY");
    IElementType YANG_LENGTH_KEYWORD = new YangElementType("YANG_LENGTH_KEYWORD");
    IElementType YANG_LENGTH_PART = new YangElementType("YANG_LENGTH_PART");
    IElementType YANG_LENGTH_STMT = new YangElementType("YANG_LENGTH_STMT");
    IElementType YANG_LF = new YangElementType("YANG_LF");
    IElementType YANG_LINE_BREAK = new YangElementType("YANG_LINE_BREAK");
    IElementType YANG_LINKAGE_STMTS = new YangElementType("YANG_LINKAGE_STMTS");
    IElementType YANG_LIST_KEYWORD = new YangElementType("YANG_LIST_KEYWORD");
    IElementType YANG_LIST_STMT = new YangElementType("YANG_LIST_STMT");
    IElementType YANG_LS_32 = new YangElementType("YANG_LS_32");
    IElementType YANG_MANDATORY_ARG = new YangElementType("YANG_MANDATORY_ARG");
    IElementType YANG_MANDATORY_ARG_STR = new YangElementType("YANG_MANDATORY_ARG_STR");
    IElementType YANG_MANDATORY_KEYWORD = new YangElementType("YANG_MANDATORY_KEYWORD");
    IElementType YANG_MANDATORY_STMT = new YangElementType("YANG_MANDATORY_STMT");
    IElementType YANG_MAX_ELEMENTS_KEYWORD = new YangElementType("YANG_MAX_ELEMENTS_KEYWORD");
    IElementType YANG_MAX_ELEMENTS_STMT = new YangElementType("YANG_MAX_ELEMENTS_STMT");
    IElementType YANG_MAX_KEYWORD = new YangElementType("YANG_MAX_KEYWORD");
    IElementType YANG_MAX_VALUE_ARG = new YangElementType("YANG_MAX_VALUE_ARG");
    IElementType YANG_MAX_VALUE_ARG_STR = new YangElementType("YANG_MAX_VALUE_ARG_STR");
    IElementType YANG_META_STMTS = new YangElementType("YANG_META_STMTS");
    IElementType YANG_MIN_ELEMENTS_KEYWORD = new YangElementType("YANG_MIN_ELEMENTS_KEYWORD");
    IElementType YANG_MIN_ELEMENTS_STMT = new YangElementType("YANG_MIN_ELEMENTS_STMT");
    IElementType YANG_MIN_KEYWORD = new YangElementType("YANG_MIN_KEYWORD");
    IElementType YANG_MIN_VALUE_ARG = new YangElementType("YANG_MIN_VALUE_ARG");
    IElementType YANG_MIN_VALUE_ARG_STR = new YangElementType("YANG_MIN_VALUE_ARG_STR");
    IElementType YANG_MODIFIER_ARG = new YangElementType("YANG_MODIFIER_ARG");
    IElementType YANG_MODIFIER_ARG_STR = new YangElementType("YANG_MODIFIER_ARG_STR");
    IElementType YANG_MODIFIER_KEYWORD = new YangElementType("YANG_MODIFIER_KEYWORD");
    IElementType YANG_MODIFIER_STMT = new YangElementType("YANG_MODIFIER_STMT");
    IElementType YANG_MODULE_HEADER_STMTS = new YangElementType("YANG_MODULE_HEADER_STMTS");
    IElementType YANG_MODULE_KEYWORD = new YangElementType("YANG_MODULE_KEYWORD");
    IElementType YANG_MODULE_STMT = new YangElementType("YANG_MODULE_STMT");
    IElementType YANG_MUST_KEYWORD = new YangElementType("YANG_MUST_KEYWORD");
    IElementType YANG_MUST_STMT = new YangElementType("YANG_MUST_STMT");
    IElementType YANG_NAMESPACE_KEYWORD = new YangElementType("YANG_NAMESPACE_KEYWORD");
    IElementType YANG_NAMESPACE_STMT = new YangElementType("YANG_NAMESPACE_STMT");
    IElementType YANG_NODE_IDENTIFIER = new YangElementType("YANG_NODE_IDENTIFIER");
    IElementType YANG_NON_NEGATIVE_INTEGER_VALUE = new YangElementType("YANG_NON_NEGATIVE_INTEGER_VALUE");
    IElementType YANG_NON_ZERO_DIGIT = new YangElementType("YANG_NON_ZERO_DIGIT");
    IElementType YANG_NOTIFICATION_KEYWORD = new YangElementType("YANG_NOTIFICATION_KEYWORD");
    IElementType YANG_NOTIFICATION_STMT = new YangElementType("YANG_NOTIFICATION_STMT");
    IElementType YANG_NOT_KEYWORD = new YangElementType("YANG_NOT_KEYWORD");
    IElementType YANG_NOT_SUPPORTED_KEYWORD = new YangElementType("YANG_NOT_SUPPORTED_KEYWORD");
    IElementType YANG_NOT_SUPPORTED_KEYWORD_STR = new YangElementType("YANG_NOT_SUPPORTED_KEYWORD_STR");
    IElementType YANG_NUMERICAL_RESTRICTIONS = new YangElementType("YANG_NUMERICAL_RESTRICTIONS");
    IElementType YANG_OBSOLETE_KEYWORD = new YangElementType("YANG_OBSOLETE_KEYWORD");
    IElementType YANG_ORDERED_BY_ARG = new YangElementType("YANG_ORDERED_BY_ARG");
    IElementType YANG_ORDERED_BY_ARG_STR = new YangElementType("YANG_ORDERED_BY_ARG_STR");
    IElementType YANG_ORDERED_BY_KEYWORD = new YangElementType("YANG_ORDERED_BY_KEYWORD");
    IElementType YANG_ORDERED_BY_STMT = new YangElementType("YANG_ORDERED_BY_STMT");
    IElementType YANG_ORGANIZATION_KEYWORD = new YangElementType("YANG_ORGANIZATION_KEYWORD");
    IElementType YANG_ORGANIZATION_STMT = new YangElementType("YANG_ORGANIZATION_STMT");
    IElementType YANG_OR_KEYWORD = new YangElementType("YANG_OR_KEYWORD");
    IElementType YANG_OUTPUT_KEYWORD = new YangElementType("YANG_OUTPUT_KEYWORD");
    IElementType YANG_OUTPUT_STMT = new YangElementType("YANG_OUTPUT_STMT");
    IElementType YANG_PATH = new YangElementType("YANG_PATH");
    IElementType YANG_PATH_ABEMPTY = new YangElementType("YANG_PATH_ABEMPTY");
    IElementType YANG_PATH_ABSOLUTE = new YangElementType("YANG_PATH_ABSOLUTE");
    IElementType YANG_PATH_ARG = new YangElementType("YANG_PATH_ARG");
    IElementType YANG_PATH_ARG_STR = new YangElementType("YANG_PATH_ARG_STR");
    IElementType YANG_PATH_EMPTY = new YangElementType("YANG_PATH_EMPTY");
    IElementType YANG_PATH_EQUALITY_EXPR = new YangElementType("YANG_PATH_EQUALITY_EXPR");
    IElementType YANG_PATH_KEYWORD = new YangElementType("YANG_PATH_KEYWORD");
    IElementType YANG_PATH_KEY_EXPR = new YangElementType("YANG_PATH_KEY_EXPR");
    IElementType YANG_PATH_NOSCHEME = new YangElementType("YANG_PATH_NOSCHEME");
    IElementType YANG_PATH_PREDICATE = new YangElementType("YANG_PATH_PREDICATE");
    IElementType YANG_PATH_ROOTLESS = new YangElementType("YANG_PATH_ROOTLESS");
    IElementType YANG_PATH_STMT = new YangElementType("YANG_PATH_STMT");
    IElementType YANG_PATTERN_BODY = new YangElementType("YANG_PATTERN_BODY");
    IElementType YANG_PATTERN_KEYWORD = new YangElementType("YANG_PATTERN_KEYWORD");
    IElementType YANG_PATTERN_STMT = new YangElementType("YANG_PATTERN_STMT");
    IElementType YANG_PCHAR = new YangElementType("YANG_PCHAR");
    IElementType YANG_PCT_ENCODED = new YangElementType("YANG_PCT_ENCODED");
    IElementType YANG_PORT = new YangElementType("YANG_PORT");
    IElementType YANG_POS = new YangElementType("YANG_POS");
    IElementType YANG_POSITION_KEYWORD = new YangElementType("YANG_POSITION_KEYWORD");
    IElementType YANG_POSITION_STMT = new YangElementType("YANG_POSITION_STMT");
    IElementType YANG_POSITION_VALUE_ARG = new YangElementType("YANG_POSITION_VALUE_ARG");
    IElementType YANG_POSITION_VALUE_ARG_STR = new YangElementType("YANG_POSITION_VALUE_ARG_STR");
    IElementType YANG_POSITIVE_INTEGER_VALUE = new YangElementType("YANG_POSITIVE_INTEGER_VALUE");
    IElementType YANG_PREFIX = new YangElementType("YANG_PREFIX");
    IElementType YANG_PREFIX_ARG = new YangElementType("YANG_PREFIX_ARG");
    IElementType YANG_PREFIX_ARG_STR = new YangElementType("YANG_PREFIX_ARG_STR");
    IElementType YANG_PREFIX_KEYWORD = new YangElementType("YANG_PREFIX_KEYWORD");
    IElementType YANG_PREFIX_STMT = new YangElementType("YANG_PREFIX_STMT");
    IElementType YANG_PRESENCE_KEYWORD = new YangElementType("YANG_PRESENCE_KEYWORD");
    IElementType YANG_PRESENCE_STMT = new YangElementType("YANG_PRESENCE_STMT");
    IElementType YANG_QUERY = new YangElementType("YANG_QUERY");
    IElementType YANG_QUOTED_PATH_ARG = new YangElementType("YANG_QUOTED_PATH_ARG");
    IElementType YANG_QUOTED_STRING = new YangElementType("YANG_QUOTED_STRING");
    IElementType YANG_QUOTED_VCHAR = new YangElementType("YANG_QUOTED_VCHAR");
    IElementType YANG_QUOTED_XPATH_FUNCTION = new YangElementType("YANG_QUOTED_XPATH_FUNCTION");
    IElementType YANG_RANGE_ARG = new YangElementType("YANG_RANGE_ARG");
    IElementType YANG_RANGE_ARG_STR = new YangElementType("YANG_RANGE_ARG_STR");
    IElementType YANG_RANGE_BOUNDARY = new YangElementType("YANG_RANGE_BOUNDARY");
    IElementType YANG_RANGE_KEYWORD = new YangElementType("YANG_RANGE_KEYWORD");
    IElementType YANG_RANGE_PART = new YangElementType("YANG_RANGE_PART");
    IElementType YANG_RANGE_STMT = new YangElementType("YANG_RANGE_STMT");
    IElementType YANG_REFERENCE_KEYWORD = new YangElementType("YANG_REFERENCE_KEYWORD");
    IElementType YANG_REFERENCE_STMT = new YangElementType("YANG_REFERENCE_STMT");
    IElementType YANG_REFINE_ARG = new YangElementType("YANG_REFINE_ARG");
    IElementType YANG_REFINE_ARG_STR = new YangElementType("YANG_REFINE_ARG_STR");
    IElementType YANG_REFINE_KEYWORD = new YangElementType("YANG_REFINE_KEYWORD");
    IElementType YANG_REFINE_STMT = new YangElementType("YANG_REFINE_STMT");
    IElementType YANG_REG_NAME = new YangElementType("YANG_REG_NAME");
    IElementType YANG_RELATIVE_PART = new YangElementType("YANG_RELATIVE_PART");
    IElementType YANG_RELATIVE_PATH = new YangElementType("YANG_RELATIVE_PATH");
    IElementType YANG_RELATIVE_REF = new YangElementType("YANG_RELATIVE_REF");
    IElementType YANG_REL_PATH_KEYEXPR = new YangElementType("YANG_REL_PATH_KEYEXPR");
    IElementType YANG_REMATCH_FUNCTION = new YangElementType("YANG_REMATCH_FUNCTION");
    IElementType YANG_REMATCH_KEYWORD = new YangElementType("YANG_REMATCH_KEYWORD");
    IElementType YANG_REPLACE_KEYWORD = new YangElementType("YANG_REPLACE_KEYWORD");
    IElementType YANG_REPLACE_KEYWORD_STR = new YangElementType("YANG_REPLACE_KEYWORD_STR");
    IElementType YANG_REQUIRE_INSTANCE_ARG = new YangElementType("YANG_REQUIRE_INSTANCE_ARG");
    IElementType YANG_REQUIRE_INSTANCE_ARG_STR = new YangElementType("YANG_REQUIRE_INSTANCE_ARG_STR");
    IElementType YANG_REQUIRE_INSTANCE_KEYWORD = new YangElementType("YANG_REQUIRE_INSTANCE_KEYWORD");
    IElementType YANG_REQUIRE_INSTANCE_STMT = new YangElementType("YANG_REQUIRE_INSTANCE_STMT");
    IElementType YANG_RESERVED = new YangElementType("YANG_RESERVED");
    IElementType YANG_REVISION_DATE = new YangElementType("YANG_REVISION_DATE");
    IElementType YANG_REVISION_DATE_KEYWORD = new YangElementType("YANG_REVISION_DATE_KEYWORD");
    IElementType YANG_REVISION_DATE_STMT = new YangElementType("YANG_REVISION_DATE_STMT");
    IElementType YANG_REVISION_KEYWORD = new YangElementType("YANG_REVISION_KEYWORD");
    IElementType YANG_REVISION_STMT = new YangElementType("YANG_REVISION_STMT");
    IElementType YANG_REVISION_STMTS = new YangElementType("YANG_REVISION_STMTS");
    IElementType YANG_RPC_KEYWORD = new YangElementType("YANG_RPC_KEYWORD");
    IElementType YANG_RPC_STMT = new YangElementType("YANG_RPC_STMT");
    IElementType YANG_SCHEMA_NODEID = new YangElementType("YANG_SCHEMA_NODEID");
    IElementType YANG_SCHEME = new YangElementType("YANG_SCHEME");
    IElementType YANG_SEGMENT = new YangElementType("YANG_SEGMENT");
    IElementType YANG_SEGMENT_NZ = new YangElementType("YANG_SEGMENT_NZ");
    IElementType YANG_SEGMENT_NZ_NC = new YangElementType("YANG_SEGMENT_NZ_NC");
    IElementType YANG_SHORT_CASE_STMT = new YangElementType("YANG_SHORT_CASE_STMT");
    IElementType YANG_SP = new YangElementType("YANG_SP");
    IElementType YANG_SQUOTE = new YangElementType("YANG_SQUOTE");
    IElementType YANG_SQUOTE_URI = new YangElementType("YANG_SQUOTE_URI");
    IElementType YANG_SQUOTE_URIFRAGMENT = new YangElementType("YANG_SQUOTE_URIFRAGMENT");
    IElementType YANG_SQUOTE_URI_AUTHORITY = new YangElementType("YANG_SQUOTE_URI_AUTHORITY");
    IElementType YANG_SQUOTE_URI_HIER_PART = new YangElementType("YANG_SQUOTE_URI_HIER_PART");
    IElementType YANG_SQUOTE_URI_HOST = new YangElementType("YANG_SQUOTE_URI_HOST");
    IElementType YANG_SQUOTE_URI_IP_LITERAL = new YangElementType("YANG_SQUOTE_URI_IP_LITERAL");
    IElementType YANG_SQUOTE_URI_I_PV_FUTURE = new YangElementType("YANG_SQUOTE_URI_I_PV_FUTURE");
    IElementType YANG_SQUOTE_URI_PATH_ABEMPTY = new YangElementType("YANG_SQUOTE_URI_PATH_ABEMPTY");
    IElementType YANG_SQUOTE_URI_PATH_ABSOLUTE = new YangElementType("YANG_SQUOTE_URI_PATH_ABSOLUTE");
    IElementType YANG_SQUOTE_URI_PATH_ROOTLESS = new YangElementType("YANG_SQUOTE_URI_PATH_ROOTLESS");
    IElementType YANG_SQUOTE_URI_PCHAR = new YangElementType("YANG_SQUOTE_URI_PCHAR");
    IElementType YANG_SQUOTE_URI_QUERY = new YangElementType("YANG_SQUOTE_URI_QUERY");
    IElementType YANG_SQUOTE_URI_REG_NAME = new YangElementType("YANG_SQUOTE_URI_REG_NAME");
    IElementType YANG_SQUOTE_URI_SEGMENT = new YangElementType("YANG_SQUOTE_URI_SEGMENT");
    IElementType YANG_SQUOTE_URI_SEGMENT_NZ = new YangElementType("YANG_SQUOTE_URI_SEGMENT_NZ");
    IElementType YANG_SQUOTE_URI_SUB_DELIMS = new YangElementType("YANG_SQUOTE_URI_SUB_DELIMS");
    IElementType YANG_SQUOTE_URI_USERINFO = new YangElementType("YANG_SQUOTE_URI_USERINFO");
    IElementType YANG_STATUS_ARG = new YangElementType("YANG_STATUS_ARG");
    IElementType YANG_STATUS_ARG_STR = new YangElementType("YANG_STATUS_ARG_STR");
    IElementType YANG_STATUS_KEYWORD = new YangElementType("YANG_STATUS_KEYWORD");
    IElementType YANG_STATUS_STMT = new YangElementType("YANG_STATUS_STMT");
    IElementType YANG_STMTEND = new YangElementType("YANG_STMTEND");
    IElementType YANG_STRING = new YangElementType("YANG_STRING");
    IElementType YANG_STRING_RESTRICTIONS = new YangElementType("YANG_STRING_RESTRICTIONS");
    IElementType YANG_STRING_SPLITTER = new YangElementType("YANG_STRING_SPLITTER");
    IElementType YANG_SUBMODULE_HEADER_STMTS = new YangElementType("YANG_SUBMODULE_HEADER_STMTS");
    IElementType YANG_SUBMODULE_KEYWORD = new YangElementType("YANG_SUBMODULE_KEYWORD");
    IElementType YANG_SUBMODULE_STMT = new YangElementType("YANG_SUBMODULE_STMT");
    IElementType YANG_SUB_DELIMS = new YangElementType("YANG_SUB_DELIMS");
    IElementType YANG_SYSTEM_KEYWORD = new YangElementType("YANG_SYSTEM_KEYWORD");
    IElementType YANG_TRUE_KEYWORD = new YangElementType("YANG_TRUE_KEYWORD");
    IElementType YANG_TYPEDEF_KEYWORD = new YangElementType("YANG_TYPEDEF_KEYWORD");
    IElementType YANG_TYPEDEF_STMT = new YangElementType("YANG_TYPEDEF_STMT");
    IElementType YANG_TYPE_BODY_STMTS = new YangElementType("YANG_TYPE_BODY_STMTS");
    IElementType YANG_TYPE_KEYWORD = new YangElementType("YANG_TYPE_KEYWORD");
    IElementType YANG_TYPE_STMT = new YangElementType("YANG_TYPE_STMT");
    IElementType YANG_UNBOUNDED_KEYWORD = new YangElementType("YANG_UNBOUNDED_KEYWORD");
    IElementType YANG_UNION_SPECIFICATION = new YangElementType("YANG_UNION_SPECIFICATION");
    IElementType YANG_UNIQUE_ARG = new YangElementType("YANG_UNIQUE_ARG");
    IElementType YANG_UNIQUE_ARG_STR = new YangElementType("YANG_UNIQUE_ARG_STR");
    IElementType YANG_UNIQUE_KEYWORD = new YangElementType("YANG_UNIQUE_KEYWORD");
    IElementType YANG_UNIQUE_STMT = new YangElementType("YANG_UNIQUE_STMT");
    IElementType YANG_UNITS_KEYWORD = new YangElementType("YANG_UNITS_KEYWORD");
    IElementType YANG_UNITS_STMT = new YangElementType("YANG_UNITS_STMT");
    IElementType YANG_UNKNOWN_STATEMENT = new YangElementType("YANG_UNKNOWN_STATEMENT");
    IElementType YANG_UNRESERVED = new YangElementType("YANG_UNRESERVED");
    IElementType YANG_URI = new YangElementType("YANG_URI");
    IElementType YANG_URI_REFERENCE = new YangElementType("YANG_URI_REFERENCE");
    IElementType YANG_URI_STR = new YangElementType("YANG_URI_STR");
    IElementType YANG_USERINFO = new YangElementType("YANG_USERINFO");
    IElementType YANG_USER_KEYWORD = new YangElementType("YANG_USER_KEYWORD");
    IElementType YANG_USES_AUGMENT_ARG = new YangElementType("YANG_USES_AUGMENT_ARG");
    IElementType YANG_USES_AUGMENT_ARG_STR = new YangElementType("YANG_USES_AUGMENT_ARG_STR");
    IElementType YANG_USES_AUGMENT_STMT = new YangElementType("YANG_USES_AUGMENT_STMT");
    IElementType YANG_USES_KEYWORD = new YangElementType("YANG_USES_KEYWORD");
    IElementType YANG_USES_STMT = new YangElementType("YANG_USES_STMT");
    IElementType YANG_VALUE_KEYWORD = new YangElementType("YANG_VALUE_KEYWORD");
    IElementType YANG_VALUE_STMT = new YangElementType("YANG_VALUE_STMT");
    IElementType YANG_VCHAR = new YangElementType("YANG_VCHAR");
    IElementType YANG_WHEN_KEYWORD = new YangElementType("YANG_WHEN_KEYWORD");
    IElementType YANG_WHEN_STMT = new YangElementType("YANG_WHEN_STMT");
    IElementType YANG_WSP = new YangElementType("YANG_WSP");
    IElementType YANG_X_PATH_FUNCTION = new YangElementType("YANG_X_PATH_FUNCTION");
    IElementType YANG_YANG_CHAR = new YangElementType("YANG_YANG_CHAR");
    IElementType YANG_YANG_KEYWORD = new YangElementType("YANG_YANG_KEYWORD");
    IElementType YANG_YANG_STMT = new YangElementType("YANG_YANG_STMT");
    IElementType YANG_YANG_STRING = new YangElementType("YANG_YANG_STRING");
    IElementType YANG_YANG_VERSION_ARG = new YangElementType("YANG_YANG_VERSION_ARG");
    IElementType YANG_YANG_VERSION_ARG_STR = new YangElementType("YANG_YANG_VERSION_ARG_STR");
    IElementType YANG_YANG_VERSION_KEYWORD = new YangElementType("YANG_YANG_VERSION_KEYWORD");
    IElementType YANG_YANG_VERSION_STMT = new YangElementType("YANG_YANG_VERSION_STMT");
    IElementType YANG_YIN_ELEMENT_ARG = new YangElementType("YANG_YIN_ELEMENT_ARG");
    IElementType YANG_YIN_ELEMENT_ARG_STR = new YangElementType("YANG_YIN_ELEMENT_ARG_STR");
    IElementType YANG_YIN_ELEMENT_KEYWORD = new YangElementType("YANG_YIN_ELEMENT_KEYWORD");
    IElementType YANG_YIN_ELEMENT_STMT = new YangElementType("YANG_YIN_ELEMENT_STMT");
    IElementType YANG_ZERO_INTEGER_VALUE = new YangElementType("YANG_ZERO_INTEGER_VALUE");

    IElementType YANG_ALPHA = new YangTokenType("ALPHA");
    IElementType YANG_ALPHANUMERICAL_ALPHA_FIRST = new YangTokenType("ALPHANUMERICAL_ALPHA_FIRST");
    IElementType YANG_ALPHANUMERICAL_DIGIT_FIRST = new YangTokenType("ALPHANUMERICAL_DIGIT_FIRST");
    IElementType YANG_AMPERSAND = new YangTokenType("AMPERSAND");
    IElementType YANG_APOSTROPHE = new YangTokenType("APOSTROPHE");
    IElementType YANG_ASTERISK = new YangTokenType("ASTERISK");
    IElementType YANG_AT_SIGN = new YangTokenType("AT_SIGN");
    IElementType YANG_BACK_SLASH = new YangTokenType("BACK_SLASH");
    IElementType YANG_CARRIAGE_RETURN = new YangTokenType("CARRIAGE_RETURN");
    IElementType YANG_CHARS = new YangTokenType("CHARS");
    IElementType YANG_CIRCUMFLEX_ACCENT = new YangTokenType("CIRCUMFLEX_ACCENT");
    IElementType YANG_CLOSED_BRACKET = new YangTokenType("CLOSED_BRACKET");
    IElementType YANG_COLON = new YangTokenType("COLON");
    IElementType YANG_COMMA = new YangTokenType("COMMA");
    IElementType YANG_DASH = new YangTokenType("DASH");
    IElementType YANG_DATE = new YangTokenType("DATE");
    IElementType YANG_DIGITS = new YangTokenType("DIGITS");
    IElementType YANG_DOLLAR_SIGN = new YangTokenType("DOLLAR_SIGN");
    IElementType YANG_DOT = new YangTokenType("DOT");
    IElementType YANG_DOUBLE_COLON = new YangTokenType("DOUBLE_COLON");
    IElementType YANG_DOUBLE_DOT = new YangTokenType("DOUBLE_DOT");
    IElementType YANG_DOUBLE_QUOTE = new YangTokenType("DOUBLE_QUOTE");
    IElementType YANG_EIGHT = new YangTokenType("EIGHT");
    IElementType YANG_EQUALS = new YangTokenType("EQUALS");
    IElementType YANG_ESCAPES = new YangTokenType("ESCAPES");
    IElementType YANG_EXCLAMATION_MARK = new YangTokenType("EXCLAMATION_MARK");
    IElementType YANG_FIVE = new YangTokenType("FIVE");
    IElementType YANG_FORWARD_SLASH = new YangTokenType("FORWARD_SLASH");
    IElementType YANG_FOUR = new YangTokenType("FOUR");
    IElementType YANG_FRACTIONS = new YangTokenType("FRACTIONS");
    IElementType YANG_GRAVE_ACCENT = new YangTokenType("GRAVE_ACCENT");
    IElementType YANG_GREATER_THAN_SIGN = new YangTokenType("GREATER_THAN_SIGN");
    IElementType YANG_HASH = new YangTokenType("HASH");
    IElementType YANG_HEXDIG = new YangTokenType("HEXDIG");
    IElementType YANG_IPV4 = new YangTokenType("IPV4");
    IElementType YANG_LEFT_BRACE = new YangTokenType("LEFT_BRACE");
    IElementType YANG_LEFT_PARENTHESIS = new YangTokenType("LEFT_PARENTHESIS");
    IElementType YANG_LESS_THAN_SIGN = new YangTokenType("LESS_THAN_SIGN");
    IElementType YANG_LINEFEED = new YangTokenType("LINEFEED");
    IElementType YANG_NINE = new YangTokenType("NINE");
    IElementType YANG_ONE = new YangTokenType("ONE");
    IElementType YANG_OPEN_BRACKET = new YangTokenType("OPEN_BRACKET");
    IElementType YANG_PARENT_FOLDER = new YangTokenType("PARENT_FOLDER");
    IElementType YANG_PERCENT_SIGN = new YangTokenType("PERCENT_SIGN");
    IElementType YANG_PIPE = new YangTokenType("PIPE");
    IElementType YANG_PLUS_SIGN = new YangTokenType("PLUS_SIGN");
    IElementType YANG_QUESTION_MARK = new YangTokenType("QUESTION_MARK");
    IElementType YANG_RIGHT_BRACE = new YangTokenType("RIGHT_BRACE");
    IElementType YANG_RIGHT_PARENTHESIS = new YangTokenType("RIGHT_PARENTHESIS");
    IElementType YANG_SEMICOLON = new YangTokenType("SEMICOLON");
    IElementType YANG_SEVEN = new YangTokenType("SEVEN");
    IElementType YANG_SINGLE_QUOTE = new YangTokenType("SINGLE_QUOTE");
    IElementType YANG_SIX = new YangTokenType("SIX");
    IElementType YANG_SPACE = new YangTokenType("SPACE");
    IElementType YANG_TAB = new YangTokenType("TAB");
    IElementType YANG_THREE = new YangTokenType("THREE");
    IElementType YANG_TILDE = new YangTokenType("TILDE");
    IElementType YANG_TWO = new YangTokenType("TWO");
    IElementType YANG_UNDERSCORE = new YangTokenType("UNDERSCORE");
    IElementType YANG_VERSION = new YangTokenType("VERSION");
    IElementType YANG_ZERO = new YangTokenType("ZERO");
    IElementType YANG_ZEROS = new YangTokenType("ZEROS");
    IElementType YANG_ZERO_LENGTH_STRING = new YangTokenType("ZERO_LENGTH_STRING");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == YANG_ABSOLUTE_PATH) {
                return new YangAbsolutePathImpl(node);
            } else if (type == YANG_ABSOLUTE_SCHEMA_NODEID) {
                return new YangAbsoluteSchemaNodeidImpl(node);
            } else if (type == YANG_ABSOLUTE_URI) {
                return new YangAbsoluteURIImpl(node);
            } else if (type == YANG_ACTION_KEYWORD) {
                return new YangActionKeywordImpl(node);
            } else if (type == YANG_ACTION_STMT) {
                return new YangActionStmtImpl(node);
            } else if (type == YANG_ADD_KEYWORD) {
                return new YangAddKeywordImpl(node);
            } else if (type == YANG_ADD_KEYWORD_STR) {
                return new YangAddKeywordStrImpl(node);
            } else if (type == YANG_AND_KEYWORD) {
                return new YangAndKeywordImpl(node);
            } else if (type == YANG_ANYDATA_KEYWORD) {
                return new YangAnydataKeywordImpl(node);
            } else if (type == YANG_ANYDATA_STMT) {
                return new YangAnydataStmtImpl(node);
            } else if (type == YANG_ANYXML_KEYWORD) {
                return new YangAnyxmlKeywordImpl(node);
            } else if (type == YANG_ANYXML_STMT) {
                return new YangAnyxmlStmtImpl(node);
            } else if (type == YANG_ARGUMENT_KEYWORD) {
                return new YangArgumentKeywordImpl(node);
            } else if (type == YANG_ARGUMENT_STMT) {
                return new YangArgumentStmtImpl(node);
            } else if (type == YANG_AUGMENT_ARG) {
                return new YangAugmentArgImpl(node);
            } else if (type == YANG_AUGMENT_ARG_STR) {
                return new YangAugmentArgStrImpl(node);
            } else if (type == YANG_AUGMENT_KEYWORD) {
                return new YangAugmentKeywordImpl(node);
            } else if (type == YANG_AUGMENT_STMT) {
                return new YangAugmentStmtImpl(node);
            } else if (type == YANG_AUTHORITY) {
                return new YangAuthorityImpl(node);
            } else if (type == YANG_BACKSLASH_QUOTE) {
                return new YangBackslashQuoteImpl(node);
            } else if (type == YANG_BASE_KEYWORD) {
                return new YangBaseKeywordImpl(node);
            } else if (type == YANG_BASE_STMT) {
                return new YangBaseStmtImpl(node);
            } else if (type == YANG_BELONGS_TO_KEYWORD) {
                return new YangBelongsToKeywordImpl(node);
            } else if (type == YANG_BELONGS_TO_STMT) {
                return new YangBelongsToStmtImpl(node);
            } else if (type == YANG_BINARY_SPECIFICATION) {
                return new YangBinarySpecificationImpl(node);
            } else if (type == YANG_BITS_SPECIFICATION) {
                return new YangBitsSpecificationImpl(node);
            } else if (type == YANG_BIT_IS_SET_FUNCTION) {
                return new YangBitIsSetFunctionImpl(node);
            } else if (type == YANG_BIT_IS_SET_KEYWORD) {
                return new YangBitIsSetKeywordImpl(node);
            } else if (type == YANG_BIT_KEYWORD) {
                return new YangBitKeywordImpl(node);
            } else if (type == YANG_BIT_STMT) {
                return new YangBitStmtImpl(node);
            } else if (type == YANG_BLOCK_COMMENT) {
                return new YangBlockCommentImpl(node);
            } else if (type == YANG_BLOCK_COMMENT_BODY) {
                return new YangBlockCommentBodyImpl(node);
            } else if (type == YANG_BLOCK_COMMENT_END) {
                return new YangBlockCommentEndImpl(node);
            } else if (type == YANG_BLOCK_COMMENT_START) {
                return new YangBlockCommentStartImpl(node);
            } else if (type == YANG_BODY_STMTS) {
                return new YangBodyStmtsImpl(node);
            } else if (type == YANG_CASE_KEYWORD) {
                return new YangCaseKeywordImpl(node);
            } else if (type == YANG_CASE_STMT) {
                return new YangCaseStmtImpl(node);
            } else if (type == YANG_CHOICE_KEYWORD) {
                return new YangChoiceKeywordImpl(node);
            } else if (type == YANG_CHOICE_STMT) {
                return new YangChoiceStmtImpl(node);
            } else if (type == YANG_COMMENT) {
                return new YangCommentImpl(node);
            } else if (type == YANG_CONFIG_ARG) {
                return new YangConfigArgImpl(node);
            } else if (type == YANG_CONFIG_ARG_STR) {
                return new YangConfigArgStrImpl(node);
            } else if (type == YANG_CONFIG_KEYWORD) {
                return new YangConfigKeywordImpl(node);
            } else if (type == YANG_CONFIG_STMT) {
                return new YangConfigStmtImpl(node);
            } else if (type == YANG_CONTACT_KEYWORD) {
                return new YangContactKeywordImpl(node);
            } else if (type == YANG_CONTACT_STMT) {
                return new YangContactStmtImpl(node);
            } else if (type == YANG_CONTAINER_KEYWORD) {
                return new YangContainerKeywordImpl(node);
            } else if (type == YANG_CONTAINER_STMT) {
                return new YangContainerStmtImpl(node);
            } else if (type == YANG_CR) {
                return new YangCrImpl(node);
            } else if (type == YANG_CRLF) {
                return new YangCrlfImpl(node);
            } else if (type == YANG_CURRENT_FUNCTION_INVOCATION) {
                return new YangCurrentFunctionInvocationImpl(node);
            } else if (type == YANG_CURRENT_KEYWORD) {
                return new YangCurrentKeywordImpl(node);
            } else if (type == YANG_DATA_DEF_STMT) {
                return new YangDataDefStmtImpl(node);
            } else if (type == YANG_DATE_ARG) {
                return new YangDateArgImpl(node);
            } else if (type == YANG_DATE_ARG_STR) {
                return new YangDateArgStrImpl(node);
            } else if (type == YANG_DECIMAL_64_SPECIFICATION) {
                return new YangDecimal64SpecificationImpl(node);
            } else if (type == YANG_DECIMAL_VALUE) {
                return new YangDecimalValueImpl(node);
            } else if (type == YANG_DEC_OCTET) {
                return new YangDecOctetImpl(node);
            } else if (type == YANG_DEFAULT_KEYWORD) {
                return new YangDefaultKeywordImpl(node);
            } else if (type == YANG_DEFAULT_STMT) {
                return new YangDefaultStmtImpl(node);
            } else if (type == YANG_DELETE_KEYWORD) {
                return new YangDeleteKeywordImpl(node);
            } else if (type == YANG_DELETE_KEYWORD_STR) {
                return new YangDeleteKeywordStrImpl(node);
            } else if (type == YANG_DEPRECATED_KEYWORD) {
                return new YangDeprecatedKeywordImpl(node);
            } else if (type == YANG_DEREF_FUNCTION) {
                return new YangDerefFunctionImpl(node);
            } else if (type == YANG_DEREF_KEYWORD) {
                return new YangDerefKeywordImpl(node);
            } else if (type == YANG_DERIVED_FROM_FUNCTION) {
                return new YangDerivedFromFunctionImpl(node);
            } else if (type == YANG_DERIVED_FROM_KEYWORD) {
                return new YangDerivedFromKeywordImpl(node);
            } else if (type == YANG_DERIVED_FROM_OR_SELF_FUNCTION) {
                return new YangDerivedFromOrSelfFunctionImpl(node);
            } else if (type == YANG_DERIVED_FROM_OR_SELF_KEYWORD) {
                return new YangDerivedFromOrSelfKeywordImpl(node);
            } else if (type == YANG_DESCENDANT_PATH) {
                return new YangDescendantPathImpl(node);
            } else if (type == YANG_DESCENDANT_SCHEMA_NODEID) {
                return new YangDescendantSchemaNodeidImpl(node);
            } else if (type == YANG_DESCRIPTION_KEYWORD) {
                return new YangDescriptionKeywordImpl(node);
            } else if (type == YANG_DESCRIPTION_STMT) {
                return new YangDescriptionStmtImpl(node);
            } else if (type == YANG_DEVIATE_ADD_STMT) {
                return new YangDeviateAddStmtImpl(node);
            } else if (type == YANG_DEVIATE_DELETE_STMT) {
                return new YangDeviateDeleteStmtImpl(node);
            } else if (type == YANG_DEVIATE_KEYWORD) {
                return new YangDeviateKeywordImpl(node);
            } else if (type == YANG_DEVIATE_NOT_SUPPORTED_STMT) {
                return new YangDeviateNotSupportedStmtImpl(node);
            } else if (type == YANG_DEVIATE_REPLACE_STMT) {
                return new YangDeviateReplaceStmtImpl(node);
            } else if (type == YANG_DEVIATION_ARG) {
                return new YangDeviationArgImpl(node);
            } else if (type == YANG_DEVIATION_ARG_STR) {
                return new YangDeviationArgStrImpl(node);
            } else if (type == YANG_DEVIATION_KEYWORD) {
                return new YangDeviationKeywordImpl(node);
            } else if (type == YANG_DEVIATION_STMT) {
                return new YangDeviationStmtImpl(node);
            } else if (type == YANG_DEVIATION_STMT_BODY_ARGS) {
                return new YangDeviationStmtBodyArgsImpl(node);
            } else if (type == YANG_DIGIT) {
                return new YangDigitImpl(node);
            } else if (type == YANG_DOUBLE_BACKSLASH) {
                return new YangDoubleBackslashImpl(node);
            } else if (type == YANG_DOUBLE_FORWARD_SLASH) {
                return new YangDoubleForwardSlashImpl(node);
            } else if (type == YANG_DOUBLE_QUOTED_VCHAR) {
                return new YangDoubleQuotedVcharImpl(node);
            } else if (type == YANG_DQUOTE) {
                return new YangDquoteImpl(node);
            } else if (type == YANG_ENUM_KEYWORD) {
                return new YangEnumKeywordImpl(node);
            } else if (type == YANG_ENUM_SPECIFICATION) {
                return new YangEnumSpecificationImpl(node);
            } else if (type == YANG_ENUM_STMT) {
                return new YangEnumStmtImpl(node);
            } else if (type == YANG_ENUM_VALUE_FUNCTION) {
                return new YangEnumValueFunctionImpl(node);
            } else if (type == YANG_ENUM_VALUE_KEYWORD) {
                return new YangEnumValueKeywordImpl(node);
            } else if (type == YANG_ERROR_APP_TAG_KEYWORD) {
                return new YangErrorAppTagKeywordImpl(node);
            } else if (type == YANG_ERROR_APP_TAG_STMT) {
                return new YangErrorAppTagStmtImpl(node);
            } else if (type == YANG_ERROR_MESSAGE_KEYWORD) {
                return new YangErrorMessageKeywordImpl(node);
            } else if (type == YANG_ERROR_MESSAGE_STMT) {
                return new YangErrorMessageStmtImpl(node);
            } else if (type == YANG_EXTENSION_KEYWORD) {
                return new YangExtensionKeywordImpl(node);
            } else if (type == YANG_EXTENSION_STMT) {
                return new YangExtensionStmtImpl(node);
            } else if (type == YANG_FALSE_KEYWORD) {
                return new YangFalseKeywordImpl(node);
            } else if (type == YANG_FEATURE_KEYWORD) {
                return new YangFeatureKeywordImpl(node);
            } else if (type == YANG_FEATURE_STMT) {
                return new YangFeatureStmtImpl(node);
            } else if (type == YANG_FILE_REFERENCE) {
                return new YangFileReferenceImpl(node);
            } else if (type == YANG_FRACTION_DIGITS_ARG) {
                return new YangFractionDigitsArgImpl(node);
            } else if (type == YANG_FRACTION_DIGITS_ARG_STR) {
                return new YangFractionDigitsArgStrImpl(node);
            } else if (type == YANG_FRACTION_DIGITS_KEYWORD) {
                return new YangFractionDigitsKeywordImpl(node);
            } else if (type == YANG_FRACTION_DIGITS_STMT) {
                return new YangFractionDigitsStmtImpl(node);
            } else if (type == YANG_FRAGMENT) {
                return new YangFragmentImpl(node);
            } else if (type == YANG_FUNCTION) {
                return new YangFunctionImpl(node);
            } else if (type == YANG_FUNCTION_BODY_END) {
                return new YangFunctionBodyEndImpl(node);
            } else if (type == YANG_FUNCTION_BODY_IDENTITY) {
                return new YangFunctionBodyIdentityImpl(node);
            } else if (type == YANG_FUNCTION_BODY_NODE) {
                return new YangFunctionBodyNodeImpl(node);
            } else if (type == YANG_FUNCTION_BODY_NODE_IDENTITY) {
                return new YangFunctionBodyNodeIdentityImpl(node);
            } else if (type == YANG_FUNCTION_BODY_NODE_STRING) {
                return new YangFunctionBodyNodeStringImpl(node);
            } else if (type == YANG_FUNCTION_BODY_START) {
                return new YangFunctionBodyStartImpl(node);
            } else if (type == YANG_FUNCTION_BODY_STRING) {
                return new YangFunctionBodyStringImpl(node);
            } else if (type == YANG_FUNCTION_BODY_STRING_STRING) {
                return new YangFunctionBodyStringStringImpl(node);
            } else if (type == YANG_GEN_DELIMS) {
                return new YangGenDelimsImpl(node);
            } else if (type == YANG_GROUPING_KEYWORD) {
                return new YangGroupingKeywordImpl(node);
            } else if (type == YANG_GROUPING_STMT) {
                return new YangGroupingStmtImpl(node);
            } else if (type == YANG_HIER_PART) {
                return new YangHierPartImpl(node);
            } else if (type == YANG_HOST) {
                return new YangHostImpl(node);
            } else if (type == YANG_HTAB) {
                return new YangHtabImpl(node);
            } else if (type == YANG_H_16) {
                return new YangH16Impl(node);
            } else if (type == YANG_IDENTIFIER) {
                return new YangIdentifierImpl(node);
            } else if (type == YANG_IDENTIFIER_ARG) {
                return new YangIdentifierArgImpl(node);
            } else if (type == YANG_IDENTIFIER_ARG_STR) {
                return new YangIdentifierArgStrImpl(node);
            } else if (type == YANG_IDENTIFIER_REF) {
                return new YangIdentifierRefImpl(node);
            } else if (type == YANG_IDENTIFIER_REF_ARG) {
                return new YangIdentifierRefArgImpl(node);
            } else if (type == YANG_IDENTIFIER_REF_ARG_STR) {
                return new YangIdentifierRefArgStrImpl(node);
            } else if (type == YANG_IDENTITYREF_SPECIFICATION) {
                return new YangIdentityrefSpecificationImpl(node);
            } else if (type == YANG_IDENTITY_KEYWORD) {
                return new YangIdentityKeywordImpl(node);
            } else if (type == YANG_IDENTITY_STMT) {
                return new YangIdentityStmtImpl(node);
            } else if (type == YANG_IF_FEATURE_EXPR) {
                return new YangIfFeatureExprImpl(node);
            } else if (type == YANG_IF_FEATURE_EXPR_STR) {
                return new YangIfFeatureExprStrImpl(node);
            } else if (type == YANG_IF_FEATURE_FACTOR) {
                return new YangIfFeatureFactorImpl(node);
            } else if (type == YANG_IF_FEATURE_KEYWORD) {
                return new YangIfFeatureKeywordImpl(node);
            } else if (type == YANG_IF_FEATURE_STMT) {
                return new YangIfFeatureStmtImpl(node);
            } else if (type == YANG_IF_FEATURE_TERM) {
                return new YangIfFeatureTermImpl(node);
            } else if (type == YANG_IMPORT_KEYWORD) {
                return new YangImportKeywordImpl(node);
            } else if (type == YANG_IMPORT_STMT) {
                return new YangImportStmtImpl(node);
            } else if (type == YANG_INCLUDE_KEYWORD) {
                return new YangIncludeKeywordImpl(node);
            } else if (type == YANG_INCLUDE_STMT) {
                return new YangIncludeStmtImpl(node);
            } else if (type == YANG_INDENTABLE_QUOTED_STRING) {
                return new YangIndentableQuotedStringImpl(node);
            } else if (type == YANG_INDENTABLE_STRING) {
                return new YangIndentableStringImpl(node);
            } else if (type == YANG_INPUT_KEYWORD) {
                return new YangInputKeywordImpl(node);
            } else if (type == YANG_INPUT_STMT) {
                return new YangInputStmtImpl(node);
            } else if (type == YANG_INSTANCE_IDENTIFIER) {
                return new YangInstanceIdentifierImpl(node);
            } else if (type == YANG_INSTANCE_IDENTIFIER_SPECIFICATION) {
                return new YangInstanceIdentifierSpecificationImpl(node);
            } else if (type == YANG_INTEGER_VALUE) {
                return new YangIntegerValueImpl(node);
            } else if (type == YANG_INTEGER_VALUE_STR) {
                return new YangIntegerValueStrImpl(node);
            } else if (type == YANG_INVERT_MATCH_KEYWORD) {
                return new YangInvertMatchKeywordImpl(node);
            } else if (type == YANG_IP_LITERAL) {
                return new YangIPLiteralImpl(node);
            } else if (type == YANG_I_PV_4_ADDRESS) {
                return new YangIPv4AddressImpl(node);
            } else if (type == YANG_I_PV_6_ADDRESS) {
                return new YangIPv6AddressImpl(node);
            } else if (type == YANG_I_PV_FUTURE) {
                return new YangIPvFutureImpl(node);
            } else if (type == YANG_KEY_ARG) {
                return new YangKeyArgImpl(node);
            } else if (type == YANG_KEY_ARG_STR) {
                return new YangKeyArgStrImpl(node);
            } else if (type == YANG_KEY_KEYWORD) {
                return new YangKeyKeywordImpl(node);
            } else if (type == YANG_KEY_PREDICATE) {
                return new YangKeyPredicateImpl(node);
            } else if (type == YANG_KEY_PREDICATE_EXPR) {
                return new YangKeyPredicateExprImpl(node);
            } else if (type == YANG_KEY_STMT) {
                return new YangKeyStmtImpl(node);
            } else if (type == YANG_LEAFREF_SPECIFICATION) {
                return new YangLeafrefSpecificationImpl(node);
            } else if (type == YANG_LEAF_KEYWORD) {
                return new YangLeafKeywordImpl(node);
            } else if (type == YANG_LEAF_LIST_KEYWORD) {
                return new YangLeafListKeywordImpl(node);
            } else if (type == YANG_LEAF_LIST_PREDICATE) {
                return new YangLeafListPredicateImpl(node);
            } else if (type == YANG_LEAF_LIST_PREDICATE_EXPR) {
                return new YangLeafListPredicateExprImpl(node);
            } else if (type == YANG_LEAF_LIST_STMT) {
                return new YangLeafListStmtImpl(node);
            } else if (type == YANG_LEAF_STMT) {
                return new YangLeafStmtImpl(node);
            } else if (type == YANG_LENGTH_ARG) {
                return new YangLengthArgImpl(node);
            } else if (type == YANG_LENGTH_ARG_STR) {
                return new YangLengthArgStrImpl(node);
            } else if (type == YANG_LENGTH_BOUNDARY) {
                return new YangLengthBoundaryImpl(node);
            } else if (type == YANG_LENGTH_KEYWORD) {
                return new YangLengthKeywordImpl(node);
            } else if (type == YANG_LENGTH_PART) {
                return new YangLengthPartImpl(node);
            } else if (type == YANG_LENGTH_STMT) {
                return new YangLengthStmtImpl(node);
            } else if (type == YANG_LF) {
                return new YangLfImpl(node);
            } else if (type == YANG_LINE_BREAK) {
                return new YangLineBreakImpl(node);
            } else if (type == YANG_LINKAGE_STMTS) {
                return new YangLinkageStmtsImpl(node);
            } else if (type == YANG_LIST_KEYWORD) {
                return new YangListKeywordImpl(node);
            } else if (type == YANG_LIST_STMT) {
                return new YangListStmtImpl(node);
            } else if (type == YANG_LS_32) {
                return new YangLs32Impl(node);
            } else if (type == YANG_MANDATORY_ARG) {
                return new YangMandatoryArgImpl(node);
            } else if (type == YANG_MANDATORY_ARG_STR) {
                return new YangMandatoryArgStrImpl(node);
            } else if (type == YANG_MANDATORY_KEYWORD) {
                return new YangMandatoryKeywordImpl(node);
            } else if (type == YANG_MANDATORY_STMT) {
                return new YangMandatoryStmtImpl(node);
            } else if (type == YANG_MAX_ELEMENTS_KEYWORD) {
                return new YangMaxElementsKeywordImpl(node);
            } else if (type == YANG_MAX_ELEMENTS_STMT) {
                return new YangMaxElementsStmtImpl(node);
            } else if (type == YANG_MAX_KEYWORD) {
                return new YangMaxKeywordImpl(node);
            } else if (type == YANG_MAX_VALUE_ARG) {
                return new YangMaxValueArgImpl(node);
            } else if (type == YANG_MAX_VALUE_ARG_STR) {
                return new YangMaxValueArgStrImpl(node);
            } else if (type == YANG_META_STMTS) {
                return new YangMetaStmtsImpl(node);
            } else if (type == YANG_MIN_ELEMENTS_KEYWORD) {
                return new YangMinElementsKeywordImpl(node);
            } else if (type == YANG_MIN_ELEMENTS_STMT) {
                return new YangMinElementsStmtImpl(node);
            } else if (type == YANG_MIN_KEYWORD) {
                return new YangMinKeywordImpl(node);
            } else if (type == YANG_MIN_VALUE_ARG) {
                return new YangMinValueArgImpl(node);
            } else if (type == YANG_MIN_VALUE_ARG_STR) {
                return new YangMinValueArgStrImpl(node);
            } else if (type == YANG_MODIFIER_ARG) {
                return new YangModifierArgImpl(node);
            } else if (type == YANG_MODIFIER_ARG_STR) {
                return new YangModifierArgStrImpl(node);
            } else if (type == YANG_MODIFIER_KEYWORD) {
                return new YangModifierKeywordImpl(node);
            } else if (type == YANG_MODIFIER_STMT) {
                return new YangModifierStmtImpl(node);
            } else if (type == YANG_MODULE_HEADER_STMTS) {
                return new YangModuleHeaderStmtsImpl(node);
            } else if (type == YANG_MODULE_KEYWORD) {
                return new YangModuleKeywordImpl(node);
            } else if (type == YANG_MODULE_STMT) {
                return new YangModuleStmtImpl(node);
            } else if (type == YANG_MUST_KEYWORD) {
                return new YangMustKeywordImpl(node);
            } else if (type == YANG_MUST_STMT) {
                return new YangMustStmtImpl(node);
            } else if (type == YANG_NAMESPACE_KEYWORD) {
                return new YangNamespaceKeywordImpl(node);
            } else if (type == YANG_NAMESPACE_STMT) {
                return new YangNamespaceStmtImpl(node);
            } else if (type == YANG_NODE_IDENTIFIER) {
                return new YangNodeIdentifierImpl(node);
            } else if (type == YANG_NON_NEGATIVE_INTEGER_VALUE) {
                return new YangNonNegativeIntegerValueImpl(node);
            } else if (type == YANG_NON_ZERO_DIGIT) {
                return new YangNonZeroDigitImpl(node);
            } else if (type == YANG_NOTIFICATION_KEYWORD) {
                return new YangNotificationKeywordImpl(node);
            } else if (type == YANG_NOTIFICATION_STMT) {
                return new YangNotificationStmtImpl(node);
            } else if (type == YANG_NOT_KEYWORD) {
                return new YangNotKeywordImpl(node);
            } else if (type == YANG_NOT_SUPPORTED_KEYWORD) {
                return new YangNotSupportedKeywordImpl(node);
            } else if (type == YANG_NOT_SUPPORTED_KEYWORD_STR) {
                return new YangNotSupportedKeywordStrImpl(node);
            } else if (type == YANG_NUMERICAL_RESTRICTIONS) {
                return new YangNumericalRestrictionsImpl(node);
            } else if (type == YANG_OBSOLETE_KEYWORD) {
                return new YangObsoleteKeywordImpl(node);
            } else if (type == YANG_ORDERED_BY_ARG) {
                return new YangOrderedByArgImpl(node);
            } else if (type == YANG_ORDERED_BY_ARG_STR) {
                return new YangOrderedByArgStrImpl(node);
            } else if (type == YANG_ORDERED_BY_KEYWORD) {
                return new YangOrderedByKeywordImpl(node);
            } else if (type == YANG_ORDERED_BY_STMT) {
                return new YangOrderedByStmtImpl(node);
            } else if (type == YANG_ORGANIZATION_KEYWORD) {
                return new YangOrganizationKeywordImpl(node);
            } else if (type == YANG_ORGANIZATION_STMT) {
                return new YangOrganizationStmtImpl(node);
            } else if (type == YANG_OR_KEYWORD) {
                return new YangOrKeywordImpl(node);
            } else if (type == YANG_OUTPUT_KEYWORD) {
                return new YangOutputKeywordImpl(node);
            } else if (type == YANG_OUTPUT_STMT) {
                return new YangOutputStmtImpl(node);
            } else if (type == YANG_PATH) {
                return new YangPathImpl(node);
            } else if (type == YANG_PATH_ABEMPTY) {
                return new YangPathAbemptyImpl(node);
            } else if (type == YANG_PATH_ABSOLUTE) {
                return new YangPathAbsoluteImpl(node);
            } else if (type == YANG_PATH_ARG) {
                return new YangPathArgImpl(node);
            } else if (type == YANG_PATH_ARG_STR) {
                return new YangPathArgStrImpl(node);
            } else if (type == YANG_PATH_EMPTY) {
                return new YangPathEmptyImpl(node);
            } else if (type == YANG_PATH_EQUALITY_EXPR) {
                return new YangPathEqualityExprImpl(node);
            } else if (type == YANG_PATH_KEYWORD) {
                return new YangPathKeywordImpl(node);
            } else if (type == YANG_PATH_KEY_EXPR) {
                return new YangPathKeyExprImpl(node);
            } else if (type == YANG_PATH_NOSCHEME) {
                return new YangPathNoschemeImpl(node);
            } else if (type == YANG_PATH_PREDICATE) {
                return new YangPathPredicateImpl(node);
            } else if (type == YANG_PATH_ROOTLESS) {
                return new YangPathRootlessImpl(node);
            } else if (type == YANG_PATH_STMT) {
                return new YangPathStmtImpl(node);
            } else if (type == YANG_PATTERN_BODY) {
                return new YangPatternBodyImpl(node);
            } else if (type == YANG_PATTERN_KEYWORD) {
                return new YangPatternKeywordImpl(node);
            } else if (type == YANG_PATTERN_STMT) {
                return new YangPatternStmtImpl(node);
            } else if (type == YANG_PCHAR) {
                return new YangPcharImpl(node);
            } else if (type == YANG_PCT_ENCODED) {
                return new YangPctEncodedImpl(node);
            } else if (type == YANG_PORT) {
                return new YangPortImpl(node);
            } else if (type == YANG_POS) {
                return new YangPosImpl(node);
            } else if (type == YANG_POSITION_KEYWORD) {
                return new YangPositionKeywordImpl(node);
            } else if (type == YANG_POSITION_STMT) {
                return new YangPositionStmtImpl(node);
            } else if (type == YANG_POSITION_VALUE_ARG) {
                return new YangPositionValueArgImpl(node);
            } else if (type == YANG_POSITION_VALUE_ARG_STR) {
                return new YangPositionValueArgStrImpl(node);
            } else if (type == YANG_POSITIVE_INTEGER_VALUE) {
                return new YangPositiveIntegerValueImpl(node);
            } else if (type == YANG_PREFIX) {
                return new YangPrefixImpl(node);
            } else if (type == YANG_PREFIX_ARG) {
                return new YangPrefixArgImpl(node);
            } else if (type == YANG_PREFIX_ARG_STR) {
                return new YangPrefixArgStrImpl(node);
            } else if (type == YANG_PREFIX_KEYWORD) {
                return new YangPrefixKeywordImpl(node);
            } else if (type == YANG_PREFIX_STMT) {
                return new YangPrefixStmtImpl(node);
            } else if (type == YANG_PRESENCE_KEYWORD) {
                return new YangPresenceKeywordImpl(node);
            } else if (type == YANG_PRESENCE_STMT) {
                return new YangPresenceStmtImpl(node);
            } else if (type == YANG_QUERY) {
                return new YangQueryImpl(node);
            } else if (type == YANG_QUOTED_PATH_ARG) {
                return new YangQuotedPathArgImpl(node);
            } else if (type == YANG_QUOTED_STRING) {
                return new YangQuotedStringImpl(node);
            } else if (type == YANG_QUOTED_VCHAR) {
                return new YangQuotedVcharImpl(node);
            } else if (type == YANG_QUOTED_XPATH_FUNCTION) {
                return new YangQuotedXpathFunctionImpl(node);
            } else if (type == YANG_RANGE_ARG) {
                return new YangRangeArgImpl(node);
            } else if (type == YANG_RANGE_ARG_STR) {
                return new YangRangeArgStrImpl(node);
            } else if (type == YANG_RANGE_BOUNDARY) {
                return new YangRangeBoundaryImpl(node);
            } else if (type == YANG_RANGE_KEYWORD) {
                return new YangRangeKeywordImpl(node);
            } else if (type == YANG_RANGE_PART) {
                return new YangRangePartImpl(node);
            } else if (type == YANG_RANGE_STMT) {
                return new YangRangeStmtImpl(node);
            } else if (type == YANG_REFERENCE_KEYWORD) {
                return new YangReferenceKeywordImpl(node);
            } else if (type == YANG_REFERENCE_STMT) {
                return new YangReferenceStmtImpl(node);
            } else if (type == YANG_REFINE_ARG) {
                return new YangRefineArgImpl(node);
            } else if (type == YANG_REFINE_ARG_STR) {
                return new YangRefineArgStrImpl(node);
            } else if (type == YANG_REFINE_KEYWORD) {
                return new YangRefineKeywordImpl(node);
            } else if (type == YANG_REFINE_STMT) {
                return new YangRefineStmtImpl(node);
            } else if (type == YANG_REG_NAME) {
                return new YangRegNameImpl(node);
            } else if (type == YANG_RELATIVE_PART) {
                return new YangRelativePartImpl(node);
            } else if (type == YANG_RELATIVE_PATH) {
                return new YangRelativePathImpl(node);
            } else if (type == YANG_RELATIVE_REF) {
                return new YangRelativeRefImpl(node);
            } else if (type == YANG_REL_PATH_KEYEXPR) {
                return new YangRelPathKeyexprImpl(node);
            } else if (type == YANG_REMATCH_FUNCTION) {
                return new YangRematchFunctionImpl(node);
            } else if (type == YANG_REMATCH_KEYWORD) {
                return new YangRematchKeywordImpl(node);
            } else if (type == YANG_REPLACE_KEYWORD) {
                return new YangReplaceKeywordImpl(node);
            } else if (type == YANG_REPLACE_KEYWORD_STR) {
                return new YangReplaceKeywordStrImpl(node);
            } else if (type == YANG_REQUIRE_INSTANCE_ARG) {
                return new YangRequireInstanceArgImpl(node);
            } else if (type == YANG_REQUIRE_INSTANCE_ARG_STR) {
                return new YangRequireInstanceArgStrImpl(node);
            } else if (type == YANG_REQUIRE_INSTANCE_KEYWORD) {
                return new YangRequireInstanceKeywordImpl(node);
            } else if (type == YANG_REQUIRE_INSTANCE_STMT) {
                return new YangRequireInstanceStmtImpl(node);
            } else if (type == YANG_RESERVED) {
                return new YangReservedImpl(node);
            } else if (type == YANG_REVISION_DATE) {
                return new YangRevisionDateImpl(node);
            } else if (type == YANG_REVISION_DATE_KEYWORD) {
                return new YangRevisionDateKeywordImpl(node);
            } else if (type == YANG_REVISION_DATE_STMT) {
                return new YangRevisionDateStmtImpl(node);
            } else if (type == YANG_REVISION_KEYWORD) {
                return new YangRevisionKeywordImpl(node);
            } else if (type == YANG_REVISION_STMT) {
                return new YangRevisionStmtImpl(node);
            } else if (type == YANG_REVISION_STMTS) {
                return new YangRevisionStmtsImpl(node);
            } else if (type == YANG_RPC_KEYWORD) {
                return new YangRpcKeywordImpl(node);
            } else if (type == YANG_RPC_STMT) {
                return new YangRpcStmtImpl(node);
            } else if (type == YANG_SCHEMA_NODEID) {
                return new YangSchemaNodeidImpl(node);
            } else if (type == YANG_SCHEME) {
                return new YangSchemeImpl(node);
            } else if (type == YANG_SEGMENT) {
                return new YangSegmentImpl(node);
            } else if (type == YANG_SEGMENT_NZ) {
                return new YangSegmentNzImpl(node);
            } else if (type == YANG_SEGMENT_NZ_NC) {
                return new YangSegmentNzNcImpl(node);
            } else if (type == YANG_SP) {
                return new YangSpImpl(node);
            } else if (type == YANG_SQUOTE) {
                return new YangSquoteImpl(node);
            } else if (type == YANG_SQUOTE_URI) {
                return new YangSquoteUriImpl(node);
            } else if (type == YANG_SQUOTE_URIFRAGMENT) {
                return new YangSquoteUrifragmentImpl(node);
            } else if (type == YANG_SQUOTE_URI_AUTHORITY) {
                return new YangSquoteUriAuthorityImpl(node);
            } else if (type == YANG_SQUOTE_URI_HIER_PART) {
                return new YangSquoteUriHierPartImpl(node);
            } else if (type == YANG_SQUOTE_URI_HOST) {
                return new YangSquoteUriHostImpl(node);
            } else if (type == YANG_SQUOTE_URI_IP_LITERAL) {
                return new YangSquoteUriIPLiteralImpl(node);
            } else if (type == YANG_SQUOTE_URI_I_PV_FUTURE) {
                return new YangSquoteUriIPvFutureImpl(node);
            } else if (type == YANG_SQUOTE_URI_PATH_ABEMPTY) {
                return new YangSquoteUriPathAbemptyImpl(node);
            } else if (type == YANG_SQUOTE_URI_PATH_ABSOLUTE) {
                return new YangSquoteUriPathAbsoluteImpl(node);
            } else if (type == YANG_SQUOTE_URI_PATH_ROOTLESS) {
                return new YangSquoteUriPathRootlessImpl(node);
            } else if (type == YANG_SQUOTE_URI_PCHAR) {
                return new YangSquoteUriPcharImpl(node);
            } else if (type == YANG_SQUOTE_URI_QUERY) {
                return new YangSquoteUriQueryImpl(node);
            } else if (type == YANG_SQUOTE_URI_REG_NAME) {
                return new YangSquoteUriRegNameImpl(node);
            } else if (type == YANG_SQUOTE_URI_SEGMENT) {
                return new YangSquoteUriSegmentImpl(node);
            } else if (type == YANG_SQUOTE_URI_SEGMENT_NZ) {
                return new YangSquoteUriSegmentNzImpl(node);
            } else if (type == YANG_SQUOTE_URI_SUB_DELIMS) {
                return new YangSquoteUriSubDelimsImpl(node);
            } else if (type == YANG_SQUOTE_URI_USERINFO) {
                return new YangSquoteUriUserinfoImpl(node);
            } else if (type == YANG_STATUS_ARG) {
                return new YangStatusArgImpl(node);
            } else if (type == YANG_STATUS_ARG_STR) {
                return new YangStatusArgStrImpl(node);
            } else if (type == YANG_STATUS_KEYWORD) {
                return new YangStatusKeywordImpl(node);
            } else if (type == YANG_STATUS_STMT) {
                return new YangStatusStmtImpl(node);
            } else if (type == YANG_STMTEND) {
                return new YangStmtendImpl(node);
            } else if (type == YANG_STRING) {
                return new YangStringImpl(node);
            } else if (type == YANG_STRING_RESTRICTIONS) {
                return new YangStringRestrictionsImpl(node);
            } else if (type == YANG_STRING_SPLITTER) {
                return new YangStringSplitterImpl(node);
            } else if (type == YANG_SUBMODULE_HEADER_STMTS) {
                return new YangSubmoduleHeaderStmtsImpl(node);
            } else if (type == YANG_SUBMODULE_KEYWORD) {
                return new YangSubmoduleKeywordImpl(node);
            } else if (type == YANG_SUBMODULE_STMT) {
                return new YangSubmoduleStmtImpl(node);
            } else if (type == YANG_SUB_DELIMS) {
                return new YangSubDelimsImpl(node);
            } else if (type == YANG_SYSTEM_KEYWORD) {
                return new YangSystemKeywordImpl(node);
            } else if (type == YANG_TRUE_KEYWORD) {
                return new YangTrueKeywordImpl(node);
            } else if (type == YANG_TYPEDEF_KEYWORD) {
                return new YangTypedefKeywordImpl(node);
            } else if (type == YANG_TYPEDEF_STMT) {
                return new YangTypedefStmtImpl(node);
            } else if (type == YANG_TYPE_BODY_STMTS) {
                return new YangTypeBodyStmtsImpl(node);
            } else if (type == YANG_TYPE_KEYWORD) {
                return new YangTypeKeywordImpl(node);
            } else if (type == YANG_TYPE_STMT) {
                return new YangTypeStmtImpl(node);
            } else if (type == YANG_UNBOUNDED_KEYWORD) {
                return new YangUnboundedKeywordImpl(node);
            } else if (type == YANG_UNION_SPECIFICATION) {
                return new YangUnionSpecificationImpl(node);
            } else if (type == YANG_UNIQUE_ARG) {
                return new YangUniqueArgImpl(node);
            } else if (type == YANG_UNIQUE_ARG_STR) {
                return new YangUniqueArgStrImpl(node);
            } else if (type == YANG_UNIQUE_KEYWORD) {
                return new YangUniqueKeywordImpl(node);
            } else if (type == YANG_UNIQUE_STMT) {
                return new YangUniqueStmtImpl(node);
            } else if (type == YANG_UNITS_KEYWORD) {
                return new YangUnitsKeywordImpl(node);
            } else if (type == YANG_UNITS_STMT) {
                return new YangUnitsStmtImpl(node);
            } else if (type == YANG_UNKNOWN_STATEMENT) {
                return new YangUnknownStatementImpl(node);
            } else if (type == YANG_UNRESERVED) {
                return new YangUnreservedImpl(node);
            } else if (type == YANG_URI) {
                return new YangUriImpl(node);
            } else if (type == YANG_URI_REFERENCE) {
                return new YangURIReferenceImpl(node);
            } else if (type == YANG_URI_STR) {
                return new YangUriStrImpl(node);
            } else if (type == YANG_USERINFO) {
                return new YangUserinfoImpl(node);
            } else if (type == YANG_USER_KEYWORD) {
                return new YangUserKeywordImpl(node);
            } else if (type == YANG_USES_AUGMENT_ARG) {
                return new YangUsesAugmentArgImpl(node);
            } else if (type == YANG_USES_AUGMENT_ARG_STR) {
                return new YangUsesAugmentArgStrImpl(node);
            } else if (type == YANG_USES_AUGMENT_STMT) {
                return new YangUsesAugmentStmtImpl(node);
            } else if (type == YANG_USES_KEYWORD) {
                return new YangUsesKeywordImpl(node);
            } else if (type == YANG_USES_STMT) {
                return new YangUsesStmtImpl(node);
            } else if (type == YANG_VALUE_KEYWORD) {
                return new YangValueKeywordImpl(node);
            } else if (type == YANG_VALUE_STMT) {
                return new YangValueStmtImpl(node);
            } else if (type == YANG_VCHAR) {
                return new YangVcharImpl(node);
            } else if (type == YANG_WHEN_KEYWORD) {
                return new YangWhenKeywordImpl(node);
            } else if (type == YANG_WHEN_STMT) {
                return new YangWhenStmtImpl(node);
            } else if (type == YANG_WSP) {
                return new YangWspImpl(node);
            } else if (type == YANG_X_PATH_FUNCTION) {
                return new YangXPathFunctionImpl(node);
            } else if (type == YANG_YANG_CHAR) {
                return new YangYangCharImpl(node);
            } else if (type == YANG_YANG_KEYWORD) {
                return new YangYangKeywordImpl(node);
            } else if (type == YANG_YANG_STMT) {
                return new YangYangStmtImpl(node);
            } else if (type == YANG_YANG_STRING) {
                return new YangYangStringImpl(node);
            } else if (type == YANG_YANG_VERSION_ARG) {
                return new YangYangVersionArgImpl(node);
            } else if (type == YANG_YANG_VERSION_ARG_STR) {
                return new YangYangVersionArgStrImpl(node);
            } else if (type == YANG_YANG_VERSION_KEYWORD) {
                return new YangYangVersionKeywordImpl(node);
            } else if (type == YANG_YANG_VERSION_STMT) {
                return new YangYangVersionStmtImpl(node);
            } else if (type == YANG_YIN_ELEMENT_ARG) {
                return new YangYinElementArgImpl(node);
            } else if (type == YANG_YIN_ELEMENT_ARG_STR) {
                return new YangYinElementArgStrImpl(node);
            } else if (type == YANG_YIN_ELEMENT_KEYWORD) {
                return new YangYinElementKeywordImpl(node);
            } else if (type == YANG_YIN_ELEMENT_STMT) {
                return new YangYinElementStmtImpl(node);
            } else if (type == YANG_ZERO_INTEGER_VALUE) {
                return new YangZeroIntegerValueImpl(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
