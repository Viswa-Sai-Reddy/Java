package Optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {
    public static String studentName() {
        Student student = StudentDataBase.studentSupplier.get();
        if (student != null)
            return student.getName();
        else
            return null;
    }

    public static Optional<String> studentNameOptional() {
//        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);
//        Optional<Student> studentOptional1 = Optional.;
        if (studentOptional.isPresent()) {
            studentOptional.get();// to get whole student object
            return studentOptional.map(Student::getName);
        } else
            return Optional.empty();
    }

    public static void main(String[] args) {
//        String name = studentName();
//        System.out.println(name.length());
        Optional<String> optional = studentNameOptional();
        if (optional.isPresent())
            System.out.println("Length:" + optional.get().length());
        else
            System.out.println(Optional.empty());
    }
}
