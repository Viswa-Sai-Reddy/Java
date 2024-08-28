package Default;
import java.util.*;

public class MultiplierClient {
    public static void main(String[] args) {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> intergerList = Arrays.asList(1,2,3,4);//new ArrayList<Integer>();
        System.out.println("Multiplication:"+multiplier.multiply(intergerList));
        System.out.println("Size of array:"+ multiplier.size(intergerList));
        System.out.println("Is Empty static method: "+Multiplier.isEmpty(intergerList));
    }
}
