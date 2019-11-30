package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Чтение из консоли. Класс Scanner.[#193276]
 * @author Andrey Markushin
 * @version 1.0
 * @since 30.11.2019
 */
public class MagicBall {

    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        System.out.print("Пример: 'Буду ли я богат ?' ");
        int answer = new Random().nextInt(3);
        Scanner input = new Scanner(System.in);
        input.nextLine();
        if (answer == 0) {
            System.out.println("Да");
        } else if (answer == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
    }
}
