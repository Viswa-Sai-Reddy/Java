package NumericStream;

import java.util.*;
import java.util.stream.*;

public class IntStreams {
    public static int sumOfnNumbers(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (a, b) -> a + b);
    }

    public static int sumOfnNumbersIntStream() {
        return IntStream.rangeClosed(0, 6)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sumOfnNumbers(integerList));
        System.out.println(sumOfnNumbersIntStream());

        //-------------------------Max(),Min(),Sum(),Avg()

        OptionalInt optionalIntMax = IntStream.rangeClosed(1, 50).max();
        optionalIntMax.ifPresent(System.out::println);

        OptionalLong optionalIntMin = LongStream.rangeClosed(59, 100).min();
        optionalIntMin.ifPresent(System.out::println);

        IntStream.rangeClosed(1, 50).asDoubleStream().forEach(System.out::print);

        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 50).average();
        System.out.println();
        optionalDouble.ifPresent(System.out::println);
    }
}
