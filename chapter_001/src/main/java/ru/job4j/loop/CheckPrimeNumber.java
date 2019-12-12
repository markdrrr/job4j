package ru.job4j.loop;

public class CheckPrimeNumber<prime> {
    public boolean check(int finish) {
        boolean primeNew = true;
        if (finish < 2) {
            primeNew = false;
        }
        for (int num = 2; num < finish; num++) {
            if (finish % num == 0) {
                primeNew = false;
                break;
            }
        }
        return primeNew;
    }
}