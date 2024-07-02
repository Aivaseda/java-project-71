package hexlet.code;


import java.io.File;

public class Differ {
    public static String generate(String firstLink, String secondLink, String format) throws Exception {
        var firstPath = getFilePath(firstLink);
        var secondPath = getFilePath(secondLink);
        var firstMap = DifferBuilder.differ(Parser.gerate(firstPath), Parser.gerate(secondPath));
        var last = Formatters.createSting(firstMap, format);

        return last.toString();
    }

    public static String generate(String firstLink, String secondLink) throws Exception {
        return Differ.generate(firstLink, secondLink, "stylish");
    }

    public static String getFilePath(String string) {
        File file = new File(string);
        return file.getAbsolutePath();
    }
}
