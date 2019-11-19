package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * 4. Расстояние между точками в трехмерном пространстве.[#193298]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 19.11.2019
 */
public class Point {

    private int x;
    private int y;
    private int z;

    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Конструтор, который принимает начальное состояние объекта "точка" в трехмерном состоянии
     * @param x координат x
     * @param y координат y
     * @param z координат z
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Метод расстояния между двумя точками
     *
     * @param that вторая (конечная) точка
     * @return расстояние
     */
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    /**
     * Метод расстояния между тремя точками
     *
     * @param that вторая (конечная) точка
     * @return расстояние
     */
    public double distance3d(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point a3 = new Point(0,2,0);
        Point b3 = new Point(0,0,0);
        double dist = a.distance(b);
        double dist3d = a3.distance3d(b3);
        System.out.println(dist);
        System.out.println(dist3d);
    }
}