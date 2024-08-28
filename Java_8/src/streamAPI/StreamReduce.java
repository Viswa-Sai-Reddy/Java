package streamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class StreamReduce {

    public static int getTotalNoteBooks(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGender().equalsIgnoreCase("male"))
                .map(Student::getNoteBooks)
                .reduce(0,Integer::sum);
    }
    public static int reduceWithIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> reduceWithoutIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a * b);
    }

    public static Optional<Student> getHighestGPA() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 3, 4, 5);
        System.out.println(reduceWithIdentity(integerList));

        List<Integer> integerList1 = new ArrayList<>();
        Optional<Integer> result = reduceWithoutIdentity(integerList1);
        result.ifPresent(System.out::println);
//        if(result.isPresent())
//            System.out.println(result.get());

        Optional<Student> student = getHighestGPA();
        student.ifPresent(System.out::println);

        System.out.println("Total NoteBooks: "+getTotalNoteBooks());
    }
}
