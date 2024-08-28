package streamAPI;

import data.StudentDataBase;

public class StreamMatch {
    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() > 3.8);
    }

    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() >= 3.5);
    }

    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() > 4.0);
    }

    public static void main(String[] args) {
        System.out.println(anyMatch());
        System.out.println(allMatch());
        System.out.println(noneMatch());
    }

}
