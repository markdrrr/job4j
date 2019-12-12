package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHas10Then1() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 10;
        int result = find.indexOf(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas9ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 9;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind5() {
        int[] input = new int[]{6, 1, 4, 2, 3, 7, 3, 9};
        int value = 5;
        int start = 4;
        int finish = 6;
        int result = FindLoop.indexOf(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort5() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = FindLoop.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        int[] input = new int[] {7, 21, 1};
        int[] result = FindLoop.sort(input);
        int[] expect = new int[] {1, 7, 21};
        assertThat(result, is(expect));
    }
}