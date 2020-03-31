package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> set = new SimpleSet<>(10);
        SimpleSet<Integer> res = new SimpleSet<>(10);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        res.add(1);
        res.add(2);
        res.add(3);

        assertEquals(set.getArray().size(), res.getArray().size());
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            // исходное значение (кого сравниваем)
            Integer next = iterator.next();
            // значение результата (с кем сравниваем)
            Integer integer = res.getArray().get(i++);
            assertEquals(next, integer);
        }
    }

}