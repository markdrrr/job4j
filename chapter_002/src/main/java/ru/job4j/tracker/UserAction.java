package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {
    String name();
    int key();

    boolean execute(Input input, Tracker tracker, Consumer<String> output);

}