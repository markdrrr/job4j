package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 5. Преобразование матрицы чисел в список чисел.[#193128]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 30.12.2019
 */
public class Matrix {

    /**
     * Преобразовывает числовую матрицу в список.
     * @param matrix числовая матрица.
     * @return список.
     */
    public static List<Integer> toArray(Integer[][] matrix) {
        List<Integer> result = Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        Integer[][] numbers = new Integer[][]{{1, 2}, {3, 4}};
        System.out.println(toArray(numbers));
    }
}
