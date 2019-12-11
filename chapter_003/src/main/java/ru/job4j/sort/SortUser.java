package ru.job4j.sort;

import java.util.*;

/**
 * 1. Организовать сортировку User[#193236]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 11.12.2019
 */
public class SortUser {

    public static Set<User> sort (List<User> users) {
        return new TreeSet<User>(users);
    }

    public static void main(String[] args) {
        List <User> users = new ArrayList<>();
        users.addAll( Arrays.asList(
                new User("Petr", 30),
                new User("Igor", 31),
                new User("Maxim",20)
                )
        );
        System.out.println(users);
        System.out.println("Sort: " + sort(users));
    }
}
