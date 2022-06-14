// This is a generated file. Not intended for manual editing.
package tech.pantheon.yanginator.plugin.highlighter.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import tech.pantheon.yanginator.plugin.psi.YangNamedElement;

public class YangVisitor extends PsiElementVisitor {

  public void visitStmt(@NotNull YangStmt o) {
    visitNamedElement(o);
  }

  public void visitDummy(@NotNull YangDummy o) {
    visitNamedElement(o);
  }

  public void visitHAnyToken(@NotNull YangHAnyToken o) {
    visitNamedElement(o);
  }

  public void visitHIdentifierLiteral(@NotNull YangHIdentifierLiteral o) {
    visitNamedElement(o);
  }

  public void visitWsp(@NotNull YangWsp o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull YangNamedElement o) {
    visitElement(o);
  }

}
