package main.java;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            showHelp();
            return;
        }

        String fileName = args[0];

        WordCounter wc = new WordCounter();
        wc.process(fileName);
    }

    private static void showHelp() {
        System.out.println("\nError, missing input file.");
        System.out.println("  Usage:");
        System.out.println("  sbt \"runMain main.java.Main /path/to/file\"\n");
    }
}
