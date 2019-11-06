package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int num = 2; num <= finish; num++) {
            if (num == 2) {
                count++;
            }
            boolean prime = true;
            for (int numfor = 2; numfor < num; numfor++) {
                if (num % numfor == 0) {
                    prime = false;}
            }
            if (prime == true && num!=2) {
                count++;
            }
            }
        return count;
    }
}
//            if ((num % num) == 0) {
//                if ((num % 2) == 0) {
//                    if (num==2){
//                        count++;
//                    }
//                } else for (;num <= finish;num++){
//                        count++;
//                        break;
//                    }
//                }
//            }