package ru.job4j.array;

/**
 * 6.4. Слово начинается с ...[#193175]
 * @author Andrey Markushin
 * @version 1.0
 * @since 08.11.2019
 */
public class ArrayChar {

    /**
     * Метод принимает два массива и сравнивает часть слова с полным словом на соответсвие
     * @param word принимает полное слово
     * @param pref принимает часть слова для проверки
     * @return возвращает результат верно либо нет
     */
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int index = 0;  index != pref.length; index++) {
            if (pref[index] != word[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}