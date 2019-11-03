package ru.job4j.loop;

        import org.junit.Test;

        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        int n = Factorial.calc (5);
        assertThat(n, is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        int n = Factorial.calc (0);
        assertThat(n, is(1));
    }
}