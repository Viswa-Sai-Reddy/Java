package Optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {
    //  orElse
    public static String orElse() {
//        Optional<Student>  optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optional = Optional.ofNullable(null);
        return optional.map(Student::getName).orElse("Default");
    }

    //  OrElseGet
    public static String orElseGet() {
        Optional<Student> optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        return optional.map(Student::getName).orElseGet(() -> "Default");
    }

    //  OrElseThrow
    public static String orElseThrow() {
//        Optional<Student> optional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> optional = Optional.ofNullable(null);
        return optional.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data"));
    }

    public static void main(String[] args) {
        System.out.println("orElse: " + orElse());
        System.out.println("orElseGet: " + orElseGet());
        System.out.println("orElseThrow: " + orElseThrow());
    }
}
