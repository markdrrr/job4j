package ru.job4j.tracker;

import java.util.Scanner;

/**
 * 1. Обеспечить бесперебойную работу приложения Tracker.[#193289]
 * @author Andrey Markushin
 * @version 1.1
 * @since 03.12.2019
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}