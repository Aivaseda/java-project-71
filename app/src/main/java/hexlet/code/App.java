package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;




@Command(name = "gendiff", version = "App 2.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {

    @Parameters(paramLabel = "filePath1", description = "path to first file")
    String first;

    @Parameters(paramLabel = "filePath2", description = "path to second file")
    String second;

    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public void run(){
        String diff = null;
        try {
            diff = Differ.generate(first, second);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(diff);
    }
    public static void main(String[] args) throws Exception {
        new CommandLine(new App()).execute(args);
        //System.exit(exitCode);
    }
}

