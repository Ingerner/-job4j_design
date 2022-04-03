package ru.job4j.io;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;
import java.io.File;

public class CSVReaderFin {
    public static void handleFin(ArgsName argsName) throws Exception {
        StringBuilder output = new StringBuilder();
        File file = new File(argsName.get("path"));
        String out = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        String filter = argsName.get("filter");
       try (Scanner scanner = new Scanner(new BufferedReader(
               new FileReader(file))).useDelimiter(System.lineSeparator())) {
           ArrayList<Integer> indexFilter = new ArrayList<>();
           List<String> filterList = Arrays.asList(filter.split(","));
           String[] oneString = null;
           if (scanner.hasNextLine()) {
               oneString = scanner.next().split(delimiter);
               for (int i = 0; i < Objects.requireNonNull(oneString).length; i++) {
                   if (filterList.contains(oneString[i])) {
                       indexFilter.add(i);
                   }
               }

           }
           Scanner scan = new Scanner(new BufferedReader(
                   new FileReader(file))).useDelimiter(System.lineSeparator());
           while (scan.hasNextLine()) {
               String[] string = scan.next().split(delimiter);
               for (Integer index : indexFilter) {
                   output.append(string[index]).append(";");
               }
               output.append(System.lineSeparator());
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
        if (argsName.get("out").equals("stdout")) {
            System.out.println(output.toString());
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(argsName.get("out")))) {
                bw.write(output.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
