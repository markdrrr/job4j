package ru.job4j.tracker;

/**
 * 1. Обеспечить бесперебойную работу приложения Tracker.[#193289]
 * @author Andrey Markushin
 * @version 1.1
 * @since 03.12.2019
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again ");
            }
        } while (invalid);
        return value;
    }

    @Override
    public int askInt(String question, int max) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question, max);
                invalid = false;
            } catch (IllegalStateException moe) {
                System.out.println("Please select key from menu ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again ");
            }
        } while (invalid);
        return value;
    }
}