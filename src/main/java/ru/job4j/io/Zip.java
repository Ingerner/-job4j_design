package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validation(File f, String expansion) {

        if (!f.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", f.isAbsolute()));
        }
        if (!f.isDirectory()) {
            throw new IllegalArgumentException(String.format("Is not a directory %s", f.isAbsolute()));
        }
        if (!(Objects.equals('.', expansion.charAt(0)))) {
            throw new IllegalArgumentException("расширение не соответствует");
        }
    }

    public static void main(String[] args) throws IOException {
        if (!(args.length == 3)) {
            throw new IllegalArgumentException("array is empty.");
        }
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String delete = argsName.get("e");
        String archive = argsName.get("o");
        File file = new File(directory);
        Zip zip = new Zip();
        zip.validation(file, delete);
        List<File> list = Search.search(file.toPath(), p -> !p.getFileName().toString().endsWith(delete))
                .stream()
                .map(Path::toFile)
                .toList();
        zip.packFiles(list, new File(archive));
        }
    }
