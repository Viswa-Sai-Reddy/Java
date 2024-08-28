package Lambda;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {
        /*
          prior Java 8
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is runnable 1");
            }
        };
        new Thread(runnable).start();

        /*
            After Java 8
         */

        Runnable runnable1 = () -> System.out.println("This is runnable 2");
        new Thread(runnable1).start();

        Runnable runnable2 = () -> {
            System.out.println("This is runnable 3");
            System.out.println("This is runnable 4");
        };
        new Thread(runnable2).start();
        new Thread(() -> System.out.println("This is runnable 5")).start();

//---------------------------------------------------------------------------

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
                /*
                0 -> o1 == 02
                1 -> o1 > o2
                -1 -> o1 < o2
                 */
            }
        };
        System.out.println("The result of comparator: "+ comparator.compare(5,3));

        Comparator<Integer> comparator1 = (Integer a, Integer b) ->{return a.compareTo(b);};
        System.out.println("The result of comparator1: "+comparator1.compare(3,5));

        Comparator<Integer> comparator2 = (a,b) -> {return a.compareTo(b);};
        System.out.println("The result of comparator2: "+comparator2.compare(10,10));
    }
}
