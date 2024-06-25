package hexlet.code;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AppTest {
//   @BeforeEach
//   public void beforeEach() {
//       String path = "src/test/resources/file1.json";
//       File file = new File(path);
//       String absolutePath = file.getAbsolutePath();
//
//       String path2 = "src/test/resources/file2.json";
//       File file2 = new File(path2);
//       String absolutePath2 = file2.getAbsolutePath();
//   }

    @Test
    public void testFirst() throws Exception {
        String path = "src/test/resources/file1.json";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        String path2 = "src/test/resources/file2.json";
        File file2 = new File(path2);
        String absolutePath2 = file2.getAbsolutePath();
        assertEquals(Differ.generate(absolutePath, absolutePath), "  follow: false,  host: hexlet.io,  proxy: 123.234.53.22,  timeout: 50");
    }
}
