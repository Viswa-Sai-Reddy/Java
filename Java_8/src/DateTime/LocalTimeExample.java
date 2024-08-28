package DateTime;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        System.out.println("Present Time: "+LocalTime.now());
        System.out.println("Present Time HH:MM: "+LocalTime.of(12,22));
        System.out.println("Present Time HH:MM:SS: "+LocalTime.of(12,22,33));
        System.out.println("Present Time HH:MM:SS: "+LocalTime.of(12,22,33,46727));

        System.out.println("GetHours: "+LocalTime.now().getHour());
        System.out.println("GetMinutes: "+LocalTime.now().getMinute());
        System.out.println("GetSeconds: "+LocalTime.now().getSecond());

    }
}
