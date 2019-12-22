package ru.job4j.labmda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calculator function = new Calculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calculator function = new Calculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2) - x - 2);
        List<Double> expected = Arrays.asList(18D, 28D, 40D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Calculator function = new Calculator();
        List<Double> result = function.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(5d), Math.log(6d), Math.log(7d));
        assertThat(result, is(expected));
    }
}