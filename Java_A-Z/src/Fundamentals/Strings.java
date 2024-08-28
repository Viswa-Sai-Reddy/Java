package Fundamentals;

import Activities.NameManager;

public class Strings {
    public static void main(String[] args) {
        String myStr = "Java";
        int len = myStr.length();
        NameManager nameManager = new NameManager();
        System.out.println(nameManager.getSurname());
        System.out.println(nameManager.getFirstName());

    }
}
