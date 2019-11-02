package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        int in = 4;
        int in1 = 8;
        int in2 = 4;
        int in3 = 4;
        double expected = 4.0;
        double out = Point.distance(in,in1,in2,in3);
        Assert.assertEquals(expected, out, 0.01);
    }
}
