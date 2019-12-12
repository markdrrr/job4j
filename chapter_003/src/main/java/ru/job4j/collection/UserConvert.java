package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2. Написать программу преобразования List в Map.[#193252]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 11.12.2019
 */
public class UserConvert {

    /**
     * Метод конвертирует List в Map с ключом Integer id и соответствующим ему User.
     *
     * @param list список пользователей.
     * @return возвращает список (ключ, пользователь).
     */
    public static HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Petr", "Moscow"));
        users.add(new User(2, "Ivan", "Rostov"));
        HashMap<Integer, User> mapUsers = new HashMap<Integer, User>();
        mapUsers = process(users);
        for (HashMap.Entry<Integer, User> user : mapUsers.entrySet()) {
            System.out.println(user);
        }
    }
}
