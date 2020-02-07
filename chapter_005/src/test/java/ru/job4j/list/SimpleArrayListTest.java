package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> result;

    @Before
    public void beforeTest() {
        result  = new SimpleArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
    }

    @Test
    public void whenAddThenAdded() {
        result.add(5);
        assertThat(result.get(3), is(5));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenGetOutOfBoundsThenException() {
        result.get(11);
    }

    @Test (expected = NoSuchElementException.class)
    public void whenGetNullThanException() {
        result.get(7);
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenEnsureCapacityWhenIterateThenException() {
        result = new SimpleArrayList<>(2);
        result.add(1);
        result.add(2);
        Iterator<Integer> itr = result.iterator();
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        result.add(3);
        itr.next();
    }

//    @Test
//    public void whenAddThreeElementsThenUseGetOneResultTwo() {
//        assertThat(list.get(1), is(2));
//    }

//    @Test
//    public void whenAddThreeElementsThenUseGetSizeResultThree() {
//        assertThat(list.getSize(), is(3));
//    }

//    @Test
//    public void whenAddThreeElementsThenUseDeleteResultThree() {
//        assertThat(list.delete(), is(3));
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void whenAddThreeElementsThenUseDeleteResultException() {
//        assertThat(list.delete(), is(3));
//        assertThat(list.delete(), is(2));
//        assertThat(list.delete(), is(1));
//        assertThat(list.delete(), is(0));
//    }
}