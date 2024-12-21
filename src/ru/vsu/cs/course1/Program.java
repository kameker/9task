package ru.vsu.cs.course1;


import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;
import org.apache.commons.cli.*;

import javax.swing.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Program {

    private static final String PROGRAM_NAME_IN_HELP = "AAAAAAAAAAAAAAAAAAAAAAA";

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        Options cmdLineOptions = new Options();
        cmdLineOptions.addOption("r", "reverse-rows", false, "Reverse rows");
        cmdLineOptions.addOption("h", "help", false, "Show help");
        cmdLineOptions.addOption("w", "window", false, "Use window user interface");
        cmdLineOptions.addOption("i", "input-file", true, "Input file");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
        try {
            cmdLine = parser.parse(cmdLineOptions, args);
        } catch (Exception e) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }

        if (cmdLine.hasOption("h")) {
            new HelpFormatter().printHelp(PROGRAM_NAME_IN_HELP, cmdLineOptions);
            System.exit(1);
        }
        if (cmdLine.hasOption("w")) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new FrameMain().setVisible(true);
                }
            });
        } else if (cmdLine.hasOption("i")){
            String inputFilename = cmdLine.getOptionValue("i");
            int[] arr2 = ArrayUtils.readIntArrayFromFile(inputFilename);
            if (arr2 == null) {
                System.err.printf("Can't read array from \"%s\"%n", inputFilename);
                System.exit(2);
            }
            List<Integer> list = new ArrayList<>();
            for (int b : arr2) {
                list.add(b);
            }
            System.out.println(ninth.process(list));
        }
    }
}
