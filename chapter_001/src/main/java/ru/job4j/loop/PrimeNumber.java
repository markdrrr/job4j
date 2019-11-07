package ru.job4j.loop;

/**
 * 5.6. Простые числа.[#193167]
 * @author Andrey Markushin
 * @version 3.0
 * @since 08.11.2019
 */
public class PrimeNumber {

    /**
     * Считаем количество простых чисел до заданного числа
     * @param finish задаем число, до которого считаем
     * @return возвращаем количество подсчитанных простых чисел
     */
    public int calc(int finish) {
        int count = 0;
        for (int num = 2; num <= finish; num++) {
            if (num == 2) {
                count++;
            }
            CheckPrimeNumber chekNumber = new CheckPrimeNumber();
            boolean prime = chekNumber.check(num);
            if (prime == true && num!=2) {
                count++;
            }
        }
        return count;
    }
}