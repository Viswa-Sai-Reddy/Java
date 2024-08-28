package DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + localDateTime);
        System.out.println("localDateTime1: "+LocalDateTime.of(2019,4,11,15,45,50,84583487));
        System.out.println("LocalDateTime2: "+LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        System.out.println("GetYear: "+LocalDateTime.now().getYear());
        System.out.println("GetMonth: "+LocalDateTime.now().getMonth());
        System.out.println("GetDayOfMonth: "+LocalDateTime.now().getDayOfMonth());
        System.out.println("GetDayOfWeek: "+LocalDateTime.now().getDayOfWeek());
        System.out.println("GetDayOdYear: "+LocalDateTime.now().getDayOfYear());
        System.out.println("GetHour: "+LocalDateTime.now().getHour());
        System.out.println("GetMinute: "+LocalDateTime.now().getMinute());
        System.out.println("GetSeconds: "+LocalDateTime.now().getSecond());
        System.out.println("GetNanoSeconds: "+LocalDateTime.now().getNano());

        System.out.println("Get Hours - with: "+LocalDateTime.now().withHour(3));

        //Converting LocalDate, LocalTime into LocalDateTime
        LocalDate localDate = LocalDate.of(2022,12,11);
        System.out.println("atTime: "+localDate.atTime(12,24,50));

        LocalTime localTime= LocalTime.of(12,50,50);
        System.out.println("atDate: "+localTime.atDate(localDate));

        LocalDateTime localDateTime1 = localDate.atTime(localTime);
        System.out.println("toLocalDate: "+localDateTime1.toLocalDate());
        System.out.println("toLocalTime: "+localDateTime1.toLocalTime());
    }
}
