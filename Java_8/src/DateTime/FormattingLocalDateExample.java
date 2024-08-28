package DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateExample {
    public static void parseLocalDate() {
        String date = "2024-11-12";
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("localDate: " + localDate);

        String date1 = "2024-11-12";
        LocalDate localDate1 = LocalDate.parse(date1, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate1: " + localDate1);

        String date2 = "20241112";
        LocalDate localDate2 = LocalDate.parse(date2, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDate2: " + localDate2);

        //Custom DateTimeFormatter

        String date3 = "2019|04|11";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate3 = LocalDate.parse(date3, dateTimeFormatter);
        System.out.println("Custom DateTimeFormatter: " + localDate3);

    }
    public static void formatLocalDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = localDate.format(dateTimeFormatter);
        System.out.println("FormatLocalDate: "+date);
    }

    public static void main(String[] args) {
        parseLocalDate();
        formatLocalDate();
    }
}
