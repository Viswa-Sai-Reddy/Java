package StreamTerminalOperators;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

import data.Student;
import data.StudentDataBase;

public class GroupByExample {
    public static void groupByGender(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGender));
        System.out.println(studentMap);
    }
    public static void groupByGpa(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >=3.5 ? "OutStanding":"Average"));
        System.out.println(studentMap);
    }
    public static void groupBy_1(){
       Map<Integer,Map<Double,List<Student>>> studentList =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,Collectors.groupingBy(Student::getGpa)));
        System.out.println(studentList);
    }
    public static void groupBy_2(){
        Map<String,Integer> studentList =  StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName,Collectors.summingInt(Student::getNoteBooks)));
        System.out.println(studentList);
    }
    public static void threeArgGroupingBy(){
       LinkedHashMap<String,Set<Student>> stringListLinkedHashMap = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new,Collectors.toSet()));
        System.out.println(stringListLinkedHashMap);
    }
    public static void groupingByMax(){
        Map<Integer,Optional<Student>> studentList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));
        System.out.println("With Optional "+studentList);
        Map<Integer,Student> studentList1 = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa))
                                ,Optional::get)));

        System.out.println("WithOut Optional "+studentList1);
    }

    public static void groupingByMin(){
        Map<Integer,Optional<Student>> studentList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.minBy(Comparator.comparing(Student::getGpa))));
        System.out.println("With Optional "+studentList);
        Map<Integer,Student> studentList1 = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa))
                                ,Optional::get)));

        System.out.println("WithOut Optional "+studentList1);
    }

    public static void main(String[] args) {
//        groupByGender();
//        groupByGpa();
//        groupBy_1();
//        groupBy_2();
//        threeArgGroupingBy();
        groupingByMax();
        groupingByMin();
    }
}
