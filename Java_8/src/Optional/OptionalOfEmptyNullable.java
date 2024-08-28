package Optional;

import java.util.Optional;

public class OptionalOfEmptyNullable {
    public static Optional<String> nullAble() {
        return Optional.ofNullable(null);
    }
    public static Optional<String> of() {
        return Optional.of("Viswa");
    }
    public static Optional<String> empty() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("Null Able: "+nullAble());
        System.out.println("Of:"+of());
        System.out.println("Empty:"+empty());
    }
}
