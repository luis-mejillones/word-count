package main.java;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class WordCounter {
    public void process(String fileName) {

        Path path = Paths.get(fileName);

        try {
            Arrays.stream(new String(Files.readAllBytes(path), StandardCharsets.UTF_8).split("\\W+"))
                    .collect(Collectors.groupingBy(Function.<String>identity(), HashMap::new, counting()))
                    .entrySet()
                    .stream()
                    .sorted(((o1, o2) -> o2.getValue().compareTo(o1.getValue())))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("\n" + e.toString() + "\n");
        }
    }
}
