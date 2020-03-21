package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.3.4. Задан связанный список. Определить цикличность.[#223099]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 21.03.2020
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public int size() {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * Метод переставляет элементы в обратном порядке.
     */
    public void revert() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}