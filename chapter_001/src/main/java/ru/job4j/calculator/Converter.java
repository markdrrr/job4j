package ru.job4j.calculator;
import java.util.Scanner;

public class Converter {

    public static int rubleToEuro(int value) {
    return value / 70;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int in = 140;
        int inDollar = 180;
        int expected = 2;
        int expectedDollar = 3;

        int out = rubleToEuro(in);
        int outDollar = rubleToDollar(inDollar);

        boolean passed = expected == out;
        boolean passedDollar = expectedDollar == outDollar;

        System.out.println("140 rubles are 2. Test1 result : " + passed);
        System.out.println("180 rubles are 3. Test2 result : " + passedDollar);
    }
}
