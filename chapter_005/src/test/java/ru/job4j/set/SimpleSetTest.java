package ru.job4j.set;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> set = new SimpleSet<>(10);
        SimpleSet<Integer> result = new SimpleSet<>(10);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(3);
        result.add(1);
        result.add(2);
        result.add(3);
        assertThat(set, is(result));
    }

}