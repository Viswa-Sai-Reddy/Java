package Pratice;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import  java.util.function.*;
import java.util.stream.Collectors;

public class OddEven {
    static List<Integer> integerList = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);


    public static void main(String[] args) {
       List<Integer> evenList = integerList.stream()
               .filter(t -> (t % 2) == 0 )
               .toList();
        List<Integer> oddList = integerList.stream()
                .filter(t -> (t % 2) != 0 )
                .toList();
        System.out.println(evenList);
        System.out.println(oddList);

        Map<Boolean,List<Integer>> getEvenOdd = integerList.stream().collect(Collectors.partitioningBy(t -> t % 2 == 0));

        System.out.println("Even: "+getEvenOdd.get(true));
        System.out.println("Even: "+getEvenOdd.get(false));
    }
}
