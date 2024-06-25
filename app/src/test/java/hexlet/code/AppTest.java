package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void testFirst() throws Exception {
        String path = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";

        assertEquals(Differ.generate(path, path),
                "  follow: false,  host: hexlet.io,  proxy: 123.234.53.22,  timeout: 50");
        assertEquals(Differ.generate(path, path2),
                "- follow: false,  host: hexlet.io,- proxy: 123.234.53.22,- timeout: 50,+ timeout: 20,+ verbose: true");
        assertEquals(Differ.generate(path2, path2), "  host: hexlet.io,  timeout: 20,  verbose: true");
    }
}
