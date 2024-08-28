package Activities;

public class NameManager {
    private String name = "Nadipannagari Viswa";

//These methods are called from Strings.java file
    public String getSurname(){
        return name.substring(0,name.indexOf(" "));
    }

    public String getFirstName(){
        return name.substring(name.indexOf(" ")+1);
    }

}
