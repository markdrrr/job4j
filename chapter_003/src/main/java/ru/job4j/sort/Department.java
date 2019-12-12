package ru.job4j.sort;

import java.util.*;

/**
 * Отсортировать департаменты [#34352]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 12.12.2019
 */
public class Department {

    /**
     * Сортировка по возрастанию.
     * @param cods список кодов.
     * @return отсортированный список.
     */
    public static Set sort(ArrayList cods) {
        Set<String> sortedSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        sortedSet.addAll(cods);
        return sortedSet;
    }

    /**
     * Сортировка по убыванию с сохранением иерархической структуры.
     * @param cods список кодов.
     * @return отсортированный список.
     */
    public static Set sortReverse(ArrayList cods) {
        Set<String> sortedSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int min = Math.min(o1.length(), o2.length());
                int result = 0;
                for (int index = 0; index < min; index++) {
                    Character first = o1.charAt(index);
                    Character second = o2.charAt(index);
                    int compareChar = second.compareTo(first);
                    if (compareChar != 0) {
                        result = second - first;
                        return result;
                    }
                }
                result = o1.length() - o2.length();
                return result;
            }
        });
        sortedSet.addAll((cods));
        return sortedSet;
    }

    public static void main(String[] args) {
        ArrayList<String> cods = new ArrayList<>();
        cods.add("K1" + '\\' + "SK1");
        cods.add("K1" + '\\' + "SK2");
        cods.add("K1" + '\\' + "SK1" + '\\' + "SSK1");
        cods.add("K1" + '\\' + "SK1" + '\\' + "SSK2");
        cods.add("K2");
        cods.add("K2" + '\\' + "SK1" + '\\' + "SSK1");
        cods.add("K2" + '\\' + "SK1" + '\\' + "SSK2");
        cods.add("K1");

        System.out.println(cods);
        System.out.println(sort(cods));
        System.out.println(sortReverse(cods));
    }
}
