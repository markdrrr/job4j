package ru.job4j.condition;

import static java.lang.Math.*;

/**
 * 2.1. Рефакторинг - Расстояние между точками.[#193296]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 19.11.2019
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор инициализации точки
     *
     * @param first  Х координата точки
     * @param second Y координата точки
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Метод расстояния между двумя точками
     *
     * @param that вторая (конечная) точка
     * @return расстояние
     */
    public double distnce(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distnce(b);
        System.out.println(dist);
    }
}