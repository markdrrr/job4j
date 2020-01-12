package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.1. Итератор для двухмерного массива int[][][#223105]
 *
 * @author Andrey Markushin
 * @version 1.1
 * @since 12.01.2020
 */
public class MatrixIteratorArray implements Iterator {
    final int[][] value;
    static int cell = 0;
    static int row = 0;

    public MatrixIteratorArray(int[][] value) {
        this.value = value;
    }

    /**
     * Метод проверки окончания следующих элементов.
     * @return - true, если еще есть элементы, false - следующий элемент отсуствует.
     */
    @Override
    public boolean hasNext() {
        return value.length > cell;
    }

    /**
     * Возвращает элемент из матрицы и переключает маркер на следующий элемент
     * @return - возвращает элемент из массива
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int index = value[row][cell++];
        if (value[row].length == cell) {
            row++;
            cell = 0;
        }
        return index;
    }
}
