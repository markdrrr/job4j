package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                        .append("+")
                        .append("+ +")
                        .append("+  +")
                        .append("+++++")
                                .toString()
                )
        );
    }
}
