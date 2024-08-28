package Fundamentals;

public class MemoryManagement {
    public static void main(String[] args) {
        String allNumbers = "";

        for (int i=1;i<11;i++)
            allNumbers += " "+ i;

        System.out.println(allNumbers);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 11; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder.toString());

    }

}
