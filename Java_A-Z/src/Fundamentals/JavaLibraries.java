package Fundamentals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JavaLibraries {
    public static void main(String[] args) {
        Date date = new Date();

        GregorianCalendar calendar = new GregorianCalendar();

        GregorianCalendar dob = new GregorianCalendar(2000,11,11);
        System.out.println(dob.getTime());

        System.out.println(calendar.getTime());

        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) - 1);
        System.out.println(calendar.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDOB = sdf.format(dob.getTime());
        System.out.println(formattedDOB);

        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate myBirthday = LocalDate.of(2000,12,11);
        Period difference = Period.between(myBirthday,yesterday);
        System.out.println("Yesterday Date: "+yesterday);
        System.out.println("There are "+ difference.getYears()+" years and "+difference.getMonths()+" months and "+difference.getDays()+" day difference between "+ myBirthday +" and "+yesterday);


    }

}
