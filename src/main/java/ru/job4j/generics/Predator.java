package ru.job4j.generics;

public class Predator extends Animal {
    private String group;
    public Predator(String type, String group) {
        super(type);
        this.group = group;
    }
}

