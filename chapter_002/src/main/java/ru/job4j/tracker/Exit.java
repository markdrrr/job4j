package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия.[#193284]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Good bye");
        return false;
    }
}
