package ru.job4j.sort;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {
    private List<User> users = new ArrayList<>();
    private SortUser sort = new SortUser();

    @Test
    public void sort() {
        List <User> users = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        ArrayList<User> result = new ArrayList<User>(SortUser.sort(users));
        ArrayList<User> expected = new ArrayList<>();
        expected.add(user3);
        expected.add(user1);
        expected.add(user2);
        assertEquals(expected, result);
    }

    @Test
    public void sortNameLength() {
        List <User> users = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Юра", 20);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        ArrayList<User> result = (ArrayList<User>) SortUser.sortNameLength(users);
        ArrayList<User> expected = new ArrayList<>();
        expected.add(user3);
        expected.add(user2);
        expected.add(user1);
        assertEquals(expected, result);
    }

    @Test
    public void sortByAllFields() {
        List <User> users = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Юра", 20);
        User user4 = new User("Юра", 19);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        ArrayList<User> result = (ArrayList<User>) SortUser.sortByAllFields(users);
        ArrayList<User> expected = new ArrayList<>();
        expected.add(user2);
        expected.add(user1);
        expected.add(user4);
        expected.add(user3);
        assertEquals(expected, result);
    }

}