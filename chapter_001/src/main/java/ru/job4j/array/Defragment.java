package ru.job4j.array;

/**
 * 6.8. Дефрагментация массива.[#193179]
 * @author Andrey Markushin
 * @version 1.0
 * @since 11.11.2019
 */
public class Defragment {

    /**
     * Перемещает заполненные ячейки массива в начало, а пустые в конец
     * @param array принимает массив
     * @return возвращает массива в отсортированном виде
     */
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            int i = 0;
            if (cell == null) {
                while (array[index] == null && index+i < array.length) {
                    String temp = array[index+i];
                    array[index+i] = array[index];
                    array[index]=temp;
                    i++;
                }
            }
            System.out.print(array[index] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}