package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintUsage {

    public static void main(String[] args) {
        try (PrintStream stream = new PrintStream(new FileOutputStream("data1/print.txt"))) {
            stream.write("Из PrintStream в FileOutputStream".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
