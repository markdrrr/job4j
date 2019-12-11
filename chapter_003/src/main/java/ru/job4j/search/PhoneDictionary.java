package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Телефонный справочник на базе ArrayList[#193244]
 *
 * @author Andrey Markushin
 * @version 1.2
 * @since 11.12.2019
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        int index = 0;
        for (Person person : persons) {
            if (person.getName().contains(key)) {
                result.add(persons.get(index));
            }
            if (person.getSurname().contains(key)) {
                result.add(persons.get(index));
            }
            if (person.getAddress().contains(key)) {
                result.add(persons.get(index));
            }
            if (person.getPhone().contains(key)) {
                result.add(persons.get(index));
            }
        }
        return result;
    }
}