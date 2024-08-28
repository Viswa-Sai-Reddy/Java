package NumericStream;

import java.util.*;
import java.util.stream.*;

public class BoxingUnBoxing {
    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

    }

    public static int unBoxing(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(boxing());
        System.out.println(unBoxing(boxing()));
    }
}
