package ru.job4j.kiss;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MaxMinTest {

    private List<Integer> list;

    @Before
    public void ini() {
        list = List.of(1, 2, 3, 4, 5);
    }

    MaxMin maxMin = new MaxMin();

    @Test
    void max() {

    }

    @Test
    void min() {
    }
}