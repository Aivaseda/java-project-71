package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;


@Command(name = "gendiff", version = "App 2.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

    @Parameters(paramLabel = "filePath1", description = "path to first file")
    String first;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    String second;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public Object call() throws Exception {
        String diff = null;
        try {
            diff = Differ.generate(first, second);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("{");
        getList(diff);
        System.out.println("}");
        return null;
    }
    public static List<String> getList(String string) {
        List<String> newList = new ArrayList<String>(Arrays.asList(string.split(",")));
        newList
                .stream()
                .map((k) -> "  " + k)
                .forEach(System.out::println);
        return newList;
    }

    public static void main(String[] args) throws Exception {
        new CommandLine(new App()).execute(args);
    }
}
