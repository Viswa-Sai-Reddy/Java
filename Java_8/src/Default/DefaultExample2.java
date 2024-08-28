package Default;

import data.Student;
import data.StudentDataBase;

import java.util.function.*;
import java.util.*;

public class DefaultExample2 {
    public static Consumer<Student> studentConsumer = (System.out::println);
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);
    static  Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);

    public static void chainComparator(List<Student> studentList) {
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        System.out.println("After chain comparator");
        studentList.forEach(System.out::println);
    }

    public static void sortByName(List<Student> studentList) {
        studentList.sort(nameComparator);
        System.out.println("After SortByName: ");
        studentList.forEach(studentConsumer);
    }

    public static void sortByGpa(List<Student> studentList) {
        studentList.sort(gpaComparator);
        System.out.println("After SortByGpa: ");
        studentList.forEach(studentConsumer);
    }

    public static void sortWithNullValues(List<Student> studentList) {
//       Comparator<Student> studentComparator = Comparator.nullsFirst(nameComparator);
        Comparator<Student> studentComparator = Comparator.nullsLast(nameComparator);
        studentList.sort(studentComparator);
        System.out.println("After Null Values Comparator: ");
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println(studentList);
        System.out.println("Before Sort: ");
        studentList.forEach(studentConsumer);
//        sortByName(studentList);
//        sortByGpa(studentList);
//        chainComparator(studentList);
        sortWithNullValues(studentList);
    }
}
