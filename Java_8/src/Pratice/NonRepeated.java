package Pratice;
import java.util.*;
import java.util.stream.*;

public class NonRepeated {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,434,4,6,546,5,5,657,6,7,56546,54,43,4,34,435,34,45,654,65,23);
        List<Integer> nonRepeated = list.stream()
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        nonRepeated.stream().forEach(System.out::println);
    }
}

