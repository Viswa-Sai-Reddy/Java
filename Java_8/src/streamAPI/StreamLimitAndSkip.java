package streamAPI;

import java.util.*;

public class StreamLimitAndSkip {
    public static Optional<Integer> limit(List<Integer> integerList) {
        return integerList.stream()
                .limit(3)
                .reduce(Integer::sum);
    }

    public static Optional<Integer> skip(List<Integer> integerList) {
        return integerList.stream()
                .skip(3)
                .reduce(Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        limit(integerList).ifPresent(System.out::println);
        skip(integerList).ifPresent(System.out::println);
    }

}
