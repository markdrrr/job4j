package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 187);
        Book masterAndMargarita = new Book("The Master and Margarita", 506);
        Book threeComrades = new Book("Three comrades", 432);
        Book godfather = new Book("Godfather", 202);

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = masterAndMargarita;
        books[2] = threeComrades;
        books[3] = godfather;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(index + ". " +bk.getName() + " содержит " + bk.getPages() + " страниц");
        }

        System.out.println();
        System.out.println("Rearrange books with index 0 and 3");
        Book temp = new Book(null,0);
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(index +  ". " + bk.getName() + " содержит " + bk.getPages() + " страниц");
        }

        System.out.println();
        System.out.println("Shown only 'Clean code' ");
        for (int index = 0; index < books.length; index++) {
            String found = "Clean code";
            Book bk = books[index];
            if (bk.getName() == found) {
                System.out.println(index + ". " + bk.getName() + " содержит " + bk.getPages() + " страниц");
            }
        }
    }
}
