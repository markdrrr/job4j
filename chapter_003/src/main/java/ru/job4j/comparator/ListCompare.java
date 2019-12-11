package ru.job4j.comparator;

import java.util.Comparator;

/**
 * 3. Компаратор для строк.[#193235]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 12.12.2019
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = left.length() - right.length();
        int length = Math.min(left.length(),right.length());
        int index = 0;
        while (index < length) {
            if (Character.compare(left.charAt(index), right.charAt(index)) != 0) {
                result = Character.compare(left.charAt(index), right.charAt(index));
                break;
            }
            index++;
        }
        return result;
    }
}