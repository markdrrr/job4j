package ru.job4j.tracker;

/**
 * 9. Написать тесты на StartUI.[#193273]
 * @author Andrey Markushin
 * @version 1.0
 * @since 02.12.2019
 */
public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}