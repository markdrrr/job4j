package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.3.1. Создать динамический список на базе массива.[#223096]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 08.02.2020
 */
public class SimpleArrayList<E> implements Iterable<E> {

    private Object[] container;
    private int position = 0;
    private int size = 0;
    private int modCount = 0;

    public SimpleArrayList() {
        this.container = new Object[10];
        this.size = 10;
    }

    public SimpleArrayList(int capacity) {
        this.container = new Object[capacity];
        this.size = capacity;
    }

    public int size() {
        return this.size;
    }

    /**
     * Метод добавляет элемент в массив.
     */
    public void add(E value) {
        ensureCapacity();
        this.container[position++] = value;
    }

    /**
     * Метод проверяет на вместимость массива, если массив заполнен,
     * создается новый массив размеором в два раза больще и копируется старый.
     */
    private void ensureCapacity() {
        if (size == position) {
            int newCapacity = size * 2;
            container = Arrays.copyOf(container, newCapacity);
            this.size = newCapacity;
            modCount++;
        }
    }

    /**
     * Метод получает элемент из массива.
     * @param index позиции элемента.
     * @throws NoSuchElementException, если яцейка массива пуста по данному индексу.
     * @return элеммент массива по заданному индексу
     */
    public E get(int index) throws NoSuchElementException {
        outOfArray(index);
        if (this.container[index] == null) {
            throw new NoSuchElementException();
        }
        return (E) this.container[index];
    }

    /**
     * Метод проверяет индекс вне массива.
     * @param index для проверки.
     * @throws IndexOutOfBoundsException, если индекс больше размера массивов.
     */
    private void outOfArray(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

//    /**
//     * Метод удаляет элемент массива по индексу.
//     * @param index для удаления.
//     * @throws IndexOutOfBoundsException, если индекс больше размера массивов.
//     */
//    public E delete(int index) throws NoSuchElementException {
//        if (size <= 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        E result = first.data;
//        first = first.next;
//        this.size--;
//        return result;
//    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int cursor = 0;
            int lastRet = -1;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForModifications();
                boolean valid = false;
                if (cursor != size && container[cursor] != null) {
                    valid = true;
                }
                return valid;
            }

            @Override
            public E next() {
                checkForModifications();
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                return (E) container[cursor++];
            }

            /**
             * Проверяет контейнер на наличие изменений после инициализации Итератора.
             *
             * @throws ConcurrentModificationException если изменено.
             */
            private void checkForModifications() throws ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

//    /**
//     * Класс предназначен для хранения данных.
//     */
//    private static class Node<E> {
//
//        E data;
//        Node<E> next;
//
//        Node(E data) {
//            this.data = data;
//        }
//    }
}
