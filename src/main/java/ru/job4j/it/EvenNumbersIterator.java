package ru.job4j.it;

import java.util.Iterator;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data[index] % 2 == 0) {
            index++;
        }
        return true;
    }

    @Override
    public Integer next() {
        return data[index++];
    }
}

