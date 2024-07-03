package hexlet.code;

import java.util.Map;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;

public class Formatters {
    public static String createSting(Map<String, Status> data, String format) {
        if (format.equals("stylish")) {
            return Stylish.getStylishFormat(data);
        } else if (format.equals("plain")) {
            return Plain.getPlainFormat(data);
        } else {
            throw new RuntimeException("unknown format: " + format);
        }
    }
}
