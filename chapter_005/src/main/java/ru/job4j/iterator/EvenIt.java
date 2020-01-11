package ru.job4j.iterator;

import java.util.Iterator;

/**
 * 5.1.2. Создать итератор четные числа[#223102]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 12.01.2020
 */
public class EvenIt implements Iterator {
    final int[] numbers;
    static int index = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Метод проверки окончания четных чисел.
     * @return - true, если есть еще следующие четные числа, иначе false.
     */
    @Override
    public boolean hasNext() {
        while (numbers.length > index) {
            if (numbers[index] % 2 == 0) {
                return true;
            } else {
                index++;
            }
        }
        return false;
    }

    /**
     * Возвращает элемент из матрицы и переключает маркер на следующий элемент.
     * @return - возвращает следующее четное число.
     */
    @Override
    public Object next() {
        while (numbers[index] % 2 != 0) {
            index++;
        }
        return numbers[index++];
    }
}
