package Pratice;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Arrays;
public class Distinct {
    static List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

    static List<String> uniqueList = listOfStrings.stream().distinct().toList();

    public static void main(String[] args) {
        System.out.println(uniqueList);
    }

}
