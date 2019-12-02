package ru.job4j.stragery;

/**
 * 7. Шаблон проектирования - Стратегия.[#193274]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class Paint {

    /**
     * Возвращает фигуру в виде строки.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
