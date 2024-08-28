package Pratice;
import java.util.*;
import java.util.stream.Collectors;

public class Flattering {
    public static void main(String[] args) {
        List<Integer> even = Arrays.asList(2,4,6,8,10);
        List<Integer> odd = Arrays.asList(1,3,5,7,9);
        List<List<Integer>> list = Arrays.asList(even,odd);
        System.out.println(list);
        List<Integer> flatList = list.stream().flatMap(lst -> lst.stream()).collect(Collectors.toList());
        System.out.println(flatList);
    }
}
