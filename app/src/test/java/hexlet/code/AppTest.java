package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;

public class AppTest {
    @Test
    public void testFirst() throws Exception {
        String path = "src/test/resources/file1.json";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        String path2 = "src/test/resources/file2.json";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();

        assertEquals(Differ.generate(absolutePath, absolutePath),
                "  follow: false,  host: hexlet.io,  proxy: 123.234.53.22,  timeout: 50");
        assertEquals(Differ.generate(absolutePath, absolutePath2),
                "- follow: false,  host: hexlet.io,- proxy: 123.234.53.22,- timeout: 50,+ timeout: 20,+ verbose: true");
        assertEquals(Differ.generate(absolutePath2, absolutePath2), "  host: hexlet.io,  timeout: 20,  verbose: true");
    }
}
