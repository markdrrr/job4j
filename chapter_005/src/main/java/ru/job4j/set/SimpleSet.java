package ru.job4j.set;

import ru.job4j.generic.SimpleArray;
import java.util.Iterator;
import java.util.Objects;

/**
 * 1. Реализовать коллекцию Set на массиве[#223111]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 23.03.2020
 */
public class SimpleSet<E> implements Iterable<E> {

    private SimpleArray<E> array;

    /**
     * Создает массив определенного размера.
     *
     * @param capacity вместимость массива.
     */
    public SimpleSet(int capacity) {
        array = new SimpleArray<>(capacity);
    }

    /**
     * Добавляет элемент, если он уникальный.
     *
     * @param e элемент для добавления.
     */
    public void add(E e) {
        if (array.size() == 0) {
            array.add(e);
        }
        int s = array.size();
        int same = 0;
        for (int i = 0; i < s; i++) {
            if (array.get(i).equals(e)) {
                same++;
            }
        }
        if (same == 0) {
            array.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(array, simpleSet.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    public SimpleArray<E> getArray() {
        return array;
    }
}
