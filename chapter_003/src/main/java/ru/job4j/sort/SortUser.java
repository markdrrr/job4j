package ru.job4j.sort;

import java.util.*;

/**
 * 2. Сортировка User с использованием Comparator[#193237]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 11.12.2019
 */
public class SortUser {

    public static Set<User> sort(List<User> users) {
        return new TreeSet<User>(users);
    }

    public static List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    public static List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Petr", 30),
                new User("Igor", 31),
                new User("Maxim", 20)
                )
        );
        System.out.println(users);
        System.out.println("Sort: " + sort(users));
        System.out.println("Sort: " + sort(users));
        System.out.println("Sort: " + sort(users));
    }
}
