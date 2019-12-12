package ru.job4j.array;

/**
 * 6.3. Массив заполнен true или false[#193176]
 * @author Andrey Markushin
 * @version 1.0
 * @since 08.11.2019
 */
public class Check {

    /**
     * Проверки всех элементов с эталонным
     * @param data принимает массив
     * @return Проверяет весь массив с эталонным под индексом 0 и возвращает результат верно либо нет
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index != data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}