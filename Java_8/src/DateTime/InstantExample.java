package DateTime;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        //Jan -01-1970 = ofEpochSecond(0)
        System.out.println(Instant.ofEpochSecond(0));
        Instant instant1 = Instant.now();

        Duration duration = Duration.between(instant, instant1);
        System.out.println("Diff: " + duration.toSeconds());
    }
}

