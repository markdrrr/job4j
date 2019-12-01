package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 5.1. Тестирование. Подготовка данных.[#193285]
 * @author Andrey Markushin
 * @version 1.0
 * @since 01.12.2019
 */
public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.replace(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        StartUI.delete(new StubInput(answers), tracker);
        Item result = tracker.findById(item.getId());
        Item expected = null;
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {" "};
        StartUI.findAll(new StubInput(answers), tracker);
        Item[] result = tracker.findAll();
        Item[] expected = {item};
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getName()};
        StartUI.findByName(new StubInput(answers), tracker);
        Item[] result = tracker.findByName(item.getName());
        Item[] expected = {item};
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByIdItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        StartUI.findById(new StubInput(answers), tracker);
        Item result = tracker.findById(item.getId());
        Item expected = item;
        assertThat(result, is(expected));
    }
}