package MethodExpression;

import data.Student;
import data.StudentDataBase;

import java.util.*;
import java.util.function.*;

public class MEExample {
    static Function<Integer, Double> reverse = Integer::doubleValue;
    static List<Student> studentList = StudentDataBase.getAllStudents();


//    static Predicate<Student> grade = s -> s.getGradeLevel() > 3;

    static Predicate<Student> grade = MEExample::gradeLevel;

    public static boolean gradeLevel(Student s) {
        return s.getGradeLevel() > 3;
    }


    public static void main(String[] args) {
        System.out.println(reverse.apply(123));
        System.out.println(grade.test(studentList.get(1)));
    }
}
