package Fundamentals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class FileManagement {

    public static void getFolderFiles(File folder) throws IOException {
        File[] files = folder.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            } else {
                System.out.println(f.getCanonicalPath());
                getFolderFiles(f);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String homeFolder = System.getProperty("user.home");
        String separator = File.separator;
        String lineSeparator = System.getProperty("line.separator");
        File currentFolder = new File(homeFolder);
        File newFile = new File(currentFolder + separator + "example.txt");
        System.out.println(newFile.getCanonicalPath());
        System.out.println(newFile.isDirectory() + " " + newFile.isFile() + " " + newFile.exists());

//       getFolderFiles(currentFolder);
        //System.out.println(newFile.delete());

        try (FileWriter fileWriter = new FileWriter(newFile);
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            bw.write("This is a First Line" + lineSeparator);
            bw.write("This is a Second Line" + lineSeparator);
        }

//        try(FileReader fr = new FileReader(newFile);
//        BufferedReader br = new BufferedReader(fr)){
//            List<String> myLines = br.lines().filter(line -> line.contains("First")).toList();
//            for(String s : myLines)
//                System.out.println(s);
//
//        }


// Path is same as File in java.io [Path is in Java.nio]
        Path currentPath = Paths.get(homeFolder);
        Path report = Paths.get(homeFolder + separator + "reports.txt");
        Files.writeString(report,"This a report 1" + lineSeparator);
        Files.writeString(report,"This a report 2"+lineSeparator, StandardOpenOption.APPEND);

        List<String> names = List.of("Viswa","Sai","reddy");
        Files.write(report,names,StandardOpenOption.APPEND);

        List<String> allLines = Files.readAllLines(report);
        System.out.println(allLines);

        System.out.println("---------------------------");
        Scanner s = new Scanner(report);
        while(s.hasNextLine())
            System.out.println(s.nextLine());

    }
}
