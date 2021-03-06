package ru.job4j.array;

/**
 * 6.5. Поиск индекса в диапазоне.[#193184]
 * @author Andrey Markushin
 * @version 2.0
 * @since 07.11.2019
 */
public class FindLoop {

    /**
     * Перебераем массив ищем схожее число
     * @param el число которое нужно найти в масиве
     * @return возвращает индекс массива в котором нашли число, либо возвращает -1
     */
    public static int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Перебераем массив ищем схожее число
     * @param el число которое нужно найти в масиве
     * @param start индекс с которого начинаем поиск
     * @param finish индекс на котором заканчиваем поиск
     * @return возвращает индекс массива в котором нашли число, либо возвращает -1
     */
    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int index = start; index != finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Сортируем данные в массиве
     * @param data массив чисел
     * @return возвращает массив в отсортированном виде
     */
    public static int[] sort(int[] data) {
        for (int i = 0; i != data.length; i++) {
            int min = MinDiapason.findMin(data, i, data.length);
            int index = FindLoop.indexOf(data, min, i, data.length);
            int temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }
        return data;
    }


}