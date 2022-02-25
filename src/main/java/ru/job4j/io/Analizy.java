package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {

    private final List<String> values = new LinkedList<>();

    public void unavailable(String source, String target) {
        StringJoiner jn = new StringJoiner(System.lineSeparator());

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
                        }
                        if (!flag && ("400".equals(array[0]) || "500".equals(array[0]))) {
                            flag = true;
                            end = array[1];
                            String interval = String.join(";", start, end);
                            writer.println(interval);
                        }

                    }
                    // read.lines().forEach(values::add);
//                    read.lines().map(s -> s.split(" ")).forEach(arr -> {
//
//                    } );
                } catch (IOException e) {
                    e.printStackTrace();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (PrintWriter out1 = new PrintWriter(new FileOutputStream(target))) {
//            String start = null;
//            String end;
//            for (String log : values) {
//                String[] el = log.split(" ");
//                String code = el[0];
//                String time = el[1];
//                if (start == null && ("400".equals(code) || "500".equals(code))) {
//                    start = time;
//                    continue;
//                }
//                if (start != null && ("200".equals(code) || "300".equals(code))) {
//                    end = time;
//                    String interval = String.join(";", start, end);
//                    out.add(interval);
//                    start = null;
//                }
//            }
//            out1.println(out);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

        public static void main(String[] args) {
            String source = "./data/server.log";
            String target = "./data/unavailable.csv";
            Analizy analizy = new Analizy();
            analizy.unavailable(source, target);
        }
    }

