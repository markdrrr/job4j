package ru.job4j.condition;
@SuppressWarnings("WeakerAccess")

    public class MultiMax {
        public int max(int first, int second, int third) {
            boolean condition1 = first > second;
            int max1 = condition1 ? first : second;
            boolean condition2 = max1 > third;
            return condition2 ? max1 : third;
        }
}
