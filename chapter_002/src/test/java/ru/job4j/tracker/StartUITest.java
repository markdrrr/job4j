package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

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
        Tracker tracker = new Tracker();
        Item item = new Item("Fix PC");
        tracker.add(item);
        ArrayList<Item> items = new ArrayList<>();
        items = tracker.findAll();
        Item created = items.get(0);
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
        BaseAction action = new Replace(0, "Replace");
        action.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        BaseAction action = new Delete(0, "Delete");
        action.execute(new StubInput(answers), tracker);
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
        BaseAction action = new FindAll(0, "Find All");
        action.execute(new StubInput(answers), tracker);
        ArrayList<Item> result = tracker.findAll();
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(item);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByNameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getName()};
        ArrayList<Item> result = tracker.findByName(item.getName());
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(item);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByIdItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        BaseAction actions = new FindById(0, "Find by id");
        actions.execute(new StubInput(answers), tracker);
        Item result = tracker.findById(item.getId());
        Item expected = item;
        assertThat(result, is(expected));
    }
}