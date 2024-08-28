package streamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Comparator;


public class StreamComparator {
    public static List<Student> sortByName() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
    }

    public static List<Student> sortByGpa() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))//.reversed()
                .toList();
    }

    public static void main(String[] args) {
        System.out.println("By NAMES");
        sortByName().forEach(System.out::println);

        System.out.println("By GPA");
        sortByGpa().forEach(System.out::println);

    }
}
