package ru.job4j.gs.cache.menu;

import ru.job4j.gs.cache.DirFileCache;

import java.io.IOException;
import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) throws IOException {
        DirFileCache dirFileCache = null;
        Boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" 1 - указать кэшируемую директорию");
            System.out.println(" 2 - загрузить содержимое файла в кэш");
            System.out.println(" 3 - выйти из программы");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                System.out.println("Введите директорию");
                String directory = scanner.nextLine();
                dirFileCache = new DirFileCache(directory);
                System.out.println("Директория введена");
            } else {
                if (select == 2) {
                    System.out.println("Введите имя файла");
                    String fileName = scanner.nextLine();
                    System.out.println(dirFileCache.get(fileName));
                } else {
                    if (select == 3) {
                        flag = false;
                    } else {
                        System.out.println("Введено не верное значение");
                    }
                }
            }
        }
    }
}


