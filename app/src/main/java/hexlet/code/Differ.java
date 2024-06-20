package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String firstLink, String secondLink ) throws Exception {
        var map1 = getData(firstLink);
        var map2 = getData(secondLink);

        return "this work";

    }
    public static Map getData(String link) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<?, ?> map = mapper.readValue(Paths.get(link).toFile(), Map.class);

//        for (Map.Entry<?, ?> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
        return map;
    }
}

