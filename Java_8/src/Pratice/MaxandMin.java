package Pratice;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MaxandMin {
    public static void findMax(int[] array) {
        System.out.println(Arrays.stream(array).reduce(Integer.MAX_VALUE, Integer::min));
    }
    public static void findMin(int[] array) {
        System.out.println(Arrays.stream(array).reduce(Integer.MIN_VALUE, Integer::max));
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 22, 11, 33, 55};
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        findMax(a);
        findMin(a);
    }
}
