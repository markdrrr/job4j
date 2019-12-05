package ru.job4j.tracker;

import ru.job4j.tracker.Item;

/**
 * 1. Singleton.[#193292] - 3. static final field. Eager loading.
 * @author Andrey Markushin
 * @version 1.0
 * @since 06.12.2019
 */
public class TrackerSingletonFourth {
    private TrackerSingletonFourth() {
    }

    public static TrackerSingletonFourth getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingletonFourth INSTANCE = new TrackerSingletonFourth();
    }

    public static void main(String[] args) {
        TrackerSingletonFourth tracker = TrackerSingletonFourth.getInstance();
        Item items = new Item("Fourth");
        tracker.add(items);
    }
}
