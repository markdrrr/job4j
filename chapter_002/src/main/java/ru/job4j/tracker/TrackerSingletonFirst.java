package ru.job4j.tracker;

import ru.job4j.tracker.Item;

/**
 * 1. Singleton.[#193292] - 1. enum. Eager loading.
 * @author Andrey Markushin
 * @version 1.0
 * @since 06.12.2019
 */
public enum TrackerSingletonFirst {
        INSTANCE; // здесь мы указываем перечисления.
        // Конструкторы и методы.
        public Item add(Item model) {
            return model;
        }

    public static void main(String[] args) {
        TrackerSingletonFirst tracker = TrackerSingletonFirst.INSTANCE;
        Item items = new Item("First");
        tracker.add(items);
    }
}
