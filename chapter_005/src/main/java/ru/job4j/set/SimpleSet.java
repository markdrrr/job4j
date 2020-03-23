package ru.job4j.set;

import ru.job4j.generic.SimpleArray;
import java.util.Iterator;

/**
 * 1. Реализовать коллекцию Set на массиве[#223111]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 23.03.2020
 */
public class SimpleSet <E> implements Iterable<E> {

    SimpleArray<E> array;

    public SimpleSet(int capacity) {
        array = new SimpleArray<>(capacity);
    }

    /**
     * Добавляет элемент, если он уникальный.
     *
     * @param e элемент для добавления.
     */
    public void add(E e) {
        if (array.indexOf(e) == -1) {
            array.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
