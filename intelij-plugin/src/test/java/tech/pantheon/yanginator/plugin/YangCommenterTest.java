/*
 *
 *   Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *   and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 */

package tech.pantheon.yanginator.plugin;

import com.intellij.codeInsight.generation.actions.CommentByBlockCommentAction;
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

public class YangCommenterTest extends LightJavaCodeInsightFixtureTestCase {

    public void testSingleLineCommenter() {
        this.myFixture.configureByText(YangFileType.INSTANCE, "<caret>text in line");
        final CommentByLineCommentAction commentAction = new CommentByLineCommentAction();
        commentAction.actionPerformedImpl(this.getProject(), this.myFixture.getEditor());
        this.myFixture.checkResult("//text in line");
        commentAction.actionPerformedImpl(this.getProject(), this.myFixture.getEditor());
        this.myFixture.checkResult("text in line");

    }

    public void testTextBlockCommenter() {
        this.myFixture.configureByText(YangFileType.INSTANCE, "text <caret>commented text");
        final CommentByBlockCommentAction blockCommentAction = new CommentByBlockCommentAction();
        // select text block
        this.myFixture.getEditor().getSelectionModel().setSelection(5, this.myFixture.getFile().getText().length());
        blockCommentAction.actionPerformedImpl(this.getProject(), this.myFixture.getEditor());
        this.myFixture.checkResult("text /*commented text*/");
        blockCommentAction.actionPerformedImpl(this.getProject(), this.myFixture.getEditor());
        this.myFixture.checkResult("text commented text");
    }


}
