package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertSame;

public class TrackerSingletonTest {
    @Test
    public void TrackerSingletonFirst() {
        TrackerSingletonFirst first = TrackerSingletonFirst.INSTANCE;
        TrackerSingletonFirst second = TrackerSingletonFirst.INSTANCE;
        assertSame(first, second);
    }

    @Test
    public void TrackerSingletonSecond() {
        TrackerSingletonSecond first = TrackerSingletonSecond.getInstance();
        TrackerSingletonSecond second = TrackerSingletonSecond.getInstance();
        assertSame(first, second);
    }

    @Test
    public void TrackerSingletonThird() {
        TrackerSingletonThird first = TrackerSingletonThird.getInstance();
        TrackerSingletonThird second = TrackerSingletonThird.getInstance();
        assertSame(first, second);
    }

    @Test
    public void TrackerSingletonFourth() {
        TrackerSingletonFourth first = TrackerSingletonFourth.getInstance();
        TrackerSingletonFourth second = TrackerSingletonFourth.getInstance();
        assertSame(first, second);
    }
}
