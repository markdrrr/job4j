package ru.job4j.generic;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    private UserStore store;

    @Before
    public void create() {
        store = new UserStore();
        store.add(new User("First"));
        store.add(new User("Second"));
        store.add(new User("Third"));
    }

    @Test
    public void whenAddThenAdded() {
        store.add(new User("Added"));
        assertThat(store.findById("Added").getId(), is("Added"));
    }

    @Test
    public void whenReplaceByIdThanReplaced() {
        User replacer = new User("Replaced");
        assertThat(store.replace("Second", replacer), is(true));
        assertThat(store.findById("Replaced").getId(), is("Replaced"));
    }

    @Test
    public void delete() {
        assertThat(store.delete("Second"), is(true));
    }

    @Test
    public void findById() {
        User expected = new User("Third");
        assertThat(store.findById("Third").getId(), is(expected.getId()));
    }
}