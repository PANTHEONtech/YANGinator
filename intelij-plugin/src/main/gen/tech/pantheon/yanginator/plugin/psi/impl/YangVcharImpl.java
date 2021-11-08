// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.pantheon.yanginator.plugin.psi.YangDigit;
import tech.pantheon.yanginator.plugin.psi.YangVchar;
import tech.pantheon.yanginator.plugin.psi.YangVisitor;

import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ALPHA;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_ASTERISK;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_BACK_SLASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_CLOSED_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_COLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_DOUBLE_DOT;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_EQUAL;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_FORWARD_SLASH;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_LEFT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OPEN_BRACKET;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_OTHER_CHARACTER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_PIPE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_POSITIVE_NUMBER;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_BRACE;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_RIGHT_PARENTHESIS;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SEMICOLON;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_SINGLE_LINE_COMMENT_START;
import static tech.pantheon.yanginator.plugin.psi.YangTypes.YANG_UNDERSCORE;

public class YangVcharImpl extends YangNamedElementImpl implements YangVchar {

  public YangVcharImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull YangVisitor visitor) {
    visitor.visitVchar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof YangVisitor) accept((YangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public YangDigit getDigit() {
    return findChildByClass(YangDigit.class);
  }

  @Override
  @Nullable
  public PsiElement getAlpha() {
    return findChildByType(YANG_ALPHA);
  }

  @Override
  @Nullable
  public PsiElement getAsterisk() {
    return findChildByType(YANG_ASTERISK);
  }

  @Override
  @Nullable
  public PsiElement getBackSlash() {
    return findChildByType(YANG_BACK_SLASH);
  }

  @Override
  @Nullable
  public PsiElement getClosedBracket() {
    return findChildByType(YANG_CLOSED_BRACKET);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(YANG_COLON);
  }

  @Override
  @Nullable
  public PsiElement getDash() {
    return findChildByType(YANG_DASH);
  }

  @Override
  @Nullable
  public PsiElement getDot() {
    return findChildByType(YANG_DOT);
  }

  @Override
  @Nullable
  public PsiElement getDoubleDot() {
    return findChildByType(YANG_DOUBLE_DOT);
  }

  @Override
  @Nullable
  public PsiElement getEqual() {
    return findChildByType(YANG_EQUAL);
  }

  @Override
  @Nullable
  public PsiElement getForwardSlash() {
    return findChildByType(YANG_FORWARD_SLASH);
  }

  @Override
  @Nullable
  public PsiElement getLeftBrace() {
    return findChildByType(YANG_LEFT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getLeftParenthesis() {
    return findChildByType(YANG_LEFT_PARENTHESIS);
  }

  @Override
  @Nullable
  public PsiElement getOpenBracket() {
    return findChildByType(YANG_OPEN_BRACKET);
  }

  @Override
  @Nullable
  public PsiElement getOtherCharacter() {
    return findChildByType(YANG_OTHER_CHARACTER);
  }

  @Override
  @Nullable
  public PsiElement getPipe() {
    return findChildByType(YANG_PIPE);
  }

  @Override
  @Nullable
  public PsiElement getPositiveNumber() {
    return findChildByType(YANG_POSITIVE_NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getRightBrace() {
    return findChildByType(YANG_RIGHT_BRACE);
  }

  @Override
  @Nullable
  public PsiElement getRightParenthesis() {
    return findChildByType(YANG_RIGHT_PARENTHESIS);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(YANG_SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getSingleLineCommentStart() {
    return findChildByType(YANG_SINGLE_LINE_COMMENT_START);
  }

  @Override
  @Nullable
  public PsiElement getUnderscore() {
    return findChildByType(YANG_UNDERSCORE);
  }

}
