package streamAPI;

import java.util.stream.*;
import java.util.function.*;
import java.util.Random;

public class StreamOfIterateGenerate {

    public static void main(String[] args) {
        Stream<String> integerStream = Stream.of("Viswa", "Sai", "Reddy");
        integerStream.forEach(System.out::println);

        Stream.iterate(1, x -> x * 2)
                .limit(10)
                .forEach(System.out::println);

        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(10)
                .forEach(System.out::println);
    }
}
