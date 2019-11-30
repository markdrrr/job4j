package ru.job4j.io;

import java.util.Scanner;

/**
 * 2. Scanner и чтение числа из консоли.[#193277]
 * @author Andrey Markushin
 * @version 1.0
 * @since 30.11.2019
 */
public class Matches {

    public static void main(String[] args) {
        int match = 11;
        int member = 1;
        String error = "Выберите от 1 до 3 спичек! Введите заново";
        boolean run = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Выигрывает тот, кто забрал последние спички.");
        System.out.println("По очереди берите от 1 до 3 спичек");
        while (run) {
            System.out.println("На столе осталось " + match + " спичек.");
            System.out.println("Сколько спичек возьмет игрок " + member +" ?");
            int answer1 = Integer.valueOf(input.nextLine());
            while (answer1 > 3) {
                System.out.println(error);
                answer1 = Integer.valueOf(input.nextLine());
            }
            match = match - answer1;
            if (match == 0) {
                System.out.println("Игра завершена. Спичек не осталось");
                System.out.println("Выишрал игрок" );
                run = false;
            } else { member++; }
            System.out.println("На столе осталось " + match + " спичек.");
            System.out.println("Сколько спичек возьмет игрок " + member +" ?");
            int answer2 = Integer.valueOf(input.nextLine());
            while (answer2 > 3) {
                System.out.println(error);
                answer2 = Integer.valueOf(input.nextLine());
            }
            match = match - answer2;
            if (match == 0) {
                System.out.println("Игра завершена. Спичек не осталось");
                System.out.println("Выиграл "+ member +" игрок" );
                run = false;
            } else { member--; }
        }
    }
}
