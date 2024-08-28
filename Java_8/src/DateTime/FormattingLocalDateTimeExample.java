package DateTime;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeExample {
    public static void parseLocalDateTime() {
        String dateTime = "2024-11-23T14:45";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        System.out.println("localDateTime :"+localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("localDateTime1 :"+localDateTime1);

        //Custom LocalDateTime Formatter
        String dateTime1 = "2024-11-23T14:45";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime1,dateTimeFormatter);
        System.out.println("localDateTime2 :"+ localDateTime2);

        String dateTime2 = "2024-11-23adc14:45:35";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'adc'HH:mm:ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTime2,dateTimeFormatter1);
        System.out.println("localDateTime3 :"+ localDateTime3);
    }
    public static void formatLocalDateTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'*ADC*'HH-mm-ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String convertedDateTime = localDateTime.format(dateTimeFormatter);
        System.out.println("convertedDateTime: "+ convertedDateTime);
    }

    public static void main(String[] args) {
        parseLocalDateTime();
        formatLocalDateTime();
    }
}
