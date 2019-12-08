package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Телефонный справочник на базе ArrayList[#193244]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 09.12.2019
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
        for (int index =0; index < persons.size(); index++) {
            if (persons.iterator().next().getName().contains(key)) {
               result.add(persons.get(index));
            }
            if (persons.iterator().next().getSurname().contains(key)) {
                result.add(persons.get(index));
            }
            if (persons.iterator().next().getAddress().contains(key)) {
                result.add(persons.get(index));
            }
            if (persons.iterator().next().getPhone().contains(key)) {
                result.add(persons.get(index));
            }
            index++;
        }
        return result;
    }
}