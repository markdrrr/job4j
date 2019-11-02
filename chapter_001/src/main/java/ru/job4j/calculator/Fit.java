package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        double weight = height - 100;
        return weight * 1.15;
    }


    public static double womanWeight(double height) {
        double weight = height - 110;
        return weight * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(187);
        double woman = womanWeight(171);
        System.out.println("Для мужчины с ростом 187 идеальный вес будет " + man + " кг");
        System.out.println("Для девушки с ростом 171 идеальный вес будет " + woman + " кг");
        // Идеальный вес для мужчин = (рост в сантиметрах – 100) · 1,15.
        // Идеальный вес для женщин = (рост в сантиметрах – 110) · 1,15.
    }
}
