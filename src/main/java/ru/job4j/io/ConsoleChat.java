package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        List<String> logOut = new ArrayList<>();
        List<String> listRead = readPhrases();
        String question = "";
        while (!OUT.equals(question)) {
            question = scanner.nextLine();
            logOut.add(question);
            if (STOP.equals(question)) {
                while (!CONTINUE.equals(question)) {
                    question = scanner.nextLine();
                    logOut.add(question);
                }
            } else if (!OUT.equals(question)) {
                String answer = listRead.get(random.nextInt(listRead.size() - 1));
                logOut.add(answer);
                System.out.println(answer);
            }
        }
        saveLog(logOut);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            list = br.lines().map(s -> s + System.lineSeparator()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private  void saveLog(List<String> log) {
        StringBuilder builder = new StringBuilder();
        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validation(String[] strings) {
        File fileOut = new File(strings[0]);
        File fileIn = new File(strings[0]);
        if (!(fileOut.exists() && fileIn.exists())) {
            throw new IllegalArgumentException(String.format("Not exist %s"));
        }
        if (!(strings[0].endsWith(".txt"))
                && (strings[1].endsWith(".txt"))) {
            throw new IllegalArgumentException("расширение не соответствует");
        }
    }

    public static void main(String[] args) {
        if (!(args.length == 2)) {
            throw new IllegalArgumentException("array is empty.");
        }
        ConsoleChat cc = new ConsoleChat(args[0], args[1]);
        cc.validation(args);
        cc.run();
    }
}