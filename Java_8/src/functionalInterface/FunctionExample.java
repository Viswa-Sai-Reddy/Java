package functionalInterface;

import data.Student;
import data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> upperCase = name -> name.toUpperCase();

    static Function<String, String> addSubString = string -> string.concat(" Is a Good Boy");

    static Function<List<Student>,Map<String,Double>>  studentGpa = (studentList -> {
        Map<String,Double> studentGpaMap = new HashMap<>();
        studentList.forEach(student -> {
            if(PredicateExample.grade.test(student))
                studentGpaMap.put(student.getName(),student.getGpa());
        });
        return studentGpaMap;

    });

    public static void main(String[] args) {
        System.out.println(upperCase.apply("Viswa"));
        System.out.println(upperCase.andThen(addSubString).apply("viswa"));
        System.out.println(upperCase.compose(addSubString).apply("viswa"));

        System.out.println(studentGpa.apply(StudentDataBase.getAllStudents()));
    }
}
