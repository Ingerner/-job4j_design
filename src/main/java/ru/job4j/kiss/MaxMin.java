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
        if (!value.isEmpty()) {
             rezult = value.get(0);
            for (T i : value) {
                rezult = comparator.compare(rezult, i) > 0 ? rezult : i;
            }
        }
        return rezult;
    }
}
