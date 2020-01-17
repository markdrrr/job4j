package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray<String> result;

    @Before
    public void create() {
        result = new SimpleArray<>(5);
        result.add("first");
        result.add("second");
        result.add("third");
    }

    @Test
    public void whenAddThenAdded() {
        result.add("fourth");
        assertThat(result.get(3), is("fourth"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenGetNullThanException() {
        result.get(4);
    }

    @Test
    public void whenRemoveExistingThenRemove() {
        result.remove(1);
        assertThat(result.get(1), is("third"));
    }

    @Test
    public void whenSetThenSets() {
        result.set(1, "five");
        assertThat(result.get(1), is("five"));
    }

    @Test
    public void whenUseIteratorThen() {
        Iterator<String> iteratorNew = result.iterator();
        assertThat(iteratorNew.hasNext(), is(true));
        assertThat(iteratorNew.next(), is("first"));
        assertThat(iteratorNew.hasNext(), is(true));
        assertThat(iteratorNew.next(), is("second"));
        assertThat(iteratorNew.hasNext(), is(true));
        assertThat(iteratorNew.next(), is("third"));
        assertThat(iteratorNew.hasNext(), is(false));
    }
}