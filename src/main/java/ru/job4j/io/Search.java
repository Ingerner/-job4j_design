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
        Path start = Paths.get(args[0]);
        String end = args[1];
        if (args.length == 2) {
           if (! Files.exists(start)) {
               throw new IllegalArgumentException(String.format("Not exist %s", start.isAbsolute()));
           }
           if (!Files.isDirectory(start)) {
               throw new IllegalArgumentException(String.format("Not exist %s", start.isAbsolute()));
           }
           if (!args[1].equals(".txt")) {
               throw new IllegalArgumentException("расширение не соответствует");
           }

        } else {
            throw new IllegalArgumentException("array is empty.");
        }
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
