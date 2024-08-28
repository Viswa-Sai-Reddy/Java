package functionalInterface;

import data.Student;
import data.StudentDataBase;

import java.util.function.*;
import java.util.*;

public class BiFunctionExample {
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (studentList, studentPredicate) -> {
        Map<String, Double> studentMap = new HashMap<>();
        studentList.forEach(student -> {
            if (studentPredicate.test(student))
                studentMap.put(student.getName(), student.getGpa());
        });
        return studentMap;
    };

    public static void main(String[] args) {
        System.out.println(biFunction.apply(StudentDataBase.getAllStudents(), PredicateExample.grade));
    }

}
