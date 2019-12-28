package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FindByName extends BaseAction {
    protected FindByName(int key, String name) {
        super(key, name);
    }

    /**
     * Поиск по имени item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String name = input.askStr("Enter name: ");
        ArrayList<Item> items = tracker.findByName(name);
        if (0 < items.size()) {
            for (int i = 0; i < items.size(); i++) {
                output.accept("Заявка Name: " + items.get(i).getName() + " id: " + items.get(i).getId());
            }
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
