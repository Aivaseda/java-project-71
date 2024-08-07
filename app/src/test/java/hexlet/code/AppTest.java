package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public final class AppTest {
    public static String readFixture(String fileName) throws IOException {
        return  Files.readString(Paths.get(fileName)).trim();
    }
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultStylish = readFixture("src/test/resources/fixtures/resultStylish.txt");
        resultPlain = readFixture("src/test/resources/fixtures/resultPlain.txt");
        resultJson = readFixture("src/test/resources/fixtures/resultJson.json");
    }
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = "src/test/resources/fixtures/file1." + format;
        String filePath2 = "src/test/resources/fixtures/file2." + format;
        assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(resultStylish);
        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(resultPlain);

        String actualJson = Differ.generate(filePath1, filePath2, "json");
        JSONAssert.assertEquals(resultJson, actualJson, false);
    }
}
