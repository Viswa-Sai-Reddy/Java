package Pratice;

import java.util.*;

public class FindHighest {

    public static void findHighest(List<Integer> list){
        System.out.println(" \n First Highest: "+list.stream().reduce(Integer.MIN_VALUE,Integer::max));
    }
    public static void findSecondHighest(List<Integer> list){
        System.out.println("Second Highest: "+list.stream().sorted(Comparator.reverseOrder()).skip(1).findAny().get());
    }
    public static void findThirdHighest(List<Integer> list){
        System.out.println("Third Highest: "+list.stream().sorted(Comparator.reverseOrder()).skip(2).findAny().get());
    }
    public static void findSecondLowest(List<Integer> list){
        System.out.println("Second Lowest: "+list.stream().sorted(Comparator.naturalOrder()).skip(1).findAny().get());
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(3, 6, 32, 1, 8, 5, 31, 22);
        array.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
        findHighest(array);
        findSecondHighest(array);
        findThirdHighest(array);
        findSecondLowest(array);
    }
}
