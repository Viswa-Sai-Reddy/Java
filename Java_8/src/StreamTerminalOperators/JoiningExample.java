package StreamTerminalOperators;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

public class JoiningExample {
    public static String join_1(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName).collect(Collectors.joining());
    }
    public static String join_2(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName).collect(Collectors.joining(", "));
    }
    public static String join_3(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName).collect(Collectors.joining("-","{","}"));
    }

    public static void main(String[] args) {
        System.out.println("Join-1 : "+join_1());

        System.out.println("Join-2 : "+join_2());

        System.out.println("Join-3 : "+join_3());
    }
}
