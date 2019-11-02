package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int p = 8;
        int k = 2;
        double expected = 8.0;
        double out = SqArea.square(p,k);
        Assert.assertEquals(expected, out, 0.01);
    }
}
