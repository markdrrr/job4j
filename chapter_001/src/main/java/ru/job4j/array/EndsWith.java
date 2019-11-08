package ru.job4j.array;

/**
 * 6.4.1. Слово заканчивается с ...[#193183]
 * @author Andrey Markushin
 * @version 1.0
 * @since 08.11.2019
 */
public class EndsWith {

    /**
     * Метод принимает два массива и сравнивает часть слова с полным словом на соответсвие
     * @param word принимает полное слово
     * @param post принимает последнию часть слова для проверки
     * @return возвращает результат верно либо нет
     */
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        for (int index = 0 ;index != post.length; index++) {
            if (post[post.length - index - 1] == word[word.length - index - 1]){
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}