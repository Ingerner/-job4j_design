package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) throws IOException {

        if (args.length == 2) {
            throw new IllegalArgumentException("array is empty.");
        }
        Path start = Paths.get(args[0]);
        String end = args[1];
       if (!Files.exists(start)) {
           throw new IllegalArgumentException(String.format("Not exist %s", start.isAbsolute()));
       }
       if (!Files.isDirectory(start)) {
           throw new IllegalArgumentException(String.format("Not exist %s", start.isAbsolute()));
       }
       if (!".txt".startsWith(end)) {
           throw new IllegalArgumentException("расширение не соответствует");
       }
        search(start, p -> p.toFile().getName().endsWith(end)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
