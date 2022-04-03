package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Human human = new Human(false, 30, "Ivan",
                new Contact(123456, "+7 (000) 000-00-00"), new int[] {1, 2, 3});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(human));

        final String humanJson =
                "{"
                        + "\"flaf\": false,"
                        + "\"age\": 30,"
                        + "\"name\":\" Ivan\","
                        + "\"contact\":"
                        + "{"
                        + "\"zipCode\": 123456,"
                        + "\"phone\":\"+7 (000) 000-00-00\""
                        + "},"
                        + "\"number\":"
                        + "[\"1\",\"2\",\"3\"]"
                        + "}";
        final Human humanMod = gson.fromJson(humanJson, Human.class);
        System.out.println(humanMod);
    }
}
