package ru.job4j.animals;

public class Tiger extends Predator {
    public Tiger(String name) {
        super("Predator");
        this.name = name;
        System.out.println(name);
    }
}
