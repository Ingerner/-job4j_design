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
       for (String key : storage.keySet()) {
           if (key.equals(id)) {
               storage.put(key,model);
               return true;
           }
       }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (String key : storage.keySet()) {
            if (key.equals(id)) {
                storage.remove(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (String key : storage.keySet()) {
            if (key.equals(id)) {
                return storage.get(key);
            }
        }
        return null;
    }
}