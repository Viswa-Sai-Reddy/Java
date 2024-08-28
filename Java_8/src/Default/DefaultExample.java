package Default;

import java.util.List;
import java.util.*;

public class DefaultExample {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Ben","Rich","Eric","Bob","Ryan","Coby");

//        Collections.sort(namesList);
//        System.out.println("Prior Java 8: "+namesList);

        namesList.sort(Comparator.naturalOrder());
        System.out.println("After Java 8 - Ascn:"+namesList);
        namesList.sort(Comparator.reverseOrder());
        System.out.println("After Java 8 - Decn:"+namesList);
    }
}
