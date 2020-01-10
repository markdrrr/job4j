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
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        var users = List.of(user1, user2, user3);
        ArrayList<User> result = new ArrayList<User>(SortUser.sort(users));
        ArrayList<User> expected = new ArrayList<>(List.of(user3, user1, user2));
        assertEquals(expected, result);
    }

//    @Test
//    public void sortNameLength() {
//        User user1 = new User("Сергей", 25);
//        User user2 = new User("Иван", 30);
//        User user3 = new User("Юра", 20);
//        var users = List.of(user1, user2, user3);
//        ArrayList<User> result = (ArrayList<User>) SortUser.sortNameLength(users);
//        ArrayList<User> expected = new ArrayList<>(List.of(user3, user2, user1));
//        assertEquals(expected, result);
//    }

//    @Test
//    public void sortByAllFields() {
//        User user1 = new User("Сергей", 25);
//        User user2 = new User("Иван", 30);
//        User user3 = new User("Юра", 20);
//        User user4 = new User("Юра", 19);
//        var users = List.of(user1, user2, user3, user4);
//        ArrayList<User> result = (ArrayList<User>) SortUser.sortByAllFields(users);
//        ArrayList<User> expected = new ArrayList<>(List.of(user2, user1, user4, user3));
//        assertEquals(expected, result);
//    }

}