package ru.job4j.animals;

/**
 * 2. Перегрузка конструктора.[#193314]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 25.11.2019
 */
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        Animal animal = new Animal("Animal");
        Predator predator = new Predator("Predator");
        Tiger tiger = new Tiger("Tiger");
    }
}
