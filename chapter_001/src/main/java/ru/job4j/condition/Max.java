package ru.job4j.condition;

/**
 * Максимум из чисел
 * @author Andrey Markushin
 * @version 2.0
 * @since 19.11.2019
 */
public class Max {

    /**
     * Метод полцчения максимума из двух чисел
     *
     * @param first первое число
     * @param second второе число
     * @return максимум из чисел
     */
    public static int max(int first, int second) {
        boolean condition = first > second;
        int result = condition ? first : second;
        return result;
    }

    /**
     * Метод полцчения максимума из трех чисел
     *
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @return максимум из чисел
     */
    public static int max(int first, int second, int third) {
        int temp = max(first, second);
        boolean condition = temp > third;
        int result = condition ? temp : third;
        return result;
    }

    /**
     * Метод полцчения максимума из четырех чисел
     *
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @param fourth четвертое число
     * @return максимум из чисел
     */
    public static int max(int first, int second, int third, int fourth) {
        int temp = max(first, second, third);
        boolean condition = temp > fourth;
        int result = condition ? temp : fourth;
        return result;
    }
}
