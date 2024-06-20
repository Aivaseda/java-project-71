package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;


public class Differ {
    public static String generate(String firstLink, String secondLink ) throws Exception {
        var map1 = getData(firstLink);
        var map2 = getData(secondLink);

        return "generated map!";

    }
    public static Map getData(String link) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<?, ?> map = mapper.readValue(Paths.get(link).toFile(), Map.class);
        Map<?, ?> sortedTreeMap = new TreeMap<>(map);


        for (Map.Entry<?, ?> entry : sortedTreeMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println();

        return map;
    }
}

