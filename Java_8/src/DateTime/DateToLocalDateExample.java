package DateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocalDateExample {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        LocalDate localDate = date.toInstant().atZone(ZoneId.of("Indian/Maldives")).toLocalDate();
        System.out.println("Date to LocalDate: "+localDate);

        Date date1 = new Date().from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDate to Date: "+date1);

        java.sql.Date date2 = java.sql.Date.valueOf(localDate);
        System.out.println("LocalDate to sql date: "+date2);

        LocalDate localDate1 = date2.toLocalDate();
        System.out.println("Sql Date to LocalDate: "+localDate1);
    }
}
