package ru.job4j.hash;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User(
                "Ivan", 1, new GregorianCalendar(2019, 8, 07)
                                );
        User user2 = new User(
                "Ivan", 1, new GregorianCalendar(2019, 8, 07)
                                  );

        Map<User, Object> data = new HashMap<>();
        data.put(user1, new Object());
        data.put(user2, new Object());
        for (Map.Entry<User, Object> i : data.entrySet()) {
            System.out.println(i + "hashCode = " + i.hashCode());
        }
    }
}
