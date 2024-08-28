package DateTime;

import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeExample {
    public static void parseTime(){
        String time = "14:00";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println("localTime: "+localTime);

        LocalTime localTime1 = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("localTime1: "+localTime1);

        //Custom Time Formatter

        String date1 = "14-00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH-mm");
        LocalTime localTime2 = LocalTime.parse(date1,dateTimeFormatter);
        System.out.println("localTime2: "+localTime2);

        String date2 = "14/00/25";
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH/mm/ss");
        LocalTime localTime3 = LocalTime.parse(date2,dateTimeFormatter1);
        System.out.println("localTime3: "+localTime3);
    }
    public static void formatTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH/mm/ss");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        String time = localTime.format(dateTimeFormatter);
        System.out.println("FormatTime: "+time);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH/mm/ss/nn");
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);
        String time1 = localTime.format(dateTimeFormatter1);
        System.out.println("FormatTime: "+time1);
    }

    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}
