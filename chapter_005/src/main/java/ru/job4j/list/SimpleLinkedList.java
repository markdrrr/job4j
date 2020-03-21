package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 5.3.2. Создать контейнер на базе связанного списка [#223097]
 *
 * @author Andrey Markushin
 * @version 1.1
 * @since 20.02.2020
 */
public class SimpleLinkedList<E> implements Iterable<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public SimpleLinkedList() {
    }

    /**
     * Добавляет элемент в последнию позицию.
     * @param item для добавления.
     */
    public void add(E item) {
        Node<E> prev = last;
        Node<E> newNode = new Node<>(prev, item, null);
        last = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * Метод получает элемент по индексу.
     * @param index искомого элемента.
     * @return item элемент.
     * @throws IndexOutOfBoundsException если индекс превышает количество элементов.
     */
    public E get(int index) {
        outBounds(index);
        Node<E> result = null;
        Node<E> temp = first;
        for (int pos = 0; pos < size; pos++) {
            if (index == pos) {
                result = temp;
                break;
            }
            temp = temp.next;
        }
        return result.item;
    }

    /**
     * Метод удаляет и возвращает первый эелемент.
     * @return удаленный элемент.
     */
    public E delete() {
        Node<E> deleted = this.first;
        this.first = deleted.next;
        if (deleted.next == null) {
            last = null;
        }
        size--;
        return deleted.item;
    }

    /**
     * Проверяет индекс в границе количеств элементов.
     * @param index для проверки.
     * @throws IndexOutOfBoundsException если индекс превышает количество элементов.
     */
    private void outBounds(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int cursor = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForModifications();
                boolean valid = false;
                if (cursor != size) {
                    valid = true;
                }
                return valid;
            }

            @Override
            public E next() {
                Node<E> result = null;
                Node<E> temp = first;
                checkForModifications();
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                for (int pos = 0; pos < size; pos++) {
                    if (cursor == pos) {
                        result = temp;
                        break;
                    }
                    temp = temp.next;
                }
                cursor++;
                return (E) result;
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

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
