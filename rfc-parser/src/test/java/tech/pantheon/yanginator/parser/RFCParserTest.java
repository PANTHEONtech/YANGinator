package tech.pantheon.yanginator.parser;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tech.pantheon.yanginator.parser.services.testData.TestDataUtils.GRAMMARKIT_RFC_SERVICE;

class RFCParserTest {

    @Test
    void shouldGenerateGrammar() throws URISyntaxException, IOException {
        File expectedFile = new File(RFCParserTest.class.getClassLoader().getResource("expectedGrammar.bnf").toURI());
        RFCParser.generateGrammar("1_0", GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/yang-1_0/yang-rfc-6020.abnf"), "src/test/gen/yang-");
        assertTrue(GRAMMARKIT_RFC_SERVICE.getFile("yang-rfc-grammar/yang-1_0/yang-rfc-6020.abnf").exists());
        assertEquals(FileUtils.readLines(expectedFile, "utf-8"), FileUtils.readLines(new File("src/test/gen/yang-1_0/yang-rfc-6020-grammar-kit.bnf"), "utf-8"));
    }
}