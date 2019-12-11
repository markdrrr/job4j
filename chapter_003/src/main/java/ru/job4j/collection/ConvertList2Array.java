package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Конвертация листа массивов в один лист Integer[#193250]
 *
 * @author Andrey Markushin
 * @version 1.1
 * @since 11.12.2019
 */
public class ConvertList2Array {

    /**
     * Метод проходит по всем элементам всех массивов в списке list и добавить их в один общий лист <Integer>.
     *
     * @param list список массивов.
     * @return возвращает один общий лист <Integer>.
     */
    public static List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) {
            for (int value : arr) {
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Метод преобразует одномерный список в двух мерный массив.
     *
     * @param list список.
     * @param cells количество элементов в создаваемом массиве.
     * @return возвращает двух мерный массив.
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
                if (cell < cells) {
                array[row][cell] = num;
                    cell++;
            }
            if (cell == cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        List<int[]> list2 = new ArrayList<>();
        list2.add(new int[]{1, 2});
        list2.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convert(list2);
        System.out.println(result);

    }
}