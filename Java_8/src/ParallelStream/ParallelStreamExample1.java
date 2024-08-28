package ParallelStream;

import data.Student;
import data.StudentDataBase;

import java.util.List;

public class ParallelStreamExample1 {
    public static List<String> parallelFlatMap() {
        long startTime = System.currentTimeMillis();
        List<String> studentlist =  StudentDataBase.getAllStudents().stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel: "+ (endTime-startTime));
        return studentlist;
    }
    public static List<String> seqFlatMap() {
        long startTime = System.currentTimeMillis();
        List<String> studentlist =  StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Seq: "+ (endTime-startTime));
        return studentlist;
    }

    public static void main(String[] args) {
        parallelFlatMap();
        seqFlatMap();
    }
}
