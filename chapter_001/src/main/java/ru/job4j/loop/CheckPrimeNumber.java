package ru.job4j.loop;

public class CheckPrimeNumber<prime> {
    public boolean check(int finish) {
        boolean prime1 = false;
        for (int num = 0; num < 1; num++) {
            if ((finish % finish) == 0) {
                if ((finish % 2) == 0){
                    prime1 = false;
                    } else prime1 = true;
            }
            }
        return prime1;
    }
}