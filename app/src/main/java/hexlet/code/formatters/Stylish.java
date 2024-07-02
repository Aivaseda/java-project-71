package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.Map;

public class Stylish {
    public static String getStylishFormat(Map<String, Status> data) {
        StringBuilder stingBuild = new StringBuilder();
        stingBuild.append("{\n");
        for (String key: data.keySet()) {
            String pref = data.get(key).getStat();
            switch (pref) {
                case "unmodified" -> stingBuild.append("    ").append(key).append(": ")
                        .append(data.get(key).getValue1()).append("\n");
                case "added" -> stingBuild.append("  + ").append(key).append(": ")
                        .append(data.get(key).getValue2()).append("\n");
                case "deleted" -> stingBuild.append("  - ").append(key).append(": ")
                        .append(data.get(key).getValue1()).append("\n");
                case "updated" -> {
                    stingBuild.append("  - ").append(key).append(": ").append(data.get(key).getValue1()).append("\n");
                    stingBuild.append("  + ").append(key).append(": ").append(data.get(key).getValue2()).append("\n");
                }
                default -> throw new RuntimeException("unknown status: " + pref);
            }
        }
        stingBuild.append("}\n");
        return stingBuild.toString();
    }
}
