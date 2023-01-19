package ru.job4j.srp;

import ru.job4j.list.List;

import java.util.ArrayList;

public class Store {

    String nameGoods;
    int article;

    public Store(String nameGoods, int article) {
        this.nameGoods = nameGoods;
        this.article = article;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public int getArticle() {
        return article;
    }

    public static void main(String[] args) {
        ArrayList<Store> list = new ArrayList<>();
        Store goods1 = new Store("Milk", 4546);
        Store goods2 = new Store("Water", 8612);
        Store goods3 = new Store("Juice", 3645);
        list.add(goods1);
        list.add(goods2);
        list.add(goods3);
        for (int i = 0; i < list.size(); i++) {
            if (8612 == list.get(i).getArticle()) {
                list.remove(i);
            }
        }
        for (Store store: list) {
            System.out.println(store.getNameGoods() +" " +store.getArticle());

        }
    }
}
