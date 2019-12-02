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
public class FindAllTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        Item item2 = new Item("new bug");
        tracker.add(item2);
        int j = 0;
        FindAll act = new FindAll();
        act.execute(new StubInput(new String[] {}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add ("All items: ")
                .add("Заявка " + j++ +". Name: " + item.getName() + " id: " + item.getId())
                .add("Заявка " + j++ +". Name: " + item2.getName() + " id: " + item2.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}