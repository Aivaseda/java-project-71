package hexlet.code;


import java.io.File;

public class Differ {
    public static String generate(String firstLink, String secondLink, String format) throws Exception {
        var firstPath = getFilePath(firstLink);
        var secondPath = getFilePath(secondLink);
        var diff = DifferBuilder.differ(Parser.gerateMap(firstPath), Parser.gerateMap(secondPath));
        var result = Formatters.createSting(diff, format);

        return result.toString();
    }

    public static String generate(String firstLink, String secondLink) throws Exception {
        return Differ.generate(firstLink, secondLink, "stylish");
    }

    public static String getFilePath(String string) {
        File file = new File(string);
        return file.getAbsolutePath();
    }
}
