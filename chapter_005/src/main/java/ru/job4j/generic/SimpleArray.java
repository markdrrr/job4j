package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.2.1. Реализовать SimpleArray<T>[#223107]
 *
 * @author Andrey Markushin
 * @version 1.3
 * @since 17.01.2020
 */
public class SimpleArray<T> implements Iterable<T>  {
    private Object[] objects;
    private int size = 0;
    private int position = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        this.size = size;
    }

    /**
     * Добавляет указанный элемент (model) в первую свободную ячейку.
     *
     * @param model элемент для добавления.
     */
    public void add(T model) {
        if (position >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.objects[position++] = model;
    }

    /**
     * Проверяет входит ли заданный индекс в размер массива.
     *
     * @param index индекс для проверки.
     * @throws IndexOutOfBoundsException если индекс за пределами массива.
     */
    private void outOfArray(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Проверяет входит ли заданный индекс в пределы добавленных элементов.
     *
     * @param index индекс для проверки.
     * @throws NoSuchElementException если индекс за пределами массива.
     */
    private void outOfAddPosition(int index) throws NoSuchElementException {
        if (index > this.position) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Заменяет указанным элементом (model) элемент, находящийся по индексу index.
     *
     * @param index индекс эелемента который будем заменять.
     * @param model элемент для добавления.
     */
    public void set(int index, T model) {
        outOfArray(index);
        outOfAddPosition(index);
        this.objects[index] = model;
    }

    /**
     * Удаляет элемент по указанному индексу, все находящиеся справа
     * элементы при этом сдвигаются на единицу влево.
     *
     * @param index индекс эелемента.
     */
    public void remove(int index) {
        outOfArray(index);
        outOfAddPosition(index);
        System.arraycopy(objects, index + 1, objects, index, size - index - 1);
        objects[size - 1] = null;
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу.
     *
     * @param index индекс эелемента.
     */
    public T get(int index) {
        outOfArray(index);
        if (this.objects[index] == null) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index];
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < position; i++) {
                if (objects[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < position; i++) {
                if (o.equals(objects[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int size() {
        return position;
    }

    /**
     * Возвращает итератор, предназначенный для обхода данной структуры.
     *
     * @return объект класса IteratorNew.
     */
    @Override
    public Iterator<T> iterator() {
        return new IteratorNew();
    }

    private class IteratorNew implements Iterator {
         int cell = 0;

        @Override
        public boolean hasNext() {
            boolean valid = false;
            if (cell < position) {
                    valid = true;
                }
            return valid;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return objects[cell++];
        }
    }
}
