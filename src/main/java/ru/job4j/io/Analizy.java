package ru.job4j.io;

import java.io.*;


public class Analizy {

    public void unavailable(String source, String target) {

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
                try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
                    boolean flag = true;
                    String start = null;
                    String end = null;
                    while (read.ready()) {
                        String[] array = read.readLine().split(" ");
                        if (flag && "400".equals(array[0]) || "500".equals(array[0])) {
                            flag = false;
                            start = array[1];
                            continue;
                        }
                        if (!flag && !(("400".equals(array[0]) || "500".equals(array[0])))) {
                            flag = true;
                            end = array[1];
                            String interval = String.join(";", start, end);
                            writer.println(interval);
                        }
                    }
                }
        } catch (IOException e) {
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

