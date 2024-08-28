package FileReader;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFile {
    public static void main(String[] args) {
        String filePath = "src/resources/sqlQuires.sql";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.startsWith("--"))
                    stringBuilder.append(line).append(System.lineSeparator());
            }
            List<String> quiresList = Arrays.asList(stringBuilder.toString().split(System.lineSeparator()));
            quiresList.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(stringBuilder.toString());
    }
}
