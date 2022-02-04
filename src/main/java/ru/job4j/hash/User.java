package ru.job4j.hash;

import java.util.*;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    public static void main(String[] args) {
        Calendar day = new GregorianCalendar(2019, 8, 07);
        User user1 = new User("Ivan", 1, day);
        User user2 = new User("Ivan", 1, day);
        Map<User, Object> data = new HashMap<>();
        System.out.println(user1.hashCode() + "           " +user2.hashCode());
        data.put(user1, new Object());
        data.put(user2, new Object());
        for (Map.Entry<User, Object> i : data.entrySet()) {
            System.out.println("Key: " +i.getKey() + "  " +"Value: " +i.getKey());
            System.out.println("Key: " +i.hashCode());
            System.out.println(data.size());
        }
    }
}
