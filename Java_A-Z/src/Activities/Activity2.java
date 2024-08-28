package Activities;

import org.w3c.dom.ls.LSOutput;

public class Activity2 {
    public static void main(String[] args) {
        System.out.println("The bigger number: "+ wholsOlder(5,10));
        boolean stmt = longerThan5("Viswa Sai");
        if (stmt == true) {
            System.out.println(true);
        } else {
            System.out.println("String length is less than 6");
        }
    }
    public static int wholsOlder(int num1, int num2){
        if(num1>num2)
            return num1;
        return num2;
    }
    public static boolean longerThan5(String str){
            return str.length() >= 6;
    }
}
