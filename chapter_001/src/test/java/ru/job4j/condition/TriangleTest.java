package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 2.2. Рефакторинг - Площадь треугольника.[#193297]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 19.11.2019
 */
public class TriangleTest {

    @Test
    public void whenArea() {
        Point first = new Point(1, 2);
        Point second = new Point(4, 3);
        Point third = new Point(2, 7);
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        double expected = 7.000000000000002;
        assertThat(result, is(expected));
    }

    @Test
    public void whenExist() {
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotExist() {
        boolean result = Triangle.exist(1.0, 2.0, 1.0);
        assertThat(result, is(false));
    }
}