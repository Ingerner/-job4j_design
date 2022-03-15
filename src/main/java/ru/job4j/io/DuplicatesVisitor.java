package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> files = new HashMap<>();
    private final List<FileProperty> dublicat = new ArrayList<>();

    public List<List<Path>> getDublicat() {
        return files.entrySet()
                .stream()
                .filter(el -> el.getValue().size() > 1)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());

        if (!files.containsKey(fileProperty)) {
            ArrayList paths = new ArrayList();
            paths.add(file);
            files.put(fileProperty, paths);
        } else {
            files.get(fileProperty).add(file);
        }

        return FileVisitResult.CONTINUE;
    }
}

