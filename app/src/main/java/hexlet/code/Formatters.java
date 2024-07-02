package hexlet.code;

import java.util.Map;
import hexlet.code.formatters.Stylish;

public class Formatters {
    public static String createSting(Map<String, Status> data, String format) {
        if (format.equals("stylish")) {
            return Stylish.getStylishFormat(data);
        } else {
            throw new RuntimeException("unknown format: " + format);
        }
    }
}
