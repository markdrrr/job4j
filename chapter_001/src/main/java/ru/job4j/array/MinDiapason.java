package ru.job4j.array;

/**
 * 6.5.2. Поиск минимума в диапазоне.[#193187]
 * @author Andrey Markushin
 * @version 1.0
 * @since 09.11.2019
 */
public class MinDiapason {

    /**
     * Ищем минимум в массиве в диапазоне индексов
     * @param start индекс с которого начинаем поиск
     * @param finish индекс на котором заканчиваем поиск
     * @return возвращает минимальое значение из диапазона
     */
    public static int findMin(int[] array, int start, int finish) {
        int min = array[start];
        for (int index = start; index < finish; index++) {
            if (min > array[index]) {
                min = array[index];
            }
        }
        return min;
    }
}