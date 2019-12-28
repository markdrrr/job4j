package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * 9. Написать тесты на StartUI.[#193273]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class StubAction extends BaseAction {
    private boolean call = false;

    protected StubAction(int key, String name) {
        super(key, name);
    }

    @Override
    public String name() {
        return "Stub action";
    }

    public int key() {
        return 0;
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}