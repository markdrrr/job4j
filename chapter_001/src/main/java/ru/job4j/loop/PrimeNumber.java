package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int num = 2; num <= finish;num++) {
            if ((num % num) == 0) {
                if ((num % 2) == 0) {
                    if (num==2){
                        count++;
                    }
                } else for (;num <= finish;num++){
                        count++;
                        break;
                    }
                }
            }
        return count;
    }
}