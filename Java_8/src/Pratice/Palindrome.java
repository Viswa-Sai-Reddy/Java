package Pratice;

import java.util.stream.IntStream;

public class Palindrome {
    public static boolean isPalindrome(int num){
        String value = String.valueOf(num);
        int len = value.length();
        return IntStream.range(0,(len/2))
                .anyMatch(index -> value.charAt(index) == value.charAt(len - index - 1));
    }
    public static boolean isPalindrome(String value){
        int len = value.length();
        return IntStream.range(0,(len/2))
                .anyMatch(index -> value.charAt(index) == value.charAt(len - index - 1));
    }

    public static void main(String[] args) {
        System.out.println("Is Palindrome: "+isPalindrome(123217));
    }
}
