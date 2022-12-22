package ru.job4j.kiss;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MaxMinTest {

    private List<Integer> list = List.of(1, 2, 5, 3, 4);
    Comparator<Integer> comp = (left, right) -> Integer.compare(left, right);

    @Test
    void maxTest() {
        Integer rezult = new MaxMin().max(list, comp);
        Integer expected = 5;
        assertThat(rezult).isEqualTo(expected);
    }

    @Test
    void minTest() {
        Integer rezult = new MaxMin().min(list, comp);
        Integer expected = 1;
        assertThat(rezult).isEqualTo(expected);
    }
}