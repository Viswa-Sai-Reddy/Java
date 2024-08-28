package Fundamentals;

import java.util.Objects;

public class Users {

    private String name;
    private int age;

    public Users(String name, int age) {
        if(age < 0)
            throw  new IllegalArgumentException("Age can't be negative");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age && Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
