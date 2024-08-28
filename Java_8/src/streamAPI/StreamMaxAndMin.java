package streamAPI;

import java.util.*;

public class StreamMaxAndMin {
    public static Optional<Integer> getMaxValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a > b ? a : b);
        //.reduce(Integer::max);
    }

    public static Optional<Integer> getMinValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a < b ? a : b);
        //.reduce(Integer::min);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(5, 76, 36, 786, 5477, 88657, 89965, 3435);
        getMaxValue(integerList).ifPresent(System.out::println);
        getMinValue(integerList).ifPresent(System.out::println);
    }
}
