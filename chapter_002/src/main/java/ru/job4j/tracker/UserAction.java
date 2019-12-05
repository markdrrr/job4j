package ru.job4j.tracker;

public interface UserAction {
    String name();
    int key();

    boolean execute(Input input, Tracker tracker);
}