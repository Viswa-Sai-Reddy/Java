package DateTime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2024,1,1);
        LocalDate localDate1 = LocalDate.of(2024,12,31);

        Period period = localDate.until(localDate1);
        System.out.println("getDays: "+period.getDays());//31-1
        System.out.println("getMonths: "+period.getMonths());//12-1
        System.out.println("getYears: "+period.getYears());//2024-2024

        Period period1 = Period.ofDays(10);
        System.out.println("ofDays: "+period1.getDays());
        Period period2 = Period.ofYears(13);
        System.out.println("ofYears: "+period2.getYears());
        System.out.println("ofMonths: "+period2.toTotalMonths());

        Period period3 = Period.between(localDate,localDate1);
        System.out.println("Years: "+period3.getYears()+" Months: "+period3.getMonths()+" Days: "+period3.getDays());
    }
}
