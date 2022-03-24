package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    List<String> logOut = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public String getPath() {
        return path;
    }

    public String getBotAnswers() {
        return botAnswers;
    }

    public void run() {
        while (!OUT.equals(getBotAnswers())) {
            switch (getBotAnswers()) {
                case(STOP): {
                    logOut.add(STOP);
                }
                case(CONTINUE): {
                    logOut.add(CONTINUE);
                }
                default:
            }
        }
        logOut.add(OUT);
        saveLog(logOut);
    }
    //* читаем фразы
    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        //StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            list = br.lines().map(s -> s + System.lineSeparator()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //* записываем логи в файл. Непонятно в тот из которого читаем или создаем новый
    private  void saveLog(List<String> log) {
        StringBuilder builder = new StringBuilder();
        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        ConsoleChat cc = new ConsoleChat("C:\\projects\\-job4j_design\\src\\main\\java\\ru\\job4j\\io\\bot.txt", scanner.nextLine() );
        //cc.run();

        //System.out.println(cc.readPhrases().get(2));


//        Scanner consol = new Scanner(System.in);
//        String name = consol.nextLine();
        //System.out.println(cc.getBotAnswers());
    }
}