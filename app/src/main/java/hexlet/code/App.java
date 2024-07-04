package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", version = "App 2.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

    @Parameters(paramLabel = "filePath1", description = "path to first file")
    String filepath1;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    String filepath2;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public Object call() throws Exception {
        String result = Differ.generate(filepath1, filepath2, format);
        System.out.println(result);
        return result;

    }
    public static void main(String[] args) throws Exception {
        new CommandLine(new App()).execute(args);
    }
}
