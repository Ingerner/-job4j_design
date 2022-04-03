package ru.job4j.serialization;

import java.util.Arrays;

public class Human {
   private boolean flag;
    private int age;
    private String name;
    Contact contact;
    int[] number;

    public Human(boolean flag, int age, String name, Contact contact, int[] number) {
        this.flag = flag;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Human{"
                + "flag=" + flag
                + ", age=" + age
                + ", name='" + name
                + '\'' + ", contact=" + contact
                + ", number=" + Arrays.toString(number)
                + '}';
    }
}
