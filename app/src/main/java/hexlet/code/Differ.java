package hexlet.code;


public class Differ {
    public static String generate(String firstLink, String secondLink, String format) throws Exception {
        var firstMap = DifferBuilder.differ(Parser.gerate(firstLink), Parser.gerate(secondLink));
        var last = Formatters.createSting(firstMap, format);

        return last.toString();
    }

    public static String generate(String firstLink, String secondLink) throws Exception {
        return Differ.generate(firstLink, secondLink, "stylish");
    }
}
