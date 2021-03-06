package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * 8. Реализация меню за счет шаблона стратегия.[#193284]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class CreateAction extends BaseAction {

    protected CreateAction(int key, String name) {
        super(key, name);
    }

    /**
     * Создание нового item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item created");
        return true;
    }
}