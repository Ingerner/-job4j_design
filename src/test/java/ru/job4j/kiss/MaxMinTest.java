package ru.job4j.kiss;


import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MaxMinTest {

    private List<Integer> list = List.of(10, 2, 5, 1, -40, 40);
    Comparator<Integer> comp = (left, right) -> Integer.compare(left, right);

    @Test
    void maxTest() {
        Integer rezult = new MaxMin().max(list, comp);
        Integer expected = 40;
        assertThat(rezult).isEqualTo(expected);
    }

    @Test
    void minTest() {
        Integer rezult = new MaxMin().min(list, comp);
        Integer expected = -40;
        assertThat(rezult).isEqualTo(expected);
    }
}