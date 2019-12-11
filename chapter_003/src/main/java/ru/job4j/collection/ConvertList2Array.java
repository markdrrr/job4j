package ru.job4j.collection;

import java.util.List;

/**
 * 3. Конвертация ArrayList в двухмерный массив[#193247]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 11.12.2019
 */
public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (array[row][cell] == 0) {
                array[row][cell] = num;
            } else if (array[row][cell] !=0 && cell < cells - 1) {
                cell++;
                array[row][cell] = num;
            }
            if (cell == cells - 1) {
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
    }
}