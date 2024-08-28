package functionalInterface;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class ConsumerAndPredicateExample {
    static List<Student> studentList = StudentDataBase.getAllStudents();

    static BiPredicate<Integer, Double> biPredicate = (grade, gpa) -> grade >= 3 && gpa >= 3.5;
    static BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    public static void printStudents(List<Student> studentList) {
        studentList.forEach(student -> {
            if (biPredicate.test(student.getGradeLevel(), student.getGpa()))
                    biConsumer.accept(student.getName(),student.getActivities());
        });
    }

    public static void main(String[] args) {
        printStudents(studentList);
    }

}
