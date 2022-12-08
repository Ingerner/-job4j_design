package ru.job4j.gs.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value)); //проработать строку

    }

    public V get(K key) {

        return null;
    }

    protected abstract V load(K key);

}
