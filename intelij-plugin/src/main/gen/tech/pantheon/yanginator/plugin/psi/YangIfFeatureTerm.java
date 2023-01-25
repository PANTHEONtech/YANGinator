// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface YangIfFeatureTerm extends YangNamedElement {

  @NotNull
  List<YangWsp> getWspList();

  @Nullable
  YangAndKeyword getAndKeyword();

  @NotNull
  List<YangComment> getCommentList();

  @NotNull
  YangIfFeatureFactor getIfFeatureFactor();

  @Nullable
  YangIfFeatureTerm getIfFeatureTerm();

  @NotNull
  List<YangLineBreak> getLineBreakList();

}
