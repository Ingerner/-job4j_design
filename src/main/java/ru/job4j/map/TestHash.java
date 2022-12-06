package ru.job4j.map;

import java.util.Objects;

public class TestHash {
    private int age;
    private String name;
    private String surname;

    public TestHash(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        int rezult = Integer.hashCode(age);
        rezult = 31 * rezult + name.hashCode();
        rezult = 31 * rezult + surname.hashCode();
        return rezult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TestHash)) {
            return false;
        }
        TestHash testHash = (TestHash) o;
        return age == testHash.age && Objects.equals(name, testHash.name) && Objects.equals(surname, testHash.surname);
    }
}