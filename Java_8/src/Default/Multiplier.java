package Default;

import java.util.*;

public interface Multiplier {
    int multiply(List<Integer> integerList);

    default int size(List<Integer> integerList) {
        return integerList.size();
    }

    static boolean isEmpty(List<Integer> integerList) {
        return integerList.isEmpty();
    }
}
