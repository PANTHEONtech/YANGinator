package tech.pantheon.yanginator.parser.services.testData;

import tech.pantheon.yanginator.parser.services.GrammarKitRFCService;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class TestDataUtils {
    public static final GrammarKitRFCService GRAMMARKIT_RFC_SERVICE = new GrammarKitRFCService();

    public static List<String> createList(final String filePath) throws URISyntaxException {
        File referenceFile = GRAMMARKIT_RFC_SERVICE.getFile(filePath);
        return GRAMMARKIT_RFC_SERVICE.readInputFile(referenceFile);
    }
}
