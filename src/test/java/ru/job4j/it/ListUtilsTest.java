package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveifByCondition() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        Predicate<Integer> filter = x -> x < 3;
        ListUtils.removeIf(input, filter);
        assertThat(input, is(Arrays.asList(3, 4)));
    }

    @Test
    public void whenReplaceToOne() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        Predicate<Integer> filter = x -> x < 3;
        ListUtils.replaceIf(input, filter, 1);
        assertThat(input, is(Arrays.asList(1, 1, 1, 3, 4)));
    }

    @Test
    public void whenRemoveList() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> delete = new ArrayList<>(Arrays.asList(2, 3));
        ListUtils.removeAll(input, delete);
        assertThat(input, is(Arrays.asList(0, 1, 4)));
    }
}

