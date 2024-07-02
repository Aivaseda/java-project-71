package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class AppTest {
    public static String readFixture(String fileName) throws IOException {
        return  Files.readString(Paths.get(fileName)).trim();
    }
    private static String result;

    @BeforeAll
    public static void beforeAll() throws Exception {
        String result = readFixture("src/test/resources/resultStylish.txt");
    }
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = "src/test/resources/file1." + format;
        String filePath2 = "src/test/resources/file2." + format;
        //assertEquals(Differ.generate(filePath1, filePath2), result );
        System.out.println(Differ.generate(filePath1, filePath2));
        assertThat(Differ.generate(filePath1, filePath2))
                .isEqualTo(result);

    }
}
