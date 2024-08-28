package Optional;

import data.Bike;
import data.Student;
import data.StudentDataBase;
import java.util.Optional;

public class OptionalFilterMapExample {
    //filter
    public static void optionalFilter(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        studentOptional.filter(student -> student.getGpa()>=4.5)
                .ifPresent(System.out::println);
    }
    //Map
    public static void optionalMap(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<String> name = studentOptional.filter(student -> student.getGpa()>3.5)
                .map(Student::getName);
        System.out.println(name);
    }
    //FlatMap
    public static void optionalFlatMap(){
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<String> name = studentOptional
                .filter(student -> student.getGpa()>=3.3)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        name.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }
}
