package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DifferBuilder {
    public static Map<String, Status> differ(Map<String, Object> dataOne, Map<String, Object> dataTwo) {
        Map<String, Status> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(dataOne.keySet());
        keys.addAll(dataTwo.keySet());
        for (String key: keys) {
            if (Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                result.put(key, new Status("unmodified", dataOne.get(key), dataTwo.get(key)));
            } else if (!dataOne.containsKey(key)) {
                result.put(key, new Status("added", dataOne.get(key), dataTwo.get(key)));
            } else if (!dataTwo.containsKey(key)) {
                result.put(key, new Status("deleted", dataOne.get(key), dataTwo.get(key)));
            } else if (!Objects.equals(dataOne.get(key), dataTwo.get(key))) {
                result.put(key, new Status("updated", dataOne.get(key), dataTwo.get(key)));
            }
        }
        return result;
    }
}
