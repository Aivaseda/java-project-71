package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    private static String result;

    @BeforeAll
    public static void BeforeAll() {
        String result = "src/test/resources/resultStylish.txt";
    }
    @Test
    public void generateTest() throws Exception {
        String path = "src/test/resources/file1_2.json";
        String path2 = "src/test/resources/file2_2.json";
        //assertEquals(Differ.generate(path, path2), result );
        assertThat(Differ.generate(path, path2)).isEqualTo(result);
    }
}
