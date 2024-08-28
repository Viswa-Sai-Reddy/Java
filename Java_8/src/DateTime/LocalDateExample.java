package DateTime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Present Local Date: "+ localDate);

        LocalDate pastDate = LocalDate.of(2000,10,11);
        System.out.println("Past Date: "+pastDate);

        LocalDate dateByDayNo = LocalDate.ofYearDay(2000,346);
        System.out.println("Date at 346 day in year 2000: "+dateByDayNo);

        //Accessing particular value for the currentDate

        System.out.println("Year: "+localDate.getYear());
        System.out.println("Month: "+localDate.getMonth());
        System.out.println("Day: "+localDate.getDayOfMonth());
        System.out.println("Day: "+localDate.getDayOfWeek());
        System.out.println("Day of Year: "+localDate.getDayOfYear());

        System.out.println("Month: "+localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("Day: "+localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("Day of Year: "+localDate.get(ChronoField.DAY_OF_YEAR));

        // The change the date we can use with(temporal)

        System.out.println("Plus Date: "+localDate.plusDays(2));
        System.out.println("Change Date - with:"+localDate.with(ChronoField.YEAR,2025));
        System.out.println("Change date  - with -TemporalAdjusters: "+localDate.with( TemporalAdjusters.firstDayOfMonth()));

        System.out.println("Minus year: "+localDate.minus(2, ChronoUnit.YEARS));

        /** boolean Functionalities
         * date1.isEquals(date2)
         * date1.isAfter(date2)
         * date1.isBefore(date2)
         * date.isSupported()
         */

    }
}
