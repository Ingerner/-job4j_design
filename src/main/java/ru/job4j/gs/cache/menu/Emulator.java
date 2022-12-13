package ru.job4j.gs.cache.menu;

import ru.job4j.gs.cache.DirFileCache;

import java.io.IOException;
import java.util.Scanner;

public class Emulator {

    public static final int DIRECTORY = 1;
    public static final int UPLOAD_FILE = 2;
    public static final int EXIT = 3;

    public static void main(String[] args) throws IOException {
        DirFileCache dirFileCache = null;
        Boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" 1 - указать кэшируемую директорию");
            System.out.println(" 2 - загрузить содержимое файла в кэш");
            System.out.println(" 3 - выйти из программы");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == DIRECTORY) {
                System.out.println("Введите директорию");
                String directory = scanner.nextLine();
                dirFileCache = new DirFileCache(directory);
                System.out.println("Директория введена");
            } else if (select == UPLOAD_FILE) {
                System.out.println("Введите имя файла");
                String fileName = scanner.nextLine();
                System.out.println(dirFileCache.get(fileName));
            } else if (select == EXIT) {
                flag = false;
            } else {
                System.out.println("Введено не верное значение");
            }
        }
    }
}



