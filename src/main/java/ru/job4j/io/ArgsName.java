package ru.job4j.io;

import java.util.*;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    String get(String key) {
       if (!values.containsKey(key)) {
            throw new IllegalArgumentException("заданный ключ не найден");
        }
        return values.get(key);
    }

    private void  parse(String[] args) {
        if (!(args.length > 0)) {
            throw new IllegalArgumentException("array is empty.");
        }
       for (String index : args) {
           cardCheck(index);
           String[]  rsl = index.replaceFirst("-", "").split("=", 2);
           if (rsl[0] == "" || rsl[1] == "") {
               throw new IllegalArgumentException("not matching (key, value)");
           }
           values.put(rsl[0], rsl[1]);
       }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private void cardCheck(String index) {
        if (!((Objects.equals('-', index.charAt(0))) && index.contains("="))) {
            throw new IllegalArgumentException("не соответствие шаблона");
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get(("out")));
    }
}
