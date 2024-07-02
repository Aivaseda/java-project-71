package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map gerate(String link) throws IOException {
        if (link.endsWith("json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(Paths.get(link).toFile(), Map.class);
            return new TreeMap<>(map);
        } else if (link.endsWith("yml")) {

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<?, ?> map = mapper.readValue(Paths.get(link).toFile(), Map.class);
            return new TreeMap<>(map);
        }
        return Map.of();
    }
}
