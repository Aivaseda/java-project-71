package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;


public class Differ {
    public static String generate(String firstLink, String secondLink) throws Exception {
        var map1 = getData(firstLink);
        var map2 = getData(secondLink);
        String newString = "";
        var keys = map1.keySet();
        var keys2 = map2.keySet();
        for (var key : keys) {
            var value1 = map1.get(key);
            var value2 = map2.get(key);
            if (value1.equals(value2)) {
                newString = getSring(newString, "  ", key, value1);
            } else if (value2 == null) {
                newString = getSring(newString, "- ", key, value1);
            } else if (!(value1.equals(value2))) {
                newString = getSring(newString, "- ", key, value1);
                newString = getSring(newString, "+ ", key, value2);
            }
            map2.remove(key);
        }
        for (var key : keys2) {
            var value2 = map2.get(key);
            newString = getSring(newString, "+ ", key, value2);
        }
        return newString.toString().replaceAll(",$", "");
    }

    private static String getSring(String stringOld, String pref, Object key, Object value1) {
        return stringOld + (pref + key + ": " + value1 + ",");
    }

    public static Map getData(String link) throws Exception {
        String path = link;
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        if (link.endsWith("json")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(Paths.get(absolutePath).toFile(), Map.class);
            return new TreeMap<>(map);
        } else if (link.endsWith("yml")) {
            ObjectMapper mapper = new YAMLMapper();
            Map<?, ?> map = mapper.readValue(Paths.get(absolutePath).toFile(), Map.class);
            return new TreeMap<>(map);
        }
        return Map.of();
    }
}


