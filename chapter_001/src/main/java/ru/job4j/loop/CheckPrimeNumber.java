package ru.job4j.loop;

public class CheckPrimeNumber<prime> {
    public boolean check(int finish) {
        boolean prime = true;
        if (finish < 2) {
            prime = false;
        }
        for (int num = 2; num < finish; num++) {
            if (finish % num == 0){
                prime = false;
            }
            }
        return prime;
    }
}