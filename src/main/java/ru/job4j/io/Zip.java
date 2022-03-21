package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(new String[] {args[0], args[1], args[2]});
        String directory = argsName.get("d");
        File f = new File(directory);
        String delete = argsName.get("e");
        String archive = argsName.get("o");
        if (Files.exists(f.toPath())) {
          //пишем исключение
        }

        Zip zip = new Zip();
//        zip.packSingleFile(
//                new File("./pom.xml"),
//                new File("./pom.zip")
//        );
        List<File> list = new ArrayList<>();
        list.add(new File("./pom.xml"));
        list.add(new File("./log.txt"));
        zip.packFiles(list, new File("./files.zip"));
    }
}
