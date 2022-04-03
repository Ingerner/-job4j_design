package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        StringBuilder output = new StringBuilder();
        File fileRead = new File(argsName.get("path"));
        String out = argsName.get("out");
        String delimiter = argsName.get("delimiter");
        try (Scanner scanner = new Scanner(new BufferedReader(
                new FileReader(fileRead))).useDelimiter(System.lineSeparator())) {
            List<String> filterColumns = List.of(argsName.get("filter").split(","));
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            String[] columns = scanner.nextLine().split(";");
            ArrayList<Integer> indexColumns = new ArrayList<>();
            StringJoiner headerJoiner = new StringJoiner(";");
            // перебираем все столбцы таблицы, которую читаем из файла по индексу
            for (int i = 0; i < columns.length; i++) {
                if (filterColumns.contains(columns[i])) {
                    indexColumns.add(i);
                    headerJoiner.add(columns[i]);
                }
            }
            // мержим джойнер хедера с главным (в котором будут храниться все строки)
            stringJoiner.merge(headerJoiner);
            // читаем из файла пока есть строки
            String outputLine = null;
            while (scanner.hasNextLine()) {
                // считываем строку, и разбиваем ее элементы по нужному нам разделителю (точка-запятая)
                String[] line = scanner.nextLine().split(delimiter);
                // создает пустой джойнер для строки с указанным разделителем для объединения элементов
                StringJoiner lineJoiner = new StringJoiner(";");
                // итерируемся по листу индексов нужных нам столбцов и добавляем элементы строки в джойнер
                indexColumns.forEach(el -> lineJoiner.add(line[el]));
                // мержим джойнер строки с главным (где хранятся все строки из считанного файла)
                stringJoiner.merge(lineJoiner);
                // получаем все содержимое главного джойнера и добавляем в конец символ для новой строки
                // (так как из-за этого не проходил тест)
                 outputLine = stringJoiner + System.lineSeparator();
                // если out = stdout, то выводим в консоль, если нет, то запись производим в файл
                if (out.equals("stdout")) {
                    System.out.println(outputLine);
                } else {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
                        bw.write(output.toString());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
