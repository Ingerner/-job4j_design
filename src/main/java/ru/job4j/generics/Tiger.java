package ru.job4j.generics;

public class Tiger extends Predator {
    private String kindOfAnimal;
    public Tiger(String type, String v, String kindOfAnimal) {
        super(type, v);
        this.kindOfAnimal = kindOfAnimal;
    }
}
