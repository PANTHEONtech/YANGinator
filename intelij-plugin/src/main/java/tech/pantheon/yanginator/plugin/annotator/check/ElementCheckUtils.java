package tech.pantheon.yanginator.plugin.annotator.check;

import tech.pantheon.yanginator.plugin.psi.YangAnyxmlStmt;
import tech.pantheon.yanginator.plugin.psi.YangArgumentStmt;
import tech.pantheon.yanginator.plugin.psi.YangBaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangBelongsToStmt;
import tech.pantheon.yanginator.plugin.psi.YangCaseStmt;
import tech.pantheon.yanginator.plugin.psi.YangChoiceStmt;
import tech.pantheon.yanginator.plugin.psi.YangConfigStmt;
import tech.pantheon.yanginator.plugin.psi.YangContactStmt;
import tech.pantheon.yanginator.plugin.psi.YangContainerStmt;
import tech.pantheon.yanginator.plugin.psi.YangDataDefStmt;
import tech.pantheon.yanginator.plugin.psi.YangDefaultStmt;
import tech.pantheon.yanginator.plugin.psi.YangDescriptionStmt;
import tech.pantheon.yanginator.plugin.psi.YangDeviationStmtBodyArgs;
import tech.pantheon.yanginator.plugin.psi.YangErrorAppTagStmt;
import tech.pantheon.yanginator.plugin.psi.YangErrorMessageStmt;
import tech.pantheon.yanginator.plugin.psi.YangInputStmt;
import tech.pantheon.yanginator.plugin.psi.YangKeyStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafListStmt;
import tech.pantheon.yanginator.plugin.psi.YangLeafStmt;
import tech.pantheon.yanginator.plugin.psi.YangLengthStmt;
import tech.pantheon.yanginator.plugin.psi.YangListStmt;
import tech.pantheon.yanginator.plugin.psi.YangMandatoryStmt;
import tech.pantheon.yanginator.plugin.psi.YangMaxElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangMinElementsStmt;
import tech.pantheon.yanginator.plugin.psi.YangNamespaceStmt;
import tech.pantheon.yanginator.plugin.psi.YangOrderedByStmt;
import tech.pantheon.yanginator.plugin.psi.YangOrganizationStmt;
import tech.pantheon.yanginator.plugin.psi.YangOutputStmt;
import tech.pantheon.yanginator.plugin.psi.YangPathStmt;
import tech.pantheon.yanginator.plugin.psi.YangPositionStmt;
import tech.pantheon.yanginator.plugin.psi.YangPrefixStmt;
import tech.pantheon.yanginator.plugin.psi.YangPresenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangReferenceStmt;
import tech.pantheon.yanginator.plugin.psi.YangRequireInstanceStmt;
import tech.pantheon.yanginator.plugin.psi.YangStatusStmt;
import tech.pantheon.yanginator.plugin.psi.YangTypeStmt;
import tech.pantheon.yanginator.plugin.psi.YangUnitsStmt;
import tech.pantheon.yanginator.plugin.psi.YangUsesStmt;
import tech.pantheon.yanginator.plugin.psi.YangValueStmt;
import tech.pantheon.yanginator.plugin.psi.YangWhenStmt;
import tech.pantheon.yanginator.plugin.psi.YangYangVersionStmt;

import java.util.List;
import java.util.Map;

public class ElementCheckUtils {
    private static final Map<Class<?>, String> CLASS_TRANSLATIONS = Map.ofEntries(
            Map.entry(YangYangVersionStmt.class, "version"),
            Map.entry(YangNamespaceStmt.class, "namespace"),
            Map.entry(YangPrefixStmt.class, "prefix"),
            Map.entry(YangContactStmt.class, "contact"),
            Map.entry(YangOrganizationStmt.class, "organization"),
            Map.entry(YangDescriptionStmt.class, "description"),
            Map.entry(YangReferenceStmt.class, "reference"),
            Map.entry(YangArgumentStmt.class, "argument"),
            Map.entry(YangStatusStmt.class, "status"),
            Map.entry(YangBaseStmt.class, "base"),
            Map.entry(YangTypeStmt.class, "type"),
            Map.entry(YangUnitsStmt.class, "units"),
            Map.entry(YangDefaultStmt.class, "default"),
            Map.entry(YangErrorMessageStmt.class, "error message"),
            Map.entry(YangErrorAppTagStmt.class, "error app tag"),
            Map.entry(YangValueStmt.class, "value"),
            Map.entry(YangPositionStmt.class, "position"),
            Map.entry(YangWhenStmt.class, "when"),
            Map.entry(YangPresenceStmt.class, "presence"),
            Map.entry(YangConfigStmt.class, "config"),
            Map.entry(YangMandatoryStmt.class, "mandatory"),
            Map.entry(YangMinElementsStmt.class, "min elements"),
            Map.entry(YangMaxElementsStmt.class, "max elements"),
            Map.entry(YangOrderedByStmt.class, "ordered by"),
            Map.entry(YangKeyStmt.class, "key"),
            Map.entry(YangInputStmt.class, "input"),
            Map.entry(YangOutputStmt.class, "output"),
            Map.entry(YangDataDefStmt.class, "data def"),
            Map.entry(YangDeviationStmtBodyArgs.class, "deviation argument"),
            Map.entry(YangBelongsToStmt.class, "belongs to"),
            Map.entry(YangLengthStmt.class, "length"),
            Map.entry(YangPathStmt.class, "path"),
            Map.entry(YangRequireInstanceStmt.class, "require instance"),
            Map.entry(YangCaseStmt.class, "case")
    );

    private static final List<Class<?>> DATA_DEF_STATEMENTS = List.of(YangContainerStmt.class,
            YangLeafStmt.class,
            YangLeafListStmt.class,
            YangListStmt.class,
            YangChoiceStmt.class,
            YangAnyxmlStmt.class,
            YangUsesStmt.class,
            YangDataDefStmt.class);

    static String translateClassName(final Class<?> clazz) {
        return CLASS_TRANSLATIONS.get(clazz);
    }

    public static List<Class<?>> getDataDefStatements() {
        return DATA_DEF_STATEMENTS;
    }
}