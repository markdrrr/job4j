package ru.job4j.tracker;

import ru.job4j.tracker.Item;

/**
 * 1. Singleton.[#193292] - 3. static final field. Eager loading.
 * @author Andrey Markushin
 * @version 1.0
 * @since 06.12.2019
 */
public class TrackerSingletonThird {
    private static final TrackerSingletonThird INSTANCE = new TrackerSingletonThird();

    private TrackerSingletonThird() {
    }

    public static TrackerSingletonThird getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingletonThird tracker = TrackerSingletonThird.getInstance();
        Item items = new Item("Third");
        tracker.add(items);
    }
}

