package ru.job4j.array;

/**
 * 6.2. Перевернуть массив.[#193182]
 * @author Andrey Markushin
 * @version 1.0
 * @since 08.11.2019
 */
public class Turn {

    /**
     * Метод возвращает массив задом наперёд, пройдя половину массива
     * @param array массив чисел
     * @return возвращает массив в обратном порядке
     */
    public int[] back(int[] array) {
        for (int index = 0; index != array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}