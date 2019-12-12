package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertSame;

public class TrackerSingletonTest {
    @Test
    public void trackerSingletonFirst() {
        TrackerSingletonFirst first = TrackerSingletonFirst.INSTANCE;
        TrackerSingletonFirst second = TrackerSingletonFirst.INSTANCE;
        assertSame(first, second);
    }

    @Test
    public void trackerSingletonSecond() {
        TrackerSingletonSecond first = TrackerSingletonSecond.getInstance();
        TrackerSingletonSecond second = TrackerSingletonSecond.getInstance();
        assertSame(first, second);
    }

    @Test
    public void trackerSingletonThird() {
        TrackerSingletonThird first = TrackerSingletonThird.getInstance();
        TrackerSingletonThird second = TrackerSingletonThird.getInstance();
        assertSame(first, second);
    }

    @Test
    public void trackerSingletonFourth() {
        TrackerSingletonFourth first = TrackerSingletonFourth.getInstance();
        TrackerSingletonFourth second = TrackerSingletonFourth.getInstance();
        assertSame(first, second);
    }
}
