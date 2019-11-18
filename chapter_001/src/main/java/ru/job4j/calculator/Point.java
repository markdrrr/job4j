package ru.job4j.calculator;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        double x = x2 - x1;
        double y = y2 - y1;
        double first = Math.pow(x, 2);
        double second = Math.pow(y, 2);
        double result = first + second;
        return Math.sqrt(result);
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        double result2 = distance(1,1,0,2);
        double result3 = distance(2,3,4,8);
        System.out.println("result (0, 0) to (2, 0) " + result);
        System.out.println("result (1, 1) to (0, 2) " + result2);
        System.out.println("result (2, 3) to (4, 8) " + result3);
    }
}
