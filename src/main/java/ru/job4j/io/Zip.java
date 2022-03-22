package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validation() {

    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(new String[]{args[0], args[1], args[2]});
        String directory = argsName.get("d");
        File file = new File(directory);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.isAbsolute()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Is not a directory %s", file.isAbsolute()));
        }
        String delete = argsName.get("e");
        String archive = argsName.get("o");
        List<File> list = Search.search(file.toPath(), p -> !p.getFileName().toString().endsWith(delete))
                .stream()
                .map(Path::toFile)
                .toList();
        Zip zip = new Zip();
        zip.packFiles(list, new File(archive));
        }
    }
