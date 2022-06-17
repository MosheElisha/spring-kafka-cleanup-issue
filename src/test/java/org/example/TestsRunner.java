package org.example;

import org.junit.platform.console.options.CommandLineOptions;
import org.junit.platform.console.tasks.ConsoleTestExecutor;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class TestsRunner {
    public static void main(String[] args) throws Exception {
        // TODO If you are running without MarkDirtyExecutionListener, increase the loop count
        // to see "memory leak" or "too many open files" issues
        for (int i = 0; i < 1; i++) {
            CommandLineOptions options = new CommandLineOptions();
            options.setSelectedPackages(List.of("org.example.tests"));
            options.setFailIfNoTests(true);
            ConsoleTestExecutor executor = new ConsoleTestExecutor(options);
            executor.execute(new PrintWriter(Writer.nullWriter()));

            Runtime rt = Runtime.getRuntime();
            System.out.println("Used: " + (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024 + "MB");
        }
    }
}
