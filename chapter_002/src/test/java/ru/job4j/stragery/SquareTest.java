package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("+ + + +" + System.lineSeparator())
                                .append("+     +" + System.lineSeparator())
                                .append("+     +" + System.lineSeparator())
                                .append("+ + + +")
                                .toString()
                )
        );
    }
}
