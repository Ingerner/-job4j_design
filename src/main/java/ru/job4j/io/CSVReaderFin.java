package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReaderFin {
    public static void handleFin(ArgsName argsName) throws Exception {
        ArgsName array =ArgsName.of(argsName)
        File sourceFile = new File(argsName.get("path"));
        String out = argsName.get("out");
        String delimiter = argsName.get("delimiter");
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
    }
}
