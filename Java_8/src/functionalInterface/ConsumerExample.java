package functionalInterface;

import data.Student;

import java.util.List;
import java.util.function.Consumer;

import static data.StudentDataBase.getAllStudents;

public class ConsumerExample {
    static List<Student> studentList = getAllStudents();

    public static void printAllStudents() {
        studentList.forEach(s -> System.out.println(s.toString()));
    }

    public static void printNameAndActivities() {
        System.out.println("printNameAndActivities");
        studentList.forEach(s -> System.out.println(s.getName() + " " + s.getActivities()));
    }

    public static void printNameAndActivitiesUnderConditions() {
        System.out.println("printNameAndActivitiesUnderConditions");
        studentList.forEach( student -> {
            if(student.getGradeLevel() >= 3)
                System.out.println(student.getName() +" "+student.getActivities());
        });
    }

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("java8");

        printAllStudents();
        printNameAndActivities();
        printNameAndActivitiesUnderConditions();


    }


}
