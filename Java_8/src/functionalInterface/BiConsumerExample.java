package functionalInterface;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    static List<Student> studentList = StudentDataBase.getAllStudents();
    public static void nameAndActivity(){
        BiConsumer<String,List<String>> biConsumer = (name,activity) -> System.out.println(name +":"+activity);
        studentList.forEach(student -> biConsumer.accept(student.getName(),student.getActivities()));
    }

    public static void main(String[] args) {
        BiConsumer<String,String> biConsumer = (a,b) -> {
            System.out.println(a+" "+b);
        };

        BiConsumer<Integer,Integer> multiply = (a,b) -> System.out.println("The Multiplication is: "+a*b);
        BiConsumer<Integer,Integer> division = (a,b) -> System.out.println("THe Division is: "+a/b);

        biConsumer.accept("Java7","Java8");
        multiply.andThen(division).accept(10,5);

        nameAndActivity();
    }
}
