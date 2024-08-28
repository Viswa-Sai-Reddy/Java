package Pratice;
import java.util.List;
import java.util.Arrays;

public class StartsWithDigits {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Viswa","12Apple","Orange","4Grape","Dates2");
        //starts with digits
        stringList.stream().filter(str -> Character.isDigit( str.charAt(0))).forEach(System.out::println);
        //Ends with digits
        stringList.stream().filter(str -> Character.isDigit( str.charAt(str.length()-1))).forEach(System.out::println);
    }
}
