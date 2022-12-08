package ru.job4j.gs.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftReferencAndWeakReference {

    class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }
    }

    public boolean softReference() {
        Scanner scanner = null;
        SoftReference<String> name = new SoftReference<>(scanner.nextLine());
        String nameItem = name.get();
        if (name != null) {
            Item item = new Item(nameItem);
        } else {
            return false;
        }
        return true;
    }

    public void   weakReference(WeakReference<List<String>> list) {
       List<String> link  = list.get();
       if (link != null) {
           for (String i : link) {
               Item item = new Item(i);
           }
       }
    }
}
