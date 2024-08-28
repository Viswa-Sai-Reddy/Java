package functionalInterface;


import java.util.function.*;
import java.util.*;

public class UnaryAndBinaryExample {
    static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = (a) -> a*a;
        System.out.println(unaryOperator.apply(10));

        BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;
        System.out.println(binaryOperator.apply(10,20));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println(maxBy.apply(10,5));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println(minBy.apply(10,5));
    }
}
