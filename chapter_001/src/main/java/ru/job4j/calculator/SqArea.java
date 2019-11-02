package ru.job4j.calculator;

public class SqArea {
    public static double square(int p, int k) {
        int l,h; // где а это результат деления периметра попалам
        h = p/2-k;
        l = h * k;
        return l * h;
    }

    public static void main(String[] args) {
        double result1 = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result1);
    }
}
