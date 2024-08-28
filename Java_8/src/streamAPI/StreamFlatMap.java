package streamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMap {
    public static List<String> flatMap() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .toList();
    }
    public static Set<String> flatSet() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toSet());

    }

    public static void main(String[] args) {
        System.out.println(flatMap());
        System.out.println(flatSet());
    }
}
