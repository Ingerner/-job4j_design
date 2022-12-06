package ru.job4j.gs.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator implements Generate {

    public static final String PATH_NAMES = "C:\\projects\\-job4j_design\\src\\main\\java\\ru\\job4j\\gs\\leak\\files\\names.txt";
    public static final String PATH_SURNAMES = "C:\\projects\\-job4j_design\\src\\main\\java\\ru\\job4j\\gs\\leak\\files\\surnames.txt";
    public static final String PATH_PATRONS = "C:\\projects\\-job4j_design\\src\\main\\java\\ru\\job4j\\gs\\leak\\files\\patr.txt";

    public static final String SEPARATOR = " ";
    public static final int NEW_USERS = 1000;

    public  List<String> names;
    public  List<String> surnames;
    public  List<String> patrons;
    private  List<User> users = new ArrayList<>();
    private Random random;

    public UserGenerator(Random random) {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        for (int i = 0; i < NEW_USERS; i++) {
            users.add(new User(String.format("%s %s %s",
                    surnames.get(random.nextInt(surnames.size())),
                    names.get(random.nextInt(names.size())),
                    patrons.get(random.nextInt(patrons.size())))));
        }
    }

    private void readAll() {
        try {
            names = read(PATH_NAMES);
            surnames = read(PATH_SURNAMES);
            patrons = read(PATH_PATRONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public  List<User> getUsers() {
        return users;
    }
}
