package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double in = 191;
        double expected = 104.65;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        double in = 168;
        double expected = 78.2;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}
