package streamAPI;

import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDataBase;

public class StreamAPIExample {
    public static void main(String[] args) {
        Predicate<Student> grade = s -> s.getGradeLevel() >= 3;
        Predicate<Student> gpa = s -> s.getGpa() >= 3.9;

        Map<String, List<String>> studentList = StudentDataBase.getAllStudents().stream()
                .filter(grade)
                //.filter(gpa)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studentList);
    }
}
