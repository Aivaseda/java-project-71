package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plain {
    public static String getPlainFormat(Map<String, Status> data) {
        StringBuilder stingBuild = new StringBuilder();
        Set<String> keys = data.keySet();
        for (String key: keys) {
            Status statusData = data.get(key);
            String pref = statusData.getStat();
            var value1 = isComplexValue(statusData.getValue1());
            var value2 = isComplexValue(statusData.getValue2());
            switch (pref) {
                case "deleted" -> stingBuild.append("Property '").append(key).append("' was removed").append("\n");
                case "added" -> stingBuild.append("Property '")
                        .append(key).append("' was added with value: ").append(value2).append("\n");
                case "updated" -> stingBuild.append("Property '")
                        .append(key).append("' was updated. From ").append(value1).append(" to ")
                        .append(value2).append("\n");
                case "unmodified" -> {
                }
                default -> throw new RuntimeException("unknown status: " + pref);
            }
        }
        return stingBuild.toString().trim();
    }
    private static String isComplexValue(Object value) {
        if (value == null) {
            return "null";
        } else if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}

