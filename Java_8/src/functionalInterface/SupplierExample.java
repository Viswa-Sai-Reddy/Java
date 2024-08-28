package functionalInterface;
import data.Student;
import data.StudentDataBase;

import java.util.List;

import java.util.function.Supplier;
public class SupplierExample {
    static Supplier<List<Student>> listSupplier =() -> StudentDataBase.getAllStudents();

    public static void main(String[] args) {
        listSupplier.get().stream().forEach(student -> System.out.println(student));
    }

}
