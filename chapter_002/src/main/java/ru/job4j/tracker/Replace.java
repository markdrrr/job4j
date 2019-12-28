package ru.job4j.tracker;

import java.util.function.Consumer;

public class Replace extends BaseAction {
    protected Replace(int key, String name) {
        super(key, name);
    }


    /**
     * Изменение name item на новое
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Edited");
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
