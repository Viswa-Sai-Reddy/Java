package streamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.List;

public class StreamFilter {
    public static List<Student> filterStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equalsIgnoreCase("Male"))
                .toList();
    }

    public static void main(String[] args) {
        filterStudent().forEach(System.out::println);
    }
}
