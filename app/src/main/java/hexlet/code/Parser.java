package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map gerate(String link) throws IOException {
        String path = link;
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        if (link.endsWith("json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(Paths.get(absolutePath).toFile(), Map.class);
            return new TreeMap<>(map);
        } else if (link.endsWith("yml")) {
            //ObjectMapper mapper = new YAMLMapper();
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<?, ?> map = mapper.readValue(Paths.get(absolutePath).toFile(), Map.class);
            return new TreeMap<>(map);
        }
        return Map.of();
    }
}
