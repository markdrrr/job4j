package ru.job4j.array;

/**
 * 6.1. Классический поиск перебором.[#193173]
 * @author Andrey Markushin
 * @version 1.0
 * @since 07.11.2019
 */
public class FindLoop {

    /**
     * Перебераем массив ищем схожее число
     * @param el число которое нужно найти в масиве
     * @return возвращает индекс массива в котором нашли число, либо возвращает -1
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0 ;index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}