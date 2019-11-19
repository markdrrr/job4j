package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    public class MaxTest {
        @Test
        public void whenMax1To2Then1() {
            int result = Max.max(3, 2);
            assertThat(result, is(3));
        }

        @Test
        public void whenMax1To2Then2() {
            int result = Max.max(1, 2);
            assertThat(result, is(2));
        }

        @Test
        public void when3Numbers() {
            int result = Max.max(1,2,3);
            assertThat(result, is(3));
        }

        @Test
        public void when4Numbers() {
            int result = Max.max(6,8,10,12);
            assertThat(result, is(12));
        }
    }
