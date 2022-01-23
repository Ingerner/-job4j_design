package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
        }

    @Override
    public boolean replace(String id, T model) {
       boolean rsl = false;
        for (String key : storage.keySet()) {
           if (key.equals(id)) {
               storage.replace(key, model);
               rsl = true;
           }
       }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        for (String key : storage.keySet()) {
            if (key.equals(id)) {
                storage.remove(id);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        T rsl = null;
        for (String key : storage.keySet()) {
            if (key.equals(id)) {
                rsl = storage.get(key);
            }
        }
        return rsl;
    }
}