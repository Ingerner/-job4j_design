package ru.job4j.list;

import java.lang.reflect.Array;
import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modeCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            grow();
        }
        modeCount++;
        container[size++] = value;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        modeCount++;
        container[index] = newValue;
        return newValue;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        modeCount++;
        T delete = container[index];
        System.arraycopy(container, index + 1, container, index, (size - 1) - index);
        size--;
        return delete;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private final Iterator<T> data = Arrays.stream(
                    Arrays.copyOf(container, size)).iterator();
            
            final int expectedModeCount = modeCount;

            @Override
            public boolean hasNext() {
                if (expectedModeCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                return data.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data.next();
            }
        };
    }
}
