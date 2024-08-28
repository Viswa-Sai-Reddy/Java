package StreamTerminalOperators;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Map;
import java.util.List;


import data.Student;
import data.StudentDataBase;

public class PartitionByExample {
    public static void main(String[] args) {
        Predicate<Student> getStudent = student -> student.getGpa() > 4;
        Map<Boolean,List<Student>>studentList = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(getStudent));
        System.out.println(studentList);
        
        Map<Boolean,Set<Student>> studentList1 = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.partitioningBy(getStudent,Collectors.toSet()));
        System.out.println(studentList1);
    }
}
