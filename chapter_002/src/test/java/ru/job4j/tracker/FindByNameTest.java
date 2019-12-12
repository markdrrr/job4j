package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 9.2. Тесты вывода на консоль в StartUI[#193270]
 * @author Andrey Markushin
 * @version 1.0
 * @since 03.12.2019
 */
public class FindByNameTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindByName act = new FindByName(5, "Find items by name");
        act.execute(new StubInput(new String[] {"fix bug"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Заявка Name: " + item.getName() + " id: " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}