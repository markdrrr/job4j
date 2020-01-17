package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    private RoleStore role;

    @Before
    public void create() {
        role = new RoleStore();
        role.add(new Role("First"));
        role.add(new Role("Second"));
        role.add(new Role("Third"));
    }

    @Test
    public void whenAddThenAdded() {
        role.add(new Role("Added"));
        assertThat(role.findById("Added").getId(), is("Added"));
    }

    @Test
    public void whenReplaceByIdThanReplaced() {
        Role replacer = new Role("Replaced");
        assertThat(role.replace("Second", replacer), is(true));
        assertThat(role.findById("Replaced").getId(), is("Replaced"));
    }

    @Test
    public void delete() {
        assertThat(role.delete("Second"), is(true));
    }

    @Test
    public void findById() {
        Role expected = new Role("Third");
        assertThat(role.findById("Third").getId(), is(expected.getId()));
    }
}