import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Welcome to my Java8 World!");

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        System.out.println("The result of comparator: "+ comparator.compare(10,20));
        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println("The result of Comparator1: "+comparator1.compare(20,10));
    }
}