package Fundamentals;

import java.time.LocalDate;

public class Date {

    String currentTaxYear = "CurrentTaxYear";
    String nextTaxYear = "nextTaxYear";
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(LocalDate.now().getYear(), 3,1);
        LocalDate end = LocalDate.of(LocalDate.now().getYear(), 4,5);
        LocalDate present = LocalDate.of(LocalDate.now().getYear(), 4,4);


        if(isDateBetween(present,start,end))
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static boolean isDateBetween(LocalDate present, LocalDate start, LocalDate end) {
        return (present.isEqual(start) || present.isAfter(start)) && (present.isEqual(end) || present.isBefore(end));
    }

    private void selectMethods(String value){
        if(value.equalsIgnoreCase(currentTaxYear))
            System.out.println(currentTaxYear);
        else
            System.out.println(nextTaxYear);
    }
}
