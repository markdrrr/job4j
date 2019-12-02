package ru.job4j.tracker;

/**
 * 8. Реализация меню за счет шаблона стратегия.[#193284]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    /**
     * Создание нового item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item created");
        return true;
    }
}