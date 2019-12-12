package ru.job4j.condition;
@SuppressWarnings("WeakerAccess")

    public class MultiMax {
        public int max(int first, int second, int third) {
            boolean condition = first > second;
            int max1 = condition ? first : second;
            return max1 > third ? max1 : third;
        }
}
