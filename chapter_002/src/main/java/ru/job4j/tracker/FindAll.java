package ru.job4j.tracker;

import java.util.ArrayList;

public class FindAll extends BaseAction {
    protected FindAll(int key, String name) {
        super(key, name);
    }

    @Override
    public String name() {
        return "Show all items";
    }

    /**
     * Вывод всех item, кроме null
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("All items: ");
        ArrayList <Item> items = tracker.findAll();
        int j = 0;
        for(Item item : items) {
            System.out.println("Заявка " + j++ +". Name: " + item.getName() + " id: " + item.getId());
        }
        return true;
    }
}
