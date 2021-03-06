package ru.job4j.array;
import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                rsl[l + r] = left[l];
                l++;
            } else {
                rsl[l + r] = right[r];
                r++;
            }
        }
        if (l >= left.length) {
            while (r < right.length) {
                rsl[l + r] = right[r];
                r++;
            }
        } else if (r >= right.length) {
            while (l < left.length) {
                rsl[l + r] = left[l];
                l++;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}


