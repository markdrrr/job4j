package ru.job4j.oop;

public class DummyDic {
    String engToRus(String eng) {
        String a = "Неизвестное слово. " + eng;
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        DummyDic a = new DummyDic();
        String word = "simple";
        a.engToRus(word);
    }
}
