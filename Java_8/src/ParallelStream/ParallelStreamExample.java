package ParallelStream;


import java.util.function.Supplier;

import java.util.stream.IntStream;


public class ParallelStreamExample {

    public static long performanceTest(Supplier<Integer> supplier, int numberOfTimes) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++)
            supplier.get();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static int sumSequentialStream() {
        return IntStream.rangeClosed(0, 1000000000).sum();
    }

    public static int sumParallelStream() {
        return IntStream.rangeClosed(0, 1000000000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Parallel Stream: "+performanceTest(ParallelStreamExample::sumParallelStream,20));
        System.out.println("Sequential Stream: "+performanceTest(ParallelStreamExample::sumSequentialStream,20));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
