package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void driv() {

    }

    @Override
    public void passengers(int pass) {

    }

    @Override
    public int prime(int fuel) {
        int price = fuel * 92;
        return price;
    }
}
