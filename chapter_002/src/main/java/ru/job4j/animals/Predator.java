package ru.job4j.animals;

public class Predator extends Animal {
    public Predator(String name) {
        super("Animal");
        this.name = name;
        System.out.println(name);
    }
}
