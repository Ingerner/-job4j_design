package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comparison(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comparison(value, comparator.reversed());
    }

    public <T> T comparison(List<T> value, Comparator<T> comparator) {
        T rezult = null;
        for(int i = 0; i < value.size() - 1; i++) {
           rezult = comparator.compare(value.get(i), value.get(i+1)) > 0 ? value.get(i) : value.get(i + 1);
       }
        return rezult;
    }

}
