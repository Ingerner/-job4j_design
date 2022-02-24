package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {

    private final List<String> values = new LinkedList<>();

    public void unavailable(String source, String target) {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(values::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out1 = new PrintWriter(new FileOutputStream(target))) {
            String start = null;
            String end;
            for (String log : values) {
                String[] el = log.split(" ");
                String code = el[0];
                String time = el[1];
                if (start == null && ("400".equals(code) || "500".equals(code))) {
                    start = time;
                    continue;
                }
                if (start != null && ("200".equals(code) || "300".equals(code))) {
                    end = time;
                    String interval = String.join(";", start, end);
                    out.add(interval);
                    start = null;
                }
            }
            out1.println(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
            String source = "./data/server.log";
            String target = "./data/unavailable.csv";
            Analizy analizy = new Analizy();
            analizy.unavailable(source, target);
        }
    }

