package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = true;
        modCount++;
        count++;
        float expansion = count / table.length;
        if (expansion >= LOAD_FACTOR) {
            expand();
        }
        MapEntry element = new MapEntry(key, value);
        int hash = hash(element.key.hashCode());
        int i = indexFor(hash);
        if (table[i] != null) {
           rsl = false;
        } else {
            table[i] = element;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> capacity);
    }

    private int indexFor(int hash) {
        return hash % capacity;
    }

    private void expand() {
        capacity = capacity * 2;
        Iterator<K> iterator = iterator();
        table = new MapEntry[capacity];
        if (iterator.hasNext()) {
            K key = iterator.next();
            put(key, get(key));
        }
    }

    @Override
    public V get(K key) {
        int i = indexFor(hash(key.hashCode()));
        if (table[i].key != null && Objects.equals(table[i].key, key)) {
            return table[i].value;
        }
        return null;
        //return table[i] != null ? table[i].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int i = indexFor(hash(key.hashCode()));
        if (table[i] != null) {
            table[i] = null;
            rsl =  true;
        }
        return rsl;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModeCount = modCount;
            int point = 0;

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                if (expectedModeCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < table.length) {
                    if (table[point] != null) {
                        rsl = true;
                        break;
                    }
                    point++;
                }
                return rsl;
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
