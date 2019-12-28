package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindById extends BaseAction {
    protected FindById(int key, String name) {
        super(key, name);
    }


    /**
     * Поиск по id item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Successful search");
            output.accept("Заявка Name: " + item.getName() + " id: " + item.getId());
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
