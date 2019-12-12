package ru.job4j.loop;

/**
 * 5.9. Крест в псевдографике. [#193170]
 * @author Andrey Markushin
 * @version 2.0
 * @since 06.11.2019
 */
public class Slash {

    /**
     * Рисует крест в консоле
     * @param size задает размер креста
     */
    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                boolean left = false;
                if (cell == row) {
                    left = true;
                }
                boolean right = false;
                if (cell == (size - 1) - row)  {
                    right = true;
                }
                if (left || right) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Draw by 3");
        draw(3);
        System.out.println("Draw by 5");
        draw(5);
    }
}