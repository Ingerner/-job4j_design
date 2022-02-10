package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;


public class SimpleMapTest {

    SimpleMap<Integer, String> sm = new SimpleMap();

    @Test
    public void putTrue() {
        Assert.assertTrue(sm.put(1, "Value1"));
    }

    @Test
    public void putFalse() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        sm.put(1, "Value1");
        Assert.assertFalse(sm.put(1, "Value1"));
    }

    @Test
    public void iteratorTest() {
        sm.put(1, "Value1");
        sm.put(2, "value2");
        sm.put(3, "value3");
        Iterator<Integer> iterator = sm.iterator();
        Assert.assertThat(1, is(iterator.next()));
    }

    @Test
    public void getTestValue() {
        sm.put(1, "Value1");
        Assert.assertThat(sm.get(1), is("Value1"));
    }

    @Test
    public void getTestNull() {
        sm.put(1, "Value1");
        Assert.assertNull(sm.get(2));
    }

    @Test
    public void removeTestTrue() {
        sm.put(1, "Value1");
        Assert.assertTrue(sm.remove(1));
    }

    @Test
    public void removeTestFalse() {
        sm.put(1, "Value1");
        Assert.assertFalse(sm.remove(2));
    }

    @Test
    public void removeTestNull() {
        sm.put(1, "Value1");
        sm.remove(1);
        Assert.assertNull(sm.get(1));
    }
}