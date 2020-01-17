package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.2.1. Реализовать SimpleArray<T>[#223107]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 17.01.2020
 */
public class SimpleArray <T> implements Iterable<T>  {
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

    private void outOfArray(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Заменяет указанным элементом (model) элемент, находящийся по индексу index.
     *
     * @param index индекс эелемента который будем заменять.
     * @param model элемент для добавления.
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**
     * Удаляет элемент по указанному индексу, все находящиеся справа
     * элементы при этом сдвигаются на единицу влево.
     *
     * @param index индекс эелемента.
     */
    public void remove(int index) {
        if (index > objects.length - 1) {
            throw new NoSuchElementException();
        }
        System.arraycopy(objects, index + 1, objects, index, size - index - 1);
    }

    /**
     * Возвращает элемент, расположенный по указанному индексу.
     *
     * @param index индекс эелемента.
     */
    public T get(int index) {
        if (this.objects[index] == null) {
            throw new NoSuchElementException();
        }
        return (T) this.objects[index];
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
            while (cell < size) {
                if (objects[cell] != null){
                    valid = true;
                    break;
                }
                valid = false;
                cell++;
            }
            return valid;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while (objects[cell] == null) {
                cell++;
            }
            return objects[cell++];
        }
    }
}
