package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;


public class SimpleMapTest {

    SimpleMap<Integer, String> map = new SimpleMap();

    @Test
    public void putTrue() {
        Assert.assertTrue(map.put(1, "Value1"));
    }

    @Test
    public void putFalse() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        sm.put(1, "Value1");
        Assert.assertFalse(sm.put(1, "Value1"));
    }

    @Test
    public void putExpand() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        sm.put(1, "Value1");
        sm.put(2, "Value2");
        sm.put(3, "Value3");
        Assert.assertThat(sm.get(1), is("Value1"));
        sm.put(4, "Value4");
        sm.put(5, "Value5");
        sm.put(6, "Value6");
        sm.put(7, "Value7");
        Assert.assertThat(sm.get(1), is("Value1"));
        Assert.assertThat(sm.size(), is(7));
    }

    @Test
    public void iteratorTest() {
        map.put(1, "Value1");
        map.put(2, "value2");
        map.put(3, "value3");
        Iterator<Integer> iterator = map.iterator();
        Assert.assertThat(1, is(iterator.next()));
    }

    @Test
    public void getTestValue() {
        map.put(1, "Value1");
        Assert.assertThat(map.get(1), is("Value1"));
    }

    @Test
    public void getTestNull() {
        map.put(1, "Value1");
        Assert.assertNull(map.get(2));
    }

    @Test
    public void removeTestTrue() {
        map.put(1, "Value1");
        Assert.assertTrue(map.remove(1));
    }

    @Test
    public void removeTestFalse() {
        map.put(1, "Value1");
        Assert.assertFalse(map.remove(2));
    }

    @Test
    public void removeTestNull() {
        map.put(1, "Value1");
        map.remove(1);
        Assert.assertNull(map.get(1));
    }
}