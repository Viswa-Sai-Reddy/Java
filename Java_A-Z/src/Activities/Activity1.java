package Activities;

public class Activity1 {
    public static void main(String[] args) {
        String word = "Sandra Burnside";
        int spaceIndex = word.indexOf(" ");
        String surName = word.substring(0,6);
        boolean evenLength = word.length() % 2 == 0 ? true : false;
        System.out.println("Space Index: "+spaceIndex);
        System.out.println("Surname: "+surName);
        System.out.println(evenLength);

        String mrng = "Morning";
        String night = "Night";
        String greetings = String.format("Tomorrow me have meet at %s and %s",mrng,night);
        System.out.println(greetings);
        String colors = "Red,Orange,Green,Black,Grey,Red,Yellow,White";
        String[] colorArray = colors.split(",");
        for (String ele : colorArray){
            System.out.println(ele);
        }
    }
}
