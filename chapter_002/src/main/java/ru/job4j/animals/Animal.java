package ru.job4j.animals;

/**
 * 1. Конструктор по умолчанию. [#193313]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 25.11.2019
 */
public class Animal {
    public Animal() {
        System.out.println("Animal");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Predator predator = new Predator();
        Tiger tiger = new Tiger();
    }
}
