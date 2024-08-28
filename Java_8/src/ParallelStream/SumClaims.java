package ParallelStream;

import java.util.stream.IntStream;

public class SumClaims {
    public static void main(String[] args) {
        Sum sum = new Sum();
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::addups);
        System.out.println(sum.getTotal());

        //don't use parallel while mutable variables
    }
}
