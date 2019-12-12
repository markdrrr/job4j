package ru.job4j.array;

/**
 * 6.6. Двухмерный массив. Таблица умножения.[#193174]
 * @author Andrey Markushin
 * @version 1.0
 * @since 09.11.2019
 */
public class Matrix {

    /**
     * Создает таблицу умножения с помощью вложенных массивов
     * @param size задаёт размер таблицы
     * @return возвращает построенную таблицу
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int x = 0; x != table.length; x++) {
            for (int y = 0; y != table.length; y++) {
                table[x][y] = (y + 1) * (x + 1);
            }
        }
        return table;
    }
}