package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        modCount++;
        count++;
        MapEntry element = new MapEntry(key, value);
        int hash = hash(element.hashCode());
        int i = indexFor(hash);
        if (table[i] != null) {
            return false;
        }  else {
            table[i] = element;
        }
        return true;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> table.length);
    }

    private int indexFor(int hash) {
        return hash % table.length;
    }

    private void expand() {

    }

    @Override
    public V get(K key) {
        int hash = hash(key.hashCode());
        int i = indexFor(hash);
        if (table[i] != null) {
            return table[i].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int hash = hash(key.hashCode());
        int i = indexFor(hash);
        if (table[i] != null) {
            table[i] = null;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModeCount = modCount;
            int point = 0;
            @Override
            public boolean hasNext() {
                if (expectedModeCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < table.length) {
                    if (table[point] != null) {
                        return true;
                    }
                    point++;
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
