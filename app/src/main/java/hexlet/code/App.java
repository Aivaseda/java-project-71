package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "App 2.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(paramLabel = "filePath1", description = "path to first file")
    private static String first;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    private static String second;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public void run() {
    }

    public static void main(String[] args) {

        var diff = Differ.generate(first, second);
        System.out.println(diff);
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }



}
