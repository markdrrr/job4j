package ru.job4j.tracker;

import ru.job4j.tracker.Item;

/**
 * 1. Singleton.[#193292] - 2. static field. Lazy loading.
 * @author Andrey Markushin
 * @version 1.0
 * @since 06.12.2019
 */
public class TrackerSingletonSecond {
    private static TrackerSingletonSecond instance;

    private TrackerSingletonSecond() {
    }

    public static TrackerSingletonSecond getInstance() {
        if (instance == null) {
            instance = new TrackerSingletonSecond();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingletonSecond tracker = TrackerSingletonSecond.getInstance();
        Item items = new Item("Second");
        tracker.add(items);
    }
}
