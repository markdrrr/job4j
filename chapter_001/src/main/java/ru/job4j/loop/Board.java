package ru.job4j.loop;

public class Board {
    private void paint(int width, int height) {
        for (int row = 0; row < height; row++) {
            for (int cell = 0; cell < width; cell++) {
                //печатаем X - width раз.
                if ((row + cell) % 2 == 0) {
                    System.out.print("X");
                } else System.out.print("  ");
            }
            // добавляем перевод на новую строку.
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.paint(3, 3);
        System.out.println();
        board.paint(5, 4);
    }
}