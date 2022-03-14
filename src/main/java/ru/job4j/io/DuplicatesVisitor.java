package ru.job4j.io;

import ru.job4j.map.Map;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, Path> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        System.out.println(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }
}
