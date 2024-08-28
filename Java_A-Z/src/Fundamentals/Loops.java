package Fundamentals;

public class Loops {
    public static void main(String[] args) {
        double[] array = {12.5,13.5,14.5,15.5};
        System.out.println("For loop");
        for (int i = 0; i < array.length; i++) {
            System.out.println((int)array[i]);
        }
        System.out.println("While loop");
        int i=0;
        while (i<10){
            System.out.println(i);
            i++;
        }
        System.out.println("Do while loop");
        int j=0;
        do{
            System.out.println(j);
            j++;
        }while(j<10);
    }
}
