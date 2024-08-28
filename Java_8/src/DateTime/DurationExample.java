package DateTime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(5,50);
        LocalTime localTime1 = LocalTime.of(10,30);

        long diffHours = localTime.until(localTime1, ChronoUnit.HOURS);
        System.out.println(diffHours);

        Duration duration = Duration.between(localTime,localTime1);
        System.out.println("Hours: "+duration.toHours());
        System.out.println("Minutes: "+duration.toMinutes());

        Duration duration1 = Duration.ofHours(5);
        System.out.println(duration1.toHours());
    }
}
