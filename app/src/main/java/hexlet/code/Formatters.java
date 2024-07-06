package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Json;

public class Formatters {
    public static String createSting(Map<String, Status> data, String format) throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> Stylish.format(data);
            case "plain" -> Plain.format(data);
            case "json" -> Json.format(data);
            default -> throw new RuntimeException("unknown format: " + format);
        };
    }
}
