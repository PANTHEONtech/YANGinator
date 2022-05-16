/*
 * Copyright (c) 2021 PANTHEON.tech, s.r.o. All rights reserved.
 *
 *   This program and the accompanying materials are made available
 *   under the
 *   terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution,  and is available at http://www.eclipse.org/legal/epl-v1.html
 */

package tech.pantheon.yanginator.plugin.completion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YangCompletionContributorPopUp {
    private final Map<String, String> prefixToYangModule;
    private final List<String> currentGroupingNames;
    private final List<String> currentTypedefNames;
    private final List<String> currentIdentityNames;
    private final List<String> importedIdentifiers;
    public String prefixMatcher = "";

    public static final YangCompletionContributorPopUp POP_UP = new YangCompletionContributorPopUp();

    private YangCompletionContributorPopUp() {
        this.prefixToYangModule = new HashMap<>();
        this.currentGroupingNames = new ArrayList<>();
        this.currentTypedefNames = new ArrayList<>();
        this.currentIdentityNames = new ArrayList<>();
        this.importedIdentifiers = new ArrayList<>();
    }

    public Map<String, String> getPrefixToYangModule() {
        return prefixToYangModule;
    }

    public List<String> getCurrentGroupingNames() {
        return currentGroupingNames;
    }

    public List<String> getCurrentTypedefNames() {
        return currentTypedefNames;
    }

    public List<String> getCurrentIdentityNames() {
        return currentIdentityNames;
    }

    public List<String> getImportedIdentifiers() {
        return importedIdentifiers;
    }

    public void setPrefixMatcher(String prefixMatcher) {
        this.prefixMatcher = prefixMatcher;
    }
}
