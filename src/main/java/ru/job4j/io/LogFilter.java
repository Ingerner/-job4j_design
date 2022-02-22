package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            list = in.lines().filter(stroka -> {
                String[] array = stroka.split(" ");
                return array[array.length - 2].equals("404");
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        for (String element : log) {
            System.out.println(element);
        }
    }
}
