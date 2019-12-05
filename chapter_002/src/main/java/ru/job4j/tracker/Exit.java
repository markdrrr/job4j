package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия.[#193284]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class Exit extends BaseAction {
    protected Exit(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Good bye");
        return false;
    }
}
