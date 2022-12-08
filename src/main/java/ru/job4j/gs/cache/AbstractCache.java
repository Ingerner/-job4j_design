package ru.job4j.gs.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));

    }

    public V get(K key) throws IOException {
        V rezul = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (rezul == null) {
            rezul = load(key);
            put(key, rezul);
        }
        return rezul;
    }

    protected abstract V load(K key) throws IOException;
}
