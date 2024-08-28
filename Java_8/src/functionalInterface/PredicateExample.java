package functionalInterface;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    static Predicate<Integer> p = a -> a > 10;
    static Predicate<Integer> p1 = a -> a % 2 == 0;
    static Predicate<Integer> p2 = a -> a % 5 == 0;

    static List<Student> studentList = StudentDataBase.getAllStudents();
    static Predicate<Student> grade = grade -> grade.getGradeLevel() >= 3;
    static Predicate<Student> gpa = gpa -> gpa.getGpa() >= 3.5;

    public static void filterStudentGrade() {

        studentList.forEach(student -> {
            if (grade.test(student))
                System.out.println(student);
        });
    }

    public static void filterStudent() {
        System.out.println("Students Filters");
        studentList.forEach(student -> {
            if (grade.and(gpa).test(student))
                System.out.println(student);
        });
    }


    public static void getPredicateAnd() {
        System.out.println(p1.and(p2).test(10));
        System.out.println(p1.and(p2).negate().test(10));
    }

    public static void getPredicateOr() {
        System.out.println(p1.or(p2).test(10));
        System.out.println(p1.or(p2).negate().test(9));
    }


    public static void main(String[] args) {
        System.out.println(p.test(15));
        System.out.println(p.negate().test(15));

        getPredicateAnd();
        getPredicateOr();
        filterStudentGrade();
        filterStudent();
    }
}
